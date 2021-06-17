package cn.hyit.web.servlet;

import cn.hyit.dao.CustomerUserDao;
import cn.hyit.dao.RiderUserDao;
import cn.hyit.dao.SellerUserDao;
import cn.hyit.domain.CustomerUser;
import cn.hyit.domain.RiderUser;
import cn.hyit.domain.SellerUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

@WebServlet("/userregisterServlet")
public class userregisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.设置编码
        req.setCharacterEncoding("utf-8");
        //2.获取请求参数
        BufferedReader in = new BufferedReader(new FileReader("/home/xiaolong/IdeaProjects/TakeOut/src/cn/hyit/runoob.txt"));
        String kind = in.readLine();
        String tele = in.readLine();
        String username = req.getParameter("username");
        String password1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        String rider = "骑手";
        String customer = "顾客";
        String seller = "商家";

        if(!password1.equals(password2))
        {
            resp.sendRedirect("zhuce1.html");
        }

        //3.根据kind来注册
        if(kind.equals(customer)){

            CustomerUser user = new CustomerUser();
            user.setPassword(password1);
            user.setUsername(username);
            user.setTele(tele);

            CustomerUserDao dao = new CustomerUserDao();
            boolean tag = dao.register(user);

            if(tag){
                resp.sendRedirect("zhuceSucc.html");
            }else{
                resp.sendRedirect("zhuce1.html");
            }

        }else if(kind.equals(rider)){
            RiderUser user = new RiderUser();
            user.setPassword(password1);
            user.setUsername(username);
            user.setTele(tele);

            RiderUserDao dao = new RiderUserDao();
            boolean tag = dao.register(user);

            if(tag){
                resp.sendRedirect("zhuceSucc.html");
            }else{
                resp.sendRedirect("zhuce1.html");
            }

        }else if(kind.equals(seller)){
            SellerUser user = new SellerUser();
            user.setPassword(password1);
            user.setUsername(username);
            user.setTele(tele);

            SellerUserDao dao = new SellerUserDao();
            boolean tag = dao.register(user);

            if(tag){
                resp.sendRedirect("zhuceSucc.html");
            }else{
                resp.sendRedirect("zhuce1.html");
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
