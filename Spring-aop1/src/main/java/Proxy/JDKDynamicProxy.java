package Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
/**
 * JDK动态代理：通过被代理对象实现的接口产生其代理对象
 * 1，创建一个类，实现InvocationHandler接口，重写invoke方法
 * 2，在类中定义一个Object类型的变量，提供这个变量的有参构造器，将被代理对象传递进来
 * 3，定义getProxy方法，用于创建并返回代理对象
 */
public class JDKDynamicProxy implements InvocationHandler {

    //被代理对象
    private Object obj;
    public JDKDynamicProxy(Object obj) {
        this.obj = obj;
    }

    //产生代理对象并返回
    public Object getProxy(){
        //获取被代理对象的类加载器
        ClassLoader classLoader = obj.getClass().getClassLoader();
        //获取被代理对象的类实现接口
        Class<?>[] interfaces = obj.getClass().getInterfaces();
        //产生代理对象（通过被代理对象的类实现接口）
        //第一个参数：被代理对象的类加载器
        //第二个参数：被代理对象实现的接口
        //第三个参数：使用产生代理对象调用方法时，用于拦截方法执行的处理器
        Object proxy = Proxy.newProxyInstance(classLoader,interfaces,this);
        return proxy;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        begin();
        Object returnValue = method.invoke(obj,args);
        commit();
        return returnValue;
    }

    public void begin(){
        System.out.println("---开启事务---");
    }

    public void commit(){
        System.out.println("---提交事务---");
    }
}
