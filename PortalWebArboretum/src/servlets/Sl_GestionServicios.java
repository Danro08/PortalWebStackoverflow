package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Servicios;
import datos.Dt_Servicios;

/**
 * Servlet implementation class Sl_GestionServicios
 */
@WebServlet("/Sl_GestionServicios")
public class Sl_GestionServicios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_GestionServicios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int idServ =0;
		idServ = Integer.parseInt(request.getParameter("idServ"));
		Dt_Servicios dts = new Dt_Servicios();
		
		if(dts.eliminarServ(idServ)) {
        	response.sendRedirect("tblServicios.jsp?msj=5");
        }
        else {
        	response.sendRedirect("tblServicios.jsp?msj=6");
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
		Dt_Servicios dts = new Dt_Servicios();
		Servicios serv = new Servicios();
		serv.setIdUser(Integer.parseInt(request.getParameter("cbxUser")));
		serv.setNombre(request.getParameter("txtNombre"));
		serv.setDescripcion(request.getParameter("txtDesc"));
		
		
		switch (opc){
			case 1:{
				
			        try {
			        	//PARA GUARDAR LA FECHA Y HORA DE CREACION
				        Date fechaSistema = new Date();
				        serv.setfCreacion(new java.sql.Timestamp(fechaSistema.getTime()));
				        System.out.println("serv.getFechaCreacion(): "+serv.getfCreacion());
				        if(dts.guardarServ(serv)) {
				        	response.sendRedirect("tblServicios.jsp?msj=1");
				        }
				        else {
				        	response.sendRedirect("tblServicios.jsp?msj=2");
				        }
				        	
			        	
			        }
			        catch(Exception e) {
			        	System.out.println("Sl_GestionServ, el error es: " + e.getMessage());
						e.printStackTrace();
			        }
			        
					break;
				}
			
			case 2:{
					
				try {
					serv.setIdServ(Integer.parseInt(request.getParameter("idServ")));
		        	//PARA GUARDAR LA FECHA Y HORA DE MODIFICACION
			        Date fechaSistema = new Date();
			        serv.setfModificacion(new java.sql.Timestamp(fechaSistema.getTime()));
			        System.out.println("serv.getfModificacion(): "+serv.getfModificacion());
			        if(dts.modificarServ(serv)) {
			        	response.sendRedirect("tblServicios.jsp?msj=3");
			        }
			        else {
			        	response.sendRedirect("tblServicios.jsp?msj=4");
			        }
			        	
		        	
		        }
		        catch(Exception e) {
		        	System.out.println("Sl_GestionServ, el error es: " + e.getMessage());
					e.printStackTrace();
		        }
					break;
					
				}
			
			default:
				response.sendRedirect("tblServicios.jsp?msj=7");	
				break;
		}
		
		
	}

}
