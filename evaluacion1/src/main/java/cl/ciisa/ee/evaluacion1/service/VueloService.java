package cl.ciisa.ee.evaluacion1.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import cl.ciisa.ee.evaluacion1.to.VueloTO;
import cl.ciisa.ee.evaluacion1.type.ValorType;

/**
 * @author psep
 * 
 * Servlet implementation class VueloService
 * 
 */
@WebServlet("/vuelo/retrieve")
public class VueloService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VueloService() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<VueloTO> list = new ArrayList<>();

		for (ValorType type : ValorType.values()) {
			VueloTO vuelo = new VueloTO();
			vuelo.setNombre(type.getId());
			vuelo.setValor(type.getValue());
			list.add(vuelo);
		}
		
		Gson gson = new Gson();
		String json = gson.toJson(list);

		response.setCharacterEncoding("utf-8");
        response.setContentType(MediaType.APPLICATION_JSON);
        response.getWriter().append(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
