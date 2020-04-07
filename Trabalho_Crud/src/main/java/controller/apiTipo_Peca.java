package controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import dao.Tipo_PecaDao;
import model.Tipo_Peca;

@WebServlet(name = "APITIPO_PECA", urlPatterns = {"/APITIPO_PECA"})
public class apiTipo_Peca extends HttpServlet {
private Tipo_PecaDao dao;

	public apiTipo_Peca() {
		super();
		dao = new Tipo_PecaDao();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Tipo_Peca> listTipos = dao.getAllTipo();
        request.setAttribute("tipos", listTipos);
        Gson gson = new Gson();
        String json = gson.toJson(listTipos);
        response.getWriter().append(json);
        
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
	
}
