package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.banner;
import datos.Dt_Banner;

/**
 * Servlet implementation class Sl_GestionUsuario
 */
@WebServlet("/S_GestionBanner")
public class SI_GestionBanner extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SI_GestionBanner() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int Mp =0;
		Mp = Integer.parseInt(request.getParameter("Mp"));
		Dt_Banner dtu = new Dt_Banner();
		
		if(dtu.eliminarBanner(Mp)) {
        	response.sendRedirect("tblBanner.jsp?msj=5");
        }
        else {
        	response.sendRedirect("tblBanner.jsp?msj=6");
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
		Dt_Banner dtu = new Dt_Banner();
		banner Bn = new banner();
		
	    Bn.setImg(request.getParameter("txtimg"));
	    
		
		switch (opc){
			case 1:{
				
			        try {
			        	//PARA GUARDAR LA FECHA Y HORA DE CREACION
				       
				        if(dtu.guardarBanner(Bn)) {
				        	response.sendRedirect("tblBanner.jsp?msj=1");
				        }
				        else {
				        	response.sendRedirect("tblBanner.jsp?msj=2");
				        }
				        	
			        	
			        }
			        catch(Exception e) {
			        	System.out.println("Sl_GestionBanner, el error es: " + e.getMessage());
						e.printStackTrace();
			        }
			        
					break;
				}
			
			case 2:{
					
				try {
					Bn.setTbl_bannerID(Integer.parseInt(request.getParameter("tbl_bannerID")));
		        	//PARA GUARDAR LA FECHA Y HORA DE MODIFICACION
		
			        if(dtu.modificarBanner( Bn)) {
			        	response.sendRedirect("tblBanner.jsp?msj=3");
			        }
			        else {
			        	response.sendRedirect("tblBanner.jsp?msj=4");
			        }
			        	
		        	
		        }
		        catch(Exception e) {
		        	System.out.println("Sl_GestionBanner, el error es: " + e.getMessage());
					e.printStackTrace();
		        }
					break;
					
				}
			
			default:
				response.sendRedirect("tblBanner.jsp?msj=7");	
				break;
		}
		
		
	}

}
