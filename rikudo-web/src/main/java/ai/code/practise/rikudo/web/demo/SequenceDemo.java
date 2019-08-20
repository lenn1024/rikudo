package ai.code.practise.rikudo.web.demo;

import ai.code.practise.rikudo.web.entity.Sequence;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SequenceDemo {

    public static void main(String args[]) throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        Sequence sequence = new Sequence();
        sequence.setBizName("fresh");

        for(int i = 0; i < 100; i++){
            SqlSession sqlSession = sqlSessionFactory.openSession();
            sqlSession.update("ai.code.practise.rikudo.web.demo.SequenceDemo.update", sequence);
            //System.out.println(sequence.getCurrentValue());
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
