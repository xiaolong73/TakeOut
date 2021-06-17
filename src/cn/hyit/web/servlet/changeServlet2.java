package cn.hyit.web.servlet;

import cn.hyit.dao.CustomerUserDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@WebServlet("/changeServlet2")
public class changeServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        //2.获取请求参数
        String tele = req.getParameter("tele");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        BufferedReader in = new BufferedReader(new FileReader("/home/xiaolong/IdeaProjects/TakeOut/src/cn/hyit/username.txt"));
        String username = in.readLine();

        if(!password1.equals(password2)){
            resp.sendRedirect("password.html");
        }else{
            CustomerUserDao dao = new CustomerUserDao();
            boolean tag = dao.changepassword(username, password1);
            if(tag){
                resp.sendRedirect("password_3.html");
            }else{
                resp.sendRedirect("password.html");
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
