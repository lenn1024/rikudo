package ai.code.practise.rikudo.spring.domain;

import lombok.Data;

/**
 * 一辆车
 */
@Data
public class Car {
    /**
     * 车的名字
     */
    private String name;

    /**
     * 车的品牌
     */
    private String brand;
}