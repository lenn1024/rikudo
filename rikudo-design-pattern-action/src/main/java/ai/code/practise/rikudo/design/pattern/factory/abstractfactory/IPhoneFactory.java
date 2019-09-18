package ai.code.practise.rikudo.design.pattern.factory.abstractfactory;

public class IPhoneFactory implements IFactory {
    @Override
    public Product create() {
        return new IPhoneProduct();
    }
}
