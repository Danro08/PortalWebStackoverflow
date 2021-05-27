package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import entidades.CatalgServ;

public class Dt_CatalgServ {
	
	//Atributos
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsCatalgServ = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	// Metodo para llenar el RusultSet
	public void llenaRsCatalgServ(Connection c){
		try{
			ps = c.prepareStatement("select * from public.\"catalogoServ\"", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsCatalgServ = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR CATALOGO SERVICIOS "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar Servicios registrados y activos
	public ArrayList<CatalgServ> listaCatalgServActivos(){
		ArrayList<CatalgServ> listCServ = new ArrayList<CatalgServ>();
		try{
			c = PoolConexion.getConnection();
			ps = c.prepareStatement("select * from public.\"catalogoServ\" where estado<>3", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			while(rs.next()){
				CatalgServ cserv = new CatalgServ();
				cserv.setIdCatalgoServ(rs.getInt("idCatalgoServ"));
				cserv.setNombre(rs.getString("nombre"));
				cserv.setTipo(rs.getString("descripcion"));
				cserv.setEstado(rs.getInt("estado"));
				listCServ.add(cserv);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR SERVICIOS "+ e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rs != null){
					rs.close();
				}
				if(ps != null){
					ps.close();
				}
				if(c != null){
					PoolConexion.closeConnection(c);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return listCServ;
	}
	
	// Metodo para visualizar los datos de un servicio específico
	public Servicios getServicios(int idServ)
	{
		Servicios serv = new Servicios();
		try
		{
			c = PoolConexion.getConnection();
			ps = c.prepareStatement("select * from public.\"servicios\" where estado <> 3 and \"idServ\"=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			ps.setInt(1, idServ);
			rs = ps.executeQuery();
			if(rs.next())
			{
				serv.setIdServ(rs.getInt("idServ"));
				serv.setIdCatalogoServ(rs.getInt("IdCatalogoServ"));
				serv.setNombre(rs.getString("nombre"));
				serv.setDescripcion(rs.getString("descripcion"));
				serv.setEstado(rs.getInt("estado"));
				serv.setUrl_foto(rs.getString("url_foto"));
			}
		}
		catch (Exception e)
		{
			System.out.println("DATOS ERROR getNIMA(): "+ e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rs != null){
					rs.close();
				}
				if(ps != null){
					ps.close();
				}
				if(c != null){
					PoolConexion.closeConnection(c);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return serv;
	}
	
	//Metodo para almacenar nuevo servicio
	public boolean guardarServ(Servicios serv){
		boolean guardado = false;
		
		try{
			c = PoolConexion.getConnection();
			this.llenaRsServicios(c);
			rsServicios.moveToInsertRow();
			rsServicios.updateString("nombre", serv.getNombre());
			rsServicios.updateString("descripcion", serv.getDescripcion());
			rsServicios.updateInt("estado", 1);
			rsServicios.updateTimestamp("fcreacion", serv.getfCreacion());
			rsServicios.insertRow();
			rsServicios.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR Servicio "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsServicios != null){
					rsServicios.close();
				}
				if(c != null){
					PoolConexion.closeConnection(c);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return guardado;
	}
	
	// Metodo para modificar usuario
	public boolean modificarServ(Servicios serv)
	{
		boolean modificado=false;	
		try
		{
			c = PoolConexion.getConnection();
			this.llenaRsServicios(c);
			rsServicios.beforeFirst();
			while (rsServicios.next())
			{
				if(rsServicios.getInt(1)==serv.getIdServ())
				{
					rsServicios.updateString("nombre", serv.getNombre());
					rsServicios.updateString("descripcion", serv.getDescripcion());
					rsServicios.updateInt("estado", 2);
					rsServicios.updateTimestamp("fmodificacion", serv.getfModificacion());
					rsServicios.updateRow();
					modificado=true;
					break;
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR AL ACTUALIZAR SERVICIO "+e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rsServicios != null){
					rsServicios.close();
				}
				if(c != null){
					PoolConexion.closeConnection(c);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return modificado;
	}
	
	// Metodo para eliminar usuario
	public boolean eliminarServ(int idServ)
	{
		boolean eliminado=false;	
		try
		{
			c = PoolConexion.getConnection();
			this.llenaRsServicios(c);
			rsServicios.beforeFirst();
			Date fechaSistema = new Date();
			while (rsServicios.next())
			{
				if(rsServicios.getInt(1)==idServ)
				{
					rsServicios.updateTimestamp("feliminacion", new java.sql.Timestamp(fechaSistema.getTime()));
					rsServicios.updateInt("estado", 3);
					rsServicios.updateRow();
					eliminado=true;
					break;
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR AL ELIMINAR SERVICIO "+e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rsServicios != null){
					rsServicios.close();
				}
				if(c != null){
					PoolConexion.closeConnection(c);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return eliminado;
	}
	
	// Metodo para guardar la foto del Usuario
	/*public boolean guardarFotoUser(int idUser, String urlFoto)
	{
		boolean actualizado = false;
		
		try
		{
			c = PoolConexion.getConnection();
			this.llenaRsUsuario(c);	
			rsUsuario.beforeFirst();
			while(rsUsuario.next())
			{
				if(rsUsuario.getInt(1)==idUser)
				{
					
					rsUsuario.updateString("url_foto", urlFoto);
					rsUsuario.updateInt("estado", 2);
					rsUsuario.updateRow();
					actualizado = true;
					break;
				}
			}
		}
		catch (Exception e) 
		{
			System.err.println("ERROR AL GUARDAR FOTO "+e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rsUsuario != null){
					rsUsuario.close();
				}
				if(c != null){
					PoolConexion.closeConnection(c);
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return actualizado;
	}*/
	

}
