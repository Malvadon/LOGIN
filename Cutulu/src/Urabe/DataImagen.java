package Urabe;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataImagen {
	
	public Connection conectar() {
		Connection cx = null;
		
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost/chupapi", "root", "");
			System.out.println("Se conecto ");
		} catch (SQLException e) {
			System.out.println("No se conecto");
		}
		return cx;
	}
	public static void main(String[] args) {
		DataImagen dt = new DataImagen();
		dt.conectar();
	}
	public boolean agregarI(Imagen imagen) {
		PreparedStatement ps = null;
		try {
			ps = conectar().prepareStatement("INSERT INTO imagenes VALUES(null,?,?)");
			FileInputStream inputStream;
				inputStream = new FileInputStream(imagen.getRuta());
			ps.setBlob(1, inputStream);
			ps.setString(2, imagen.getRuta());
			return ps.executeUpdate() > 0;
		} catch (FileNotFoundException|SQLException e) {
			return false;
		}
	}
	public boolean cargarI(Imagen imagen) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conectar().prepareStatement("SELECT * FROM imagenes WHERE id=?");
			ps.setInt(1, imagen.getId());
			rs = ps.executeQuery();
			if(rs.next()) {
				imagen.setRuta(rs.getString(3));
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			return false;
		}
	}
	public boolean editarI(Imagen imagen) {
		PreparedStatement ps = null;
		try {
			ps = conectar().prepareStatement("UPDATE imagenes SET image=?,ruta=? WHERE id=?");
			FileInputStream inputStream;
				inputStream = new FileInputStream(imagen.getRuta());
			ps.setBlob(1, inputStream);
			ps.setString(2, imagen.getRuta());
			ps.setInt(3, imagen.getId());
			return ps.executeUpdate() > 0;
		} catch (FileNotFoundException|SQLException e) {
			return false;
		}
	}
	public boolean eliminarI(Imagen imagen) {
		PreparedStatement ps = null;
		try {
			ps = conectar().prepareStatement("DELETE FROM imagenes WHERE id=?");
			ps.setInt(1, imagen.getId());
			return ps.executeUpdate() > 0;
		} catch (SQLException e) {
			return false;
		}
		
	}

}