package ai.code.practise.rikudo.design.pattern.factory.abstractfactory;

public class AndroidFacotry implements IFactory {
    @Override
    public Product create() {
        return new AndroidProduct();
    }
}
