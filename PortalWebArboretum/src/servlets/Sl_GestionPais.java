package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidades.Pais;
import datos.Dt_Pais;

@WebServlet("/Sl_GestionPais")
public class Sl_GestionPais extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public Sl_GestionPais() 
	{
		super();
        // TODO Auto-generated constructor stub
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int paisID = 0;
		paisID = Integer.parseInt(request.getParameter("idP"));
		Dt_Pais dtp = new Dt_Pais();
		
		if(dtp.eliminarPais(paisID))
		{
			response.sendRedirect("tblPais.jsp?msj=5");
		}
		else
		{
			response.sendRedirect("tblPais.jsp?msj=6");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		//obtenemos el valor de opcion
		int opc = 0;
		opc = Integer.parseInt(request.getParameter("opcion"));
		
		//CONTRUIR EL OBJETO FLOR
		Dt_Pais dtp = new Dt_Pais();
		Pais pa = new Pais();
		
		pa.setNombre(request.getParameter("txtNombre"));
		
		switch (opc) {
		case 1:
		{
			try
			{
				if(dtp.guardarPais(pa))
				{
					response.sendRedirect("tblPais.jsp?msj=1");
				}
				else
				{
					response.sendRedirect("tblPais.jsp?msj=2");	
				}
			}
			catch (Exception e) 
			{
				System.out.println("Sl_GestionPais, el error es: " + e.getMessage());
				e.printStackTrace();
				// TODO: handle exception
			}			
			break;			
		}
		
		case 2:
		{
			try
			{
				pa.setPaisID(Integer.parseInt(request.getParameter("idPais")));
				if(dtp.modificarPais(pa))
				{
					response.sendRedirect("tblPais.jsp?msj=3");
				}
				else
				{
					response.sendRedirect("tblPais.jsp?msj=4");
				}
			}
			catch (Exception e) 
			{
				System.out.println("Sl_GestionPais, el error es: " + e.getMessage());
				e.printStackTrace();
				// TODO: handle exception
			}
			break;
		}
		
		default:
			response.sendRedirect("tblPais.jsp?msj=7");
			break;
		}
	}

}
