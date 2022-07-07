import Dao.GenaralDAO;
import Impl.BookDaoImpl;
import Impl.StudentDAOImpl;
import Proxy.CGLibDynamicProxy;
import Proxy.JDKDynamicProxy;

public class TestDynamicProxy {
    public static void main(String[] args) {
        //被代理对象
        BookDaoImpl bookDAO = new BookDaoImpl();
        StudentDAOImpl studentDAO = new StudentDAOImpl();

        //proxy就是产生的代理对象：可强转成被代理对象实现的接口类型
      //  GenaralDAO proxy1 = (GenaralDAO) new JDKDynamicProxy(bookDAO).getProxy();
      //  GenaralDAO proxy2 = (GenaralDAO) new CGLibDynamicProxy(studentDAO).getProxy();

        //使用代理对象的调用方法，并不会执行调用方法，而是进入到创建代理对象时指定的InvocationHandler类中的invoke方法
        //调用方法作为一个method参数，传递给invoke方法
       // System.out.println("JDKDynamicProxy：");
       // proxy1.insert();

      //  System.out.println("-------------------");

       // System.out.println("CGLibDynamicProxy：");
       // proxy2.update();
    }
}
