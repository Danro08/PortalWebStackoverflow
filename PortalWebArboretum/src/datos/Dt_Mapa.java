package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


//importando entidades
import entidades.Mapa;



public class Dt_Mapa {
	
	//Atributos
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsMapa= null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	// Metodo para llenar el RusultSet
	public void llenaRsMapa(Connection c){
		try{
			ps = c.prepareStatement("select * from public.\"Mapa\"", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rsMapa = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN RECUPERAR MAPA "+ e.getMessage());
			e.printStackTrace();
		}
	}
	//Metodo para visualizar mapas  registrados y activos
		public ArrayList<Mapa> listaMapaActivos(){
			ArrayList<Mapa> listMap = new ArrayList<Mapa>();
			try{
				c = PoolConexion.getConnection();
				ps = c.prepareStatement("select * from public.\"Mapa\" where estado<>3", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				rs = ps.executeQuery();
				while(rs.next()){
					Mapa Mp = new Mapa();
					Mp.setEstado(rs.getInt("estado"));
					Mp.setNombre(rs.getString("nombre"));
					Mp.setMapaID(rs.getInt("mapaID"));
					Mp.setSectorID(rs.getInt("sectorID"));
					listMap.add(Mp);
				}
			}
			catch (Exception e){
				System.out.println("DATOS: ERROR EN LISTAR MAPAS "+ e.getMessage());
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
			return listMap;
		}
		// Metodo para visualizar los datos de un Mapa específico
		public Mapa getMapa(int mapaID)
		{
			Mapa Mp = new Mapa();
			try
			{
				c = PoolConexion.getConnection();
				ps = c.prepareStatement("select * from public.\"Mapa\" where estado <> 3 and \"mapaID\"=?", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
				ps.setInt(1, mapaID);
				rs = ps.executeQuery();
				if(rs.next())
				{
					Mp.setEstado(rs.getInt("estado"));
					Mp.setNombre(rs.getString("nombre"));
					Mp.setMapaID(rs.getInt("mapaID"));
					Mp.setSectorID(rs.getInt("sectorID"));
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
			
			return Mp;
		}
		//Metodo para almacenar nuevo Mapa
		public boolean guardarMapa(Mapa Mp){
			boolean guardado = false;
			
			try{
				c = PoolConexion.getConnection();
				this.llenaRsMapa(c);
				rsMapa.moveToInsertRow();
				
				rsMapa.updateInt("estado", 1);
				rsMapa.updateString("nombre", Mp.getNombre());
				//rsMapa.updateInt("mapaID",2);
				rsMapa.updateInt("sectorID", Mp.getSectorID());
				rsMapa.insertRow();
				rsMapa.moveToCurrentRow();
				guardado = true;
			}
			catch (Exception e) {
				System.err.println("ERROR AL GUARDAR Usuario "+e.getMessage());
				e.printStackTrace();
			}
			finally{
				try {
					if(rsMapa != null){
						rsMapa.close();
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
		
		// Metodo para modificar Mapa
		public boolean modificarMapa(Mapa Mp)
		{
			boolean modificado=false;	
			try
			{
				c = PoolConexion.getConnection();
				this.llenaRsMapa(c);
				rsMapa.beforeFirst();
				while (rsMapa.next())
				{
					if(rsMapa.getInt(1)==Mp.getMapaID())
					{
						rsMapa.updateInt("sectorID", Mp.getSectorID());
						rsMapa.updateString("nombre", Mp.getNombre());
						rsMapa.updateInt("estado", 2);
						rsMapa.updateRow();
						modificado=true;
						break;
					}
				}
			}
			catch (Exception e)
			{
				System.err.println("ERROR AL ACTUALIZAR Mapa "+e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				try {
					if(rsMapa != null){
						rsMapa.close();
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
		
		// Metodo para eliminar Mapa
		public boolean eliminarMapa(int mapaID)
		{
			boolean eliminado=false;	
			try
			{
				c = PoolConexion.getConnection();
				this.llenaRsMapa(c);
				rsMapa.beforeFirst();
				
				while (rsMapa.next())
				{
					if(rsMapa.getInt(1)==mapaID)
					{
						
						rsMapa.updateInt("estado", 3);
						
						rsMapa.updateRow();
						eliminado=true;
						break;
					}
				}
			}
			catch (Exception e)
			{
				System.err.println("ERROR AL ACTUALIZAR Mapa "+e.getMessage());
				e.printStackTrace();
			}
			finally
			{
				try {
					if(rsMapa != null){
						rsMapa.close();
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
