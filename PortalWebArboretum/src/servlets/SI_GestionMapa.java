package servlets;
import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datos.Dt_Mapa;
import entidades.Mapa;
/**
 * Servlet implementation class Sl_GestionMapa
 */
@WebServlet("/Sl_GestionMapa")
public class SI_GestionMapa extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SI_GestionMapa() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int mapaID =0;
		mapaID = Integer.parseInt(request.getParameter("mapaID"));
		Dt_Mapa Mp = new Dt_Mapa();
		
		if(Mp.eliminarMapa(mapaID)) {
        	response.sendRedirect("tblMapa.jsp?msj=5");
        }
        else {
        	response.sendRedirect("tblMapa.jsp?msj=6");
        }
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		//obtenemos el valor de opcion
		int opc = 0;
		opc = Integer.parseInt(request.getParameter("opcion"));
		
		//CONSTRUIR EL OBJETO USUARIO
		Dt_Mapa dtu = new Dt_Mapa();
		Mapa Mp = new Mapa();
		Mp.setSectorID(Integer.parseInt(request.getParameter("txtsectorID")));
		Mp.setNombre(request.getParameter("txtnombre"));
		
		
		switch (opc){
			case 1:{
				
			        try {
			        	//PARA GUARDAR LA FECHA Y HORA DE CREACION
				   
				        if(dtu.guardarMapa(Mp)) {
				        	response.sendRedirect("tblMapa.jsp?msj=1");
				        }
				        else {
				        	response.sendRedirect("tblMapa.jsp?msj=2");
				        }
				        	
			        	
			        }
			        catch(Exception e) {
			        	System.out.println("Sl_GestionMapa, el error es: " + e.getMessage());
						e.printStackTrace();
			        }
			        
					break;
				}
			
			case 2:{
					
				try {
					Mp.setMapaID(Integer.parseInt(request.getParameter("mapaID")));
					
		        	//PARA GUARDAR LA FECHA Y HORA DE MODIFICACION
			        if(dtu.modificarMapa(Mp)) {
			        	response.sendRedirect("tblMapa.jsp?msj=3");
			        }
			        else {
			        	response.sendRedirect("tblMapa.jsp?msj=4");
			        }
			        	
		        	
		        }
		        catch(Exception e) {
		        	System.out.println("Sl_GestionMapa, el error es: " + e.getMessage());
					e.printStackTrace();
		        }
					break;
					
				}
			
			default:
				response.sendRedirect("tblMapa.jsp?msj=7");	
				break;
		}
		
		
	}

}
