package ai.code.practise.rikudo.netty.socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static final Logger logger = LoggerFactory.getLogger(Server.class);

    private ServerSocket serverSocket;

    public Server(int port) {
        try {
            this.serverSocket = new ServerSocket(port);
            logger.info("服务端启动成功，端口：" + port);
        } catch (IOException e) {
            logger.error("服务端启动失败。", e);
        }
    }

    public void start(){
        new Thread(() -> doStart()).start();
    }

    private void doStart(){
        while (true){
            try {
                Socket clientSocket = this.serverSocket.accept();
                new ClientSocketHandler(clientSocket).start();
            } catch (IOException e) {
                logger.error("服务端异常。", e);
            }
        }
    }
}
