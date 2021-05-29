package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Floracion;

public class Dt_Floracion {
	
	//Atributos
	PoolConexion pc = PoolConexion.getInstance();
	Connection c = null;
	private ResultSet rsFloracion = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodos para llenar el ResultSet
	public void llenarFloracion(Connection c)
	{
		try 
		{
			ps = c.prepareStatement("SELECT * FROM public.\"Floracion\"", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
		}
		catch (Exception e) 
		{
			System.out.println("DATOS: ERROR EN LISTAR FLORACION "+ e.getMessage());
			e.printStackTrace();
			// TODO: handle exception
		}
	}//fin del metodo para llenar el ResulSet
	
	//Metodo para visualizar floracion registrados y activos
	public ArrayList<Floracion> listaFloracionActivos()
	{
		ArrayList<Floracion> listFloracion = new ArrayList<Floracion>();
		try
		{
			c = PoolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM public.\"Floracion\" WHERE \"estado\" <>3", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			while(rs.next())
			{
				Floracion flor = new Floracion();
				flor.setDescripcion(rs.getString("descripcion"));
				flor.setEstado(rs.getInt("estado"));
				flor.setNombre(rs.getString("nombre"));
				flor.setTemporada(rs.getString("temporada"));
				flor.setFloracionID(rs.getInt("floracionID"));
				listFloracion.add(flor);
			}
		}
		catch (Exception e) 
		{
			System.out.println("DATOS: ERROR EN LISTAR FLORACION 00"+ e.getMessage());
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
		return listFloracion;
	} //fin del metodo de visualizar todas las flores
	
	//Metodo para visualizar los datos de una flor especifica
	public Floracion getFloracion(int idFloracion)
	{
		Floracion flor = new Floracion();
		try
		{
			c = PoolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM public.\"Floracion\" where \"estado\" <> 3 AND \"floracionID\" = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, idFloracion);
			rs = ps.executeQuery();
			if(rs.next())
			{
				flor.setDescripcion(rs.getString("descripcion"));
				flor.setEstado(rs.getInt("estado"));
				flor.setNombre(rs.getString("nombre"));
				flor.setTemporada(rs.getString("temporada"));
				flor.setFloracionID(idFloracion);
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
		return flor;
	} //fin del metodo visualizar de una especifica flor
	
	//Metodo para almacenar nueva flor
	public boolean guardarFlor(Floracion flor)
	{
		Boolean guardado = false;
		try
		{
			c = PoolConexion.getConnection();
			this.llenarFloracion(c);
			rsFloracion.moveToInsertRow();
			
			rsFloracion.updateString("descripcion", flor.getDescripcion());
			rsFloracion.updateInt("estado", 1);
			rsFloracion.updateString("nombre", flor.getNombre());
			rsFloracion.updateString("temporada", flor.getTemporada());
			rsFloracion.insertRow();
			rsFloracion.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) 
		{
			System.err.println("ERROR AL GUARDAR FLORACION "+e.getMessage());
			e.printStackTrace();
			// TODO: handle exception
		}
		finally 
		{
			try
			{
				if(rsFloracion != null){
					rsFloracion.close();
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
	} //fin de guardar flor
	
	//Metodo para modificar flor
	public boolean modificarFlor(Floracion flor)
	{
		boolean modificado=false;
		try
		{
			c = PoolConexion.getConnection();
			this.llenarFloracion(c);
			rsFloracion.beforeFirst();
			while (rsFloracion.next())
			{
				if(rsFloracion.getInt(1)==flor.getFloracionID())
				{
					rsFloracion.updateString("descripcion",flor.getDescripcion());
					rsFloracion.updateInt("estado", 2);
					rsFloracion.updateString("nombre", flor.getNombre());
					rsFloracion.updateString("temporada", flor.getTemporada());
					rsFloracion.updateRow();					
					modificado=true;
					break;
				}
			}
		}
		catch (Exception e) {
			System.err.println("ERROR AL ACTUALIZAR FLORACION "+e.getMessage());
			e.printStackTrace();
			// TODO: handle exception
		}
		finally 
		{
			try
			{
				if(rsFloracion != null){
					rsFloracion.close();
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
	} //fin de modificar flor
	
	public boolean eliminarFlor(int idFloracion)
	{
		boolean eliminado = false;
		try
		{
			c = PoolConexion.getConnection();
			this.llenarFloracion(c);
			rsFloracion.beforeFirst();
			while (rsFloracion.next())
			{
				if(rsFloracion.getInt(1)==idFloracion)
				{
					rsFloracion.updateInt("estado", 3);
					rsFloracion.updateRow();
					eliminado=true;
					break;
				}
			}
		}
		catch (Exception e) 
		{
			System.err.println("ERROR AL ELIMINAR FLOR "+e.getMessage());
			e.printStackTrace();
			// TODO: handle exception
		}
		finally
		{
			try
			{
				if(rsFloracion != null){
					rsFloracion.close();
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
