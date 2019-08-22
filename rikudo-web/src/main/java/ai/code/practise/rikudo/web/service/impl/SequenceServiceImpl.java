package ai.code.practise.rikudo.web.service.impl;

import ai.code.practise.rikudo.common.SleepHelper;
import ai.code.practise.rikudo.web.dao.SequenceBlockDao;
import ai.code.practise.rikudo.web.dao.SequenceDao;
import ai.code.practise.rikudo.web.entity.Sequence;
import ai.code.practise.rikudo.web.entity.SequenceBlock;
import ai.code.practise.rikudo.web.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SequenceServiceImpl implements SequenceService {

    @Autowired
    private SequenceDao sequenceDao;

    @Autowired
    private SequenceBlockDao sequenceBlockDao;

    /**
     * 序列号区块map
     */
    private Map<String, SequenceBlock> sequenceBlockMap = new HashMap<>();

    @Override
    public long getNextId(String bizName) {
        Sequence sequence = new Sequence();
        sequence.setBizName(bizName);
        sequenceDao.updateNextSequence(sequence);
        return sequence.getId();
    }

    @Override
    public synchronized long getBlockNextId(String bizName) {
        SequenceBlock sequenceBlock = sequenceBlockMap.get(bizName);
        Long value = 0L;
        if(sequenceBlock == null){
            try {
                // 生成一条新记录
                sequenceBlockDao.newSequenceBlock(new SequenceBlock(bizName, 0L, 0L));
            }catch (Exception e){
                // 若与别的机器产生并发冲突
                value = sequenceBlockDao.getSequenceBlockVal(bizName);
            }
        }else {
            if(sequenceBlock.getCurrentVal() < sequenceBlock.getEndVal()){
                return sequenceBlock.increamentAndGet();
            }
        }

        // 更新序列区块
        sequenceBlock = new SequenceBlock(bizName, value, value + SequenceBlock.BLOCK_LEN);
        while (sequenceBlockDao.updateSequenceBlock(sequenceBlock) != 1){
            SleepHelper.sleep(10);
            value = sequenceBlockDao.getSequenceBlockVal(bizName);
            sequenceBlock = new SequenceBlock(bizName, value, value + SequenceBlock.BLOCK_LEN);
        }
        sequenceBlockMap.put(bizName, sequenceBlock);

        return sequenceBlock.increamentAndGet();
    }

}
