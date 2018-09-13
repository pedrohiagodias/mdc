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
import javax.swing.border.EtchedBorder;

import control.DAOUsuario;
import model.Aluno;
import model.Prof;
import model.Usuario;

import javax.swing.JSeparator;
import javax.swing.JPasswordField;

public class pPesquisa3 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txt0;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt1;
	JComboBox cmb5;
	
	JButton btnsavealt;
	JButton btnexc;
	private JPasswordField txt4;
	
	DAOUsuario dao = new DAOUsuario();
	
	JButton btnalt;

	/**
	 * Create the panel.
	 */
	public pPesquisa3() {
		setBackground(Color.WHITE);
		setBounds(100, 100, 800, 500);
		setLayout(null);
		
		JLabel lblMatrcula = new JLabel("Matr\u00EDcula");
		lblMatrcula.setFont(new Font("Arial", Font.PLAIN, 18));
		lblMatrcula.setBounds(75, 152, 100, 25);
		add(lblMatrcula);
		
		JLabel lblPesquisaAluno = new JLabel("Pesquisa Usu\u00E1rio");
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
						txt4.setEditable(true);
						cmb5.setEnabled(true);
						btnexc.setVisible(false);
						btnalt.setText("Cancelar");
					}
				}else{
					btnsavealt.setVisible(false);
					txt1.setEditable(false);
					txt2.setEditable(false);
					txt3.setEditable(false);
					txt4.setEditable(false);
					cmb5.setEnabled(false);
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
		btnalt.setBounds(301, 446, 121, 35);
		add(btnalt);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(pPesquisa3.class.getResource("/images/ifce-logo2.jpg")));
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
				Usuario a = new Usuario();
				a.setId(txt1.getText());
				a.setEmail(txt2.getText());
				a.setTel(txt3.getText());
				a.setSenha(txt4.getText());
				a.setTurno(cmb5.getSelectedItem().toString());
		
				dao.con();
				dao.edit(a);
				dao.desc();
				
				//quanto concluir a alteração
				btnsavealt.setVisible(false);
				txt1.setEditable(false);
				txt2.setEditable(false);
				txt3.setEditable(false);
				txt4.setEditable(false);
				cmb5.setEnabled(false);
				txt0.setEnabled(true);
				btnexc.setVisible(true);
				
				txt0.setText(txt1.getText());
			}
		});
		btnsavealt.setForeground(Color.WHITE);
		btnsavealt.setFont(new Font("Arial", Font.PLAIN, 18));
		btnsavealt.setBackground(new Color(50, 205, 50));
		btnsavealt.setBounds(75, 446, 216, 35);
		add(btnsavealt);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*
				if(txt0.getText().equals("003")){
					//simulação
					txt1.setText("003");
					txt2.setText("marcondes013@gmail.com");
					txt3.setText("8899834691");
					txt4.setText("123456");
					cmb5.setSelectedItem("Noite");
					//
					btnalt.setVisible(true);
					btnexc.setVisible(true);
				}else{
					btnalt.setVisible(false);
					btnexc.setVisible(false);
				}
				*/
                pesq();
				
			}
		});
		button.setIcon(new ImageIcon(pPesquisa3.class.getResource("/images/search.png")));
		button.setBounds(389, 150, 33, 28);
		add(button);
		
		btnexc = new JButton("Excluir");
		btnexc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario a = new Usuario();
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
		btnexc.setBounds(432, 446, 121, 35);
		add(btnexc);
		
		JLabel label = new JLabel("Senha");
		label.setFont(new Font("Arial", Font.PLAIN, 18));
		label.setBounds(75, 351, 82, 25);
		add(label);
		
		txt4 = new JPasswordField();
		txt4.setEditable(false);
		txt4.setBounds(167, 349, 255, 27);
		add(txt4);
		
		JLabel lblTurno = new JLabel("Turno");
		lblTurno.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTurno.setBounds(75, 401, 82, 25);
		add(lblTurno);
		
		cmb5 = new JComboBox();
		cmb5.setEnabled(false);
		cmb5.setModel(new DefaultComboBoxModel(new String[] {"Manh\u00E3", "Tarde", "Noite"}));
		cmb5.setBounds(167, 399, 255, 27);
		add(cmb5);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(pPesquisa3.class.getResource("/images/profile.png")));
		label_4.setBounds(502, 194, 192, 192);
		add(label_4);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(454, 55, 288, 371);
		add(panel);

	}
	public void pesq(){
		dao.con();
		
		Usuario a = new Usuario();
		a=dao.pesq(txt0.getText());
		txt1.setText(a.getId());
		txt2.setText(a.getEmail());
		txt3.setText(""+a.getTel());
		cmb5.setSelectedItem(a.getTurno());
		txt4.setText(a.getSenha());
		
		if(txt1.getText().equals("")){
			btnalt.setVisible(false);
			btnexc.setVisible(false);
		}else{
			btnalt.setVisible(true);
			btnexc.setVisible(true);
		}
		dao.desc();
	}
}
