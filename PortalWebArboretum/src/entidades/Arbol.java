package entidades;

public class Arbol {

	//Atributos
	private String descripcion;
	private int estado;
	private String nombre_cientifico;
	private String nombre_comun;
	private int arbolID;
	private int distribuccionID;
	private int familiaID;
	private int generoID;
	private int floracionID;
	private int usuarioID;
	
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
	public String getNombre_cientifico() {
		return nombre_cientifico;
	}
	public void setNombre_cientifico(String nombre_cientifico) {
		this.nombre_cientifico = nombre_cientifico;
	}
	public String getNombre_comun() {
		return nombre_comun;
	}
	public void setNombre_comun(String nombre_comun) {
		this.nombre_comun = nombre_comun;
	}
	public int getArbolID() {
		return arbolID;
	}
	public void setArbolID(int arbolID) {
		this.arbolID = arbolID;
	}
	public int getDistribuccionID() {
		return distribuccionID;
	}
	public void setDistribuccionID(int distribuccionID) {
		this.distribuccionID = distribuccionID;
	}
	public int getFamiliaID() {
		return familiaID;
	}
	public void setFamiliaID(int familiaID) {
		this.familiaID = familiaID;
	}
	public int getGeneroID() {
		return generoID;
	}
	public void setGeneroID(int generoID) {
		this.generoID = generoID;
	}
	public int getFloracionID() {
		return floracionID;
	}
	public void setFloracionID(int floracionID) {
		this.floracionID = floracionID;
	}
	public int getUsuarioID() {
		return usuarioID;
	}
	public void setUsuarioID(int usuarioID) {
		this.usuarioID = usuarioID;
	}	
}
