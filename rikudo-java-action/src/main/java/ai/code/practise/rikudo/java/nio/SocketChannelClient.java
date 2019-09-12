package ai.code.practise.rikudo.java.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

@Slf4j
public class SocketChannelClient {

    /**
     * 服务器IP地址
     */
    private final static String HOST = "127.0.0.1";

    /**
     * 连接端口
     */
    private final static int PORT = 9999;

    public static void main(String[] args){

        SocketChannel socketChannel = null;
        try {
            // 打开一个socket channel
            socketChannel = SocketChannel.open();
            socketChannel.connect(new InetSocketAddress(HOST, PORT));

            // 分配一个ByteBuffer供socket channel使用
            ByteBuffer buf = ByteBuffer.allocate(60);
            byte[] bytes = "中华人民共和国万岁!".getBytes(Charset.forName("utf-8"));
            buf.put(bytes);
            buf.flip();

            // 将byteBuffer中内容写入socket channel中
            while (buf.hasRemaining()){
                socketChannel.write(buf);
            }
        } catch (IOException e) {
            log.error("SocketChannelClient open socket exception.", e);
        }finally {
            try {
                socketChannel.close();
            } catch (IOException e) {
                log.error("SocketChannelClient close socket exception.", e);
            }
        }
    }
}
