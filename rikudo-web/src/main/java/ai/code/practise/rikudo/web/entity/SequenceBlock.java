package ai.code.practise.rikudo.web.entity;

import lombok.Data;

/**
 * 序列号step
 */
@Data
public class SequenceBlock {

    public static final Long BLOCK_LEN = 10000L;

    /**
     * 业务名称
     */
    private String bizName;

    /**
     * 起始值
     */
    private Long currentVal;

    /**
     * 终止值
     */
    private Long endVal;


    public SequenceBlock() {
    }

    public SequenceBlock(String bizName, Long currentVal, Long endVal) {
        this.bizName = bizName;
        this.currentVal = currentVal;
        this.endVal = endVal;
    }

    /**
     * 增加并获取
     * @return
     */
    public synchronized Long increamentAndGet(){
        return ++currentVal;
    }
}
