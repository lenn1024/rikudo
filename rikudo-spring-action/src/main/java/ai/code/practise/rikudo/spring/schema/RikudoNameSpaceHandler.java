package ai.code.practise.rikudo.spring.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class RikudoNameSpaceHandler extends NamespaceHandlerSupport {

    @Override
    public void init() {
        registerBeanDefinitionParser("extBean", new ExtBeanDefinitionParser());
    }
}
