package ai.code.practise.rikudo.java.test;

public class Son extends Parent {

    private static String name = "Son";

    static {
        System.out.println(name);
    }

    public static void main(String[] args){
        Parent parent = new Parent("演绎");

        // lombok Boolean的getter是getXXX
        parent.getMale();

        // lombok boolean的getter是isXXX
        parent.isGentlemen();
    }

    public Son(String parentName, String name) {
        super(parentName);
        this.name = name;
    }
}
