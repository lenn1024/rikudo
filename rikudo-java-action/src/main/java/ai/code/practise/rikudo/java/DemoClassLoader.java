package ai.code.practise.rikudo.java;

import java.io.FileInputStream;
import java.io.IOException;

/**
 * 自定义ClassLoader
 */
public class DemoClassLoader extends ClassLoader {

    public static void main(String[] args) throws ClassNotFoundException {
        DemoClassLoader demoClassLoader = new DemoClassLoader("/Users/lenn/lab");
        Class<?> clazz = demoClassLoader.loadClass("ai.code.mikasa.TestCaseClass");

        System.out.println("我是由[" + clazz.getClassLoader().getClass() + "]加载进来的。");
    }

    private String classPath;

    public DemoClassLoader(String classPath) {
        this.classPath = classPath;
    }

    /**
     * 根据Class名字进行自定义类加载
     * @param name
     * @return
     * @throws ClassNotFoundException
     */
    protected Class<?> findClass(String name) throws ClassNotFoundException{
        try {
            byte[] data = loadByte(name);
            return defineClass(name, data, 0, data.length);
        }catch (Exception e){
            throw new ClassNotFoundException();
        }
    }

    /**
     * 加载字节码文件，转换成字节数组
     * @param name
     * @return
     * @throws IOException
     */
    private byte[] loadByte(String name) throws IOException {
        name = name.replaceAll("\\.", "/");
        FileInputStream fis = new FileInputStream(classPath + "/" + name + ".class");
        int len = fis.available();
        byte[] data = new byte[len];
        fis.read(data);
        fis.close();

        return data;
    }
}
