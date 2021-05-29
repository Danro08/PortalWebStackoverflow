package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import entidades.Infocontacto;
import entidades.banner;


public class Dt_infocontacto {
	//Atributos
			PoolConexion pc = PoolConexion.getInstance(); 
			Connection c = null;
			private ResultSet rsinfocontacto = null;
			private ResultSet rs = null;
			private PreparedStatement ps = null;
			
			// Metodo para llenar el RusultSet
			public void llenaRsinfocontacto(Connection c){
				try{
					ps = c.prepareStatement("SELECT * FROM PUBLIC.\"Tbl_infocontacto\"", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
					rsinfocontacto = ps.executeQuery();
				}
				catch (Exception e){
					System.out.println("DATOS: ERROR EN LISTAR INFO CONTACTO "+ e.getMessage());
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

}
