package controller;


import dao.PecaDao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import model.Peca;

@WebServlet(name = "API", urlPatterns = {"/API"})
public class api extends HttpServlet {
    private PecaDao dao;
	
    public api() {
        super();
        dao = new PecaDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Peca> listpecas = dao.getAllPecas();
        request.setAttribute("pecas", listpecas);
        Gson gson = new Gson();
        String json = gson.toJson(listpecas);
        response.getWriter().append(json);
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

}
