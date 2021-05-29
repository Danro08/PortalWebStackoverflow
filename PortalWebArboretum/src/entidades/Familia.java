package entidades;

public class Familia {
	
	//Atributos
	private String descripcion;
	private int estado;
	private String nombre;
	private int familiaID;
	
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
	public int getFamiliaID() {
		return familiaID;
	}
	public void setFamiliaID(int familiaID) {
		this.familiaID = familiaID;
	}
}
