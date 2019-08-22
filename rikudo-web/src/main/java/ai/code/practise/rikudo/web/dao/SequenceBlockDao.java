package ai.code.practise.rikudo.web.dao;

import ai.code.practise.rikudo.web.entity.SequenceBlock;

public interface SequenceBlockDao {

    /**
     * 根据业务id新生成一个序列号区块
     * @param sequenceBlock
     * @return
     */
    int newSequenceBlock(SequenceBlock sequenceBlock);

    /**
     * 根据业务名称查询区块序列号
     * @param bizName
     * @return
     */
    Long getSequenceBlockVal(String bizName);

    /**
     * 更新序列区块
     * @param sequenceBlock
     */
    int updateSequenceBlock(SequenceBlock sequenceBlock);
}
