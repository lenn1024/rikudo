package ai.code.practise.rikudo.java.rpc;

import ai.code.practise.rikudo.common.SleepHelper;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RpcConsumer {

    public static void main(String[] args) throws Exception {
        HelloService service = RpcFramework.refer(HelloService.class, "127.0.0.1", 1234);

        for(int i = 0; i < Integer.MAX_VALUE; i++){
            String hello = service.hello("World" + i);
            log.info(hello);
            SleepHelper.sleep(1000);
        }
    }

}
