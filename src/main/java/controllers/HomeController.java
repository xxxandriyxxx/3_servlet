package controllers;

import dao.UserDAO;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


//@WebServlet(value = {"/", "/home"})  // annotation <-> xml !!!!!
public class HomeController extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    // localhost:8080/home -GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        -------------------------------------------
//        System.out.println("work");
//        resp.setHeader("contentType","text/html");
//        PrintWriter writer = resp.getWriter();
//        writer.print("<h1>hello<h1>");
//        writer.flush();
//        writer.close();
//        -------------------------------------------

//        String msg = req.getParameter("msg");
//        String name = req.getParameter("name");
//        req.setAttribute("msg", msg);
//        req.setAttribute("name", name);


        List<User> users = userDAO.findAll();
        req.setAttribute("users", users);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    // localhost:8080/home -POST
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String msg = req.getParameter("msg");
        String name = req.getParameter("name");
//        req.setAttribute("msg", msg + "POST");
        req.setAttribute("name", name);
        userDAO.save(new User(name));
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
