package ai.code.practise.rikudo.web.service.impl;

import ai.code.practise.rikudo.web.dao.SequenceDao;
import ai.code.practise.rikudo.web.entity.Sequence;
import ai.code.practise.rikudo.web.service.SequenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SequenceServiceImpl implements SequenceService {

    @Autowired
    private SequenceDao sequenceDao;

    @Override
    public long getNextId(String bizName) {

        Sequence sequence = new Sequence();
        sequence.setBizName(bizName);
        sequenceDao.updateNextSequence(sequence);
        return sequence.getId();
    }
}
