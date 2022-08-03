import com.Dao.UserDAOImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDAOImpl userDAOImpl = (UserDAOImpl) context.getBean("userDAOImpl");

        userDAOImpl.insert();
    }
}
