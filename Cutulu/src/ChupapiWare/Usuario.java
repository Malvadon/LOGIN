package ChupapiWare;

public class Usuario {
	int idusuario;
	String nombre;
	String correo;
	String contrasena;
	String fecha;
	DataUsuario du = new DataUsuario();
	
	public Usuario() {
		
	}
	
	public boolean verificarUsuario() {
		return du.verificarUsuario(this);
	}
	
	public boolean consultaCorreo() {
		return du.consultaCorreo(this);
	}
	
	public boolean consultarUsuario() {
		return du.consultarUsuario(this);
	}
	
	public boolean registrarUsuario() {
		return du.registrarUsuario(this);
	}
	
	public boolean actualizarUsuario() {
		return du.actualizarUsuario(this);
	}
	
	public boolean actualizarCorreo() {
		return du.actualizarCorreo(this);
	}
	
	
	public Usuario(int idusuario, String nombre, String correo, String contrasena,String fecha) {
		this.idusuario = idusuario;
		this.nombre = nombre;
		this.correo = correo;
		this.contrasena = contrasena;
		this.fecha = fecha;
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	

	

	
	

}
