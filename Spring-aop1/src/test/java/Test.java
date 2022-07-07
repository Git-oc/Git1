import Impl.BookDaoImpl;
import Impl.StudentDAOImpl;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookDaoImpl bookDAO = (BookDaoImpl) context.getBean("bookDAO");

        StudentDAOImpl studentDAO = (StudentDAOImpl) context.getBean("studentDAO");



        bookDAO.delete(1);
        studentDAO.delete();
    }
}
