package entidades;

public class Mapa {
//atributos
	
	private int mapaID;
	private int sectorID;
	private String nombre;
	private int estado;
	
	//metodos
	
	public int getMapaID() {
		return mapaID;
	}
	public void setMapaID(int mapaID) {
		this.mapaID = mapaID;
	}
	public int getSectorID() {
		return sectorID;
	}
	public void setSectorID(int sectorID) {
		this.sectorID = sectorID;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
}
