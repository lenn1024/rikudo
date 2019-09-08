package ai.code.practise.rikudo.java.nio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

@Slf4j
public class TestMain {
    public static void main(String[] args){
        try {
            // test code
            Selector selector = Selector.open();
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

            SelectionKey selectionKey = serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
            selectionKey.channel();
            selectionKey.selector();

            selector.selectedKeys();

        } catch (IOException e) {
            log.error("excption.", e);
        }
    }
}
