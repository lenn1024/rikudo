package ai.code.practise.rikudo.web.dao;

import ai.code.practise.rikudo.web.entity.Sequence;

public interface SequenceDao {

    /**
     * 更新并获取id
     * @param sequence
     * @return
     */
    void updateNextSequence(Sequence sequence);
}
