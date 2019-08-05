package ai.code.practise.rikudo.common;

public final class SleepHelper {

    /**
     * sleep millis毫秒
     * @param millis
     */
    public static void sleep(long millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
