package ai.code.practise.rikudo.web.demo;

import ai.code.practise.rikudo.web.entity.SequenceBlock;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class SequenceBlockDemo {

    public static void main(String[] args) throws IOException {
        SequenceBlockDemo instance = new SequenceBlockDemo();
        for(int i = 0; i< 100010; i++){
            System.out.println(instance.getNextId("fresh"));
        }
    }

    private Map<String, SequenceBlock> map = new HashMap<>();

    public synchronized Long getNextId(String bizName) throws IOException {
        SequenceBlock sequenceBlock = map.get(bizName);

        if(sequenceBlock == null){
            try {
                newSequenceBlock(bizName);
            }catch (Exception e){
            }finally {
                sequenceBlock = getSequenceBlock(bizName);
            }
            sequenceBlock.setEndVal(sequenceBlock.getCurrentVal() + SequenceBlock.BLOCK_LEN);
            if(updateSequenceBlock(sequenceBlock) == 1){
                map.put(bizName, sequenceBlock);
                return sequenceBlock.increamentAndGet();
            }
        }else {
            if(sequenceBlock.getCurrentVal() < sequenceBlock.getEndVal()){
                return sequenceBlock.increamentAndGet();
            }
        }

        throw new RuntimeException("getNextId exception.");
    }

    private SequenceBlock getSequenceBlock(String bizName){
        SqlSession sqlSession = openSession();
        SequenceBlock sequenceBlock = sqlSession.selectOne("ai.code.practise.rikudo.web.demo.SequenceBlockDemo.queryByBizName", bizName);
        commitAndCloseSession(sqlSession);

        return sequenceBlock;
    }

    /**
     *
     * @param bizName
     * @return
     */
    private int newSequenceBlock(String bizName){
        SqlSession sqlSession = null;
        try{
            sqlSession = openSession();
            SequenceBlock sequenceBlock = new SequenceBlock(bizName, 0L, 0L);
            int result = sqlSession.insert("ai.code.practise.rikudo.web.demo.SequenceBlockDemo.insertItem", sequenceBlock);
            return result;
        }finally {
            commitAndCloseSession(sqlSession);
        }
    }

    private int updateSequenceBlock(SequenceBlock sequenceBlock){
        SqlSession sqlSession = openSession();
        int result = sqlSession.update("ai.code.practise.rikudo.web.demo.SequenceBlockDemo.updateSequenceBlock", sequenceBlock);
        commitAndCloseSession(sqlSession);
        return result;
    }

    private SqlSession openSession(){
        String resource = "mybatis/mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            return sqlSession;
        } catch (IOException e) {

        }
        return null;
    }

    private void commitAndCloseSession(SqlSession sqlSession) {
        if(sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
