package ai.code.practise.rikudo.web.service;


/**
 * 序列号生成服务
 */
public interface SequenceService {

    /**
     * 根据业务名称获取生成的id
     * @param bizName
     * @return
     */
    long getNextId(String bizName);

    /**
     * 根据业务名称获取区块id
     * @param bizName
     * @return
     */
    long getBlockNextId(String bizName);
}
