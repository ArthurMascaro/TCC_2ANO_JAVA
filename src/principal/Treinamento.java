package principal;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Pokemon;
import bean.Treina;
import bean.Treinador;
import dao.PokemonDAO;
import dao.TreinaDAO;
import dao.TreinadorDAO;

import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Treinamento extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JPanel adicionar;
	private JPanel alterar;
	private JPanel remover;
	private JPanel mostrar;
	private JComboBox comboBox_remover1;
	private JComboBox comboBox_remover1_1;
	private JComboBox comboBox_remover1_2;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JComboBox comboBox_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JComboBox comboBox_3;
	private JComboBox comboBox_1_1;
	private JComboBox comboBox_2_1;
	private JTextField textField_8;
	private JTextField textField_9;
	private JComboBox comboBox_NDex;
	private JComboBox comboBox_IdP;
	private JComboBox comboBox_IdT;
	private JTable table;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label5;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_3_2;
	private JComboBox comboBox_4;
	private JComboBox comboBox_3_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Treinamento frame = new Treinamento();
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
	public Treinamento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel background = new JLabel("");
		background.setBounds(-52, -80, 862, 597);
		background.setIcon(new ImageIcon(Index.class.getResource("/img/blue_stylish_halftone_comic_zoom_background (1).jpg")));
		
		
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
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 624, 441);
		contentPane.add(layeredPane);
		
		
		
		panel = new JPanel();
		panel.setBounds(0, 0, 640, 480);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		adicionar = new JPanel();
		adicionar.setBounds(0, 0, 640, 480);
		layeredPane.add(adicionar);
		adicionar.setLayout(null);
		
		remover = new JPanel();
		remover.setBounds(0, 0, 640, 480);
		layeredPane.add(remover);
		remover.setLayout(null);
		
		alterar = new JPanel();
		alterar.setBounds(0, 0, 640, 480);
		layeredPane.add(alterar);
		alterar.setLayout(null);
		
		mostrar = new JPanel();
		mostrar.setBounds(0, 0, 640, 480);
		layeredPane.add(mostrar);
		mostrar.setLayout(null);
		
		lblNewLabel = new JLabel("Treinamento");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 25));
		lblNewLabel.setBounds(184, 11, 271, 73);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Treinar");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(adicionar);
				panel.remove(background);
				adicionar.add(background);
				fieldsAdicionar();
				comboBox_remover1.setSelectedIndex(-1);
				comboBox_remover1_1.setSelectedIndex(-1);
				comboBox_remover1_2.setSelectedIndex(-1);
			}
		});
		btnNewButton.setBounds(170, 120, 100, 30);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Alterar");
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(alterar);
				panel.remove(background);
				alterar.add(background);
				esconder();
				fieldsAlterar();
				comboBox_3.setSelectedIndex(-1);
				comboBox_3.setEnabled(true);
				comboBox_1_1.setSelectedIndex(-1);
				comboBox_2_1.setSelectedIndex(-1);
				comboBox_NDex.setSelectedIndex(-1);
				comboBox_IdP.setSelectedIndex(-1);
				comboBox_IdT.setSelectedIndex(-1);
				comboBox_3_1.setSelectedIndex(-1);
				comboBox_3_1.removeAllItems();
			}
		});
		btnNewButton_2.setBounds(170, 280, 100, 30);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Remover");
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(remover);
				panel.remove(background);
				remover.add(background);
				fieldsRemover();
				comboBox.setSelectedIndex(-1);
				comboBox_1.setSelectedIndex(-1);
				comboBox_2.setSelectedIndex(-1);
				comboBox_4.removeAllItems();
			}
		});
		btnNewButton_3.setBounds(370, 120, 100, 30);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_5 = new JButton("Mostrar");
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_5.setForeground(new Color(0, 0, 0));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(mostrar);
				panel.remove(background);
				mostrar.add(background);
				ArrayList<Treina> treinos = TreinaDAO.getTreinos();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				((DefaultTableModel)table.getModel()).setRowCount(0);
				for (Treina t : treinos) {
					Treinador treinador = TreinadorDAO.getTreinador(t.getTreinador().getId());
					String nomeTreinador = treinador.getNome();
					Pokemon pokemon = PokemonDAO.getPokemon(t.getPokemon().getId(), t.getPokemon().getNumeroPokedex());
					String nomePokemon = pokemon.getNome();
					String data = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(t.getData_hora());
					model.addRow(new Object[] {t.getPokemon().getNumeroPokedex(), t.getPokemon().getId(), nomePokemon, treinador.getId(), nomeTreinador, data});					
				}
			}
		});
		btnNewButton_5.setBounds(370, 280, 100, 30);
		panel.add(btnNewButton_5);
		
		JButton btnVoltarAdicionar = new JButton("Voltar");
		btnVoltarAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(panel);
				adicionar.remove(background);
				fieldsAdicionar();
				panel.add(background);
			}
		});
		btnVoltarAdicionar.setForeground(Color.BLACK);
		btnVoltarAdicionar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltarAdicionar.setBackground(new Color(255, 255, 255));
		btnVoltarAdicionar.setBounds(514, 395, 100, 35);
		
		JButton btnVoltarAlterar = new JButton("Voltar");
		btnVoltarAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(panel);
				alterar.remove(background);
				fieldsAlterar();
				esconder();
				panel.add(background);
			}
		});
		btnVoltarAlterar.setForeground(Color.BLACK);
		btnVoltarAlterar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltarAlterar.setBackground(new Color(255, 255, 255));
		btnVoltarAlterar.setBounds(514, 395, 100, 35);
		
		JButton btnVoltarRemover = new JButton("Voltar");
		btnVoltarRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(panel);
				remover.remove(background);
				fieldsRemover();
				panel.add(background);
			}
		});
		btnVoltarRemover.setForeground(Color.BLACK);
		btnVoltarRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltarRemover.setBackground(new Color(255, 255, 255));
		btnVoltarRemover.setBounds(514, 395, 100, 35);
				
		JButton btnVoltarMostrar = new JButton("Voltar");
		btnVoltarMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(panel);
				mostrar.remove(background);
				panel.add(background);
			}
		});
		btnVoltarMostrar.setForeground(Color.BLACK);
		btnVoltarMostrar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltarMostrar.setBackground(new Color(255, 255, 255));
		btnVoltarMostrar.setBounds(514, 395, 100, 35);
		
		
		adicionarTreinamento();
		
		alterarTreinamento();
		
		removerTreinamento();
		
		mostrarTreinamentos();
		
		panel.add(btnSair);
		panel.add(background);
		adicionar.add(btnVoltarAdicionar);
		alterar.add(btnVoltarAlterar);
		
		comboBox_3_1 = new JComboBox(new Object[]{});
		comboBox_3_1.setEnabled(false);
		comboBox_3_1.setSelectedIndex(-1);
		comboBox_3_1.setBounds(255, 170, 130, 20);
		alterar.add(comboBox_3_1);
		remover.add(btnVoltarRemover);
		mostrar.add(btnVoltarMostrar);
		SwitchScreen(panel);
		
		
		
		//
		
		
		
		
	}

	public void SwitchScreen(JPanel p) {
		layeredPane.removeAll();
		layeredPane.add(p);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	public void adicionarTreinamento() {
		JLabel lblNewLabel_1 = new JLabel("Adicionar");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 25));
		lblNewLabel_1.setBounds(184, 11, 271, 73);
		adicionar.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Numero Pokedex");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(110, 125, 110, 14);
		adicionar.add(lblNewLabel_3);
		
		JLabel lblNewLabel_7_1 = new JLabel("IdPokemon");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setForeground(Color.WHITE);
		lblNewLabel_7_1.setBounds(275, 125, 90, 14);
		adicionar.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("IdTreinador");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setForeground(Color.WHITE);
		lblNewLabel_8_1.setBounds(430, 125, 90, 14);
		adicionar.add(lblNewLabel_8_1);
		
		Integer numeroPokedex[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		comboBox_remover1 = new JComboBox(numeroPokedex);
		comboBox_remover1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_remover1.getSelectedIndex() > -1) {
					textField.setText("");
					comboBox_remover1_1.setSelectedIndex(-1);
					int ndex = (int) comboBox_remover1.getSelectedItem();
					ArrayList<Integer> ids = PokemonDAO.getIds(ndex);
					comboBox_remover1_1.removeAllItems();
					for (int i : ids) {
						comboBox_remover1_1.addItem(i);
					}
					comboBox_remover1_1.setEnabled(true);
				}
			}
		});
		comboBox_remover1.setEditable(true);
		comboBox_remover1.setSelectedIndex(-1);
		comboBox_remover1.setBounds(120, 140, 90, 20);
		adicionar.add(comboBox_remover1);
		
		comboBox_remover1_1 = new JComboBox(new Object[]{});
		comboBox_remover1_1.setSelectedIndex(-1);
		comboBox_remover1_1.setEnabled(false);
		comboBox_remover1_1.setBounds(275, 140, 90, 20);
		adicionar.add(comboBox_remover1_1);
		comboBox_remover1_2 = new JComboBox();
		ArrayList<Integer> idsTreinadores = TreinadorDAO.getListaId();
		comboBox_remover1_2.removeAllItems();
		for (int id : idsTreinadores) {
			comboBox_remover1_2.addItem(id);
		}
		comboBox_remover1_2.setSelectedIndex(-1);
		comboBox_remover1_2.setEnabled(true);
		comboBox_remover1_2.setBounds(430, 140, 90, 20);
		adicionar.add(comboBox_remover1_2);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nome Pokemon");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setBounds(110, 210, 110, 14);
		adicionar.add(lblNewLabel_3_1);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(120, 225, 90, 20);
		adicionar.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(430, 225, 90, 20);
		adicionar.add(textField_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Nome Treinador");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setBounds(420, 210, 110, 14);
		adicionar.add(lblNewLabel_3_1_1);
		
		JButton btnNewButton_1 = new JButton("Adicionar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ndex = (int) comboBox_remover1.getSelectedItem();
				int idPokemon = (int) comboBox_remover1_1.getSelectedItem();
				int idTreinador = (int) comboBox_remover1_2.getSelectedItem();
				Pokemon p = new Pokemon(idPokemon, ndex);
				Treinador t = new Treinador(idTreinador);
				Treina tr = new Treina(t, p);
				int inseriu = TreinaDAO.inserir(tr);
				if (inseriu > 0) {
					JOptionPane.showMessageDialog(null, "Treinamento cadastrado com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar Treinamento");
				}
				fieldsAdicionar();
				comboBox_remover1.setSelectedIndex(-1);
				comboBox_remover1_1.setSelectedIndex(-1);
				comboBox_remover1_2.setSelectedIndex(-1);
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(265, 330, 110, 30);
		adicionar.add(btnNewButton_1);
		
		comboBox_remover1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_remover1_1.getSelectedIndex() > -1) {
					int id = (int) comboBox_remover1_1.getSelectedItem();
					int ndex = (int) comboBox_remover1.getSelectedItem();
					Pokemon p = PokemonDAO.getPokemon(id, ndex);
					textField.setText("");
					textField.setEnabled(true);
					textField.setText(p.getNome());
				}
			}
		});
		
		comboBox_remover1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_remover1_2.getSelectedIndex() > -1) {
					int id = (int) comboBox_remover1_2.getSelectedItem();
					Treinador t = TreinadorDAO.getTreinador(id);
					textField_1.setText("");
					textField_1.setEnabled(true);
					textField_1.setText(t.getNome());
				}
			}
		});
		
		
	}

	public void fieldsAdicionar() {
		textField.setText("");
		textField_1.setText("");
	}
	
	public void removerTreinamento() {
		JLabel lblRemover = new JLabel("Remover");
		lblRemover.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemover.setForeground(Color.WHITE);
		lblRemover.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 25));
		lblRemover.setBounds(184, 11, 271, 73);
		remover.add(lblRemover);
		
		JLabel lblNewLabel_3 = new JLabel("Numero Pokedex");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(110, 125, 110, 14);
		remover.add(lblNewLabel_3);
		
		JLabel lblNewLabel_7_1 = new JLabel("IdPokemon");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setForeground(Color.WHITE);
		lblNewLabel_7_1.setBounds(275, 125, 90, 14);
		remover.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("IdTreinador");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setForeground(Color.WHITE);
		lblNewLabel_8_1.setBounds(430, 125, 90, 14);
		remover.add(lblNewLabel_8_1);
		
		Integer numeroPokedex[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		comboBox = new JComboBox(numeroPokedex);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() > -1) {
					comboBox_1.setSelectedIndex(-1);
					comboBox_2.removeAllItems();
					comboBox_4.setSelectedIndex(-1);
					comboBox_4.removeAllItems();
					fieldsRemover();
					int ndex = (int) comboBox.getSelectedItem();
					ArrayList<Integer> ids = TreinaDAO.getIdsPorNDex(ndex);
					comboBox_1.removeAllItems();
					for (int i : ids) {
						comboBox_1.addItem(i);
					}
					comboBox_1.setEnabled(true);
				}
			}
		});
		comboBox.setEditable(true);
		comboBox.setSelectedIndex(-1);
		comboBox.setBounds(120, 140, 90, 20);
		remover.add(comboBox);
		
		comboBox_1 = new JComboBox(new Object[]{});
		comboBox_1.setEnabled(false);
		comboBox_1.setSelectedIndex(-1);
		comboBox_1.setBounds(275, 140, 90, 20);
		remover.add(comboBox_1);
		
		comboBox_2 = new JComboBox(new Object[]{});
		comboBox_2.setEnabled(false);
		comboBox_2.setSelectedIndex(-1);
		comboBox_2.setBounds(430, 140, 90, 20);
		remover.add(comboBox_2);
		
		comboBox_4 = new JComboBox(new Object[]{});
		comboBox_4.setEnabled(false);
		comboBox_4.setSelectedIndex(-1);
		comboBox_4.setEditable(true);
		comboBox_4.setBounds(255, 225, 130, 20);
		remover.add(comboBox_4);
		
		JLabel lblNewLabel_3_1 = new JLabel("Nome Pokemon");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setBounds(110, 210, 110, 14);
		remover.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Nome Treinador");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setBounds(420, 210, 110, 14);
		remover.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("Data");
		lblNewLabel_7_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_1.setForeground(Color.WHITE);
		lblNewLabel_7_1_1.setBounds(275, 210, 90, 14);
		remover.add(lblNewLabel_7_1_1);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(120, 225, 90, 20);
		remover.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(430, 225, 90, 20);
		remover.add(textField_4);
		
		JButton btnNewButton_1 = new JButton("Remover");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ndex = (int) comboBox.getSelectedItem();
				int idPokemon = (int) comboBox_1.getSelectedItem();
				int idTreinador = (int) comboBox_2.getSelectedItem();
				
				
				SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dataS = (String) comboBox_4.getSelectedItem();		
				Date data = null;
				try {
					data = new Date(fmt.parse(dataS).getTime());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				Timestamp ts = new Timestamp(data.getTime());
				
				
				Pokemon p = new Pokemon(idPokemon, ndex);
				Treinador t = new Treinador(idTreinador);
				Treina tr = new Treina(t, p, ts);
				int removeu = TreinaDAO.remover(tr);
				if (removeu > 0) {
					JOptionPane.showMessageDialog(null, "Treinamento removido com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao remover Treinamento");
				}
				fieldsRemover();
				comboBox.setSelectedIndex(-1);
				comboBox_1.setSelectedIndex(-1);
				comboBox_2.setSelectedIndex(-1);
				comboBox_4.setSelectedIndex(-1);
			}
		});
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(265, 330, 110, 30);
		remover.add(btnNewButton_1);
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_1.getSelectedIndex() > -1) {
					textField_2.setText("");
					comboBox_4.removeAllItems();
					comboBox_4.setEnabled(false);
					int id = (int) comboBox_1.getSelectedItem();
					int ndex = (int) comboBox.getSelectedItem();
					Pokemon p = PokemonDAO.getPokemon(id, ndex);
					textField_2.setEnabled(true);
					textField_2.setText(p.getNome());
					ArrayList<Integer> ids = TreinaDAO.getTreinadoresPorPokemon(new Pokemon(id, ndex));
					comboBox_2.removeAllItems();
					for (int i : ids) {
						comboBox_2.addItem(i);
					}
					comboBox_2.setEnabled(true);
				}
			}
		});
		
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_2.getSelectedIndex() > -1){
					textField_4.setText("");
					comboBox_4.removeAllItems();
					int id = (int) comboBox_2.getSelectedItem();
					Treinador t = TreinadorDAO.getTreinador(id);
					textField_4.setEnabled(true);
					textField_4.setText(t.getNome());
					int idPokemon = (int) comboBox_1.getSelectedItem();
					int ndex = (int) comboBox.getSelectedItem();
					Treina tr = new Treina(new Treinador(id), new Pokemon(idPokemon, ndex));
					ArrayList<Timestamp>  datas = TreinaDAO.getDatasTreino(tr);
					comboBox_4.setEnabled(true);
					for (Timestamp data : datas) {
						comboBox_4.addItem(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(data));
					}
				}
			}
		});
		
		
	}

	public void fieldsRemover() {	
		textField_2.setText("");
		textField_4.setText("");
	}
	
	public void alterarTreinamento() {
		JLabel lblNewLabel_1 = new JLabel("Alterar");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 25));
		lblNewLabel_1.setBounds(184, 11, 271, 73);
		alterar.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Buscar");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(275, 70, 90, 20);
		alterar.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Numero Pokedex");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setBounds(110, 105, 110, 14);
		alterar.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("IdPokemon");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setForeground(Color.WHITE);
		lblNewLabel_7_1.setBounds(275, 105, 90, 14);
		alterar.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("IdTreinador");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setForeground(Color.WHITE);
		lblNewLabel_8_1.setBounds(430, 105, 90, 14);
		alterar.add(lblNewLabel_8_1);
		
		Integer numeroPokedex[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		comboBox_3 = new JComboBox(numeroPokedex);
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_3.getSelectedIndex() > -1) {
					textField_7.setText("");
					textField_5.setText("");
					comboBox_1_1.setSelectedIndex(-1);
					comboBox_2_1.setSelectedIndex(-1);
					comboBox_3_1.removeAllItems();
					comboBox_3_1.setSelectedIndex(-1);
					int ndex = (int) comboBox_3.getSelectedItem();
					ArrayList<Integer> ids = TreinaDAO.getIdsPorNDex(ndex);
					comboBox_2_1.removeAllItems();
					comboBox_1_1.removeAllItems();
					for (int i : ids) {
						comboBox_1_1.addItem(i);
					}
					comboBox_1_1.setEnabled(true);
				}
			}
		});
		comboBox_3.setSelectedIndex(-1);
		comboBox_3.setEditable(true);
		comboBox_3.setBounds(120, 120, 90, 20);
		alterar.add(comboBox_3);
		
		comboBox_1_1 = new JComboBox(new Object[]{});
		comboBox_1_1.setSelectedIndex(-1);
		comboBox_1_1.setEnabled(false);
		comboBox_1_1.setBounds(275, 120, 90, 20);
		alterar.add(comboBox_1_1);
		
		comboBox_2_1 = new JComboBox(new Object[]{});
		comboBox_2_1.setSelectedIndex(-1);
		comboBox_2_1.setEnabled(false);
		comboBox_2_1.setBounds(430, 120, 90, 20);
		alterar.add(comboBox_2_1);
		
		JButton btnNewButton_4 = new JButton("Confirmar");
		btnNewButton_4.setEnabled(false);
		btnNewButton_4.setForeground(new Color(0, 0, 0));
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setBounds(270, 201, 100, 25);
		alterar.add(btnNewButton_4);
		
		
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Nome Pokemon");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setBounds(110, 155, 110, 14);
		alterar.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("Nome Treinador");
		lblNewLabel_3_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1_1.setBounds(420, 155, 110, 14);
		alterar.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_7_1_1 = new JLabel("Data");
		lblNewLabel_7_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1_1.setForeground(Color.WHITE);
		lblNewLabel_7_1_1.setBounds(275, 155, 90, 14);
		alterar.add(lblNewLabel_7_1_1);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(120, 170, 90, 20);
		alterar.add(textField_5);

		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(430, 170, 90, 20);
		alterar.add(textField_7);
		
		lblNewLabel_3_2 = new JLabel("Selecione as altera\u00E7\u00F5es");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setForeground(Color.WHITE);
		lblNewLabel_3_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3_2.setBounds(230, 245, 180, 20);
		lblNewLabel_3_2.setVisible(false);
		alterar.add(lblNewLabel_3_2);
		
		label1 = new JLabel("Numero Pokedex");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setForeground(Color.WHITE);
		label1.setBounds(110, 275, 110, 14);
		alterar.add(label1);
		
		label2 = new JLabel("IdPokemon");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setForeground(Color.WHITE);
		label2.setBounds(275, 275, 90, 14);
		alterar.add(label2);
		
		label3 = new JLabel("IdTreinador");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setForeground(Color.WHITE);
		label3.setBounds(430, 275, 90, 14);
		alterar.add(label3);
		
		comboBox_NDex = new JComboBox(numeroPokedex);
		comboBox_NDex.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_NDex.getSelectedIndex() > -1) {
					textField_8.setText("");
					int ndex = (int) comboBox_NDex.getSelectedItem();
					ArrayList<Integer> ids = TreinaDAO.getIdsPorNDex(ndex);
					comboBox_IdP.removeAllItems();
					for (int i : ids) {
						comboBox_IdP.addItem(i);
					}
					comboBox_IdP.setEnabled(true);
				}
			}
		});
		comboBox_NDex.setEnabled(false);
		comboBox_NDex.setSelectedIndex(-1);
		comboBox_NDex.setBounds(120, 290, 90, 20);
		alterar.add(comboBox_NDex);
		
		comboBox_IdP = new JComboBox(new Object[]{});
		comboBox_IdP.setSelectedIndex(-1);
		comboBox_IdP.setEnabled(false);
		comboBox_IdP.setBounds(275, 290, 90, 20);
		alterar.add(comboBox_IdP);
		
		comboBox_IdT = new JComboBox(new Object[]{});
		comboBox_IdT.setSelectedIndex(-1);
		comboBox_IdT.setEnabled(false);
		comboBox_IdT.setBounds(430, 290, 90, 20);
		alterar.add(comboBox_IdT);
		
		label4 = new JLabel("Nome Pokemon");
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		label4.setForeground(Color.WHITE);
		label4.setBounds(110, 325, 110, 14);
		alterar.add(label4);
		
		textField_8 = new JTextField();
		textField_8.setEnabled(false);
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(120, 340, 90, 20);
		alterar.add(textField_8);
		
		label5 = new JLabel("Nome Treinador");
		label5.setHorizontalAlignment(SwingConstants.CENTER);
		label5.setForeground(Color.WHITE);
		label5.setBounds(420, 325, 110, 14);
		alterar.add(label5);
		
		textField_9 = new JTextField();
		textField_9.setEnabled(false);
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(430, 340, 90, 20);
		alterar.add(textField_9);
		
		btnNewButton_1 = new JButton("Alterar");
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(265, 330, 110, 30);
		alterar.add(btnNewButton_1);
		
		comboBox_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_1_1.getSelectedIndex() > -1) {
					comboBox_3_1.setEnabled(true);
					comboBox_3_1.setSelectedIndex(-1);
					int id = (int) comboBox_1_1.getSelectedItem();
					int ndex = (int) comboBox_3.getSelectedItem();
					Pokemon p = PokemonDAO.getPokemon(id, ndex);
					textField_5.setEnabled(true);
					textField_5.setText(p.getNome());
					ArrayList<Integer> ids = TreinaDAO.getTreinadoresPorPokemon(new Pokemon(id, ndex));
					comboBox_2_1.removeAllItems();
					for (int i : ids) {
						comboBox_2_1.addItem(i);
					}
					comboBox_2_1.setEnabled(true);
				}
			}
		});
		
		comboBox_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_2_1.getSelectedIndex() > -1){
					int id = (int) comboBox_2_1.getSelectedItem();
					Treinador t = TreinadorDAO.getTreinador(id);
					textField_7.setEnabled(true);
					textField_7.setText(t.getNome());
					int idPokemon = (int) comboBox_1_1.getSelectedItem();
					int ndex = (int) comboBox_3.getSelectedItem();
					Treina tr = new Treina(new Treinador(id), new Pokemon(idPokemon, ndex));
					comboBox_3_1.removeAllItems();
					comboBox_3_1.setEnabled(true);
					for (Timestamp ts : TreinaDAO.getDatasTreino(tr)) {
						comboBox_3_1.addItem(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ts));
					}
					btnNewButton_4.setEnabled(true);
				}	
			}
		});
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					btnNewButton_4.setEnabled(false);
					comboBox_1_1.setEnabled(false);
					comboBox_2_1.setEnabled(false);
					comboBox_3.setEnabled(false);
					textField_5.setEnabled(false);
					textField_7.setEnabled(false);
					comboBox_3_1.setEnabled(false);
					comboBox_NDex.setEnabled(true);
					btnNewButton_1.setVisible(true);
					mostrar();
			}
		});
		
		comboBox_IdP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_IdP.getSelectedIndex() > -1) {
					int id = (int) comboBox_IdP.getSelectedItem();
					int ndex = (int) comboBox_NDex.getSelectedItem();
					Pokemon p = PokemonDAO.getPokemon(id, ndex);
					textField_8.setEnabled(true);
					textField_8.setText(p.getNome());
					
				}
			}
		});
		
		ArrayList<Integer> ids = TreinadorDAO.getListaId();
		comboBox_IdT.removeAllItems();
		for (int i : ids) {
			comboBox_IdT.addItem(i);
		}
		
		comboBox_IdT.setEnabled(true);
		comboBox_IdT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_IdT.getSelectedIndex() > -1){
					int id = (int) comboBox_IdT.getSelectedItem();
					Treinador t = TreinadorDAO.getTreinador(id);
					textField_9.setEnabled(true);
					textField_9.setText(t.getNome());
				}
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int idpAntigo = (int) comboBox_1_1.getSelectedItem();
				int ndexAntigo = (int) comboBox_3.getSelectedItem();
				int idtAntigo = (int) comboBox_2_1.getSelectedItem();
				
				SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String dataS = (String) comboBox_3_1.getSelectedItem();		
				Date data = null;
				try {
					data = new Date(fmt.parse(dataS).getTime());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				Timestamp ts = new Timestamp(data.getTime());
				
				Pokemon pAntigo = new Pokemon(idpAntigo, ndexAntigo);
				Treinador tAntigo = new Treinador(idtAntigo);
				Treina treinoAntigo = new Treina(tAntigo, pAntigo, ts);
				
				
				int idpNovo = (int) comboBox_IdP.getSelectedItem();
				int ndexNovo = (int) comboBox_NDex.getSelectedItem();
				int idtNovo = (int) comboBox_IdT.getSelectedItem();
				Pokemon pNovo = new Pokemon(idpNovo, ndexNovo);
				Treinador tNovo = new Treinador(idtNovo);
				Treina treinoNovo = new Treina(tNovo, pNovo);
				int alterou = TreinaDAO.alterar(treinoAntigo, treinoNovo);
				if (alterou > 0) {
					JOptionPane.showMessageDialog(null, "Treinamento atualizado com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao atualizar Treinamento");
				}
				esconder();
				fieldsAlterar();
				comboBox_3.setSelectedIndex(-1);
				comboBox_3.setEnabled(true);
				comboBox_1_1.setSelectedIndex(-1);
				comboBox_2_1.setSelectedIndex(-1);
				comboBox_NDex.setSelectedIndex(-1);
				comboBox_IdP.setSelectedIndex(-1);
				comboBox_IdT.setSelectedIndex(-1);
				comboBox_3_1.setSelectedIndex(-1);
				comboBox_3_1.removeAllItems();
			}
		});
	}

	public void fieldsAlterar() {
		textField_5.setText("");
		textField_7.setText("");
		textField_8.setText("");
		textField_9.setText("");
		
	}
	
	public void esconder() {
		label1.setVisible(false);
		label2.setVisible(false);
		label3.setVisible(false);
		label4.setVisible(false);
		label5.setVisible(false);
		lblNewLabel_3_2.setVisible(false);
		comboBox_NDex.setVisible(false);
		comboBox_IdP.setVisible(false);
		comboBox_IdT.setVisible(false);
		textField_8.setVisible(false);
		textField_9.setVisible(false);
		btnNewButton_1.setVisible(false);
	}
	
	public void mostrar() {
		label1.setVisible(true);
		label2.setVisible(true);
		label3.setVisible(true);
		label4.setVisible(true);
		label5.setVisible(true);
		lblNewLabel_3_2.setVisible(true);
		comboBox_NDex.setVisible(true);
		comboBox_IdP.setVisible(true);
		comboBox_IdT.setVisible(true);
		textField_8.setVisible(true);
		textField_9.setVisible(true);
	}
	
	public void mostrarTreinamentos() {
		JLabel lblMostrar = new JLabel("Mostrar");
		lblMostrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrar.setForeground(Color.WHITE);
		lblMostrar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 25));
		lblMostrar.setBounds(184, 15, 271, 30);
		mostrar.add(lblMostrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 55, 500, 325);
		mostrar.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
					"NDex", "IdPoke", "NomePoke", "IdTreina", "NomeTreina", "Data / Hora"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class, Integer.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(5).setPreferredWidth(125);
		scrollPane.setViewportView(table);
	}
}
