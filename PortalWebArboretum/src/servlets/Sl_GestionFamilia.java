package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Familia;
import datos.Dt_Familia;

@WebServlet("/Sl_GestionFamilia")
public class Sl_GestionFamilia extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
     * @see HttpServlet#HttpServlet()
     */
	
	public Sl_GestionFamilia() 
	{
		super();
        // TODO Auto-generated constructor stub
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int familiaID = 0;
		familiaID = Integer.parseInt(request.getParameter("idFa"));
		Dt_Familia dtfa = new Dt_Familia();
		
		if(dtfa.eliminarFamilia(familiaID))
		{
			response.sendRedirect("tblFamilia.jsp?msj=5");
		}
		else
		{
			response.sendRedirect("tblFamilia.jsp?msj=6");
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
		Dt_Familia dtfa = new Dt_Familia();
		Familia fam = new Familia();
		
		fam.setDescripcion(request.getParameter("txtDescripcion"));
		fam.setNombre(request.getParameter("txtNombre"));
		
		switch (opc) {
		case 1:
		{
			try
			{
				if(dtfa.guardarFamilia(fam))
				{
					response.sendRedirect("tblFamilia.jsp?msj=1");
				}
				else
				{
					response.sendRedirect("tblFamilia.jsp?msj=2");	
				}
			}
			catch (Exception e) 
			{
				System.out.println("Sl_GestionFamilia, el error es: " + e.getMessage());
				e.printStackTrace();
				// TODO: handle exception
			}			
			break;			
		}
		case 2:
		{
			try
			{
				fam.setFamiliaID(Integer.parseInt(request.getParameter("idFamilia")));
				if(dtfa.modificarFamilia(fam))
				{
					response.sendRedirect("tblFamilia.jsp?msj=3");
				}
				else
				{
					response.sendRedirect("tblFamilia.jsp?msj=4");
				}
			}
			catch (Exception e) 
			{
				System.out.println("Sl_GestionFamilia, el error es: " + e.getMessage());
				e.printStackTrace();
				// TODO: handle exception
			}
			break;
		}
		
		default:
			response.sendRedirect("tblFamilia.jsp?msj=7");
			break;
		}
	}
	
}
