package ai.code.practise.rikudo.java.nio.test;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

@Slf4j
public class ServerSocketChannelDemo {

    private static final int PORT = 9999;

    public static void main(String[] args){
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
            while (true){
                SocketChannel socketChannel = serverSocketChannel.accept();
                // todo something
            }

        } catch (IOException e) {
            log.error("ServerSocketChannel test exception.", e);
        }

    }
}
