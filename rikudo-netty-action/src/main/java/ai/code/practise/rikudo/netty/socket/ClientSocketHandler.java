package ai.code.practise.rikudo.netty.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ClientSocketHandler {

    private static final Logger logger = LoggerFactory.getLogger(ClientSocketHandler.class);

    public static final int MAX_DATA_LEN = 1024;

    private final Socket socket;

    public ClientSocketHandler(Socket socket) {
        this.socket = socket;
    }

    public void start(){
        logger.info("新客户端接入。");
        new Thread(() -> doStart()).start();
    }

    private void doStart(){
        try {
            InputStream inputStream = socket.getInputStream();
            logger.info("开始处理用户请求。");
            byte[] data = new byte[MAX_DATA_LEN];
            int len;
            while ((len = inputStream.read(data)) != -1){
                String message = new String(data, 0, len);
                logger.info("客户端传来消息：" + message);
                // 再回写到客户端
                socket.getOutputStream().write(data);
            }
        } catch (IOException e) {
            logger.error("处理客户端请求异常。", e);
        }
        logger.info("处理用户请求结束。");
    }
}
