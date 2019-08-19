package ai.code.practise.rikudo.web.dao;

import ai.code.practise.rikudo.web.entity.Sequence;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SequenceDao {

    public static void main(String args[]) throws IOException {
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        Sequence sequence = new Sequence();
        sequence.setBizName("fresh");

        long start = System.currentTimeMillis();
        for(int i = 0; i < 10000; i++){
            SqlSession sqlSession = sqlSessionFactory.openSession();
            sqlSession.update("ai.code.practise.rikudo.web.dao.SequenceDao.update", sequence);
            //System.out.println(sequence.getCurrentValue());
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println((System.currentTimeMillis() - start) / 1000 + "s");
    }
}
