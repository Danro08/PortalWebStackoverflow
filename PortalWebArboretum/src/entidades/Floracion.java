package entidades;

public class Floracion {
	
	//Atributos
	private String descripcion;
	private int estado;
	private String nombre;
	private String temporada;
	private int floracionID;
	
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
	public String getTemporada() {
		return temporada;
	}
	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
	public int getFloracionID() {
		return floracionID;
	}
	public void setFloracionID(int floracionID) {
		this.floracionID = floracionID;
	}
}
