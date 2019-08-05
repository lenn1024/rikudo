package ai.code.practise.rikudo.netty.socket;

public class ServerBootStrap {

    private static final int PORT = 8000;

    public static void main(String[] args){
        Server server = new Server(PORT);
        server.start();
    }
}
