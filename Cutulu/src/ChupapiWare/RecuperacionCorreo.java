package ChupapiWare;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class RecuperacionCorreo {

	public JFrame frmRecuperarco;
	private JTextField txtUsuario;
	private JTextField txtCorreo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RecuperacionCorreo window = new RecuperacionCorreo();
					window.frmRecuperarco.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public RecuperacionCorreo() {
		initialize();
	}
	
	public void Limpiar() {
		txtUsuario.setText("");
		txtCorreo.setText("");
	}
	
	public  boolean validaEmail (String email) {
		Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRecuperarco = new JFrame();
		frmRecuperarco.setTitle("RecuperarCO");
		frmRecuperarco.setUndecorated(true);
		frmRecuperarco.setBounds(100, 100, 586, 300);
		frmRecuperarco.setLocationRelativeTo(null);
		frmRecuperarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 586, 300);
		frmRecuperarco.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(236, 57, 126, 14);
		panel.add(lblUsuario);
		
		JLabel lblNewLabel = new JLabel("Correo nuevo");
		lblNewLabel.setBounds(236, 112, 110, 14);
		panel.add(lblNewLabel);
		
		txtUsuario = new JTextField();
		txtUsuario.setBounds(236, 70, 126, 20);
		
		panel.add(txtUsuario);
		
		JLabel lblAceptar = new JLabel("ACEPTAR");
		lblAceptar.setBackground(Color.white);
		lblAceptar.setForeground(null);
		lblAceptar.setOpaque(true);
		lblAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String usuario = txtUsuario.getText();
					String correo = txtCorreo.getText().toString();
					if(usuario.equalsIgnoreCase("")||correo.equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "Error, Campos vacios");
					}else {
						if(validaEmail(correo)) {
							Usuario u = new Usuario();
							u.setNombre(usuario);
							u.setCorreo(correo);
							if(u.consultaCorreo()) {
								JOptionPane.showMessageDialog(null, "Opps ya esta registrado ese correo");
							}else {
								
								if(u.actualizarCorreo()) {
									Limpiar();
									JOptionPane.showMessageDialog(null, "Se actualizo el correo");
									frmRecuperarco.setVisible(false);
								}else {
									JOptionPane.showMessageDialog(null, "Oops No se actualizo el correo");
								}
								
							}
							
							
						}else {
							JOptionPane.showMessageDialog(null,"Oops Ese correo no es valido");
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
				frmRecuperarco.setVisible(false);
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
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(236, 126, 126, 20);
		panel.add(txtCorreo);
		txtCorreo.setColumns(10);
	}
}
