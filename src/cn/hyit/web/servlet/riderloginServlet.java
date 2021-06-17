package cn.hyit.web.servlet;

import cn.hyit.dao.RiderUserDao;
import cn.hyit.domain.RiderUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/riderloginServlet")
public class riderloginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        //2.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //3.封装用户对象
        RiderUser loginuser = new RiderUser();
        loginuser.setUsername(username);
        loginuser.setPassword(password);
        //4.调用UserDao中的login方法
        RiderUserDao dao = new RiderUserDao();
        RiderUser user = dao.login(loginuser);

        //5.判断Uesr
        if(user == null){
            //登录失败
//            req.getRequestDispatcher("/failServlet").forward(req,resp);
            resp.sendRedirect("rider_login.html");
        }else{
            //登录成功
//            req.setAttribute("user",user);
//            req.getRequestDispatcher("/successServlet").forward(req,resp);
            resp.sendRedirect("riderindex.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
