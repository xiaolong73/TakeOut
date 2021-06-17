package cn.hyit.web.servlet;

import cn.hyit.dao.SellerUserDao;
import cn.hyit.domain.SellerUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/sellerloginServlet")
public class sellerloginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        //2.获取请求参数
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //3.封装用户对象
        SellerUser loginuser = new SellerUser();
        loginuser.setUsername(username);
        loginuser.setPassword(password);
        //4.调用UserDao中的login方法
        SellerUserDao dao = new SellerUserDao();
        SellerUser user = dao.login(loginuser);

        //5.判断Uesr
        if(user == null){
            //登录失败
//            req.getRequestDispatcher("/failServlet").forward(req,resp);
            resp.sendRedirect("seller_login.html");
        }else{
            //登录成功
//            req.setAttribute("user",user);
//            req.getRequestDispatcher("/successServlet").forward(req,resp);
            resp.sendRedirect("seller.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
