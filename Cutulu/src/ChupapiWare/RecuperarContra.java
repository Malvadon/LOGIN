package ChupapiWare;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

public class RecuperarContra {

	public JFrame frmRecuperacionC;
	private JTextField txtCorreo;
	private JPasswordField passContra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecuperarContra window = new RecuperarContra();
					window.frmRecuperacionC.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RecuperarContra() {
		initialize();
	}
	
	public void Limpiar() {
		txtCorreo.setText("");
		passContra.setText("");
	}
	
	public String convertirSHA256(String contra) {
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			return null;
		}
		byte[] Hash = md.digest(contra.getBytes());
		StringBuffer ab = new StringBuffer();
		for(byte b: Hash) {
			ab.append(String.format("%02x", b));
			
		}
		return ab.toString();
	}
	
	public boolean validarContra(String contra) {
		if(contra.length() < 8) {
			return false;
		}else {
			boolean mayus = false;
			boolean minus = false;
			boolean numero = false;
			
			for(char c : contra.toCharArray()) {
				if(Character.isUpperCase(c)) {
					mayus = true;
				}else if(Character.isLowerCase(c)) {
					minus = true;
				}else if(Character.isDigit(c)) {
					numero = true;
				}
				
			}
			return mayus && minus && numero;
		}
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRecuperacionC = new JFrame();
		frmRecuperacionC.setUndecorated(true);
		frmRecuperacionC.setTitle("RecuperacionC");
		frmRecuperacionC.setBounds(100, 100, 586, 300);
		frmRecuperacionC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRecuperacionC.setLocationRelativeTo(null);
		frmRecuperacionC.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 586, 300);
		frmRecuperacionC.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblCorreo = new JLabel("Correo");
		lblCorreo.setBounds(236, 57, 126, 14);
		panel.add(lblCorreo);
		
		JLabel lblNewLabel = new JLabel("Contraseña nueva");
		lblNewLabel.setBounds(236, 111, 110, 14);
		panel.add(lblNewLabel);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(236, 70, 126, 20);
		
		panel.add(txtCorreo);
		
		JLabel lblAceptar = new JLabel("ACEPTAR");
		lblAceptar.setBackground(Color.white);
		lblAceptar.setForeground(null);
		lblAceptar.setOpaque(true);
		lblAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String correo = txtCorreo.getText();
					String contra = passContra.getText().toString();
					if(correo.equalsIgnoreCase("")||contra.equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "Error, Campos vacios");
					}else {
						if(validarContra(contra)) {
							Usuario u = new Usuario();
							u.setCorreo(correo);
							u.setContrasena(convertirSHA256(contra));
							if(u.actualizarUsuario()) {
								Limpiar();
								JOptionPane.showMessageDialog(null, "Se actualizo la contraseña");
								frmRecuperacionC.setVisible(false);
							}else {
								JOptionPane.showMessageDialog(null, "Oops No se actualizo la contraseña");
							}
						}else {
							JOptionPane.showMessageDialog(null, "Error, la contraseña no es segura");
						}
					}
					
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Oops Ocurrio un Error");
				}
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				lblAceptar.setBackground(Color.black);
				lblAceptar.setForeground(Color.yellow);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblAceptar.setBackground(Color.white);
				lblAceptar.setForeground(null);
			}
		});
		lblAceptar.setBounds(270, 157, 46, 14);
		panel.add(lblAceptar);
		
		
		JLabel lblSalir = new JLabel("     X");
		lblSalir.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				Limpiar();
				frmRecuperacionC.setVisible(false);
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				
				lblSalir.setForeground(Color.black);
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				lblSalir.setForeground(Color.white);
			}
		});
		lblSalir.setBackground(Color.red);
		lblSalir.setForeground(Color.white);
		lblSalir.setOpaque(true);
		lblSalir.setBounds(553, 0, 33, 20);
		panel.add(lblSalir);
		
		passContra = new JPasswordField();
		passContra.setBounds(236, 126, 126, 20);
		panel.add(passContra);
		
		
	}
}
