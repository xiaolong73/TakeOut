package cn.hyit.web.servlet;

import cn.hyit.dao.RiderUserDao;
import cn.hyit.domain.RiderUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@WebServlet("/changeServlet")
public class changeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        //2.获取请求参数

        String username = req.getParameter("username");

        BufferedWriter out = new BufferedWriter(new FileWriter("/home/xiaolong/IdeaProjects/TakeOut/src/cn/hyit/username.txt"));
        out.write(username);
        out.close();

        //4.重定向到第二个修改页面
        resp.sendRedirect("password_2.html");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
