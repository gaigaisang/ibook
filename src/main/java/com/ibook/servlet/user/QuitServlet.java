package com.ibook.servlet.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "QuitServlet", value = "/QuitServlet")
public class QuitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("application/json;charset=utf-8");
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userid")) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    request.getSession().removeAttribute("userid");
                    response.getWriter().write("true");
                    return;
                }
            }
        }
        response.getWriter().write("false");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    this.doGet(request, response);

    }
}
