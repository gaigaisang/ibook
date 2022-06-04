package com.ibook.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(filterName = "LoginFilter", urlPatterns = {"*.html"})
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(request, response);

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

//        resp.setContentType("text/html;charset=utf-8");
//        resp.setCharacterEncoding("utf-8");

        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userid")) {
                    if (cookie.getValue() != null) {
                        String userid = cookie.getValue();
                        HttpSession session = req.getSession();
                        session.setAttribute("userid", userid);
                    }
                }
            }
        }
        String uri = req.getRequestURI();

        if (uri.contains("login.html") || uri.contains("register.html") || uri.contains("index.html")) {
            chain.doFilter(req, resp);
        } else {
            HttpSession session = req.getSession();
            String userid = (String) session.getAttribute("userid");


            if (userid == null) {
//                resp.sendRedirect("login.html");
                req.getRequestDispatcher("/login.html").forward(req, resp);
//                request.getRequestDispatcher("/login.html").forward(request,response);
                return;
            } else {
                chain.doFilter(req, resp);
            }
        }
    }
}
