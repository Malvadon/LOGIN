package Urabe;

public class Imagen {
	String ruta;
	int id;
	DataImagen di = new DataImagen();
	public Imagen() {
		
	}
	public Imagen(String ruta,int id) {
		this.ruta = ruta;
		this.id = id;
	}

	public String getRuta() {
		return ruta;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}
	public boolean agergarI() {
		
		return di.agregarI(Imagen.this);
	}
	public boolean cargarI() {
		// TODO Auto-generated method stub
		return di.cargarI(Imagen.this);
	}
	public boolean editarI() {
		// TODO Auto-generated method stub
		return di.editarI(Imagen.this);
	}
	public boolean eliminarI() {
		// TODO Auto-generated method stub
		return di.eliminarI(Imagen.this);
	}
	
	
	

}