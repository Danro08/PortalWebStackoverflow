package entidades;

public class tipoProducto {

	//Atributos
	private String descrip_tipo;
	private String tipo_producto;
	private int tipoproductoID;
	private int estado;
	
	
	//Metodos
	public String getDescrip_tipo() {
		return descrip_tipo;
	}
	public void setDescrip_tipo(String descrip_tipo) {
		this.descrip_tipo = descrip_tipo;
	}
	public String getTipo_producto() {
		return tipo_producto;
	}
	public void setTipo_producto(String tipo_producto) {
		this.tipo_producto = tipo_producto;
	}
	public int getTipoproductoID() {
		return tipoproductoID;
	}
	public void setTipoproductoID(int tipoproductoID) {
		this.tipoproductoID = tipoproductoID;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
}
