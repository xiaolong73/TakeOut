package cn.hyit.test;

        import cn.hyit.dao.UserDao;
        import cn.hyit.domain.User;
        import org.junit.Test;

public class UserDaoTest {
    @Test
    public void testlogin(){
        User loginuser = new User();
        loginuser.setUsername("xiaolong");
        loginuser.setPassword("123456");

        UserDao dao = new UserDao();
        User user = dao.login(loginuser);

        System.out.println(user);

    }
}
