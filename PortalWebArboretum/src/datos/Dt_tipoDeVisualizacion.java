package datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import entidades.tipoVisualizacion;


public class Dt_tipoDeVisualizacion {
	
	//Atributos
	PoolConexion pc = PoolConexion.getInstance(); 
	Connection c = null;
	private ResultSet rsTV = null;
	private ResultSet rs = null;
	private PreparedStatement ps = null;
	
	
	// Metodo para llenar el RusultSet
	public void llenarTV(Connection c){
		try{
			ps = c.prepareStatement("select * from public.\"Tipodevisualizacion\"", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR Tipos de visualizacion "+ e.getMessage());
			e.printStackTrace();
		}
	}
	
	//Metodo para visualizar usuarios registrados y activos
	public ArrayList<tipoVisualizacion> listaTVactivos(){
		ArrayList<tipoVisualizacion> listTV = new ArrayList<tipoVisualizacion>();
		try{
			c = PoolConexion.getConnection();
			ps = c.prepareStatement("SELECT * FROM public.\"Tipodevisualizacion\" WHERE \"estado\" <> 3", ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE, ResultSet.HOLD_CURSORS_OVER_COMMIT);
			rs = ps.executeQuery();
			while(rs.next()){
				tipoVisualizacion tv = new tipoVisualizacion();
				tv.setEstado(rs.getInt("estado"));
				tv.setDescripcion(rs.getString("descripcion"));
				tv.setNombre(rs.getString("nombre"));
				tv.setTipodevisualizacionID(rs.getInt("tipodevisualizacionID"));				
				listTV.add(tv);
			}
		}
		catch (Exception e){
			System.out.println("DATOS: ERROR EN LISTAR TIPOS DE VISUALIZACION "+ e.getMessage());
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
		return listTV;
	}
	
	/*
	 * // Metodo para visualizar los datos de un tipoProducot específico public
	 * tipoProducto getTipoProducto(int tipoproductoID ) { tipoProducto tp = new
	 * tipoProducto(); try { c = PoolConexion.getConnection(); ps = c.
	 * prepareStatement("select * from public.Tipodevisualizacion where estado <> 3 and tipodevisualizacionID=?"
	 * , ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE,
	 * ResultSet.HOLD_CURSORS_OVER_COMMIT); ps.setInt(1, tipoproductoID); rs =
	 * ps.executeQuery(); if(rs.next()) {
	 * tp.setDescrip_tipo(rs.getString("descrip_tipo"));
	 * tp.setTipo_producto(rs.getString("tipo_producto"));
	 * tp.setTipoproductoID(rs.getInt("tipoproductoID"));
	 * tp.setEstado(rs.getInt("estado")); } } catch (Exception e) {
	 * System.out.println("DATOS ERROR getTipoProducto(): "+ e.getMessage());
	 * e.printStackTrace(); } finally { try { if(rs != null){ rs.close(); } if(ps !=
	 * null){ ps.close(); } if(c != null){ PoolConexion.closeConnection(c); }
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 * 
	 * return tp; }
	 * 
	 * // Metodo para modificar rol public boolean modificarTP(tipoProducto tp) {
	 * boolean modificado=false; try { c = PoolConexion.getConnection();
	 * this.llenarTP(c); rsTP.beforeFirst(); while (rsTP.next()) {
	 * if(rsTP.getInt(1)==tp.getTipoproductoID()) {
	 * rsTP.updateString("descrip_tipo", tp.getDescrip_tipo());
	 * rsTP.updateString("tipo_producto", tp.getTipo_producto());
	 * rsTP.updateInt("estado", 2); rsTP.updateRow(); modificado=true; break; } } }
	 * catch (Exception e) {
	 * System.err.println("ERROR AL ACTUALIZAR "+e.getMessage());
	 * e.printStackTrace(); } finally { try { if(rsTP != null){ rsTP.close(); } if(c
	 * != null){ PoolConexion.closeConnection(c); }
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } } return modificado; }
	 * 
	 * //Metodo para guardar Rol public boolean guardarTP(tipoProducto tp){ boolean
	 * guardado = false;
	 * 
	 * try{ c = PoolConexion.getConnection(); this.llenarTP(c);
	 * rsTP.moveToInsertRow(); rsTP.updateString("descrip_tipo",
	 * tp.getDescrip_tipo()); rsTP.updateString("tipo_producto",
	 * tp.getTipo_producto()); rsTP.updateInt("tipoproductoID", 3);
	 * rsTP.updateInt("estado", 1); rsTP.insertRow(); rsTP.moveToCurrentRow();
	 * guardado = true; } catch (Exception e) {
	 * System.err.println("ERROR AL GUARDAR "+e.getMessage()); e.printStackTrace();
	 * } finally{ try { if(rsTP != null){ rsTP.close(); } if(c != null){
	 * PoolConexion.closeConnection(c); }
	 * 
	 * } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 * 
	 * return guardado; }
	 */
	

}
