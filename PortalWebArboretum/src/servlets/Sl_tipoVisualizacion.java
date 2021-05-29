package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_tipoDeVisualizacion;
import entidades.tipoVisualizacion;

/**
 * Servlet implementation class Sl_GetionRol
 */
@WebServlet("/Sl_tipoVisualizacion")
public class Sl_tipoVisualizacion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Sl_tipoVisualizacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		
		//obtenemos el valor de opcion
		int opc = 0;
		opc = Integer.parseInt(request.getParameter("opcion"));
		
		//CONSTRUIR EL OBJETO ROL
		Dt_tipoDeVisualizacion dtv = new Dt_tipoDeVisualizacion();
		tipoVisualizacion tp = new tipoVisualizacion();
		
		tp.setDescripcion(request.getParameter("txtdescripcion"));
		tp.setNombre(request.getParameter("txtnombre"));
		
		/*switch (opc){
		case 1:{
			
		        try {
		        	if(dtp.guardarTP(tp)) {
			        	response.sendRedirect("tbltipoVisualizacion.jsp?msj=1");
			        }
			        else {
			        	response.sendRedirect("tbltipoVisualizacion.jsp?msj=2");
			        }
		        	PARA GUARDAR LA FECHA Y HORA DE CREACION
			        Date fechaSistema = new Date();
			        user.setfCreacion(new java.sql.Timestamp(fechaSistema.getTime()));
			        System.out.println("user.getFechaCreacion(): "+user.getfCreacion());
			        if(dtu.guardarUser(user)) {
			        	response.sendRedirect("tblUsuarios.jsp?msj=1");
			        }
			        else {
			        	response.sendRedirect("tblUsuarios.jsp?msj=2");
			        }
			        	
		        	
		        }
		        catch(Exception e) {
		        	System.out.println("Sl_tipoVisualizacion, el error es: " + e.getMessage());
					e.printStackTrace();
		        }
		        
				break;
			}
		
		case 2:{
			try {
				tp.setTipoproductoID(Integer.parseInt(request.getParameter("tipoproductoID")));
		        if(dtp.modificarTP(tp)) {
		        	response.sendRedirect("tbltipoVisualizacion.jsp?msj=3");
		        }
		        else {
		        	response.sendRedirect("tbltipoVisualizacion.jsp?msj=4");
		        }
	        }
	        catch(Exception e) {
	        	System.out.println("Sl_tipoVisualizacion, el error es: " + e.getMessage());
				e.printStackTrace();
	        }
				break;
				
			}
		
		default:
			response.sendRedirect("tbltipoVisualizacion.jsp?msj=5");	
			break;
	}*/
		
	}

}
