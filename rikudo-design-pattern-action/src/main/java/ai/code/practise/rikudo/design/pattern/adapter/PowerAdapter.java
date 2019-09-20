package ai.code.practise.rikudo.design.pattern.adapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PowerAdapter extends Adaptee implements Target {

    @Override
    public void supply10V() {
        supply220V();
        log.info("转换220V到10V。");
        log.info("提供10伏电压。");
    }

    public static void main(String[] args){
        Target target = new PowerAdapter();
        target.supply10V();
    }
}
