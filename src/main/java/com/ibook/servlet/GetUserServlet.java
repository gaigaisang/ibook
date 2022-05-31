package com.ibook.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibook.bean.User;
import com.ibook.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "GetSessionServlet", value = "/GetUserServlet")
public class GetUserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        String userid = (String) session.getAttribute("userid");
//        System.out.println(userid);
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.findUserById(userid);
        if (user != null) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(response.getWriter(), user.getUsername());
        }
        else response.getWriter().write("null");


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
