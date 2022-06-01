package com.ibook.servlet.user;

import com.ibook.bean.User;
import com.ibook.service.impl.UserServiceImpl;
import com.ibook.utils.MailUtils;
import org.junit.Test;

import javax.mail.MessagingException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        if (username != null || password != null || email != null) {
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setActiveCode(UUID.randomUUID().toString());
            UserServiceImpl userService = new UserServiceImpl();
            if (userService.addUser(user)) {
                response.getWriter().write("true");
                String url = "http://localhost:8080/ibook/ActivateServlet?activateCode=" + user.getActiveCode();
                String content = "<p>欢迎！"+user.getUsername()+"</p>\n" +
                        "    <hr>\n" +
                        "    <p>感谢您在 iBook 的注册，请点击这里激活您的账号：</p>\n" +
                        "    <a href='"+url+"'>"+url+"</a>\n" +
                        "    <p>祝您使用愉快，使用过程中您有任何问题请及时联系我们。</p>";
                try {
                    MailUtils.sendMail(email,content);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            } else {
                response.getWriter().write("false");
            }
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
    @Test
    public void test(){
        System.out.println(UUID.randomUUID().toString());
    }
}
