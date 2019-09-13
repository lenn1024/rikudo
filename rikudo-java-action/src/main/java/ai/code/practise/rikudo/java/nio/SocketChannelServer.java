package ai.code.practise.rikudo.java.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

@Slf4j
public class SocketChannelServer {

    private static final int PORT = 9999;

    public static void main(String[] args){
        ServerSocketChannel serverSocketChannel = null;
        try {
            // 打开服务通道
            serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
            // 配置为非阻塞
            serverSocketChannel.configureBlocking(false);

            log.info("服务端启动...");
            ByteBuffer buffer = ByteBuffer.allocate(60);
            while (true){
                // accept 新连接
                SocketChannel socketChannel = serverSocketChannel.accept();
                if(socketChannel != null){
                    int readBytes = socketChannel.read(buffer);
                    if(readBytes != 0){
                        byte[] bytes = new byte[readBytes];
                        buffer.flip();
                        buffer.get(bytes);
                        buffer.clear();
                        log.info("receive message from client: {}", new String(bytes, Charset.forName("utf-8")));
                    }
                }
            }
        } catch (IOException e) {
            log.error("Open server socket channel exception.", e);
        } finally {
            try {
                serverSocketChannel.close();
            } catch (IOException e){
                log.error("Close server socket channel exception.", e);
            }
        }

    }
}
