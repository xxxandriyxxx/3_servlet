package controllers;

import com.google.gson.Gson;
import dao.UserDAO;
import models.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class RestController extends HttpServlet {


    // localhost:8080/json [get]

    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userDAO.findAll();
//        System.out.println(users);
        resp.setHeader("contentType","application/json");
        PrintWriter writer = resp.getWriter();
        Gson gson = new Gson();
        String json = gson.toJson(users);
        writer.print(json);
        writer.close();
    }
}
