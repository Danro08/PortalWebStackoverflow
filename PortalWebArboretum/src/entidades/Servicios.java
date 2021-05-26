package entidades;

import java.sql.Timestamp;

public class Servicios {

	//Atributos
	
	private String descripcion;
	private int estado;
	private String foto;
	private String nombres;
	private int idServ;
	private int idCatalogoServ;
	private int idUser;
	private Timestamp fCreacion;
	private Timestamp fModificacion;
	private Timestamp fEliminacion;
	
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
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public int getIdServ() {
		return idServ;
	}
	public void setIdServ(int idServ) {
		this.idServ = idServ;
	}
	public int getIdCatalogoServ() {
		return idCatalogoServ;
	}
	public void setIdCatalogoServ(int idCatalogoServ) {
		this.idCatalogoServ = idCatalogoServ;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
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
	

	
}
