package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import dao.Tipo_PecaDao;
import model.Tipo_Peca;

@WebServlet(name = "Tipos", urlPatterns = {"/TipoController"})
public class TipoController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    private static String INSERT_OR_EDIT = "/tipo.jsp";
    private static String LIST_PECA = "/listTipo.jsp";
    private Tipo_PecaDao dao;
    
    public TipoController() {
        super();
        dao = new Tipo_PecaDao();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward="";
        String action = request.getParameter("action");
        

        if (action.equalsIgnoreCase("delete")){
            int tipoId = Integer.parseInt(request.getParameter("tipoId"));
            dao.deleteTipo(tipoId);
            forward = LIST_PECA;
            request.setAttribute("tipos", dao.getAllTipo());    
        } else if (action.equalsIgnoreCase("edit")){
            forward = INSERT_OR_EDIT;
            int tipoId = Integer.parseInt(request.getParameter("tipoId"));
            Tipo_Peca tipo = dao.getTipoById(tipoId);
            request.setAttribute("tipos", new Tipo_PecaDao().getAllTipo());
            request.setAttribute("tipo", tipo);
        } else if (action.equalsIgnoreCase("listTipos")){
            forward = LIST_PECA;
            request.setAttribute("tipos", dao.getAllTipo());
        } else {
            forward = INSERT_OR_EDIT;
            request.setAttribute("tipos", new Tipo_PecaDao().getAllTipo());
        }
        request.setAttribute("tipos", new Tipo_PecaDao().getAllTipo());
        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Tipo_Peca tipo = new Tipo_Peca();
        Gson gson = new Gson();

        tipo.setCategoria(request.getParameter("categoria"));
        String tipoId = request.getParameter("tipoId");
        
        
        if(tipoId == null || tipoId.isEmpty())
        {
            dao.addTipo(tipo);;
            String json = gson.toJson(tipo);
            System.out.println(json);
        }
        else
        {
        	tipo.setId(Integer.parseInt(tipoId));
        	//System.out.println(pecaId);
        	dao.updatePeca(tipo);;
            String json = gson.toJson(tipo);

           System.out.println(json);
        }
        RequestDispatcher view = request.getRequestDispatcher(LIST_PECA); 
        List<Tipo_Peca> listaDeTipos = dao.getAllTipo();
        
        request.setAttribute("tipos", new Tipo_PecaDao().getAllTipo());
        view.forward(request, response);
    }

}
