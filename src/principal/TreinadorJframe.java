package principal;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bean.Pokemon;
import bean.Treinador;
import dao.PokemonDAO;
import dao.TreinaDAO;
import dao.TreinadorDAO;

import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class TreinadorJframe extends JFrame {

	private JPanel contentPane;
	private JLayeredPane layeredPane;
	private JPanel panel;
	private JPanel adicionar;
	private JPanel alterar;
	private JPanel remover;
	private JPanel mostrar;
	private JPanel pocao;
	private JPanel berry;
	private JTextField textField;
	private JComboBox comboBox_1;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JComboBox comboBox;
	private JTable table;
	private JTextField textField_4;
	private JComboBox comboBox_1_1;
	private JComboBox comboBox_1_2;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TreinadorJframe frame = new TreinadorJframe();
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
	public TreinadorJframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon(Index.class.getResource("/img/blue_stylish_halftone_comic_zoom_background (1).jpg")));
		background.setBounds(-52, -80, 862, 597);
		
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
		
		pocao = new JPanel();
		pocao.setBounds(0, 0, 640, 480);
		layeredPane.add(pocao);
		pocao.setLayout(null);
		
		berry = new JPanel();
		berry.setBounds(0, 0, 640, 480);
		layeredPane.add(berry);
		berry.setLayout(null);
		
		mostrar = new JPanel();
		mostrar.setBounds(0, 0, 640, 480);
		layeredPane.add(mostrar);
		mostrar.setLayout(null);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				comboBox_1.setSelectedIndex(-1);
				SwitchScreen(adicionar);
				panel.remove(background);
				adicionar.add(background);
			}
		});
		btnNewButton.setBounds(170, 120, 100, 30);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Berry");
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(berry);
				panel.remove(background);
				berry.add(background);
			}
		});
		btnNewButton_1.setBounds(370, 200, 100, 30);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Alterar");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(alterar);
				panel.remove(background);
				alterar.add(background);
				
				
				comboBox_1_1.removeAllItems();
				ArrayList<Integer> ids = TreinadorDAO.getListaId();
				for (int id : ids) {
					comboBox_1_1.addItem(id);
				}
				comboBox_1_1.setSelectedIndex(-1);;
				setFieldsAlterar();
			}
		});
		btnNewButton_2.setBounds(170, 200, 100, 30);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Remover");
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_3.setBackground(new Color(255, 255, 255));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(remover);
				panel.remove(background);
				remover.add(background);
				comboBox.removeAllItems();
				ArrayList<Integer> ids = TreinadorDAO.getListaId();
				for (int id : ids) {
					comboBox.addItem(id);
				}
				setFieldsRemover();
			}
		});
		btnNewButton_3.setBounds(170, 280, 100, 30);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Po\u00E7\u00E3o");
		btnNewButton_4.setBackground(new Color(255, 255, 255));
		btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_4.setForeground(new Color(0, 0, 0));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(pocao);
				panel.remove(background);
				pocao.add(background);
			}
		});
		btnNewButton_4.setBounds(370, 120, 100, 30);
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Mostrar");
		btnNewButton_5.setBackground(new Color(255, 255, 255));
		btnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_5.setForeground(new Color(0, 0, 0));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(mostrar);
				panel.remove(background);
				mostrar.add(background);
				ArrayList<Treinador> treinadores = TreinadorDAO.treinadores();
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				((DefaultTableModel)table.getModel()).setRowCount(0);
				for (Treinador t : treinadores) {
					model.addRow(new Object[] {t.getId(), t.getNome(), t.getRegistroPokedex(), t.getSexo()});
				}
			}
		});
		btnNewButton_5.setBounds(370, 280, 100, 30);
		panel.add(btnNewButton_5);
		
		JLabel lblNewLabel_1 = new JLabel("Treinador");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 25));
		lblNewLabel_1.setBounds(184, 11, 271, 73);
		panel.add(lblNewLabel_1);
		
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
				alterar.remove(background);
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
		
		JButton btnVoltarPocao = new JButton("Voltar");
		btnVoltarPocao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(panel);
				pocao.remove(background);
				panel.add(background);
			}
		});
		btnVoltarPocao.setForeground(Color.BLACK);
		btnVoltarPocao.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltarPocao.setBackground(new Color(255, 255, 255));
		btnVoltarPocao.setBounds(514, 395, 100, 35);
		
		
		
		JButton btnVoltarBerry = new JButton("Voltar");
		btnVoltarBerry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchScreen(panel);
				berry.remove(background);
				panel.add(background);
			}
		});
		btnVoltarBerry.setForeground(Color.BLACK);
		btnVoltarBerry.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnVoltarBerry.setBackground(new Color(255, 255, 255));
		btnVoltarBerry.setBounds(514, 395, 100, 35);
		
		
		
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
		
		adicionarTreinador();
		
		removerTreinador();
		
		mostrarTreinador();
		
		alterarTreinador();
		
		panel.add(btnSair);
		panel.add(background);
		adicionar.add(btnVoltarAdicionar);
		alterar.add(btnVoltarAlterar);
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(275, 140, 90, 20);
		alterar.add(textField_5);
		remover.add(btnVoltarRemover);	
		mostrar.add(btnVoltarMostrar);
		pocao.add(btnVoltarPocao);
		berry.add(btnVoltarBerry);
		SwitchScreen(panel);
	}
	
	public void SwitchScreen(JPanel p) {
		layeredPane.removeAll();
		layeredPane.add(p);
		layeredPane.repaint();
		layeredPane.revalidate();
	}
	
	public void adicionarTreinador() {
		JLabel lblNewLabel = new JLabel("Adicionar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 25));
		lblNewLabel.setBounds(184, 11, 271, 73);
		adicionar.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(140, 125, 90, 14);
		adicionar.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(140, 140, 90, 20);
		adicionar.add(textField);
		
		JLabel lblNewLabel_2_2 = new JLabel("Sexo");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setBounds(400, 125, 90, 14);
		adicionar.add(lblNewLabel_2_2);
		
		String s1[] = {"M","F"};
		comboBox_1 = new JComboBox(s1);
		comboBox_1.setBounds(400, 140, 90, 20);
		adicionar.add(comboBox_1);
		
		JButton btnNewButton_6 = new JButton("Adicionar");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textField.getText();
				String sexo = (String) comboBox_1.getSelectedItem();
				Treinador t = new Treinador(nome, 0, sexo);
				int inseriu = TreinadorDAO.inserir(t);
				if (inseriu > 0) {
					JOptionPane.showMessageDialog(null, "Treinador cadastrado com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao cadastrar Treinador");
				}
				textField.setText("");
				comboBox_1.setSelectedIndex(-1);
			}
		});
		btnNewButton_6.setForeground(Color.BLACK);
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setBounds(265, 330, 110, 30);
		adicionar.add(btnNewButton_6);
	}
	
	public void removerTreinador() {
		JLabel lblRemover = new JLabel("Remover");
		lblRemover.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemover.setForeground(Color.WHITE);
		lblRemover.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 25));
		lblRemover.setBounds(184, 11, 271, 73);
		remover.add(lblRemover);
		
		JLabel lblNewLabel_2 = new JLabel("Nome");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(110, 125, 90, 14);
		remover.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Sexo");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(430, 125, 90, 14);
		remover.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Registro Pokedex");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setBounds(265, 125, 110, 14);
		remover.add(lblNewLabel_2_2);
		
		comboBox = new JComboBox();
		comboBox.setBounds(275, 240, 90, 20);
		remover.add(comboBox);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(110, 140, 90, 20);
		remover.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(275, 140, 90, 20);
		remover.add(textField_2);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Id");
		lblNewLabel_2_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setBounds(275, 225, 90, 14);
		remover.add(lblNewLabel_2_1_1);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(430, 140, 90, 20);
		remover.add(textField_3);
		
		JButton btnRemover = new JButton("Remover");
		btnRemover.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = (int) comboBox.getSelectedItem();
				Treinador t = new Treinador(id);
				if (TreinaDAO.existeRelacaoTreinador(t) == true) {
					Object[] options = { "Confirmar", "Cancelar" };
					int resultado = JOptionPane.showOptionDialog(null, "Este treinador possui treinamentos no sistema, deseja continuar mesmo assim?", "", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if (resultado == 0) {
						TreinaDAO.removerPorTreina(t);
						int removeu = TreinadorDAO.remover(id);
						if (removeu > 0) {
							JOptionPane.showMessageDialog(null, "Treinador removido com sucesso");
						} else {
							JOptionPane.showMessageDialog(null, "Erro ao remover Treinador");
						}
					}
				} else {
					int removeu = TreinadorDAO.remover(id);
					if (removeu > 0) {
						JOptionPane.showMessageDialog(null, "Treinador removido com sucesso");
					} else {
						JOptionPane.showMessageDialog(null, "Erro ao remover Treinador");
					}
				}
				comboBox_1.setSelectedIndex(-1);
				comboBox.removeAllItems();
				ArrayList<Integer> ids = TreinadorDAO.getListaId();
				for (int i : ids) {
					comboBox.addItem(i);
				}
				setFieldsRemover();
			}
		});
		btnRemover.setForeground(Color.BLACK);
		btnRemover.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnRemover.setBackground(Color.WHITE);
		btnRemover.setBounds(265, 402, 110, 30);
		remover.add(btnRemover);
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox.getSelectedIndex() > -1) {
				int id = (int) comboBox.getSelectedItem();
				Treinador t = TreinadorDAO.getTreinador(id);
				textField_1.setText(t.getNome());
				textField_2.setText(Integer.toString(t.getRegistroPokedex()));
				textField_3.setText(t.getSexo());
				}
			}
		});
	}
	
	public void setFieldsRemover() {
		comboBox.setSelectedIndex(-1);
		textField_1.setText("");
		textField_2.setText("");
		textField_3.setText("");
	}

	public void mostrarTreinador() {
		JLabel lblMostrar = new JLabel("Mostrar");
		lblMostrar.setHorizontalAlignment(SwingConstants.CENTER);
		lblMostrar.setForeground(Color.WHITE);
		lblMostrar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 25));
		lblMostrar.setBounds(184, 11, 271, 73);
		mostrar.add(lblMostrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(115, 80, 410, 300);
		mostrar.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "Registro Pokedex", "Sexo"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Integer.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane.setViewportView(table);
	}

	public void alterarTreinador() {
		
		JLabel lblAlterar = new JLabel("Alterar");
		lblAlterar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlterar.setForeground(Color.WHITE);
		lblAlterar.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.BOLD, 25));
		lblAlterar.setBounds(184, 11, 271, 73);
		alterar.add(lblAlterar);
		
		comboBox_1_1 = new JComboBox();
		comboBox_1_1.setBounds(275, 240, 90, 20);
		alterar.add(comboBox_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Id");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(275, 225, 90, 14);
		alterar.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Nome");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setBounds(140, 125, 90, 14);
		alterar.add(lblNewLabel_2_1);
		
		textField_4 = new JTextField();
		
		textField_4.setColumns(10);
		textField_4.setBounds(140, 140, 90, 20);
		alterar.add(textField_4);
		
		JLabel lblNewLabel_2_2 = new JLabel("Sexo");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_2.setBounds(400, 125, 90, 14);
		alterar.add(lblNewLabel_2_2);
		
		String s1[] = {"M","F"};
		comboBox_1_2 = new JComboBox<Object>(s1);
		comboBox_1_2.setBounds(400, 140, 90, 20);
		alterar.add(comboBox_1_2);
		
		comboBox_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (comboBox_1_1.getSelectedIndex() > -1) {
				int id = (int) comboBox_1_1.getSelectedItem();
				Treinador t = TreinadorDAO.getTreinador(id);
				if (t.getSexo().equals("M")) {
					comboBox_1_2.setSelectedIndex(0);
				} else {
					comboBox_1_2.setSelectedIndex(1);
				}
				comboBox_1_2.setEnabled(true);
				comboBox_1_2.setEditable(true);
				textField_4.setText(t.getNome());
				textField_4.setEnabled(true);
				textField_4.setEditable(true);
				textField_5.setText(Integer.toString(t.getRegistroPokedex()));
				textField_5.setEnabled(true);
				textField_5.setEditable(true);
				}
			}
		});
		
		JButton btnNewButton_6 = new JButton("Alterar");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nome = textField_4.getText();
				int nDex = Integer.parseInt(textField_5.getText());
				int id = (int) comboBox_1_1.getSelectedItem();
				String sexo = (String) comboBox_1_2.getSelectedItem();
				Treinador t = new Treinador (id, nome, nDex, sexo);
				int alterou = TreinadorDAO.alterar(t);
				if (alterou > 0) {
					JOptionPane.showMessageDialog(null, "Treinador alterado com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao alterar Treinador");
				}
				setFieldsAlterar();
			}
		});
		btnNewButton_6.setForeground(Color.BLACK);
		btnNewButton_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_6.setBackground(Color.WHITE);
		btnNewButton_6.setBounds(265, 330, 110, 30);
		alterar.add(btnNewButton_6);
		
		JLabel lblNewLabel_2_2_1 = new JLabel("Registro Pokedex");
		lblNewLabel_2_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_2_1.setBounds(265, 125, 110, 14);
		alterar.add(lblNewLabel_2_2_1);
		
	}

	public void setFieldsAlterar() {
		comboBox_1_1.setSelectedIndex(-1);
		textField_4.setText("");
		textField_5.setText("");
		comboBox_1_2.setSelectedIndex(-1);
		textField_4.setEditable(false);
		textField_4.setEnabled(false);
		comboBox_1_2.setEnabled(false);
		textField_5.setEnabled(false);
		textField_5.setEditable(false);
		
	}
}
