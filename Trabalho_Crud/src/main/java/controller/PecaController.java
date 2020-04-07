package controller;


import dao.PecaDao;
import dao.Tipo_PecaDao;

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

@WebServlet(name = "Pecas", urlPatterns = {"/PecaController"})
public class PecaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/peca.jsp";
    private static String LIST_PECA = "/listPeca.jsp";
    private PecaDao dao;
	
    public PecaController() {
        super();
        dao = new PecaDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        

        if (action.equalsIgnoreCase("delete")){
            int pecaId = Integer.parseInt(request.getParameter("pecaId"));
            dao.deletePeca(pecaId);
            forward = LIST_PECA;
            request.setAttribute("pecas", dao.getAllPecas());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int pecaId = Integer.parseInt(request.getParameter("pecaId"));
            Peca peca = dao.getPecaById(pecaId);
            request.setAttribute("pecas",new PecaDao().getAllPecas());
            request.setAttribute("tipos", new Tipo_PecaDao().getAllTipo());
            request.setAttribute("peca", peca);
        } else if (action.equalsIgnoreCase("listPeca")){
            forward = LIST_PECA;
            request.setAttribute("pecas", dao.getAllPecas());
        } else {
            forward = INSERT_OR_EDIT;
            request.setAttribute("pecas",new PecaDao().getAllPecas());
            request.setAttribute("tipos", new Tipo_PecaDao().getAllTipo());
        }
        request.setAttribute("pecas",new PecaDao().getAllPecas());
        request.setAttribute("tipos", new Tipo_PecaDao().getAllTipo());
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Peca peca = new Peca();
        Gson gson = new Gson();

        
        
        peca.setNome(request.getParameter("nome"));
        peca.setDesc(request.getParameter("descricao"));
        peca.setTipo(request.getParameter("cod_tipo"));
        peca.setValor(Float.parseFloat(request.getParameter("valor")));
        
        String teste = request.getParameter("cod_tipo");
       // System.out.println(teste);
        String pecaId = request.getParameter("pecaId");
        
        
        if(pecaId == null || pecaId.isEmpty())
        {
            dao.addPeca(peca);
            String json = gson.toJson(peca);
            System.out.println(json);
        }
        else
        {
        	peca.setId(Integer.parseInt(pecaId));
        	//System.out.println(pecaId);
        	dao.updatePeca(peca);
            String json = gson.toJson(peca);

            System.out.println(json);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_PECA); 
        List<Peca> listaPeca = dao.getAllPecas();
        
        request.setAttribute("pecas",new PecaDao().getAllPecas());
        request.setAttribute("tipos", new Tipo_PecaDao().getAllTipo());
        view.forward(request, response);
    }

}
