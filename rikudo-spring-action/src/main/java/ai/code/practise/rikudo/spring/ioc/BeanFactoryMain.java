package ai.code.practise.rikudo.spring.ioc;

import ai.code.practise.rikudo.spring.domain.Beauty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * 手动初始化一个Ioc容器
 */
@Slf4j
public class BeanFactoryMain {

    public static void main(String[] args){
        // 初始化资源访问
        Resource resource = new ClassPathResource("spring/spring-ioc.xml");
        // 构造Ioc容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        // 构造读取BeanDefinition的Reader
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        // 加载bean定义
        reader.loadBeanDefinitions(resource);

        // 使用构造好的Ioc容器
        Beauty beauty = beanFactory.getBean(Beauty.class);
        log.info("管哥今天碰见了一个美女: {}.", beauty);
    }
}