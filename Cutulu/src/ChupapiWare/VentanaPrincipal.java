package ChupapiWare;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.BoxLayout;
import javax.swing.JMenuItem;

public class VentanaPrincipal {

	public JFrame frmSandwichHub;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal window = new VentanaPrincipal(" ");
					window.frmSandwichHub.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrincipal(String nombre) {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSandwichHub = new JFrame();
		frmSandwichHub.setTitle("Sandwich Hub");
		frmSandwichHub.setBounds(100, 100, 1191, 626);
		frmSandwichHub.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSandwichHub.setLocationRelativeTo(null);
		frmSandwichHub.getContentPane().setLayout(null);
	}
}
