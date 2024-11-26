package Urabe;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToolBar;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class CrudImagenes {

	private JFrame frame;
	private JButton btnSeleccionarArchivo;
	private JLabel lblRuta;
	String rutaArchivo = "";
	private JLabel lblFoto;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrudImagenes window = new CrudImagenes();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CrudImagenes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 909, 602);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(rutaArchivo.equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "Error, la ruta esta vacia");
					}else {
						Imagen i = new Imagen(rutaArchivo,0);
						if(i.agergarI()) {
							JOptionPane.showMessageDialog(null, "Se agrego correctamente");
							rutaArchivo = "";
							
						}else {
							JOptionPane.showMessageDialog(null, "No se agrego");
						}
						
					}
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Error");
					
				}
			}
		});
		btnNewButton.setBounds(159, 209, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEditar = new JButton("editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(rutaArchivo.equalsIgnoreCase("")) {
						JOptionPane.showMessageDialog(null, "Error, la ruta esta vacia");
					}else {
						int idd =Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el id que quieres editar"));
						Imagen i = new Imagen(rutaArchivo,idd);
						if(i.editarI()) {
							JOptionPane.showMessageDialog(null, "Se edito correctamente");
							
						}else {
							JOptionPane.showMessageDialog(null, "No se edito");
						}
						
					}
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null, "Error");
					
				}
			}
		});
		btnEditar.setBounds(258, 209, 89, 23);
		frame.getContentPane().add(btnEditar);
		
		JButton btnEliminar = new JButton("eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int idd =Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el id que quieres editar"));
					Imagen i = new Imagen();
					i.setId(idd);
					if(i.eliminarI()) {
						JOptionPane.showMessageDialog(null,"Se elimino correctamente");
					}else {
						JOptionPane.showMessageDialog(null,"No Se elimino correctamente");
					}
					
				}catch(Exception ex){
					JOptionPane.showMessageDialog(null,"Error");
					
				}
				
				
			}
		});
		btnEliminar.setBounds(357, 209, 89, 23);
		frame.getContentPane().add(btnEliminar);
		
		JButton btnCargar = new JButton("cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					int idd =Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa el id que quieres cargar"));
					Imagen i = new Imagen();
					i.setId(idd);
					if(i.cargarI()) {
						lblFoto.setIcon(new ImageIcon(i.getRuta())); 
					}else {
						JOptionPane.showMessageDialog(null, "No se cargo");
					}
					
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(null,"Error");
					
				}
			}
		});
		btnCargar.setBounds(456, 209, 89, 23);
		frame.getContentPane().add(btnCargar);
		
		btnSeleccionarArchivo = new JButton("seleccionar archivo");
		btnSeleccionarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					JFileChooser jf = new JFileChooser();
					jf.setVisible(true);
					jf.showOpenDialog(null);
					rutaArchivo  = jf.getSelectedFile().getAbsolutePath();
					lblRuta.setText(rutaArchivo);
					
				}catch(Exception ex) {
					
					
				}
			}
		});
		btnSeleccionarArchivo.setBounds(555, 209, 180, 23);
		frame.getContentPane().add(btnSeleccionarArchivo);
		
		lblRuta = new JLabel("");
		lblRuta.setBounds(143, 113, 471, 40);
		frame.getContentPane().add(lblRuta);
		
		lblFoto = new JLabel("");
		
		lblFoto.setBounds(126, 245, 650, 307);
		frame.getContentPane().add(lblFoto);
	}
}