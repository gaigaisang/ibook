package com.ibook.servlet.cart;

import com.ibook.service.CartService;
import com.ibook.service.impl.CartServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DelCartItemServlet", value = "/DelCartItemServlet")
public class DelCartItemServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String userId = (String) session.getAttribute("userid");
        String bookIds = request.getParameter("bookIds");
        String[] bookId = bookIds.split(",");
//        System.out.println("userId="+userId);
//        System.out.println("bookIds="+bookIds);
//        System.out.println("bookId="+bookId.length);
        CartService cartService = new CartServiceImpl();
        for (String s : bookId) {
            Boolean flag = cartService.delCartitem(userId, s);
            if (!flag) {
                response.getWriter().write("false");
                return;
            }
        }
        response.getWriter().write("true");
    }
}
