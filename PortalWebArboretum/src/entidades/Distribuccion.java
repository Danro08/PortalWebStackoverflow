package entidades;

public class Distribuccion {

	//Atributos
	private String descripcion;
	private int estado;
	private String nombre;
	private int distribuccionID;
	private int paisID;
	
	//Metodos
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getDistribuccionID() {
		return distribuccionID;
	}
	public void setDistribuccionID(int distribuccionID) {
		this.distribuccionID = distribuccionID;
	}
	public int getPaisID() {
		return paisID;
	}
	public void setPaisID(int paisID) {
		this.paisID = paisID;
	}	
}
