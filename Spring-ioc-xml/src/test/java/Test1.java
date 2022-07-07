import com.ioc.bean.Clazz;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test1 {
    public static void main(String[] args) {
        //初始化Spring容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过Spring容器获取Clazz对象
        Clazz clazz = (Clazz) context.getBean("clazz");

        System.out.println(clazz);
    }
}
