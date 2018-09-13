package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

import control.DAOAluno;
import control.DAOCopia;
import control.DAORelatorio;
import control.DataSoma;
import model.Aluno;
import model.Copia;
import model.Relatorio;

import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class pPesquisa extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txt0;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt5;
	private JTextField txt1;
	
	JButton btnsavealt;
	private JTextField txt00;
	private JTextField txt6;
	JButton btnexc;
	JButton btnadd;
	private JTextField txtdt;
	JButton btnatt;
	
	DataSoma d = new DataSoma();
	JLabel lblinfo;
	
	DAOAluno dao = new DAOAluno();
	DAOCopia daoc = new DAOCopia();
	DAORelatorio daor = new DAORelatorio();
	
	JComboBox cmb4;
	JButton btnalt;

	/**
	 * Create the panel.
	 */
	public pPesquisa() {
		setBackground(Color.WHITE);
		setBounds(100, 100, 800, 500);
		setLayout(null);
		
		JLabel lblMatrcula = new JLabel("Matr\u00EDcula");
		lblMatrcula.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMatrcula.setBounds(75, 152, 100, 25);
		add(lblMatrcula);
		
		JLabel lblPesquisaAluno = new JLabel("Pesquisa Aluno");
		lblPesquisaAluno.setFont(new Font("Arial", Font.PLAIN, 24));
		lblPesquisaAluno.setBounds(75, 97, 194, 25);
		add(lblPesquisaAluno);
		
		txt0 = new JTextField();
		txt0.setColumns(10);
		txt0.setBounds(167, 150, 216, 27);
		add(txt0);
		
		JLabel label_2 = new JLabel("Email");
		label_2.setFont(new Font("Arial", Font.PLAIN, 18));
		label_2.setBounds(75, 246, 66, 25);
		add(label_2);
		
		JLabel label_3 = new JLabel("Telefone");
		label_3.setFont(new Font("Arial", Font.PLAIN, 18));
		label_3.setBounds(75, 298, 82, 25);
		add(label_3);
		
		JLabel label_4 = new JLabel("Curso");
		label_4.setFont(new Font("Arial", Font.PLAIN, 18));
		label_4.setBounds(75, 350, 89, 25);
		add(label_4);
		
		JLabel lblSemestre = new JLabel("Semestre");
		lblSemestre.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSemestre.setBounds(75, 395, 89, 25);
		add(lblSemestre);
		
		txt2 = new JTextField();
		txt2.setEditable(false);
		txt2.setColumns(10);
		txt2.setBounds(167, 246, 255, 27);
		add(txt2);
		
		txt3 = new JTextField();
		txt3.setEditable(false);
		txt3.setColumns(10);
		txt3.setBounds(167, 298, 255, 27);
		add(txt3);
		
		cmb4 = new JComboBox();
		cmb4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cmb4.getSelectedIndex() == 0 || cmb4.getSelectedIndex() == 1){
					lblSemestre.setText("Semestre");
				}else{
					lblSemestre.setText("Bimestre");
				}
			}
		});
		cmb4.setEnabled(false);
		cmb4.setModel(new DefaultComboBoxModel(new String[] {"Sistemas de Informa\u00E7\u00E3o", "Zootecnia", "Ensino M\u00E9dio", "Subsequente"}));
		cmb4.setBounds(167, 350, 255, 27);
		add(cmb4);
		
		txt5 = new JTextField();
		txt5.setEditable(false);
		txt5.setColumns(10);
		txt5.setBounds(167, 395, 255, 27);
		add(txt5);
		
		btnalt = new JButton("Alterar");
		btnalt.setVisible(false);
		btnalt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnalt.getText().equals("Alterar")){
					if(!btnsavealt.isVisible()){
						txt0.setEnabled(false);
						btnsavealt.setVisible(true);
						txt1.setEditable(true);
						txt2.setEditable(true);
						txt3.setEditable(true);
						cmb4.setEnabled(true);
						txt5.setEditable(true);
						btnexc.setVisible(false);
						btnalt.setText("Cancelar");
					}
				}else{
					//quanto concluir a alteração
					btnsavealt.setVisible(false);
					txt1.setEditable(false);
					txt2.setEditable(false);
					txt3.setEditable(false);
					cmb4.setEnabled(false);
					txt5.setEditable(false);
					txt0.setEnabled(true);
					btnexc.setVisible(true);
					btnalt.setText("Alterar");
					pesq();
				}
				
			}
		});
		btnalt.setForeground(Color.WHITE);
		btnalt.setFont(new Font("Arial", Font.PLAIN, 18));
		btnalt.setBackground(new Color(50, 205, 50));
		btnalt.setBounds(301, 443, 121, 35);
		add(btnalt);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(pPesquisa.class.getResource("/images/ifce-logo2.jpg")));
		label_6.setBounds(480, 55, 246, 106);
		add(label_6);
		
		JLabel label_1 = new JLabel("Matr\u00EDcula");
		label_1.setFont(new Font("Arial", Font.PLAIN, 18));
		label_1.setBounds(75, 201, 100, 25);
		add(label_1);
		
		txt1 = new JTextField();
		txt1.setEditable(false);
		txt1.setColumns(10);
		txt1.setBounds(167, 199, 255, 27);
		add(txt1);
		
		btnsavealt = new JButton("Salvar Altera\u00E7\u00F5es");
		btnsavealt.setVisible(false);
		btnsavealt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno a = new Aluno();
				a.setId(txt1.getText());
				a.setEmail(txt2.getText());
				a.setTel(txt3.getText());
				a.setSemestre(Integer.parseInt(txt5.getText()));
				a.setCurso(cmb4.getSelectedItem().toString());
			
				dao.con();
				dao.edit(a);
				dao.desc();
				
				//quanto concluir a alteração
				btnsavealt.setVisible(false);
				txt1.setEditable(false);
				txt2.setEditable(false);
				txt3.setEditable(false);
				cmb4.setEnabled(false);
				txt5.setEditable(false);
				txt0.setEnabled(true);
				btnexc.setVisible(true);
				btnalt.setText("Alterar");
				
				txt0.setText(txt1.getText());
			}
		});
		btnsavealt.setForeground(Color.WHITE);
		btnsavealt.setFont(new Font("Arial", Font.PLAIN, 18));
		btnsavealt.setBackground(new Color(50, 205, 50));
		btnsavealt.setBounds(75, 443, 216, 35);
		add(btnsavealt);
		
		JButton btnPesq = new JButton("");
		btnPesq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				if(txt0.getText().equals("001")){
					//simulação
					txt1.setText("001");
					txt2.setText("pedrohiago.d@gmail.com");
					txt3.setText("88998019491");
					txt5.setText("6");
					if(txtdt.getText().equals(""))
					    txt6.setText("20");
					//txtdt.setText("10/05/2018");
					contSemanal();
					
					//
					btnalt.setVisible(true);
					btnexc.setVisible(true);
					btnadd.setEnabled(true);
					txt00.setEditable(true);
				}else{
					btnalt.setVisible(false);
					btnexc.setVisible(false);
					btnatt.setEnabled(false);
					btnadd.setEnabled(false);
					txt00.setEditable(false);
				}
				*/
				pesq();
			}
		});
		btnPesq.setIcon(new ImageIcon(pPesquisa.class.getResource("/images/search.png")));
		btnPesq.setBounds(389, 150, 33, 28);
		add(btnPesq);
		
		JLabel lblControleDeCpias = new JLabel("Controle de C\u00F3pias");
		lblControleDeCpias.setFont(new Font("Arial", Font.PLAIN, 18));
		lblControleDeCpias.setBounds(480, 201, 207, 25);
		add(lblControleDeCpias);
		
		txt00 = new JTextField();
		txt00.setEditable(false);
		txt00.setColumns(10);
		txt00.setBounds(593, 247, 82, 27);
		add(txt00);
		
		JLabel lblAddCpias = new JLabel("ADD C\u00F3pias");
		lblAddCpias.setFont(new Font("Arial", Font.PLAIN, 18));
		lblAddCpias.setBounds(480, 248, 100, 25);
		add(lblAddCpias);
		
		btnadd = new JButton("");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int x = Integer.parseInt(txt6.getText()); // a = limite de copias
				int r = x-Integer.parseInt(txt00.getText()); // r = limite de copias após add
				if(r>=0){
					
					if(Integer.parseInt(txt6.getText()) == 20){
						try {
							SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
							DataSoma d = new DataSoma();
							Date hj = formato.parse(d.hj);
							txtdt.setText(d.hj);
							contSemanal();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					
					txt6.setText(r+"");
					//add copias no banco de dados
					Aluno a = new Aluno();
					a.setId(txt0.getText());
					a.setCop(Integer.parseInt(txt6.getText()));
					a.setDt(txtdt.getText());
					dao.con();
					dao.editcop(a);
					dao.desc();
					
					daor.con();
					Relatorio re = new Relatorio();
					re=daor.pesq();
				    daor.desc();
					
					daoc.con();
					Copia c = new Copia();
					c=daoc.pesq(re.getId());
					c.setAlu(c.getAlu()+Integer.parseInt(txt00.getText()));
					daoc.edit(c,c.getId());
					daoc.desc();
					
					    
					
				}else if (!(Integer.parseInt(txt6.getText()) == 20)){
					JOptionPane.showMessageDialog(null, "Limite de cópias atingido!\nAtt. Limite em "+d.somaData(d.converteDataBrasil(txtdt.getText()), 7));
				}else{
					JOptionPane.showMessageDialog(null, "Limite de cópias atingido!");
				}
			}
		});
		btnadd.setEnabled(false);
		btnadd.setIcon(new ImageIcon(pPesquisa.class.getResource("/images/add.png")));
		btnadd.setBounds(685, 246, 33, 28);
		add(btnadd);
		
		JLabel lblLimite = new JLabel("Limite");
		lblLimite.setFont(new Font("Arial", Font.PLAIN, 18));
		lblLimite.setBounds(480, 286, 100, 25);
		add(lblLimite);
		
		txt6 = new JTextField();
		txt6.setEditable(false);
		txt6.setColumns(10);
		txt6.setBounds(593, 285, 82, 27);
		add(txt6);
		
		btnexc = new JButton("Excluir");
		btnexc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Aluno a = new Aluno();
				a.setId(txt0.getText());
				Object[] options = { "Confirmar", "Cancelar" };
				int r = JOptionPane.showOptionDialog(null, "Clique Confirmar para continuar", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				if(r==0){
					dao.con();
					dao.del(a);
					dao.desc();
					txt0.setText("");
				}
			}
		});
		btnexc.setVisible(false);
		btnexc.setForeground(Color.WHITE);
		btnexc.setFont(new Font("Arial", Font.PLAIN, 18));
		btnexc.setBackground(Color.RED);
		btnexc.setBounds(432, 443, 121, 35);
		add(btnexc);
		
		txtdt = new JTextField();
		txtdt.setEditable(false);
		txtdt.setColumns(10);
		txtdt.setBounds(480, 363, 89, 27);
		add(txtdt);
		
		JLabel lblltimaSolicitao = new JLabel("Data da 1\u00AA C\u00F3pia Semanal");
		lblltimaSolicitao.setFont(new Font("Arial", Font.PLAIN, 18));
		lblltimaSolicitao.setBounds(480, 335, 270, 25);
		add(lblltimaSolicitao);
		
		btnatt = new JButton("");
		btnatt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt6.setText("20");
				Aluno a = new Aluno();
				a.setId(txt0.getText());
				a.setCop(Integer.parseInt(txt6.getText()));
				a.setDt(txtdt.getText());
				dao.con();
				dao.editcop(a);
				dao.desc();
			}
		});
		btnatt.setIcon(new ImageIcon(pPesquisa.class.getResource("/images/page.png")));
		btnatt.setEnabled(false);
		btnatt.setBounds(685, 362, 33, 28);
		add(btnatt);
		
		JLabel lblResetar = new JLabel("Att. Limite");
		lblResetar.setFont(new Font("Arial", Font.PLAIN, 18));
		lblResetar.setBounds(593, 362, 94, 25);
		add(lblResetar);
		
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(480, 321, 238, 15);
		add(separator_1);
		
		lblinfo = new JLabel("0 dias atr\u00E1s.");
		lblinfo.setFont(new Font("Arial", Font.PLAIN, 14));
		lblinfo.setBounds(480, 395, 270, 25);
		add(lblinfo);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(454, 55, 288, 367);
		add(panel);

	}
	
	//controle data limite semanal
	
	public void contSemanal(){
		if(!txtdt.getText().toString().equals("")){
			SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date data = formato.parse(txtdt.getText());
				DataSoma d = new DataSoma();
				Date hj = formato.parse(d.hj);
				int dias = d.intervaloDias(hj, data);
				lblinfo.setText(dias+" dias atrás.");
				if(dias > 7){
					btnatt.setEnabled(true);
				}else{
					btnatt.setEnabled(false);
				}
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void pesq(){
		dao.con();
		
		Aluno a = new Aluno();
		a=dao.pesq(txt0.getText());
		txt1.setText(a.getId());
		txt2.setText(a.getEmail());
		txt3.setText(""+a.getTel());
		cmb4.setSelectedItem(a.getCurso());
		txt5.setText(""+a.getSemestre());
		txt6.setText(""+a.getCop());
		txtdt.setText(a.getDt());
		
		if(txt1.getText().equals("")){
			btnalt.setVisible(false);
			btnexc.setVisible(false);
			btnatt.setEnabled(false);
			btnadd.setEnabled(false);
			txt00.setEditable(false);
		}else{
			contSemanal();
			btnalt.setVisible(true);
			btnexc.setVisible(true);
			btnadd.setEnabled(true);
			txt00.setEditable(true);
		}
		dao.desc();
	}
}
