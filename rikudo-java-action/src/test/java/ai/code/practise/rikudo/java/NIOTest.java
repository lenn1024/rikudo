package ai.code.practise.rikudo.java;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.nio.ByteBuffer;

@Slf4j
public class NIOTest {

    @Test
    public void testByteBuffer(){
        ByteBuffer buf = ByteBuffer.allocate(10);
        buf.put("1234567890".getBytes());
        buf.flip();

        byte[] bytes = new byte[5];
        buf.get(bytes);
        log.info("字符串为：{}.", new String(bytes));
    }
}
