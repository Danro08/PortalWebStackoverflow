package entidades;

public class tipoVisualizacion {
	
	private String descripcion;
	private String nombre;
	private int tipodevisualizacionID;
	private int estado;
	
	
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTipodevisualizacionID() {
		return tipodevisualizacionID;
	}
	public void setTipodevisualizacionID(int tipodevisualizacionID) {
		this.tipodevisualizacionID = tipodevisualizacionID;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}

}
