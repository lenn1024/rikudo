package ai.code.practise.rikudo.web.test;

import ai.code.practise.rikudo.common.SleepHelper;
import ai.code.practise.rikudo.web.service.SequenceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath*:applicationContext.xml"})
public class SequenceServiceTest {

    private static Logger logger = LoggerFactory.getLogger(SequenceServiceTest.class);

    /**
     * 定义一个线程池
     */
    private ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
            5,
            10,
            2000,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(1),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());

    @Autowired
    private SequenceService sequenceService;

    /**
     * 多线程测试id生成
     */
    @Test
    public void testGetNextId() {
        String bizName = "fresh";

        threadPool.submit(() -> {
            for(int i = 0; i < 500; i++){
                logger.info("generate id:{}.", sequenceService.getNextId(bizName));
            }
        });
        threadPool.submit(() -> {
            for(int i = 0; i < 500; i++){
                logger.info("generate id:{}.", sequenceService.getNextId(bizName));
            }
        });
        // sleep 1.5s to wait task execute end.
        SleepHelper.sleep(1500);
    }
}
