package ChupapiWare;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import com.formdev.flatlaf.FlatIntelliJLaf;

import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JProgressBar;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;

public class VentanaLogin {

	public JFrame frmLogin;
	private JTextField txtCorreo;
	private JPasswordField passContra;
	private JTextField txtNombre;
	private JTextField txtCorreoR;
	private JPasswordField passContraR;
	private JLabel lblNewLabel_7;
	String fecha = "";
	String dia;
	String mes;
	String ano;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_1_1;
	boolean vander;
	RecuperarContra v1 = new RecuperarContra();
	RecuperacionCorreo v2 = new RecuperacionCorreo();
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(new FlatIntelliJLaf());
					VentanaLogin window = new VentanaLogin();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaLogin() {
		initialize();
		
		
	}
	
	
	
	public void Limpieza1() {
		comboBox.setSelectedIndex(0);
		comboBox_1.setSelectedIndex(0);
		comboBox_1_1.setSelectedIndex(0);
		txtNombre.setText("");
		txtCorreoR.setText("");
		passContraR.setText("");
		
	}
	public void Limpieza2() {
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
	
	public  boolean validaEmail (String email) {
		Pattern pattern = Pattern.compile("^([0-9a-zA-Z]+[-._+&])*[0-9a-zA-Z]+@([-0-9a-zA-Z]+[.])+[a-zA-Z]{2,6}$");
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
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
		
		
		
		frmLogin = new JFrame();
		frmLogin.setResizable(false);
		frmLogin.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\HP\\Downloads\\capp2.png"));
		frmLogin.setTitle("Login");
		frmLogin.setBackground(Color.BLACK);
		frmLogin.setBounds(100, 100, 1210, 619);
		frmLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLogin.setLocationRelativeTo(null);
		frmLogin.getContentPane().setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1196, 580);
		panel_1.setVisible(false);
		frmLogin.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1196, 580);
		frmLogin.getContentPane().add(panel);
		panel.setLayout(null);
		
		
		
		
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 1196, 580);
		frmLogin.getContentPane().add(panel_2);
		panel_2.setVisible(false);
		panel_2.setLayout(null);
		
		
		
		
		
		
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		JLabel lblIcono = new JLabel("");
		lblIcono.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\AroCappa.png"));
		
		lblIcono.setBounds(508, 36, 209, 188);
		panel.add(lblIcono);
		
		JLabel lblNewLabel_3 = new JLabel("Correo");
		lblNewLabel_3.setForeground(Color.white);
		lblNewLabel_3.setBounds(519, 254, 84, 14);
		panel.add(lblNewLabel_3);
		
		txtCorreo = new JTextField();
		txtCorreo.setOpaque(false);
		txtCorreo.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtCorreo.setText("");
			}
		});
		txtCorreo.setText("Ingrese su correo");
		txtCorreo.setBorder(null);
		txtCorreo.setBackground(Color.BLACK);
		txtCorreo.setForeground(Color.YELLOW);
		txtCorreo.setBounds(519, 267, 182, 30);
		panel.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Contraseña");
		lblNewLabel_4.setForeground(Color.white);		
		lblNewLabel_4.setBounds(519, 355, 84, 14);
		panel.add(lblNewLabel_4);
		
		passContra = new JPasswordField();
		passContra.setOpaque(false);
		passContra.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				passContra.setText("");
			}
		});
		passContra.setText("1111111");
		passContra.setBorder(null);
		passContra.setBackground(Color.BLACK);
		passContra.setForeground(Color.YELLOW);
		passContra.setBounds(519, 380, 182, 30);
		panel.add(passContra);
		
		JLabel lblIniciar = new JLabel("INICIAR SESION");
		lblIniciar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblIniciar.setForeground(Color.yellow);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String correo = txtCorreo.getText();
					String contrasena =convertirSHA256(passContra.getText().toString());
					
					if(txtCorreo.getText().equalsIgnoreCase("")||String.valueOf(passContra.getText()).equalsIgnoreCase("")) {
						AudioClip sonido;
						sonido = java.applet.Applet.newAudioClip(getClass().getResource("/ChupapiWare/sonido1.WAV"));
						
						Thread musica = new Thread(new Runnable() {
						    @Override
						    public void run() {
						        for (int i = 0; i <= 2; i++) {
						        	if(i < 3) {
						        		sonido.play();
						        	}else {
						        		sonido.stop();
						        	}
						        }
						      
						        try {
						        	Thread.sleep(1000);
						        } catch (InterruptedException e) {
						             e.printStackTrace();
						        }
						    }
						}
					   );
						musica.start();
						JOptionPane.showMessageDialog(null, "Error, Campos vacios");
					}else {
							Usuario u = new Usuario();
							u.setCorreo(correo);
							u.setContrasena(contrasena);
								if(u.verificarUsuario()) {
									String usuario = u.getNombre();
									Thread hilo = new Thread(new Runnable() {
									    @Override
									    public void run() {
									        for (int i = 0; i <= 2; i++) {
									            final boolean visible = (i < 2);
									            SwingUtilities.invokeLater(new Runnable() {
									                @Override
									                public void run() {
									                    
									                }
									            });
									            try {
									                Thread.sleep(500);
									            } catch (InterruptedException e) {
									                e.printStackTrace();
									            }
									        }
									    }
									});
									hilo.start();
									Limpieza2();
									
									AudioClip sonido;
									sonido = java.applet.Applet.newAudioClip(getClass().getResource("/ChupapiWare/sonido2.WAV"));
									
									Thread musica = new Thread(new Runnable() {
									    @Override
									    public void run() {
									        for (int i = 0; i <= 2; i++) {
									        	if(i < 3) {
									        		sonido.play();
									        	}else {
									        		sonido.stop();
									        	}
									        }
									      
									        try {
									        	Thread.sleep(1000);
									        } catch (InterruptedException e) {
									             e.printStackTrace();
									        }
									    }
									}
								   );
									musica.start();
									txtCorreo.setText("Ingrese su correo");
									passContra.setText("1111111");
									
									
									JOptionPane.showMessageDialog(null, "Bienvenido "+usuario);	
								}else {
									AudioClip sonido;
									sonido = java.applet.Applet.newAudioClip(getClass().getResource("/ChupapiWare/sonido1.WAV"));
									
									Thread musica = new Thread(new Runnable() {
									    @Override
									    public void run() {
									        for (int i = 0; i <= 2; i++) {
									        	if(i < 3) {
									        		sonido.play();
									        	}else {
									        		sonido.stop();
									        	}
									        }
									      
									        try {
									        	Thread.sleep(1000);
									        } catch (InterruptedException e) {
									             e.printStackTrace();
									        }
									    }
									}
								   );
									musica.start();
									JOptionPane.showMessageDialog(null, "Oops No se encontro al usuario");
								}
								
							
							
							
						
					}
				}catch(Exception ex) {
					AudioClip sonido;
					sonido = java.applet.Applet.newAudioClip(getClass().getResource("/ChupapiWare/sonido1.WAV"));
					
					Thread musica = new Thread(new Runnable() {
					    @Override
					    public void run() {
					        for (int i = 0; i <= 2; i++) {
					        	if(i < 3) {
					        		sonido.play();
					        	}else {
					        		sonido.stop();
					        	}
					        }
					      
					        try {
					        	Thread.sleep(1000);
					        } catch (InterruptedException e) {
					             e.printStackTrace();
					        }
					    }
					}
				   );
					musica.start();
					JOptionPane.showMessageDialog(null, "Algo salio mal, intentalo de nuevo");
					ex.printStackTrace();
					
				}
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblIniciar.setForeground(Color.white);
			}
		});
		lblIniciar.setBackground(Color.black);
		lblIniciar.setForeground(Color.white);
		lblIniciar.setBounds(519, 480, 91, 24);
		panel.add(lblIniciar);
		
		JLabel lblRegistrar = new JLabel("REGISTRARSE");
		lblRegistrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblRegistrar.setForeground(Color.yellow);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setVisible(true);
				panel.setVisible(false);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
				lblRegistrar.setForeground(Color.white);
			}
		});
		lblRegistrar.setBackground(Color.black);
		lblRegistrar.setForeground(Color.white);
		lblRegistrar.setBounds(638, 480, 91, 24);
		panel.add(lblRegistrar);
		
		JLabel lblBotonContra = new JLabel("¿Olvidaste la contraseña?");
		lblBotonContra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBotonContra.setForeground(Color.yellow);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBotonContra.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				v1.frmRecuperacionC.setVisible(true);
				v1.frmRecuperacionC.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		lblBotonContra.setOpaque(true);
		lblBotonContra.setBackground(Color.black);
		lblBotonContra.setForeground(Color.white);
		lblBotonContra.setBounds(519, 421, 182, 24);
		panel.add(lblBotonContra);
		
		JLabel lblBotonCorreo = new JLabel("¿Olvidaste el correo?");
		lblBotonCorreo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBotonCorreo.setForeground(Color.yellow);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBotonCorreo.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				v2.frmRecuperarco.setVisible(true);
				v2.frmRecuperarco.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
			}
		});
		lblBotonCorreo.setOpaque(true);
		lblBotonCorreo.setForeground(Color.WHITE);
		lblBotonCorreo.setBackground(Color.BLACK);
		lblBotonCorreo.setBounds(519, 308, 182, 24);
		panel.add(lblBotonCorreo);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\Explocion.gif"));
		lblNewLabel_5.setBounds(498, 435, 130, 111);
		lblNewLabel_5.setVisible(false);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\capp1.png"));
		lblNewLabel_6.setBounds(559, 67, 95, 124);
		panel.add(lblNewLabel_6);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.WHITE);
		separator.setBackground(Color.WHITE);
		separator.setBounds(519, 297, 182, 7);
		panel.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(Color.WHITE);
		separator_1.setBackground(Color.WHITE);
		separator_1.setBounds(519, 411, 182, 6);
		panel.add(separator_1);
		
		JLabel lblFondo = new JLabel("");
		lblFondo.setForeground(Color.YELLOW);
		lblFondo.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\22908-331768732_medium.gif"));
		lblFondo.setBounds(0, 0, 1196, 580);
		panel.add(lblFondo);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\AroCappa.png"));
		
		lblNewLabel_1.setBounds(508 ,23, 188, 221);
		panel_1.add(lblNewLabel_1);
		
		JSeparator separator_2_1_1_1 = new JSeparator();
		separator_2_1_1_1.setForeground(Color.WHITE);
		separator_2_1_1_1.setBackground(Color.WHITE);
		separator_2_1_1_1.setBounds(508, 335, 200, 2);
		panel_1.add(separator_2_1_1_1);
		
		txtNombre = new JTextField();
		txtNombre.setOpaque(false);
		txtNombre.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtNombre.setText("");
			}
		});
		txtNombre.setText("Ingrese su nombre");
		txtNombre.setBorder(null);
		txtNombre.setBackground(new java.awt.Color(0));
		txtNombre.setForeground(Color.YELLOW);
		txtNombre.setBounds(508, 293, 200, 37);
		panel_1.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNombreR = new JLabel("Nombre");
		lblNombreR.setForeground(Color.white);
		lblNombreR.setBounds(508, 281, 104, 14);
		panel_1.add(lblNombreR);
		
		txtCorreoR = new JTextField();
		txtCorreoR.setOpaque(false);
		txtCorreoR.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				txtCorreoR.setText("");
			}
		});
		txtCorreoR.setText("ingrese tu correo");
		txtCorreoR.setBorder(null);
		txtCorreoR.setBackground(Color.BLACK);
		txtCorreoR.setForeground(Color.YELLOW);
		txtCorreoR.setBounds(508, 373, 200, 30);
		panel_1.add(txtCorreoR);
		
		JLabel lblCorreoR = new JLabel("Correo");
		lblCorreoR.setForeground(Color.white);
		lblCorreoR.setBounds(508, 348, 200, 14);
		panel_1.add(lblCorreoR);
		
		JLabel lblContraR = new JLabel("Contraseña");
		lblContraR.setForeground(Color.white);
		lblContraR.setBounds(508, 422, 200, 14);
		panel_1.add(lblContraR);
		
		JSeparator separator_2_1_1 = new JSeparator();
		separator_2_1_1.setForeground(Color.WHITE);
		separator_2_1_1.setBackground(Color.WHITE);
		separator_2_1_1.setBounds(508, 481, 200, 2);
		panel_1.add(separator_2_1_1);
		
		passContraR = new JPasswordField();
		passContraR.setOpaque(false);
		passContraR.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				passContraR.setText("");
			}
		});
		passContraR.setText("1111111");
		passContraR.setBorder(null);
		passContraR.setBackground(Color.BLACK);
		passContraR.setForeground(Color.YELLOW);
		passContraR.setBounds(508, 447, 200, 30);
		panel_1.add(passContraR);
		
		JLabel lblBotonRegistrase = new JLabel("      REGISTRARSE");
		lblBotonRegistrase.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBotonRegistrase.setForeground(Color.yellow);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBotonRegistrase.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String nombre = txtNombre.getText();
					String correo = txtCorreoR.getText();
					String contra = passContraR.getText().toString();
					fecha = dia+"-"+mes+"-"+ano;
					if(nombre.equalsIgnoreCase("")||correo.equalsIgnoreCase("")||contra.equalsIgnoreCase("")|| fecha.equalsIgnoreCase("")||dia.equalsIgnoreCase("")||mes.equalsIgnoreCase("")||ano.equalsIgnoreCase("")) {
						AudioClip sonido;
						sonido = java.applet.Applet.newAudioClip(getClass().getResource("/ChupapiWare/sonido1.WAV"));
						
						Thread musica = new Thread(new Runnable() {
						    @Override
						    public void run() {
						        for (int i = 0; i <= 2; i++) {
						        	if(i < 3) {
						        		sonido.play();
						        	}else {
						        		sonido.stop();
						        	}
						        }
						      
						        try {
						        	Thread.sleep(1000);
						        } catch (InterruptedException e) {
						             e.printStackTrace();
						        }
						    }
						}
					   );
						musica.start();
						JOptionPane.showMessageDialog(null, "Error, Campos vacios");
					}else {
						if(validaEmail(correo)) {
							Usuario u = new Usuario();
							u.setCorreo(correo);
							u.setNombre(nombre);
							if(u.consultaCorreo()) {
								AudioClip sonido;
								sonido = java.applet.Applet.newAudioClip(getClass().getResource("/ChupapiWare/sonido1.WAV"));
								
								Thread musica = new Thread(new Runnable() {
								    @Override
								    public void run() {
								        for (int i = 0; i <= 2; i++) {
								        	if(i < 3) {
								        		sonido.play();
								        	}else {
								        		sonido.stop();
								        	}
								        }
								      
								        try {
								        	Thread.sleep(1000);
								        } catch (InterruptedException e) {
								             e.printStackTrace();
								        }
								    }
								}
							   );
								musica.start();
								JOptionPane.showMessageDialog(null,"Oops Ya existe un usuario con ese correo");
								
							}else {
								if(u.consultarUsuario()) {
									AudioClip sonido;
									sonido = java.applet.Applet.newAudioClip(getClass().getResource("/ChupapiWare/sonido1.WAV"));
									
									Thread musica = new Thread(new Runnable() {
									    @Override
									    public void run() {
									        for (int i = 0; i <= 2; i++) {
									        	if(i < 3) {
									        		sonido.play();
									        	}else {
									        		sonido.stop();
									        	}
									        }
									      
									        try {
									        	Thread.sleep(1000);
									        } catch (InterruptedException e) {
									             e.printStackTrace();
									        }
									    }
									}
								   );
									musica.start();
									JOptionPane.showMessageDialog(null,"Error Ya existe un usuario con ese nombre");
								}else {
									if(validarContra(contra)) {
										String con = convertirSHA256(passContraR.getText().toString());
										u.setCorreo(correo);
										u.setNombre(nombre);
										u.setContrasena(con);
										u.setFecha(fecha);
										if(u.registrarUsuario()) {
											AudioClip sonido;
											sonido = java.applet.Applet.newAudioClip(getClass().getResource("/ChupapiWare/sonido2.WAV"));
											Thread musica = new Thread(new Runnable() {
											    @Override
											    public void run() {
											        for (int i = 0; i <= 2; i++) {
											        	if(i < 3) {
											        		sonido.play();
											        	}else {
											        		sonido.stop();
											        	}
											        }
											      
											        try {
											        	Thread.sleep(1000);
											        } catch (InterruptedException e) {
											             e.printStackTrace();
											        }
											    }
											}
										   );
											Limpieza1();
											musica.start();
											txtCorreoR.setText("ingrese tu correo");
											txtNombre.setText("Ingrese su nombre");
											passContraR.setText("1111111");
											JOptionPane.showMessageDialog(null, "Se registro correctamanete al usuario");
										}else {
											AudioClip sonido;
											sonido = java.applet.Applet.newAudioClip(getClass().getResource("/ChupapiWare/sonido1.WAV"));
											
											Thread musica = new Thread(new Runnable() {
											    @Override
											    public void run() {
											        for (int i = 0; i <= 2; i++) {
											        	if(i < 3) {
											        		sonido.play();
											        	}else {
											        		sonido.stop();
											        	}
											        }
											      
											        try {
											        	Thread.sleep(1000);
											        } catch (InterruptedException e) {
											             e.printStackTrace();
											        }
											    }
											}
										   );
											musica.start();
											JOptionPane.showMessageDialog(null, "Oops No se Registro al usuario");
											
										}
									}else {
										AudioClip sonido;
										sonido = java.applet.Applet.newAudioClip(getClass().getResource("/ChupapiWare/sonido1.WAV"));
										
										Thread musica = new Thread(new Runnable() {
										    @Override
										    public void run() {
										        for (int i = 0; i <= 2; i++) {
										        	if(i < 3) {
										        		sonido.play();
										        	}else {
										        		sonido.stop();
										        	}
										        }
										      
										        try {
										        	Thread.sleep(1000);
										        } catch (InterruptedException e) {
										             e.printStackTrace();
										        }
										    }
										}
									   );
										musica.start();
										JOptionPane.showMessageDialog(null, "Error, la contraseña no es segura");
										
									}
									
								}
								
							}//
							
						}else{
							AudioClip sonido;
							sonido = java.applet.Applet.newAudioClip(getClass().getResource("/ChupapiWare/sonido1.WAV"));
							
							Thread musica = new Thread(new Runnable() {
							    @Override
							    public void run() {
							        for (int i = 0; i <= 2; i++) {
							        	if(i < 3) {
							        		sonido.play();
							        	}else {
							        		sonido.stop();
							        	}
							        }
							      
							        try {
							        	Thread.sleep(1000);
							        } catch (InterruptedException e) {
							             e.printStackTrace();
							        }
							    }
							}
						   );
							musica.start();
							JOptionPane.showMessageDialog(null,"Oops Ese correo no es valido");
						}
						
						
					}
				}catch(Exception ex) {
					AudioClip sonido;
					sonido = java.applet.Applet.newAudioClip(getClass().getResource("/ChupapiWare/sonido1.WAV"));
					
					Thread musica = new Thread(new Runnable() {
					    @Override
					    public void run() {
					        for (int i = 0; i <= 2; i++) {
					        	if(i < 3) {
					        		sonido.play();
					        	}else {
					        		sonido.stop();
					        	}
					        }
					      
					        try {
					        	Thread.sleep(1000);
					        } catch (InterruptedException e) {
					             e.printStackTrace();
					        }
					    }
					}
				   );
					musica.start();
					JOptionPane.showMessageDialog(null, "Oops Ocurrio un Error");
					
				}
			}
		});
		lblBotonRegistrase.setBackground(Color.black);
		lblBotonRegistrase.setForeground(Color.white);
		lblBotonRegistrase.setBounds(622, 501, 112, 30);
		panel_1.add(lblBotonRegistrase);
		
		JLabel lblBotonVolverAtras = new JLabel("     VOLVER ATRAS");
		lblBotonVolverAtras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblBotonVolverAtras.setForeground(Color.yellow);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblBotonVolverAtras.setForeground(Color.WHITE);
				
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				panel_1.setVisible(false);
				panel.setVisible(true);
				txtCorreoR.setText("ingrese tu correo");
				txtNombre.setText("Ingrese su nombre");
				passContraR.setText("1111111");
				txtCorreo.setText("Ingrese su correo");
				passContra.setText("1111111");
				
			}
		});
		lblBotonVolverAtras.setForeground(Color.WHITE);
		lblBotonVolverAtras.setBackground(Color.BLACK);
		lblBotonVolverAtras.setBounds(496, 501, 112, 30);
		panel_1.add(lblBotonVolverAtras);
		
		
		
		
		JLabel lblDia = new JLabel("dia");
		lblDia.setForeground(new Color(255, 255, 255));
		lblDia.setBounds(443, 230, 46, 14);
		panel_1.add(lblDia);
		
		JLabel lblMes = new JLabel("mes");
		lblMes.setForeground(Color.WHITE);
		lblMes.setBounds(559, 230, 46, 14);
		panel_1.add(lblMes);
		
		JLabel lblAno = new JLabel("año\r\n");
		lblAno.setForeground(Color.WHITE);
		lblAno.setBounds(675, 230, 46, 14);
		panel_1.add(lblAno);
		
		JLabel lblCapp2 = new JLabel("");
		lblCapp2.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\capp2.png"));
		lblCapp2.setBounds(559, 67, 95, 124);
		panel_1.add(lblCapp2);
		
		JSeparator separator_2_1 = new JSeparator();
		separator_2_1.setForeground(Color.WHITE);
		separator_2_1.setBackground(Color.white);
		separator_2_1.setBounds(508, 409, 200, 2);
		panel_1.add(separator_2_1);
		
		comboBox = new JComboBox();
		comboBox.setAutoscrolls(true);
		comboBox.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		comboBox.setForeground(Color.BLUE);
		comboBox.setBackground(Color.BLACK);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dia = comboBox.getSelectedItem().toString();
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox.setSelectedItem(0);
		comboBox.setBounds(443, 248, 96, 22);
		panel_1.add(comboBox);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		comboBox_1.setBackground(Color.BLACK);
		comboBox_1.setForeground(Color.YELLOW);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mes = comboBox_1.getSelectedItem().toString();
				
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"}));
		comboBox_1.setSelectedItem(0);
		comboBox_1.setBounds(559, 248, 96, 22);
		panel_1.add(comboBox_1);
		
		comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		comboBox_1_1.setBackground(Color.BLACK);
		comboBox_1_1.setForeground(Color.YELLOW);
		comboBox_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ano = comboBox_1_1.getSelectedItem().toString();
				
			}
			
		});
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"2021", "2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012", "2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003", "2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994", "1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985", "1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976", "1975", "1974", "1973", "1972"}));
		comboBox_1_1.setSelectedItem(0);
		comboBox_1_1.setBounds(675, 248, 96, 22);
		panel_1.add(comboBox_1_1);
		
		
		JLabel lblNewLabel =   new JLabel("");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\HP\\Downloads\\22908-331768732_medium.gif"));
		lblNewLabel.setBounds(0, 0, 1196, 582);
		panel_1.add(lblNewLabel);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
}