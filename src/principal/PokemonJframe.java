package principal;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bean.Pokemon;
import bean.Tipo;
import bean.Treinador;
import dao.PokemonDAO;
import dao.TreinaDAO;
import dao.TreinadorDAO;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Panel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class PokemonJframe extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JButton btnNewButton_5;
	private JLabel lblNewLabel_1;
	private JPanel adicionar;
	private JPanel alterar;
	private JPanel remover;
	private JPanel capturar;
	private JPanel ataques;
	private JPanel mostrar;
	private JLabel lblNewLabel;
	private JTextField txtPokemon;
	private JTextField txtFogo;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblNewLabel_5;
	private JLabel lblAlterar;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTable table;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JComboBox comboBox_2;
	private JComboBox comboBox_1_alterar;
	private JComboBox comboBox_1;
	private JComboBox comboBox_1_1;
	private JComboBox<Integer> comboBox;
	private JComboBox comboBox_remover2;
	private JComboBox comboBox_remover1;
	private JComboBox comboBox_mostrar;
	private JComboBox comboBox_mostrar2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PokemonJframe frame = new PokemonJframe();
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
	public PokemonJframe() {
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
		
		layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 624, 441);
		contentPane.add(layeredPane);
		
		mostrar = new JPanel();
		mostrar.setBounds(0, 0, 640, 480);
		layeredPane.add(mostrar);
		mostrar.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(0, 0, 640, 480);
		layeredPane.add(panel);
		panel.setLayout(null);
		
		adicionar = new JPanel();
		adicionar.setBounds(0, 0, 640, 480);
		layeredPane.add(adicionar);
		adicionar.setLayout(null);
		
		alterar = new JPanel();
		alterar.setBounds(0, 0, 640, 480);
		layeredPane.add(alterar);
		alterar.setLayout(null);
		
		remover = new JPanel();
		remover.setBounds(0, 0, 640, 480);
		layeredPane.add(remover);
		remover.setLayout(null);
		
		capturar = new JPanel();
		capturar.setBounds(0, 0, 640, 480);
		layeredPane.add(capturar);
		capturar.setLayout(null);
		
		ataques = new JPanel();
		ataques.setBounds(0, 0, 640, 480);
		layeredPane.add(ataques);
		ataques.setLayout(null);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(PokemonJframe.class.getResource("/img/blue_stylish_halftone_comic_zoom_background (1).jpg")));
		background.setBounds(-52, -80, 862, 597);
		
		btnNewButton = new JButton("Adicionar");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(adicionar);
				comboBox.setSelectedIndex(-1);
				comboBox_1.removeAllItems();
				comboBox_1.setEnabled(false);
				comboBox_1.setSelectedIndex(-1);
				setFields();
				panel.remove(background);
				adicionar.add(background);
			}
		});
		btnNewButton.setBounds(170, 120, 100, 30);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Capturar");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(capturar);
				panel.remove(background);
				capturar.add(background);
			}
		});
		btnNewButton_1.setBounds(370, 120, 100, 30);
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Alterar");
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(alterar);
				setFieldsAlterar();
				comboBox_1_alterar.removeAllItems();
				comboBox_1_alterar.setSelectedIndex(-1);
				comboBox_1_alterar.setEnabled(false);
				comboBox_2.setSelectedIndex(-1);
				comboBox_1_1.removeAllItems();
				comboBox_1_1.setEnabled(false);
				comboBox_1_1.setSelectedIndex(-1);
				panel.remove(background);
				alterar.add(background);
			}
		});
		btnNewButton_2.setBounds(170, 200, 100, 30);
		panel.add(btnNewButton_2);
		
		btnNewButton_3 = new JButton("Remover");
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(remover);
				panel.remove(background);
				setFieldsRemover();
				comboBox_remover1.removeAllItems();
				comboBox_remover1.setEnabled(false);
				comboBox_remover1.setSelectedIndex(-1);
				comboBox_remover2.setSelectedIndex(-1);
				remover.add(background);
			}
		});
		btnNewButton_3.setBounds(170, 280, 100, 30);
		panel.add(btnNewButton_3);
		
		btnNewButton_4 = new JButton("Ataques");
		btnNewButton_4.setForeground(new Color(0, 0, 0));
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(ataques);
				panel.remove(background);
				ataques.add(background);
			}
		});
		btnNewButton_4.setBounds(370, 200, 100, 30);
		panel.add(btnNewButton_4);
		
		btnNewButton_5 = new JButton("Mostrar");
		btnNewButton_5.setForeground(new Color(0, 0, 0));
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(mostrar);
				panel.remove(background);
				mostrar.add(background);
				ArrayList<Pokemon> pokemons = PokemonDAO.getPokemons();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				((DefaultTableModel)table.getModel()).setRowCount(0);
				for (Pokemon p : pokemons) {
					model.addRow(new Object[] {p.getNumeroPokedex(), p.getId(), p.getNome()});
				}
				comboBox_mostrar.removeAllItems();
				comboBox_mostrar.setEnabled(false);
				comboBox_mostrar.setSelectedIndex(-1);
				comboBox_mostrar2.setSelectedIndex(-1);
				setFieldsMostrar();
			}
		});
		btnNewButton_5.setBounds(370, 280, 100, 30);
		panel.add(btnNewButton_5);
		
		lblNewLabel_1 = new JLabel("Pokemon");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 25));
		lblNewLabel_1.setBounds(184, 11, 271, 73);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(PokemonJframe.class.getResource("/img/blue_stylish_halftone_comic_zoom_background (1).jpg")));
		lblNewLabel_4.setBounds(-52, -80, 862, 597);
		
		JButton btnVoltarAdicionar = new JButton("Voltar");
		btnVoltarAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(panel);
				adicionar.remove(background);
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
				adicionar.remove(background);
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
				panel.add(background);
			}
		});
		btnVoltarRemover.setForeground(Color.BLACK);
		btnVoltarRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltarRemover.setBackground(new Color(255, 255, 255));
		btnVoltarRemover.setBounds(514, 395, 100, 35);
		
		JButton btnVoltarCapturar = new JButton("Voltar");
		btnVoltarCapturar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(panel);
				capturar.remove(background);
				panel.add(background);
			}
		});
		btnVoltarCapturar.setForeground(Color.BLACK);
		btnVoltarCapturar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltarCapturar.setBackground(new Color(255, 255, 255));
		btnVoltarCapturar.setBounds(514, 395, 100, 35);
		
		JButton btnVoltarAtaques = new JButton("Voltar");
		btnVoltarAtaques.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(panel);
				ataques.remove(background);
				panel.add(background);
			}
		});
		btnVoltarAtaques.setForeground(Color.BLACK);
		btnVoltarAtaques.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltarAtaques.setBackground(new Color(255, 255, 255));
		btnVoltarAtaques.setBounds(514, 395, 100, 35);
		
		
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
				
		adicionarPokemon();
		
		alterarPokemon();
		
		removerPokemon();
		
		mostrarPokemon();
		
		panel.add(btnSair);
		panel.add(background);
		adicionar.add(btnVoltarAdicionar);	
		alterar.add(btnVoltarAlterar);
		remover.add(btnVoltarRemover);
		capturar.add(btnVoltarCapturar);
		ataques.add(btnVoltarAtaques);
		mostrar.add(btnVoltarMostrar);	
		SwitchScreen(panel);
	}
	
	public void SwitchScreen(JPanel p) {
		layeredPane.removeAll();
		layeredPane.add(p);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	public Map<Integer, Tipo> getNumeroPokedexTipos() {
				
		Map<Integer, Tipo> nPokedex = new HashMap<>();
		nPokedex.put(1, new Tipo("Charmander", "Fogo", 1));
		nPokedex.put(2, new Tipo("Bulbasauro", "Planta", 1));
		nPokedex.put(3, new Tipo("Squirtle", "Agua", 1));
		nPokedex.put(4, new Tipo("Pikachu", "Elétrico", 1));
		nPokedex.put(5, new Tipo("Gengar", "Fantasma/Venenoso", 1));
		nPokedex.put(6, new Tipo("Eevee", "Normal", 1 ));
		nPokedex.put(7, new Tipo("Blaziken", "Fogo/Lutador", 3));
		nPokedex.put(8, new Tipo("Gardevoir", "Fada/Psiquico", 3));
		nPokedex.put(9, new Tipo("Lucario", "Lutador/Metal", 4));
		nPokedex.put(10,new Tipo("Mimikyu", "Fantasma/Fada", 6));
		return nPokedex;
	}
	
	public void adicionarPokemon() {
		
		JLabel lblNewLabel = new JLabel("Adicionar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 25));
		lblNewLabel.setBounds(184, 11, 271, 73);
		adicionar.add(lblNewLabel);
				
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(275, 125, 90, 14);
		adicionar.add(lblNewLabel_2);
				
		txtPokemon = new JTextField();
		txtPokemon.setBounds(275, 140, 90, 20);
		adicionar.add(txtPokemon);
		txtPokemon.setColumns(10);
				
		JLabel lblNewLabel_3 = new JLabel("Numero Pokedex");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(110, 125, 110, 14);
		adicionar.add(lblNewLabel_3);
				
		JLabel labelElemento = new JLabel("Elemento");
		labelElemento.setForeground(new Color(255, 255, 255));
		labelElemento.setHorizontalAlignment(SwingConstants.CENTER);
		labelElemento.setBounds(430, 125, 90, 14);
		adicionar.add(labelElemento);
				
		txtFogo = new JTextField();
		txtFogo.setBounds(430, 140, 90, 20);
		adicionar.add(txtFogo);
		txtFogo.setColumns(10);
				
		textField_2 = new JTextField();
		textField_2.setBounds(120, 240, 90, 20);
		adicionar.add(textField_2);
		textField_2.setColumns(10);
				
		JLabel lblNewLabel_3_1 = new JLabel("Gera\u00E7\u00E3o");
		lblNewLabel_3_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setBounds(120, 225, 90, 14);
		adicionar.add(lblNewLabel_3_1);
				
		JLabel lblNewLabel_2_1 = new JLabel("Experi\u00EAncia");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(275, 225, 90, 14);
		adicionar.add(lblNewLabel_2_1);
				
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(275, 240, 90, 20);
		adicionar.add(textField_3);
				
		JLabel lblNewLabel_4_1 = new JLabel("Hp");
		lblNewLabel_4_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setBounds(422, 225, 90, 14);
		adicionar.add(lblNewLabel_4_1);
				
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(430, 240, 90, 20);
		adicionar.add(textField_4);
				
		JLabel lblNewLabel_3_1_1 = new JLabel("Situa\u00E7\u00E3o");
		lblNewLabel_3_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setBounds(120, 325, 90, 14);
		adicionar.add(lblNewLabel_3_1_1);
				
		JLabel lblNewLabel_4_1_1 = new JLabel("IdTreinador");
		lblNewLabel_4_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setBounds(430, 325, 90, 14);
		adicionar.add(lblNewLabel_4_1_1);
				
		Integer ndex[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		comboBox = new JComboBox(ndex);
		comboBox.setSelectedIndex(-1);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ((int) comboBox.getSelectedIndex()  > -1) {
					int i = (int) comboBox.getSelectedItem();
					Map<Integer, Tipo> MapNDex = getNumeroPokedexTipos();
					Tipo tipo = MapNDex.get(i);
					txtPokemon.setText(tipo.getNome());
					txtFogo.setText(tipo.getElemento());
					textField_2.setText(Integer.toString(tipo.getGeracao()));
				}
			}
		});
		comboBox.setBounds(120, 140, 90, 22);
		adicionar.add(comboBox);
				
				
		comboBox_1 = new JComboBox();
		comboBox_1.setEnabled(false);
		comboBox_1.setBounds(430, 339, 90, 22);
		adicionar.add(comboBox_1);
				
		textField_5 = new JTextField();
		textField_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valor = Double.parseDouble(textField_5.getText());
				if (valor == 0) {
					comboBox_1.setEnabled(true);
					comboBox_1.removeAllItems();
					ArrayList<Integer> ids = TreinadorDAO.getListaId();
					for (int i : ids) {
						comboBox_1.addItem(i);
					}
				} else {
					comboBox_1.removeAllItems();
					comboBox_1.setEnabled(false);
				}
			}
		});
		textField_5.setColumns(10);
		textField_5.setBounds(120, 340, 90, 20);
		adicionar.add(textField_5);
				
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Treinador t = null;
				int numeroPokedex = (int) comboBox.getSelectedItem();
				String nomePokemon = txtPokemon.getText();
				String nomeElemento = txtFogo.getText();
				int geracao = Integer.parseInt(textField_2.getText());
				int experiencia = Integer.parseInt(textField_3.getText());
				int hp = Integer.parseInt(textField_4.getText());
				double situacao = Double.parseDouble(textField_5.getText());
				if (situacao == 0) {
					int idTreinador = (int) comboBox_1.getSelectedItem();
					t = new Treinador(idTreinador);
				}
				Pokemon p = new Pokemon(numeroPokedex,nomePokemon, nomeElemento, geracao,
						experiencia, situacao, hp, t, t);
				int inseriu = PokemonDAO.inserir(p);
				if (inseriu > 0) {
					JOptionPane.showMessageDialog(null, "Pokemon cadastrado com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar Pokemon");
				}
				setFields();
				comboBox.setSelectedIndex(-1);
				comboBox_1.removeAllItems();
				comboBox_1.setEnabled(false);
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBounds(265, 330, 110, 30);
		adicionar.add(btnNewButton);
	}
	
	public void setFields() {
		txtPokemon.setText("Pokemon");
		txtFogo.setText("Fogo");
		textField_2.setText("1");
		textField_3.setText("100");
		textField_4.setText("30");
		textField_5.setText("10");
	}

	public void alterarPokemon() {		
		lblAlterar = new JLabel("Alterar");
		lblAlterar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlterar.setForeground(Color.WHITE);
		lblAlterar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 25));
		lblAlterar.setBounds(184, 11, 271, 73);
		alterar.add(lblAlterar);
		
		lblNewLabel_6 = new JLabel("Numero Pokedex");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(Color.WHITE);
		lblNewLabel_6.setBounds(110, 125, 110, 14);
		alterar.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Id");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setBounds(275, 125, 90, 14);
		alterar.add(lblNewLabel_7);
		
		comboBox_1_alterar = new JComboBox(new Object[]{});
		comboBox_1_alterar.setSelectedIndex(-1);
		comboBox_1_alterar.setBounds(275, 140, 90, 20);
		comboBox_1_alterar.setEnabled(false);
		alterar.add(comboBox_1_alterar);
		
		Integer numeroPokedex[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		comboBox_2 = new JComboBox(numeroPokedex);
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_2.getSelectedIndex() > -1) {
					int ndex = (int) comboBox_2.getSelectedItem();
					ArrayList<Integer> ids = PokemonDAO.getIds(ndex);
					setFieldsAlterar();
					comboBox_1_alterar.removeAllItems();
					for (int i : ids) {
						comboBox_1_alterar.addItem(i);
					}
					comboBox_1_alterar.setEnabled(true);
				}
			}
		});
		comboBox_2.setSelectedIndex(-1);
		comboBox_2.setBounds(120, 140, 90, 20);
		alterar.add(comboBox_2);
		
		lblNewLabel_8 = new JLabel("Nome");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setForeground(Color.WHITE);
		lblNewLabel_8.setBounds(430, 125, 90, 14);
		alterar.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(430, 140, 90, 20);
		alterar.add(textField);
		
		JLabel labelElemento = new JLabel("Elemento");
		labelElemento.setHorizontalAlignment(SwingConstants.CENTER);
		labelElemento.setForeground(Color.WHITE);
		labelElemento.setBounds(120, 225, 90, 14);
		alterar.add(labelElemento);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(120, 240, 90, 20);
		alterar.add(textField_1);
		
		JLabel lblNewLabel_3_1 = new JLabel("Gera\u00E7\u00E3o");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setBounds(275, 225, 90, 14);
		alterar.add(lblNewLabel_3_1);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(275, 240, 90, 20);
		alterar.add(textField_6);
		
		JLabel lblNewLabel_2_1 = new JLabel("Experi\u00EAncia");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(430, 225, 90, 14);
		alterar.add(lblNewLabel_2_1);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(430, 240, 90, 20);
		alterar.add(textField_7);
		
		JLabel lblNewLabel_4_1 = new JLabel("Hp");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setBounds(120, 325, 90, 14);
		alterar.add(lblNewLabel_4_1);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(120, 340, 90, 20);
		alterar.add(textField_8);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Situa\u00E7\u00E3o");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setBounds(275, 325, 90, 14);
		alterar.add(lblNewLabel_3_1_1);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(275, 340, 90, 20);
		alterar.add(textField_9);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("IdTreinador");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setBounds(430, 325, 90, 14);
		alterar.add(lblNewLabel_4_1_1);
		
		comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(430, 339, 90, 20);
		alterar.add(comboBox_1_1);
		comboBox_1_1.setEnabled(false);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Treinador t = null;
				String nome = textField.getText();
				String elemento = textField_1.getText();
				int geracao = Integer.parseInt(textField_6.getText());
				int experiencia = Integer.parseInt(textField_7.getText());
				int hp = Integer.parseInt(textField_8.getText());
				double situacao = Double.parseDouble(textField_9.getText());
				if (situacao == 0) {
					t = TreinadorDAO.getTreinador( (int) comboBox_1_1.getSelectedItem());
				}
				Pokemon p = new Pokemon(nome, elemento, geracao, experiencia, situacao, hp, t);
				int ndex = (int) comboBox_2.getSelectedItem();
				int id = (int) comboBox_1_alterar.getSelectedItem();
				int alterou = PokemonDAO.alterar(p, id, ndex);
				if (alterou > 0) {
					JOptionPane.showMessageDialog(null, "Pokemon alterado com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao alterar Pokemon");
				}
				setFieldsAlterar();
				comboBox_1_alterar.setSelectedIndex(-1);
				comboBox_2.setSelectedIndex(-1);
			}
		});
		btnAlterar.setForeground(Color.BLACK);
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnAlterar.setBackground(Color.WHITE);
		btnAlterar.setBounds(265, 402, 110, 30);
		alterar.add(btnAlterar);
		
		comboBox_1_alterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_1_alterar.getSelectedIndex() > -1) {
					int id = (int) comboBox_1_alterar.getSelectedItem();
					int ndex = (int) comboBox_2.getSelectedItem();
					Pokemon pokemon = PokemonDAO.getPokemon(id, ndex);
					setFieldsAlterar();
					textField.setText(pokemon.getNome());
					textField_1.setText(pokemon.getElemento());
					textField_6.setText(Integer.toString(pokemon.getGeracao()));
					textField_7.setText(Integer.toString(pokemon.getExperiencia()));
					textField_8.setText(Integer.toString(pokemon.getHp()));
					textField_9.setText(Double.toString(pokemon.getSituacao()));
					if (pokemon.getSituacao() == 0) {
						ArrayList<Integer> ids = TreinadorDAO.getListaId();
						comboBox_1_1.removeAllItems();
						for (int i : ids) {
							comboBox_1_1.addItem(i);
						}
						comboBox_1_1.setSelectedItem(pokemon.getTreinador().getId());
						comboBox_1_1.setEnabled(true);
					} else {
						comboBox_1_1.setEnabled(false);
					}
				}
			}
		});
		
		textField_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double valor = Double.parseDouble(textField_9.getText());
				if (valor == 0) {
					comboBox_1_1.removeAllItems();
					comboBox_1_1.setEnabled(true);
					ArrayList<Integer> ids = TreinadorDAO.getListaId();
					for (int i : ids) {
						comboBox_1_1.addItem(i);
					}
				} else {
					comboBox_1_1.setEnabled(false);
				}
			}
		});
	}
	
	public void setFieldsAlterar() {
		textField.setText("");
		textField_1.setText("");
		textField_6.setText("");
		textField_7.setText("");
		textField_8.setText("");
		textField_9.setText("");
		comboBox_1_1.setSelectedIndex(-1);
	}
	
	public void removerPokemon() {

		JLabel lblRemover = new JLabel("Remover");
		lblRemover.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemover.setForeground(Color.WHITE);
		lblRemover.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 25));
		lblRemover.setBounds(184, 11, 271, 73);
		remover.add(lblRemover);
		
		JLabel lblNewLabel_6_1 = new JLabel("Numero Pokedex");
		lblNewLabel_6_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6_1.setForeground(Color.WHITE);
		lblNewLabel_6_1.setBounds(110, 125, 110, 14);
		remover.add(lblNewLabel_6_1);
		
		JLabel lblNewLabel_7_1 = new JLabel("Id");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setForeground(Color.WHITE);
		lblNewLabel_7_1.setBounds(275, 125, 90, 14);
		remover.add(lblNewLabel_7_1);
		
		Integer numeroPokedex[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		comboBox_remover2 = new JComboBox(numeroPokedex);
		comboBox_remover2.setSelectedIndex(-1);
		comboBox_remover2.setBounds(120, 140, 90, 20);
		remover.add(comboBox_remover2);
		
		comboBox_remover1 = new JComboBox(new Object[]{});
		comboBox_remover1.setSelectedIndex(-1);
		comboBox_remover1.setEnabled(false);
		comboBox_remover1.setBounds(275, 140, 90, 20);
		remover.add(comboBox_remover1);
		
		comboBox_remover2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_remover2.getSelectedIndex() > -1) {
					int ndex = (int) comboBox_remover2.getSelectedItem();
					setFieldsRemover();
					ArrayList<Integer> ids = PokemonDAO.getIds(ndex);
					comboBox_remover1.removeAllItems();
					for (int i : ids) {
						comboBox_remover1.addItem(i);
					}
					comboBox_remover1.setEnabled(true);
				}
			}
		});
		
		JLabel lblNewLabel_8_1 = new JLabel("Nome");
		lblNewLabel_8_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8_1.setForeground(Color.WHITE);
		lblNewLabel_8_1.setBounds(430, 125, 90, 14);
		remover.add(lblNewLabel_8_1);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(430, 140, 90, 20);
		remover.add(textField_10);
		
		JLabel labelElemento = new JLabel("Elemento");
		labelElemento.setHorizontalAlignment(SwingConstants.CENTER);
		labelElemento.setForeground(Color.WHITE);
		labelElemento.setBounds(120, 225, 90, 14);
		remover.add(labelElemento);
		
		JLabel lblNewLabel_3_1 = new JLabel("Gera\u00E7\u00E3o");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setBounds(275, 225, 90, 14);
		remover.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("Experi\u00EAncia");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(430, 225, 90, 14);
		remover.add(lblNewLabel_2_1);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(120, 240, 90, 20);
		remover.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(275, 240, 90, 20);
		remover.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(430, 240, 90, 20);
		remover.add(textField_13);
		
		JLabel lblNewLabel_4_1 = new JLabel("Hp");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setBounds(120, 325, 90, 14);
		remover.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("Situa\u00E7\u00E3o");
		lblNewLabel_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1_1.setForeground(Color.WHITE);
		lblNewLabel_3_1_1.setBounds(275, 325, 90, 14);
		remover.add(lblNewLabel_3_1_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("IdTreinador");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setBounds(430, 325, 90, 14);
		remover.add(lblNewLabel_4_1_1);
		
		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBounds(120, 340, 90, 20);
		remover.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setEditable(false);
		textField_15.setColumns(10);
		textField_15.setBounds(275, 340, 90, 20);
		remover.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		textField_16.setBounds(430, 340, 90, 20);
		remover.add(textField_16);
		
		comboBox_remover1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					if (comboBox_remover1.getSelectedIndex() > -1) {
						setFieldsRemover();
						int id = (int) comboBox_remover1.getSelectedItem();
						int ndex = (int) comboBox_remover2.getSelectedItem();
						Pokemon pokemon = PokemonDAO.getPokemon(id, ndex);
						textField_10.setText(pokemon.getNome());
						textField_11.setText(pokemon.getElemento());
						textField_12.setText(Integer.toString(pokemon.getGeracao()));
						textField_13.setText(Integer.toString(pokemon.getExperiencia()));
						textField_14.setText(Integer.toString(pokemon.getHp()));
						textField_15.setText(Double.toString(pokemon.getSituacao()));
						if (pokemon.getSituacao() == 0) {
							textField_16.setText(Integer.toString(pokemon.getTreinador().getId()));
					} else {
						textField_16.setText("");
					}
				}
			}
		});
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (int) comboBox_remover1.getSelectedItem();
				int ndex = (int) comboBox_remover2.getSelectedItem();
				Pokemon p = new Pokemon(id, ndex);
				if (TreinaDAO.existeRelacaoPokemon(p) == true) {
					Object[] options = { "Confirmar", "Cancelar" };
					int resultado = JOptionPane.showOptionDialog(null, "Este pokemon possui treinamentos no sistema, deseja continuar mesmo assim?", "", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if (resultado == 0) {
						TreinaDAO.removerPorPoke(p);
						int removeu = PokemonDAO.remover(id, ndex);
						if (removeu > 0) {
							JOptionPane.showMessageDialog(null, "Pokemon removido com sucesso");
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao remover Pokemon");
						}
					}
				} else {
					int removeu = PokemonDAO.remover(id, ndex);
					if (removeu > 0) {
						JOptionPane.showMessageDialog(null, "Pokemon removido com sucesso");
					} else {
						JOptionPane.showMessageDialog(null, "Erro ao remover Pokemon");
					}
				}
				
				setFieldsRemover();
			}
		});
		btnRemover.setForeground(Color.BLACK);
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRemover.setBackground(Color.WHITE);
		btnRemover.setBounds(265, 402, 110, 30);
		remover.add(btnRemover);
	}
	
	public void setFieldsRemover() {
		textField_10.setText("");
		textField_11.setText("");
		textField_12.setText("");
		textField_13.setText("");
		textField_14.setText("");
		textField_15.setText("");
		textField_16.setText("");
	}

	public void mostrarPokemon() {
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 80, 290, 350);
		mostrar.add(scrollPane);
		
		JLabel lblMostrar = new JLabel("Mostrar");
		lblMostrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrar.setForeground(Color.WHITE);
		lblMostrar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 25));
		lblMostrar.setBounds(184, 11, 271, 73);
		mostrar.add(lblMostrar);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"NumeroPokedex", "ID", "Nome"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(370, 150, 110, 14);
		mostrar.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Numero Pokedex");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setBounds(370, 80, 110, 14);
		mostrar.add(lblNewLabel_3);
		
		JLabel lblNewLabel_7_1 = new JLabel("Id");
		lblNewLabel_7_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7_1.setForeground(Color.WHITE);
		lblNewLabel_7_1.setBounds(510, 80, 90, 14);
		mostrar.add(lblNewLabel_7_1);
		
		textField_19 = new JTextField();
		textField_19.setEditable(false);
		textField_19.setColumns(10);
		textField_19.setBounds(380, 165, 90, 20);
		mostrar.add(textField_19);
		
		JLabel labelElemento = new JLabel("Elemento");
		labelElemento.setHorizontalAlignment(SwingConstants.CENTER);
		labelElemento.setForeground(Color.WHITE);
		labelElemento.setBounds(510, 150, 90, 14);
		mostrar.add(labelElemento);
		
		textField_20 = new JTextField();
		textField_20.setEditable(false);
		textField_20.setColumns(10);
		textField_20.setBounds(510, 165, 90, 20);
		mostrar.add(textField_20);
		
		JLabel lblNewLabel_3_1 = new JLabel("Gera\u00E7\u00E3o");
		lblNewLabel_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setBounds(380, 220, 90, 14);
		mostrar.add(lblNewLabel_3_1);
		
		textField_21 = new JTextField();
		textField_21.setEditable(false);
		textField_21.setColumns(10);
		textField_21.setBounds(380, 235, 90, 20);
		mostrar.add(textField_21);
		
		JLabel lblNewLabel_2_1 = new JLabel("Experi\u00EAncia");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(510, 220, 90, 14);
		mostrar.add(lblNewLabel_2_1);
		
		textField_22 = new JTextField();
		textField_22.setEditable(false);
		textField_22.setColumns(10);
		textField_22.setBounds(510, 235, 90, 20);
		mostrar.add(textField_22);
		
		JLabel lblNewLabel_4_1 = new JLabel("Hp");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setBounds(380, 290, 90, 14);
		mostrar.add(lblNewLabel_4_1);
		
		textField_23 = new JTextField();
		textField_23.setEditable(false);
		textField_23.setColumns(10);
		textField_23.setBounds(380, 305, 90, 20);
		mostrar.add(textField_23);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Situa\u00E7\u00E3o");
		lblNewLabel_4_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1.setBounds(510, 290, 90, 14);
		mostrar.add(lblNewLabel_4_1_1);
		
		textField_24 = new JTextField();
		textField_24.setEditable(false);
		textField_24.setColumns(10);
		textField_24.setBounds(510, 305, 90, 20);
		mostrar.add(textField_24);
		
		JLabel lblNewLabel_4_1_1_1 = new JLabel("IdTreinador");
		lblNewLabel_4_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_4_1_1_1.setBounds(380, 360, 90, 14);
		mostrar.add(lblNewLabel_4_1_1_1);
		
		textField_25 = new JTextField();
		textField_25.setEditable(false);
		textField_25.setColumns(10);
		textField_25.setBounds(380, 375, 90, 20);
		mostrar.add(textField_25);
		
		comboBox_mostrar = new JComboBox(new Object[]{});
		comboBox_mostrar.setEnabled(false);
		comboBox_mostrar.setSelectedIndex(-1);
		comboBox_mostrar.setBounds(510, 94, 90, 20);
		mostrar.add(comboBox_mostrar);
		
		Integer numeroPokedex[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		comboBox_mostrar2 = new JComboBox(numeroPokedex);
		comboBox_mostrar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_mostrar2.getSelectedIndex() > -1) {
					int ndex = (int) comboBox_mostrar2.getSelectedItem();
					setFieldsMostrar();
					ArrayList<Integer> ids = PokemonDAO.getIds(ndex);
					comboBox_mostrar.removeAllItems();
					for (int i : ids) {
						comboBox_mostrar.addItem(i);
					}
					comboBox_mostrar.setEnabled(true);
				}
			}
		});
		comboBox_mostrar2.setSelectedIndex(-1);
		comboBox_mostrar2.setBounds(380, 95, 90, 20);
		mostrar.add(comboBox_mostrar2);
		
		comboBox_mostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_mostrar.getSelectedIndex() > -1) {
					int id = (int) comboBox_mostrar.getSelectedItem();
					int ndex = (int) comboBox_mostrar2.getSelectedItem();
					Pokemon pokemon = PokemonDAO.getPokemon(id, ndex);
					setFieldsMostrar();
					textField_19.setText(pokemon.getNome());
					textField_20.setText(pokemon.getElemento());
					textField_21.setText(Integer.toString(pokemon.getGeracao()));
					textField_22.setText(Integer.toString(pokemon.getExperiencia()));
					textField_23.setText(Integer.toString(pokemon.getHp()));
					textField_24.setText(Double.toString(pokemon.getSituacao()));
					if(pokemon.getSituacao() == 0) {
						textField_25.setText(Integer.toString(pokemon.getTreinador().getId()));
					} else {
						textField_25.setText("");
					}
					
				}
			}
		});
	}

	public void setFieldsMostrar() {
		textField_19.setText("");
		textField_20.setText("");
		textField_21.setText("");
		textField_22.setText("");
		textField_23.setText("");
		textField_24.setText("");
		textField_25.setText("");
	}
}
