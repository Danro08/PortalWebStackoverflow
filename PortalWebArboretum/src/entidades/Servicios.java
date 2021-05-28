package entidades;

import java.sql.Timestamp;

public class Servicios {

	//Atributos
	
	private int idServ;
	private int idUser;
	private String nombre;
	private String descripcion;
	private int estado;
	private Timestamp fCreacion;
	private Timestamp fModificacion;
	private Timestamp fEliminacion;
	private String url_foto;
	
	//Metodos
	public int getIdServ() {
		return idServ;
	}
	public void setIdServ(int idServ) {
		this.idServ = idServ;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUSer) {
		this.idUser = idUSer;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
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
	public Timestamp getfCreacion() {
		return fCreacion;
	}
	public void setfCreacion(Timestamp fCreacion) {
		this.fCreacion = fCreacion;
	}
	public Timestamp getfModificacion() {
		return fModificacion;
	}
	public void setfModificacion(Timestamp fModificacion) {
		this.fModificacion = fModificacion;
	}
	public Timestamp getfEliminacion() {
		return fEliminacion;
	}
	public void setfEliminacion(Timestamp fEliminacion) {
		this.fEliminacion = fEliminacion;
	}
	public String getUrl_foto() {
		return url_foto;
	}
	public void setUrl_foto(String url_foto) {
		this.url_foto = url_foto;
	}
	
	
	

}
