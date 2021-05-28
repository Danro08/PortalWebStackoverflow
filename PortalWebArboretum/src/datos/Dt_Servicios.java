package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import entidades.Servicios;

public class Dt_Servicios {
	
	//Atributos
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsServicios = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	// Metodo para llenar el RusultSet
	public void llenaRsServicios(Connection c){
		try{
			ps = c.prepareStatement("select * from public.\"servicios\"", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsServicios = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR SERVICIOS "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar Servicios registrados y activos
	public ArrayList<Servicios> listaServiciosActivos(){
		ArrayList<Servicios> listServ = new ArrayList<Servicios>();
		try{
			c = PoolConexion.getConnection();
			ps = c.prepareStatement("select * from public.\"servicios\" where estado<>3", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			while(rs.next()){
				Servicios serv = new Servicios();
				serv.setIdServ(rs.getInt("idServ"));
				serv.setIdUser(rs.getInt("idUser"));
				serv.setNombre(rs.getString("nombre"));
				serv.setDescripcion(rs.getString("descripcion"));
				serv.setEstado(rs.getInt("estado"));
				serv.setfCreacion(rs.getTimestamp("fcreacion"));
				serv.setUrl_foto(rs.getString("url_foto"));
				
				listServ.add(serv);
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
		return listServ;
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
				serv.setIdUser(rs.getInt("idUser"));
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
			rsServicios.updateInt("idUser", serv.getIdUser());
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
					rsServicios.updateInt("idUser", serv.getIdUser());
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
	
	// Metodo para guardar la foto del Servidor
	public boolean guardarFotoServ(int idServ, String urlFoto)
	{
		boolean actualizado = false;
		
		try
		{
			c = PoolConexion.getConnection();
			this.llenaRsServicios(c);	
			rsServicios.beforeFirst();
			while(rsServicios.next())
			{
				if(rsServicios.getInt(1)==idServ)
				{
					
					rsServicios.updateString("url_foto", urlFoto);
					rsServicios.updateInt("estado", 2);
					rsServicios.updateRow();
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
		
		return actualizado;
	}
	

}
