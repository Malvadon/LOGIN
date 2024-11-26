package ChupapiWare;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class DataUsuario {
	public Connection Conectar() {
		Connection cx = null;
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost/chupapi", "root", "");
			System.out.println("Se conecto correctamente");
		} catch (SQLException e) {
			System.out.println("Error no se conecto correctamente");
			
		}
		return cx;
	}
	
	public static void main(String[] args) {
		DataUsuario dt = new DataUsuario();
		dt.Conectar();
	}

	public boolean verificarUsuario(Usuario u) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = Conectar().prepareStatement("SELECT * FROM loginWare WHERE correo='"+u.getCorreo()+"' and contrasena='"+u.getContrasena()+"'");
			rs = ps.executeQuery();
			if(rs.next()) {
				u.setNombre(rs.getString(2));
				return true;
			}else {
				return false;
			}
			
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean consultaCorreo(Usuario u) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = Conectar().prepareStatement("SELECT * FROM loginWare WHERE correo='"+u.getCorreo()+"'");
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean registrarUsuario(Usuario u) {
		PreparedStatement ps = null;
		try { 
			ps = Conectar().prepareStatement("INSERT INTO loginWare VALUES(?,?,?,?,?)");
			ps.setInt(1, u.getIdusuario());
			ps.setString(2, u.getNombre());
			ps.setString(3, u.getCorreo());
			ps.setString(4, u.getContrasena());
			ps.setString(5, u.getFecha());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean actualizarUsuario(Usuario u) {
		PreparedStatement ps = null;
		try {
			ps = Conectar().prepareStatement("UPDATE loginWare SET contrasena=? WHERE correo=?");
			ps.setString(1, u.getContrasena());
			ps.setString(2, u.getCorreo());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			return false;
		}
	}

	public boolean consultarUsuario(Usuario u) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = Conectar().prepareStatement("SELECT * FROM loginWare WHERE nombre='"+u.getNombre()+"'");
			rs = ps.executeQuery();
			if(rs.next()) {
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
		
	}

	public boolean actualizarCorreo(Usuario u) {
		PreparedStatement ps = null;
		try {
			ps = Conectar().prepareStatement("UPDATE loginWare SET correo=? WHERE nombre=?");
			ps.setString(1, u.getCorreo());
			ps.setString(2, u.getNombre());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			return false;
		}
		
	}

	

}
