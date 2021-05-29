package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import entidades.banner;
public class Dt_Banner {
	//Atributos
		PoolConexion pc = PoolConexion.getInstance(); 
		Connection c = null;
		private ResultSet rsBanner = null;
		private ResultSet rs = null;
		private PreparedStatement ps = null;
		
		// Metodo para llenar el RusultSet
		public void llenaRsBanner(Connection c){
			try{
				ps = c.prepareStatement("select * from public.\"Tbl_banner\"", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				rsBanner = ps.executeQuery();
			}
			catch (Exception e){
				System.out.println("DATOS: ERROR EN LISTAR USUARIOS "+ e.getMessage());
				e.printStackTrace();
			}
		}
		
		//Metodo para visualizar banners registrados y activos
		public ArrayList<banner> listabannerActivos(){
			ArrayList<banner> listbanner = new ArrayList<banner>();
			try{
				c = PoolConexion.getConnection();
				ps = c.prepareStatement("select * from public.\"Tbl_banner\" where estado <> 3 ", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				rs = ps.executeQuery();
				while(rs.next()){
					banner bn = new banner();
					bn.setImg(rs.getString("img"));
					bn.setTbl_bannerID(rs.getInt("tbl_bannerID"));
					bn.setEstado(rs.getInt("estado"));
					
					listbanner.add(bn);
				}
			}
			catch (Exception e){
				System.out.println("DATOS: ERROR EN LISTAR BANNERS "+ e.getMessage());
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
			return listbanner;
		}
		
		// Metodo para visualizar los datos de un banner específico
		public banner getBanner(int tbl_bannerID)
		{
			banner bn = new banner();
			try
			{
				c = PoolConexion.getConnection();
				ps = c.prepareStatement("select * from public.\"Tbl_banner\" where estado <> 3 and \"tbl_bannerID\"=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				ps.setInt(1, tbl_bannerID);
				rs = ps.executeQuery();
				if(rs.next())
				{
					bn.setImg(rs.getString("img"));
					bn.setTbl_bannerID(tbl_bannerID);
					bn.setEstado(rs.getInt("estado"));
					
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
			
			return bn;
		}
		
		//Metodo para almacenar nuevo usuario
		public boolean guardarBanner(banner bn){
			boolean guardado = false;
			
			try{
				c = PoolConexion.getConnection();
				this.llenaRsBanner(c);
				rsBanner.moveToInsertRow();
				rsBanner.updateString("img", bn.getImg());
//				rsUsuario.updateInt("UsuarioID", 2);
				rsBanner.updateInt("Estado", 1);
				rsBanner.insertRow();
				rsBanner.moveToCurrentRow();
				guardado = true;
			}
			catch (Exception e) {
				System.err.println("ERROR AL GUARDAR Usuario "+e.getMessage());
				e.printStackTrace();
			}
			finally{
				try {
					if(rsBanner != null){
						rsBanner.close();
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
		
		// Metodo para modificar banner
		public boolean modificarBanner(banner bn)
		{
			boolean modificado=false;	
			try
			{
				c = PoolConexion.getConnection();
				this.llenaRsBanner(c);
				rsBanner.beforeFirst();
				while (rsBanner.next())
				{
					if(rsBanner.getInt(1)==bn.getTbl_bannerID())
					{
						rsBanner.updateString("img", bn.getImg());
						rsBanner.updateInt("estado", 2);
						rsBanner.updateRow();
						modificado=true;
						break;
					}
				}
			}
			catch (Exception e)
			{
				System.err.println("ERROR AL ACTUALIZAR BANNER "+e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				try {
					if(rsBanner != null){
						rsBanner.close();
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
		
		// Metodo para eliminar Banner
		public boolean eliminarBanner(int idBanner)
		{
			boolean eliminado=false;	
			try
			{
				c = PoolConexion.getConnection();
				this.llenaRsBanner(c);
				rsBanner.beforeFirst();

				while (rsBanner.next())
				{
					if(rsBanner.getInt(1)==idBanner)
					{
						rsBanner.updateInt("estado", 3);
						rsBanner.updateRow();
						eliminado=true;
						break;
					}
				}
			}
			catch (Exception e)
			{
				System.err.println("ERROR AL ACTUALIZAR BANNER "+e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				try {
					if(rsBanner != null){
						rsBanner.close();
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
