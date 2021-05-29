package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entidades.Familia;

public class Dt_Familia {
	
	//Atributos
	PoolConexion pc = PoolConexion.getInstance();
	Connection c = null;
	private ResultSet rsFamilia = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	//Metodos para llenar el ResultSet
		public void llenarFamilia(Connection c)
		{
			try 
			{
				ps = c.prepareStatement("SELECT * FROM public.\"Familia\"", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			}
			catch (Exception e) 
			{
				System.out.println("DATOS: ERROR EN LISTAR FAMILIA "+ e.getMessage());
				e.printStackTrace();
				// TODO: handle exception
			}
		}//fin del metodo para llenar el ResulSet
		
		//Metodo para visualizar familias registrados y activos
		public ArrayList<Familia> listaFamiliaActivos()
		{
			ArrayList<Familia> listFamilia = new ArrayList<Familia>();
			try
			{
				c = PoolConexion.getConnection();
				ps = c.prepareStatement("SELECT * FROM public.\"Familia\" WHERE \"estado\" <>3", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				rs = ps.executeQuery();
				while(rs.next())
				{
					Familia fam = new Familia();
					fam.setDescripcion(rs.getString("descripcion"));
					fam.setEstado(rs.getInt("estado"));
					fam.setNombre(rs.getString("nombre"));
					fam.setFamiliaID(rs.getInt("familiaID"));
					listFamilia.add(fam);
				}
			}
			catch (Exception e) 
			{
				System.out.println("DATOS: ERROR EN LISTAR FAMILIA 00"+ e.getMessage());
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
			return listFamilia;
		} //fin del metodo de visualizar todas las damilias
		
		
		//Metodo para visualizar los datos de una familia especifica
		public Familia getFamilia(int idFamilia)
		{
			Familia fam = new Familia();
			try
			{
				c = PoolConexion.getConnection();
				ps = c.prepareStatement("SELECT * FROM public.\"Familia\" WHERE \"estado\" <> 3 AND \"familiaID\" = ?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				ps.setInt(1, idFamilia);
				rs = ps.executeQuery();
				if(rs.next())
				{
					fam.setDescripcion(rs.getString("descripcion"));
					fam.setEstado(rs.getInt("estado"));
					fam.setNombre(rs.getString("nombre"));
					fam.setFamiliaID(idFamilia);
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
			return fam;
		} //fin del metodo visualizar de una especifica familia
		
		//Metodo para almacenar nueva familia
		public boolean guardarFamilia(Familia fam)
		{
			Boolean guardado = false;
			try
			{
				c = PoolConexion.getConnection();
				this.llenarFamilia(c);
				rsFamilia.moveToInsertRow();
				
				rsFamilia.updateString("descripcion", fam.getDescripcion());
				rsFamilia.updateInt("estado", 1);
				rsFamilia.updateString("nombre", fam.getNombre());
				rsFamilia.insertRow();
				rsFamilia.moveToCurrentRow();
				guardado = true;
			}
			catch (Exception e) 
			{
				System.err.println("ERROR AL GUARDAR FAMILIA "+e.getMessage());
				e.printStackTrace();
				// TODO: handle exception
			}
			finally 
			{
				try
				{
					if(rsFamilia != null){
						rsFamilia.close();
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
		} //fin de guardar familia
		
		//Metodo para modificar familia
		public boolean modificarFamilia(Familia fam)
		{
			boolean modificado=false;
			try
			{
				c = PoolConexion.getConnection();
				this.llenarFamilia(c);
				rsFamilia.beforeFirst();
				while (rsFamilia.next())
				{
					if(rsFamilia.getInt(1)==fam.getFamiliaID())
					{
						rsFamilia.updateString("descripcion",fam.getDescripcion());
						rsFamilia.updateInt("estado", 2);
						rsFamilia.updateString("nombre", fam.getNombre());
						rsFamilia.updateRow();					
						modificado=true;
						break;
					}
				}
			}
			catch (Exception e) {
				System.err.println("ERROR AL ACTUALIZAR FAMILIA "+e.getMessage());
				e.printStackTrace();
				// TODO: handle exception
			}
			finally 
			{
				try
				{
					if(rsFamilia != null){
						rsFamilia.close();
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
		} //fin de modificar familia
		
		public boolean eliminarFamilia(int idFamilia)
		{
			boolean eliminado = false;
			try
			{
				c = PoolConexion.getConnection();
				this.llenarFamilia(c);
				rsFamilia.beforeFirst();
				while (rsFamilia.next())
				{
					if(rsFamilia.getInt(1)==idFamilia)
					{
						rsFamilia.updateInt("estado", 3);
						rsFamilia.updateRow();
						eliminado=true;
						break;
					}
				}
			}
			catch (Exception e) 
			{
				System.err.println("ERROR AL ELIMINAR FAMILIA "+e.getMessage());
				e.printStackTrace();
				// TODO: handle exception
			}
			finally
			{
				try
				{
					if(rsFamilia != null){
						rsFamilia.close();
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
}
