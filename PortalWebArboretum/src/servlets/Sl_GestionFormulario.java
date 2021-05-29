package servlets;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.FormularioServ;
import datos.Dt_FormularioServ;

/**
 * Servlet implementation class Sl_GestionServicios
 */
@WebServlet("/Sl_GestionFormulario")
public class Sl_GestionFormulario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sl_GestionFormulario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int idFormulario =0;
		idFormulario = Integer.parseInt(request.getParameter("idFormulario"));
		Dt_FormularioServ dtfs = new Dt_FormularioServ();
		
		if(dtfs.eliminarFServ(idFormulario)) {
        	response.sendRedirect("tblFormularioServ.jsp?msj=5");
        }
        else {
        	response.sendRedirect("tblFormularioServ.jsp?msj=6");
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
		Dt_FormularioServ dtfs = new Dt_FormularioServ();
		FormularioServ Fserv = new FormularioServ();
		Fserv.setIdServ(Integer.parseInt(request.getParameter("cbxServ")));
		Fserv.setNombreUsuario(request.getParameter("txtNombre"));
		Fserv.setEmail(request.getParameter("txtEmail"));
		Fserv.setCuerpoEmail(request.getParameter("txtDesc"));
		Fserv.setNumerotelefono(request.getParameter("txtNumero"));
		
		
		
		
		switch (opc){
			case 1:{
				
			        try {
			        	//PARA GUARDAR LA FECHA Y HORA DE CREACION
				        Date fechaSistema = new Date();
				        Fserv.setfCreacion(new java.sql.Timestamp(fechaSistema.getTime()));
				        System.out.println("Fserv.getFechaCreacion(): "+Fserv.getfCreacion());
				        if(dtfs.guardarFServ(Fserv)) {
				        	response.sendRedirect("PgServicios.jsp?msj=1");
				        }
				        else {
				        	response.sendRedirect("PgServicios.jsp?msj=2");
				        }
				        	
			        	
			        }
			        catch(Exception e) {
			        	System.out.println("Sl_GestionFormulario, el error es: " + e.getMessage());
						e.printStackTrace();
			        }
			        
					break;
				}
			
			/*case 2:{
					
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
					
				}*/
			
			default:
				response.sendRedirect("Pgservicios.jsp?msj=7");	
				break;
		}
		
		
	}

}
