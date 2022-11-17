package principal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ConfrontoJframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfrontoJframe frame = new ConfrontoJframe();
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
	public ConfrontoJframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnSair = new JButton("Voltar");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Index index = new Index();
				index.setVisible(true);
				dispose();
			}
		});
		btnSair.setForeground(Color.BLACK);
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSair.setBackground(new Color(255, 255, 255));
		btnSair.setBounds(514, 395, 100, 35);
		contentPane.add(btnSair);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(Index.class.getResource("/img/blue_stylish_halftone_comic_zoom_background (1).jpg")));
		lblNewLabel_3.setBounds(-52, -80, 862, 597);
		contentPane.add(lblNewLabel_3);
	}

}
