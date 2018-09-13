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
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

import control.DAOCopia;
import control.DAOProf;
import control.DAORelatorio;
import model.Aluno;
import model.Copia;
import model.Prof;
import model.Relatorio;

import javax.swing.JSeparator;
import javax.swing.border.EtchedBorder;

public class pPesquisa2 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txt0;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt1;
	
	JButton btnsavealt;
	private JTextField txt00;
	private JTextField txt6;
	JButton btnexc;
	JButton btnadd;

	DAOProf dao = new DAOProf();
	DAOCopia daoc = new DAOCopia();
	DAORelatorio daor = new DAORelatorio();
	
	JButton btnalt;
	/**
	 * Create the panel.
	 */
	public pPesquisa2() {
		setBackground(Color.WHITE);
		setBounds(100, 100, 800, 500);
		setLayout(null);
		
		JLabel lblMatrcula = new JLabel("Matr\u00EDcula");
		lblMatrcula.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMatrcula.setBounds(75, 152, 100, 25);
		add(lblMatrcula);
		
		JLabel lblPesquisaAluno = new JLabel("Pesquisa Professor");
		lblPesquisaAluno.setFont(new Font("Arial", Font.PLAIN, 24));
		lblPesquisaAluno.setBounds(75, 97, 255, 25);
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
						btnexc.setVisible(false);
						btnalt.setText("Cancelar");
					}
				}else{
					//quanto concluir a alteração
					btnsavealt.setVisible(false);
					txt1.setEditable(false);
					txt2.setEditable(false);
					txt3.setEditable(false);
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
		btnalt.setBounds(301, 352, 121, 35);
		add(btnalt);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(pPesquisa2.class.getResource("/images/ifce-logo2.jpg")));
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
				Prof a = new Prof();
				a.setId(txt1.getText());
				a.setEmail(txt2.getText());
				a.setTel(txt3.getText());
		
				dao.con();
				dao.edit(a);
				dao.desc();
				
				//quanto concluir a alteração
				btnsavealt.setVisible(false);
				txt1.setEditable(false);
				txt2.setEditable(false);
				txt3.setEditable(false);
				txt0.setEnabled(true);
				btnexc.setVisible(true);
				
				txt0.setText(txt1.getText());
			}
		});
		btnsavealt.setForeground(Color.WHITE);
		btnsavealt.setFont(new Font("Arial", Font.PLAIN, 18));
		btnsavealt.setBackground(new Color(50, 205, 50));
		btnsavealt.setBounds(75, 352, 216, 35);
		add(btnsavealt);
		
		JButton btnPesq = new JButton("");
		btnPesq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				if(txt0.getText().equals("002")){
					//simulação
					txt1.setText("002");
					txt2.setText("marcelinux@gmail.com");
					txt3.setText("88988932812");
					txt6.setText("0");
					//
					btnalt.setVisible(true);
					btnexc.setVisible(true);
					btnadd.setEnabled(true);
					txt00.setEditable(true);
				}else{
					btnalt.setVisible(false);
					btnexc.setVisible(false);
					btnadd.setEnabled(false);
					txt00.setEditable(false);
				}
				*/
                pesq();
				
			}
		});
		btnPesq.setIcon(new ImageIcon(pPesquisa2.class.getResource("/images/search.png")));
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
				int x = Integer.parseInt(txt6.getText());
				int r = x+Integer.parseInt(txt00.getText());
					txt6.setText(r+"");
					
					//add copias no banco de dados
					Prof a = new Prof();
					a.setId(txt0.getText());
					a.setCop(Integer.parseInt(txt6.getText()));
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
					c.setProf(c.getProf()+Integer.parseInt(txt00.getText()));
					daoc.edit(c,c.getId());
					daoc.desc();
			}
		});
		btnadd.setEnabled(false);
		btnadd.setIcon(new ImageIcon(pPesquisa2.class.getResource("/images/add.png")));
		btnadd.setBounds(685, 246, 33, 28);
		add(btnadd);
		
		JLabel lblLimite = new JLabel("Total C\u00F3pias");
		lblLimite.setFont(new Font("Arial", Font.PLAIN, 18));
		lblLimite.setBounds(480, 286, 115, 25);
		add(lblLimite);
		
		txt6 = new JTextField();
		txt6.setEditable(false);
		txt6.setColumns(10);
		txt6.setBounds(593, 285, 82, 27);
		add(txt6);
		
		btnexc = new JButton("Excluir");
		btnexc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prof a = new Prof();
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
		btnexc.setBounds(432, 352, 121, 35);
		add(btnexc);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(454, 55, 288, 268);
		add(panel);

	}
	public void pesq(){
		dao.con();
		
		Prof a = new Prof();
		a=dao.pesq(txt0.getText());
		txt1.setText(a.getId());
		txt2.setText(a.getEmail());
		txt3.setText(""+a.getTel());
		txt6.setText(""+a.getCop());
		
		if(txt1.getText().equals("")){
			btnalt.setVisible(false);
			btnexc.setVisible(false);
			btnadd.setEnabled(false);
			txt00.setEditable(false);
		}else{
			btnalt.setVisible(true);
			btnexc.setVisible(true);
			btnadd.setEnabled(true);
			txt00.setEditable(true);
		}
		dao.desc();
	}
}
