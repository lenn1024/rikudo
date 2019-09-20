package ai.code.practise.rikudo.design.pattern.adapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Adaptee {
    /**
     * 提供220伏电压
     */
    public void supply220V(){
        log.info("提供220伏电压。");
    }
}
