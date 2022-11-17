package principal;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.ImageIcon;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.Box;
import javax.swing.JScrollPane;

public class Index extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Index frame = new Index();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Index() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Pokemon Odyssey");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(176, 0, 271, 73);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(Index.class.getResource("/img/pokebola.png")));
		lblNewLabel_1.setBounds(400, 0, 82, 73);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Pokemon");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PokemonJframe pokemon = new PokemonJframe();
				pokemon.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(252, 100, 120, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(Index.class.getResource("/img/pngwing.com (2) (1).png")));
		lblNewLabel_2.setBounds(149, 50, 120, 114);
		contentPane.add(lblNewLabel_2);
		
		JButton btnTreinadores = new JButton("Treinador");
		btnTreinadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TreinadorJframe treinador = new TreinadorJframe();
				treinador.setVisible(true);
				dispose();
			}
		});
		btnTreinadores.setForeground(Color.BLACK);
		btnTreinadores.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTreinadores.setBackground(new Color(255, 255, 255));
		btnTreinadores.setBounds(252, 190, 120, 35);
		contentPane.add(btnTreinadores);
		
		JButton btnBatalha = new JButton("Confronto");
		btnBatalha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConfrontoJframe confronto = new ConfrontoJframe();
				confronto.setVisible(true);
				dispose();
			}
		});
		btnBatalha.setForeground(Color.BLACK);
		btnBatalha.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBatalha.setBackground(new Color(255, 255, 255));
		btnBatalha.setBounds(252, 370, 120, 35);
		contentPane.add(btnBatalha);
		
		JButton btnBatalha_1 = new JButton("Treinamento");
		btnBatalha_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Treinamento t = new Treinamento();
				t.setVisible(true);
				dispose();
			}
		});
		btnBatalha_1.setForeground(Color.BLACK);
		btnBatalha_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBatalha_1.setBackground(Color.WHITE);
		btnBatalha_1.setBounds(252, 280, 120, 35);
		contentPane.add(btnBatalha_1);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("");
		lblNewLabel_2_2_1.setIcon(new ImageIcon(Index.class.getResource("/img/gym (1).png")));
		lblNewLabel_2_2_1.setBounds(154, 247, 100, 96);
		contentPane.add(lblNewLabel_2_2_1);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnSair.setForeground(Color.BLACK);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSair.setBackground(new Color(255, 255, 255));
		btnSair.setBounds(514, 395, 100, 35);
		contentPane.add(btnSair);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setIcon(new ImageIcon(Index.class.getResource("/img/pngegg (1).png")));
		lblNewLabel_2_1.setBounds(357, 150, 92, 122);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setIcon(new ImageIcon(Index.class.getResource("/img/pngwing.com (1).png")));
		lblNewLabel_2_2.setBounds(367, 340, 100, 96);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Index.class.getResource("/img/blue_stylish_halftone_comic_zoom_background (1).jpg")));
		lblNewLabel_3.setBounds(-52, -80, 862, 597);
		contentPane.add(lblNewLabel_3);
		
	}
}
