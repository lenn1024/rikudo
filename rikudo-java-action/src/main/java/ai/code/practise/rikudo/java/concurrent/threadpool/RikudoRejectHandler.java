package ai.code.practise.rikudo.java.concurrent.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义拒绝执行处理器
 */
@Slf4j
public class RikudoRejectHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        log.warn("task rejected! {}", executor.toString());
    }
}
