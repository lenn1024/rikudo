package ai.code.practise.rikudo.java.nio.selector;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO Selector 实现一个server
 */
@Slf4j
public class SelectorNioServer {

    public static final int SERVER_PORT = 9999;

    public static void main(String[] args){
        try {
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            serverSocketChannel.configureBlocking(false);

            serverSocketChannel.socket().bind(new InetSocketAddress(SERVER_PORT));

            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            for (;;){
                log.info("start select.");
                selector.select();

                Set<SelectionKey> selectionKeys =  selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()){
                    SelectionKey key = iterator.next();
                    iterator.remove();

                    if(key.isAcceptable()){
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();

                        // 接受客户端连接，并注册到选择器
                        SocketChannel client = server.accept();
                        client.configureBlocking(false);
                        client.register(selector, SelectionKey.OP_READ | SelectionKey.OP_WRITE);
                        log.info("Accept connection from {}", client);
                    }

                    if(key.isReadable()){
                        SocketChannel socketChannel = (SocketChannel) key.channel();

                        ByteBuffer buffer = ByteBuffer.allocate(60);
                        int readBytes = socketChannel.read(buffer);
                        if(readBytes > 0){
                            buffer.flip();
                            byte[] bytes = new byte[readBytes];
                            buffer.get(bytes);
                            log.info("receive msg ({}) from client.", new String(bytes, Charset.forName("utf-8")));
                        }
                        socketChannel.close();
                    }

//                    if(key.isWritable()){
//                        log.info("key is writable.");
//                    }
                }
            }

        } catch (IOException e) {
            log.error("IOException.", e);
        }

    }
}
