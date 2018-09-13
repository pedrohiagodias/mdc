package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import javax.swing.JTextField;

import control.DAOProf;
import model.Prof;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pCadastro2 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	
	DAOProf dao = new DAOProf();

	/**
	 * Create the panel.
	 */
	public pCadastro2() {
		setBackground(Color.WHITE);
		setBounds(100, 100, 800, 500);
		setLayout(null);
		
		JLabel label = new JLabel("Matr\u00EDcula");
		label.setFont(new Font("Arial", Font.PLAIN, 18));
		label.setBounds(75, 152, 100, 25);
		add(label);
		
		JLabel lblCadastroProfessor = new JLabel("Cadastro Professor");
		lblCadastroProfessor.setFont(new Font("Arial", Font.PLAIN, 24));
		lblCadastroProfessor.setBounds(75, 97, 255, 25);
		add(lblCadastroProfessor);
		
		txt1 = new JTextField();
		txt1.setColumns(10);
		txt1.setBounds(167, 150, 255, 27);
		add(txt1);
		
		JLabel label_2 = new JLabel("Email");
		label_2.setFont(new Font("Arial", Font.PLAIN, 18));
		label_2.setBounds(75, 199, 66, 25);
		add(label_2);
		
		JLabel label_3 = new JLabel("Telefone");
		label_3.setFont(new Font("Arial", Font.PLAIN, 18));
		label_3.setBounds(75, 251, 82, 25);
		add(label_3);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(167, 199, 255, 27);
		add(txt2);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(167, 251, 255, 27);
		add(txt3);
		
		JButton btncad = new JButton("Cadastrar");
		btncad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Prof a = new Prof();
				a.setId(txt1.getText());
				a.setEmail(txt2.getText());
				a.setTel(txt3.getText());
				
				dao.con();
				dao.cad(a);
				dao.desc();
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");
			}
		});
		btncad.setForeground(Color.WHITE);
		btncad.setFont(new Font("Arial", Font.PLAIN, 18));
		btncad.setBackground(new Color(50, 205, 50));
		btncad.setBounds(288, 299, 134, 35);
		add(btncad);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(pCadastro2.class.getResource("/images/ifce-logo2.jpg")));
		label_6.setBounds(500, 55, 246, 106);
		add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(pPesquisa3.class.getResource("/images/professor.png")));
		label_7.setBounds(522, 201, 192, 192);
		add(label_7);

	}
}
