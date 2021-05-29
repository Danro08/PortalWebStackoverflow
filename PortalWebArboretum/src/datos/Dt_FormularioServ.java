package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import entidades.FormularioServ;

public class Dt_FormularioServ {
	
	//Atributos
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsformularioServ = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	// Metodo para llenar el RusultSet
	public void llenaRsFServicios(Connection c){
		try{
			ps = c.prepareStatement("select * from public.\"formularioServ\"", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsformularioServ = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR SERVICIOS "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar Formularios registrados y activos
	public ArrayList<FormularioServ> listaFServActivos(){
		ArrayList<FormularioServ> listFServ = new ArrayList<FormularioServ>();
		try{
			c = PoolConexion.getConnection();
			ps = c.prepareStatement("select * from public.\"formularioServ\" where estado<>3", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			while(rs.next()){
				FormularioServ Fserv = new FormularioServ();
				Fserv.setIdFormulario(rs.getInt("idFormulario"));
				Fserv.setIdServ(rs.getInt("idServ"));
				Fserv.setNombreUsuario(rs.getString("nombreUsuario"));
				Fserv.setEmail(rs.getString("email"));
				Fserv.setCuerpoEmail(rs.getString("cuerpoEmail"));
				Fserv.setNumerotelefono(rs.getString("numerotelefono"));
				Fserv.setfCreacion(rs.getTimestamp("fcreacion"));
				Fserv.setEstado(rs.getInt("estado"));
				
				listFServ.add(Fserv);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Formularios "+ e.getMessage());
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
		return listFServ;
	}
	
	// Metodo para visualizar los datos de un servicio específico
	/*public Servicios getServicios(int idServ)
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
	}*/
	
	//Metodo para almacenar nuevo Formulario
	public boolean guardarFServ(FormularioServ Fserv){
		boolean guardado = false;
		
		try{
			c = PoolConexion.getConnection();
			this.llenaRsFServicios(c);
			rsformularioServ.moveToInsertRow();
			rsformularioServ.updateInt("idServ", Fserv.getIdServ());
			rsformularioServ.updateString("nombreUsuario", Fserv.getNombreUsuario());
			rsformularioServ.updateString("email", Fserv.getEmail());
			rsformularioServ.updateString("cuerpoEmail", Fserv.getCuerpoEmail());
			rsformularioServ.updateString("numerotelefono", Fserv.getNumerotelefono());
			rsformularioServ.updateInt("estado", 1);
			rsformularioServ.updateTimestamp("fcreacion", Fserv.getfCreacion());
			rsformularioServ.insertRow();
			rsformularioServ.moveToCurrentRow();
			guardado = true;
		}
		catch (Exception e) {
			System.err.println("ERROR AL GUARDAR Formulario "+e.getMessage());
			e.printStackTrace();
		}
		finally{
			try {
				if(rsformularioServ != null){
					rsformularioServ.close();
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
	/*public boolean modificarServ(Servicios serv)
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
	}*/
	
	// Metodo para eliminar usuario
	public boolean eliminarFServ(int idFormulario)
	{
		boolean eliminado=false;	
		try
		{
			c = PoolConexion.getConnection();
			this.llenaRsFServicios(c);
			rsformularioServ.beforeFirst();
			Date fechaSistema = new Date();
			while (rsformularioServ.next())
			{
				if(rsformularioServ.getInt(1)==idFormulario)
				{
					rsformularioServ.updateTimestamp("feliminacion", new java.sql.Timestamp(fechaSistema.getTime()));
					rsformularioServ.updateInt("estado", 3);
					rsformularioServ.updateRow();
					eliminado=true;
					break;
				}
			}
		}
		catch (Exception e)
		{
			System.err.println("ERROR AL ELIMINAR Formulario "+e.getMessage());
			e.printStackTrace();
		}
		finally
		{
			try {
				if(rsformularioServ != null){
					rsformularioServ.close();
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
}
	
	