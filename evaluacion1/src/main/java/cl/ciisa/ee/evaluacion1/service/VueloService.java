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
 * Servlet implementation class VueloService.
 * <br>
 * Se expone mediante el path GET '/vuelo/retrieve' como
 * un servicio REST, se retorna un JSON con la lista de
 * valores definidos en el requerimiento de la Evaluación 1.
 * 
 * @author psep
 */
@WebServlet("/vuelo/retrieve")
public class VueloService extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * Constructor por defecto del servlet.
     * 
     * @see HttpServlet#HttpServlet()
     */
    public VueloService() {
        super();
    }

	/**
	 * Método GET del servlet que permite la iteración de un enum
	 * (a falta aún de integración con alguna DB) la serialización
	 * de una lista mediante Gson en formato JSON.
	 * 
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
	 * Método POST por defecto.
	 * 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
