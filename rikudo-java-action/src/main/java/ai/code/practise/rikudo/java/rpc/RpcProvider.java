package ai.code.practise.rikudo.java.rpc;

/**
 * 服务提供者
 */
public class RpcProvider {

    public static void main(String[] args) throws Exception {
        HelloService service = new HelloServiceImpl();
        RpcFramework.export(service, 1234);
    }
}
