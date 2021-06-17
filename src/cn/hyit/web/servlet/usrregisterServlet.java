package cn.hyit.web.servlet;

import cn.hyit.dao.UserDao;
import cn.hyit.domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/usrregisterServlet")
public class usrregisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        //2.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //3.封装用户对象
        User registUser = new User();
        registUser.setUsername(username);
        registUser.setPassword(password);
        //4.调用UserDao中的login方法
        UserDao dao = new UserDao();
        boolean tag  = dao.register(registUser);

        if(tag == true){
            System.out.println("注册成功！！");
        }else{
            System.out.println("注册失败");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
