import com.ioc.bean.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        //初始化Spring容器
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过Spring容器获取Student对象
        Student student = (Student) context.getBean("stu");

        System.out.println(student);
    }
}
