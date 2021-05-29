package entidades;

public class Genero {
	
	//Atributos
	private String descripcion;
	private int estado;
	private String nombre;
	private int generoID;
	
	//Metodo
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
	public int getGeneroID() {
		return generoID;
	}
	public void setGeneroID(int generoID) {
		this.generoID = generoID;
	}
}
