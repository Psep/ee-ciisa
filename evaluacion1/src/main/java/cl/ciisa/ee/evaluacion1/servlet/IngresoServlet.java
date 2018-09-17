package cl.ciisa.ee.evaluacion1.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.ciisa.ee.evaluacion1.delegate.DescuentoDelegate;
import cl.ciisa.ee.evaluacion1.to.IngresoTO;
import cl.ciisa.ee.evaluacion1.type.SeveridadType;
import cl.ciisa.ee.evaluacion1.type.ValorType;
import cl.ciisa.ee.evaluacion1.utils.GenericUtil;
import cl.ciisa.ee.evaluacion1.utils.HtmlUtil;

/**
 * @author psep
 * 
 * Servlet implementation class IngresoServlet
 */
@WebServlet(name = "ingresoServlet", urlPatterns = "/ingreso.do")
public class IngresoServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String LISTA = "lista";
	
	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger("IngresoServlet");
	
	@Inject
	private DescuentoDelegate descuentoDelegate;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IngresoServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder body = new StringBuilder();
		
		@SuppressWarnings("unchecked")
		ArrayList<IngresoTO> lista = (ArrayList<IngresoTO>) request.getSession().getAttribute(LISTA);
		
		if (lista != null && lista.size() >= 4) {
			body.append(HtmlUtil.getMessage(SeveridadType.ERROR, "Alerta", "Ha alcanzado el máximo de reservas por cliente."));
		} else {
			lista = this.getLista(lista, request);
		}
		
		body.append(HtmlUtil.generateTable(lista));
		body.append("<a href=\"index.html\" class=\"btn btn-primary\">Volver</a>");
		
		response.setCharacterEncoding("utf-8");
        response.getWriter().append(HtmlUtil.getBody(body.toString()));
	}
	
	/**
	 * @param lista
	 * @param request
	 * @return
	 */
	private ArrayList<IngresoTO> getLista(ArrayList<IngresoTO> lista, HttpServletRequest request) {
		String vuelo = request.getParameter("vuelo");
		String fIda = request.getParameter("fIda");
		String fRegreso = request.getParameter("fRegreso");
		
		if (vuelo != null && fIda != null) {
			IngresoTO ingreso = new IngresoTO(ValorType.getVuelo(Long.valueOf(vuelo)), 
					GenericUtil.stringToDate(fIda), 
					GenericUtil.stringToDate(fRegreso));
			ingreso = this.descuentoDelegate.getDescuento(ingreso);

			if (lista == null) {
				lista = new ArrayList<>();
			}

			lista.add(ingreso);
			request.getSession().setAttribute(LISTA, lista);
		}
		
		return lista;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
