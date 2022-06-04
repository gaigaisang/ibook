package com.ibook.servlet.cart;

import com.ibook.bean.CartItem;
import com.ibook.service.impl.CartServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AddToCartServlet", value = "/AddToCartServlet")
public class AddToCartServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        String bookid = request.getParameter("bookid");

        HttpSession session = request.getSession();
        String userid = (String) session.getAttribute("userid");
        if (userid==null) {
            response.getWriter().write("0");//未登录
            return;
        }
//        System.out.println(userid);
//        System.out.println(bookid);
        CartServiceImpl cartService = new CartServiceImpl();
        Boolean result = cartService.addToCart(userid, bookid);
//        System.out.println(result);
        if (result) {
            response.getWriter().write("1");//添加成功
        } else {
            response.getWriter().write("2");//添加失败
        }
    }
}
