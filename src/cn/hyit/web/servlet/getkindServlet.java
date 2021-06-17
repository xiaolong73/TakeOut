package cn.hyit.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

@WebServlet("/getkindServlet")
public class getkindServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        //2.获取请求参数
        String tele = req.getParameter("tele");
        String kind = req.getParameter("kind");

        //3.保存tele到runoob.txt文件中
        BufferedWriter out = new BufferedWriter(new FileWriter("/home/xiaolong/IdeaProjects/TakeOut/src/cn/hyit/runoob.txt"));
        out.write(kind);
        out.write('\n');
        out.write(tele);
        out.close();
        //4.跳转到zhuce1.html
        resp.sendRedirect("zhuce1.html");

//        req.getRequestDispatcher("userregisterServlet").forward(req,resp);



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
