package ai.code.practise.rikudo.web.entity;

import lombok.Data;

/**
 * 业务id实体类
 */
@Data
public class Sequence {

    private String bizName;

    private Long currentValue;

    private Integer _increament;
}
