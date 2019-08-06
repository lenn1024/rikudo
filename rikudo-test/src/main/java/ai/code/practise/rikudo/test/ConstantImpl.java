package ai.code.practise.rikudo.test;

import io.netty.util.Constant;

public class ConstantImpl implements Constant<ConstantImpl> {
    public int id() {
        return 0;
    }

    public String name() {
        return null;
    }

    public int compareTo(ConstantImpl o) {
        return 0;
    }
}
