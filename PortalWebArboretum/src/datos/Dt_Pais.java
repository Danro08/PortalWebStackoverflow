package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Pais;

public class Dt_Pais {
	
	//Atributos
	PoolConexion pc = PoolConexion.getInstance();
	Connection c = null;
	private ResultSet rsPais = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;

	//Metodos para llenar el ResultSet
		public void llenarPais(Connection c)
		{
			try 
			{
				ps = c.prepareStatement("SELECT * FROM public.\"Pais\"", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			}
			catch (Exception e) 
			{
				System.out.println("DATOS: ERROR EN LISTAR PAIS "+ e.getMessage());
				e.printStackTrace();
				// TODO: handle exception
			}
		}//fin del metodo para llenar el ResulSet
		
		
		//Metodo para visualizar paises registrados y activos
		public ArrayList<Pais> listaPaisActivos()
		{
			ArrayList<Pais> listPais = new ArrayList<Pais>();
			try
			{
				c = PoolConexion.getConnection();
				ps = c.prepareStatement("SELECT * FROM public.\"Pais\" WHERE \"estado\" <>3", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				rs = ps.executeQuery();
				while(rs.next())
				{
					Pais pa = new Pais();
					pa.setEstado(rs.getInt("estado"));
					pa.setNombre(rs.getString("nombre"));
					pa.setPaisID(rs.getInt("paisID"));
					listPais.add(pa);
				}
			}
			catch (Exception e) 
			{
				System.out.println("DATOS: ERROR EN LISTAR PAIS"+ e.getMessage());
				e.printStackTrace();
				// TODO: handle exception
			}
			finally
			{
				try 
				{
					if(rs != null)
					{
						rs.close();
					}
					if(ps != null)
					{
						ps.close();
					}
					if(c != null)
					{
						PoolConexion.closeConnection(c);
					}
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
					// TODO: handle exception
				}			
			}
			return listPais;
		} //fin del metodo de visualizar todas las pais
		
		
		//Metodo para visualizar los datos de una pais especifica
		public Pais getPais(int idPais)
		{
			Pais pa = new Pais();
			try
			{
				c = PoolConexion.getConnection();
				ps = c.prepareStatement("SELECT * FROM public.\"Pais\" where \"estado\" <> 3 AND \"paisID\" = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				ps.setInt(1, idPais);
				rs = ps.executeQuery();
				if(rs.next())
				{
					pa.setEstado(rs.getInt("estado"));
					pa.setNombre(rs.getString("nombre"));
					pa.setPaisID(idPais);
				}
				}
			catch (Exception e) {
				System.out.println("DATOS ERROR getNIMA(): "+ e.getMessage());
				e.printStackTrace();
				// TODO: handle exception
			}
			finally
			{
				try
				{
					if(rs != null){
						rs.close();
					}
					if(ps != null){
						ps.close();
					}
					if(c != null){
						PoolConexion.closeConnection(c);
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
			return pa;
		} //fin del metodo visualizar de una especifico pais
		
		//Metodo para almacenar nuevo pais
		public boolean guardarPais(Pais pais)
		{
			Boolean guardado = false;
			try
			{
				c = PoolConexion.getConnection();
				this.llenarPais(c);
				rsPais.moveToInsertRow();				
				rsPais.updateInt("estado", 1);
				rsPais.updateString("nombre", pais.getNombre());
				rsPais.insertRow();
				rsPais.moveToCurrentRow();
				guardado = true;
			}
			catch (Exception e) 
			{
				System.err.println("ERROR AL GUARDAR PAIS "+e.getMessage());
				e.printStackTrace();
				// TODO: handle exception
			}
			finally 
			{
				try
				{
					if(rsPais != null){
						rsPais.close();
					}
					if(c != null){
						PoolConexion.closeConnection(c);
					}
				}
				catch (SQLException e) {
					e.printStackTrace();
					// TODO: handle exception
				}
			}
			return guardado;
		} //fin de guardar pais
		
		//Metodo para modificar pais
		public boolean modificarPais(Pais pais)
		{
			boolean modificado=false;
			try
			{
				c = PoolConexion.getConnection();
				this.llenarPais(c);
				rsPais.beforeFirst();
				while (rsPais.next())
				{
					if(rsPais.getInt(1)==pais.getPaisID())
					{
						rsPais.updateInt("estado", 2);
						rsPais.updateString("nombre", pais.getNombre());
						rsPais.updateRow();					
						modificado=true;
						break;
					}
				}
			}
			catch (Exception e) {
				System.err.println("ERROR AL ACTUALIZAR PAIS "+e.getMessage());
				e.printStackTrace();
				// TODO: handle exception
			}
			finally 
			{
				try
				{
					if(rsPais != null){
						rsPais.close();
					}
					if(c != null){
						PoolConexion.closeConnection(c);
					}
				}
				catch (SQLException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return modificado;
		} //fin de modificar pais
		
		
		public boolean eliminarPais(int idPais)
		{
			boolean eliminado = false;
			try
			{
				c = PoolConexion.getConnection();
				this.llenarPais(c);
				rsPais.beforeFirst();
				while (rsPais.next())
				{
					if(rsPais.getInt(1)==idPais)
					{
						rsPais.updateInt("estado", 3);
						rsPais.updateRow();
						eliminado=true;
						break;
					}
				}
			}
			catch (Exception e) 
			{
				System.err.println("ERROR AL ELIMINAR PAIS "+e.getMessage());
				e.printStackTrace();
				// TODO: handle exception
			}
			finally
			{
				try
				{
					if(rsPais != null){
						rsPais.close();
					}
					if(c != null){
						PoolConexion.closeConnection(c);
					}
				}
				catch (SQLException e) 
				{
					e.printStackTrace();
					// TODO: handle exception
				}
			}
			return eliminado;
		}//fin del meteodo eliminar
	
}//Fin de la clase
