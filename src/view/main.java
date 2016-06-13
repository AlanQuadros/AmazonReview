package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import pucrs.DataManager;
import pucrs.User;

import javax.swing.JLabel;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class main extends JFrame {

	private JPanel contentPane;
	private final JDesktopPane desktopPane = new JDesktopPane();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			DataManager data = new DataManager();
			public void run() {
				try {
					main frame = new main();
					frame.setVisible(true);
					data.leitura();
					ArrayList<User> users = data.getUsefulUsers();
					for (User user : users) {
						System.out.println(user.getUserId());
					}
					System.out.println();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 611, 414);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu jmConsultas = new JMenu("Consultas");
		menuBar.add(jmConsultas);
		
		JMenuItem jmiUsuarios = new JMenuItem("Usu\u00E1rios");
		jmConsultas.add(jmiUsuarios);
		
		JMenuItem jmiProdutos = new JMenuItem("Produtos");
		jmConsultas.add(jmiProdutos);
		
		JMenuItem jmiAvaliacoes = new JMenuItem("Avalia\u00E7\u00F5es");
		jmConsultas.add(jmiAvaliacoes);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		desktopPane.setBounds(0, 0, 595, 355);
		contentPane.add(desktopPane);
	}
}
