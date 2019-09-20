package ai.code.practise.rikudo.spring.aop.prpxyfactory;

import lombok.extern.slf4j.Slf4j;

/**
 * 好市多
 */
@Slf4j
public class CostcoSeller implements MoutaiSeller {
    @Override
    public void sellMoutai() {
        log.info("茅台促销了，只卖1499一瓶。");
    }
}
