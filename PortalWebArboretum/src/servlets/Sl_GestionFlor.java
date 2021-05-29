package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Floracion;
import datos.Dt_Floracion;

@WebServlet("/Sl_GestionFlor")
public class Sl_GestionFlor extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public Sl_GestionFlor() 
	{
		super();
        // TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int floracionID = 0;
		floracionID = Integer.parseInt(request.getParameter("idF"));
		Dt_Floracion dtf = new Dt_Floracion();
		
		if(dtf.eliminarFlor(floracionID))
		{
			response.sendRedirect("tblFloracion.jsp?msj=5");
		}
		else
		{
			response.sendRedirect("tblFloracion.jsp?msj=6");
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		//obtenemos el valor de opcion
		int opc = 0;
		opc = Integer.parseInt(request.getParameter("opcion"));
		
		//CONTRUIR EL OBJETO FLOR
		Dt_Floracion dtf = new Dt_Floracion();
		Floracion flor = new Floracion();
		
		flor.setDescripcion(request.getParameter("txtDescripcion"));
		flor.setNombre(request.getParameter("txtNombre"));
		flor.setTemporada(request.getParameter("txtTemporada"));
		
		switch (opc) {
		case 1:
		{
			try
			{
				if(dtf.guardarFlor(flor))
				{
					response.sendRedirect("tblFloracion.jsp?msj=1");
				}
				else
				{
					response.sendRedirect("tblFloracion.jsp?msj=2");	
				}
			}
			catch (Exception e) 
			{
				System.out.println("Sl_GestionFlor, el error es: " + e.getMessage());
				e.printStackTrace();
				// TODO: handle exception
			}			
			break;			
		}
		
		case 2:
		{
			try
			{
				flor.setFloracionID(Integer.parseInt(request.getParameter("idFloracion")));
				if(dtf.modificarFlor(flor))
				{
					response.sendRedirect("tblFloracion.jsp?msj=3");
				}
				else
				{
					response.sendRedirect("tblFloracion.jsp?msj=4");
				}
			}
			catch (Exception e) 
			{
				System.out.println("Sl_GestionFlor, el error es: " + e.getMessage());
				e.printStackTrace();
				// TODO: handle exception
			}
			break;
		}
		
		default:
			response.sendRedirect("tblFloracion.jsp?msj=7");
			break;
		}
	}

}
