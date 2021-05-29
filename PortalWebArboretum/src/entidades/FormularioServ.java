package entidades;

import java.sql.Timestamp;

public class FormularioServ {
	
	private int idFormulario;
	private int idServ;
	private String nombreUsuario;
	private String email;
	private String cuerpoEmail;
	private String numerotelefono;
	private Timestamp fCreacion;
	private Timestamp fModificacion;
	private Timestamp fEliminacion;
	private int estado;
	
	
	//Metodos
	public int getIdFormulario() {
		return idFormulario;
	}
	public void setIdFormulario(int idFormulario) {
		this.idFormulario = idFormulario;
	}
	public int getIdServ() {
		return idServ;
	}
	public void setIdServ(int idServ) {
		this.idServ = idServ;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCuerpoEmail() {
		return cuerpoEmail;
	}
	public void setCuerpoEmail(String cuerpoEmail) {
		this.cuerpoEmail = cuerpoEmail;
	}
	public String getNumerotelefono() {
		return numerotelefono;
	}
	public void setNumerotelefono(String numerotelefono) {
		this.numerotelefono = numerotelefono;
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
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	
	
	
}
