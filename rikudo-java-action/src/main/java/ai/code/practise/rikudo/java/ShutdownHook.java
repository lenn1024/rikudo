package ai.code.practise.rikudo.java;

import ai.code.practise.rikudo.common.SleepHelper;

/**
 * JVM运行时 shutdown hook
 */
public class ShutdownHook {
    public static void main(String[] args){
        // 在JVM关闭时调用该钩子函数
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run(){
                SleepHelper.sleep(3000);
                System.out.println("JVM shutdown hook.");
            }
        });
    }
}
