package ai.code.practise.rikudo.spring.schema;

import ai.code.practise.rikudo.spring.domain.ExtBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.beans.factory.xml.BeanDefinitionParser;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

public class ExtBeanDefinitionParser implements BeanDefinitionParser {

    @Override
    public BeanDefinition parse(Element element, ParserContext parserContext) {

        // 声明一个RootBeanDefinition
        RootBeanDefinition beanDefinition = new RootBeanDefinition();
        beanDefinition.setBeanClass(ExtBean.class);
        beanDefinition.setLazyInit(false);

        beanDefinition.getPropertyValues()
                .add("name", element.getAttribute("name"));

        parserContext.getRegistry().registerBeanDefinition("extBean", beanDefinition);
        return beanDefinition;
    }
}
