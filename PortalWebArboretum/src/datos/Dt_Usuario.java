package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.Usuario;


public class Dt_Usuario {

	//Atributos
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsUsuario = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;

	// Metodo para llenar el RusultSet
	public void llenaRsUsuario(Connection c){
		try{
			ps = c.prepareStatement("SELECT * FROM public.\"Usuario\";", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsUsuario = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR USUARIOS "+ e.getMessage());
			e.printStackTrace();
		}
	}

	//Metodo para visualizar usuarios registrados y activos
	public ArrayList<Usuario> listaUserActivos(){
		ArrayList<Usuario> listUser = new ArrayList<Usuario>();
		try{
			c = PoolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM public.\"Usuario\" where \"Estado\" <> 3;", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			while(rs.next()){
				Usuario user = new Usuario();
				user.setUsuarioID(rs.getInt("UsuarioID"));
				user.setNombre(rs.getString("Nombre"));
				user.setApellido(rs.getString("Apellido"));
				user.setNombreUsuario(rs.getString("Nombreusuario"));
				user.setPwd(rs.getString("Pwd"));
				user.setEstado(rs.getInt("Estado"));
				user.setFechaCreacion(rs.getTimestamp("Fechacreacion"));
				listUser.add(user);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR USUARIOS "+ e.getMessage());
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
		return listUser;
	}
	
	// Metodo para visualizar los datos de un usuario específico
		public Usuario getUsuario(int idUsuario)
		{
			Usuario user = new Usuario();
			try
			{
				c = PoolConexion.getConnection();
				ps = c.prepareStatement("select * from public.\"Usuario\" where \"Estado\" <> 3", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				ps.setInt(1, idUsuario);
				rs = ps.executeQuery();
				if(rs.next())
				{
					user.setUsuarioID(idUsuario);
					user.setNombreUsuario(rs.getString("Nombreusuario"));
					user.setPwd(rs.getString("Pwd"));
					user.setNombre(rs.getString("Nombre"));
					user.setApellido(rs.getString("Apellido"));
					user.setEstado(rs.getInt("Estado"));
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

			return user;
		}


		//Metodo para almacenar nuevo usuario
		public boolean guardarUser(Usuario user){
			boolean guardado = false;

			try{
				c = PoolConexion.getConnection();
				this.llenaRsUsuario(c);
				rsUsuario.moveToInsertRow();
//				rsUsuario.updateInt("UsuarioID", 2);
				rsUsuario.updateString("nombreUsuario", user.getNombreUsuario());
				rsUsuario.updateString("pwd", user.getPwd());
				rsUsuario.updateString("nombre", user.getNombre());
				rsUsuario.updateString("apellido", user.getApellido());
				rsUsuario.updateTimestamp("fechaCreacion", user.getFechaCreacion());
				rsUsuario.updateInt("estado", 1);
				rsUsuario.insertRow();
				rsUsuario.moveToCurrentRow();
				guardado = true;
			}
			catch (Exception e) {
				System.err.println("ERROR AL GUARDAR Usuario "+e.getMessage());
				e.printStackTrace();
			}
			finally{
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

			return guardado;
		}

		// Metodo para modificar usuario
		public boolean modificarUser(Usuario user)
		{
			boolean modificado=false;	
			try
			{
				c = PoolConexion.getConnection();
				this.llenaRsUsuario(c);
				rsUsuario.beforeFirst();
				while (rsUsuario.next())
				{
					if(rsUsuario.getInt(1)==user.getUsuarioID())
					{
						rsUsuario.updateString("NombreUsuario", user.getNombreUsuario());
						rsUsuario.updateString("Pwd", user.getPwd());
						rsUsuario.updateString("Nombre", user.getNombre());
						rsUsuario.updateString("Apellido", user.getApellido());
						rsUsuario.updateTimestamp("FechaModificacion", user.getFechaModificacion());
						rsUsuario.updateInt("Estado", 2);
						rsUsuario.updateRow();
						modificado=true;
						break;
					}
				}
			}
			catch (Exception e)
			{
				System.err.println("ERROR AL ACTUALIZAR USUARIO "+e.getMessage());
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
			return modificado;
		}
	
	

}