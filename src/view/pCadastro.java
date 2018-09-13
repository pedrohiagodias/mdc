package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import javax.swing.JTextField;

import control.DAOAluno;
import model.Aluno;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class pCadastro extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt5;

	DAOAluno dao = new DAOAluno();
	
	/**
	 * Create the panel.
	 */
	public pCadastro() {
		setBackground(Color.WHITE);
		setBounds(100, 100, 800, 500);
		setLayout(null);
		
		JLabel label = new JLabel("Matr\u00EDcula");
		label.setFont(new Font("Arial", Font.PLAIN, 18));
		label.setBounds(75, 152, 100, 25);
		add(label);
		
		JLabel label_1 = new JLabel("Cadastro Aluno");
		label_1.setFont(new Font("Arial", Font.PLAIN, 24));
		label_1.setBounds(75, 97, 255, 25);
		add(label_1);
		
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
		
		JLabel label_4 = new JLabel("Curso");
		label_4.setFont(new Font("Arial", Font.PLAIN, 18));
		label_4.setBounds(75, 303, 89, 25);
		add(label_4);
		
		JLabel lblSemestre = new JLabel("Semestre");
		lblSemestre.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSemestre.setBounds(75, 348, 82, 25);
		add(lblSemestre);
		
		txt2 = new JTextField();
		txt2.setColumns(10);
		txt2.setBounds(167, 199, 255, 27);
		add(txt2);
		
		txt3 = new JTextField();
		txt3.setColumns(10);
		txt3.setBounds(167, 251, 255, 27);
		add(txt3);
		
		JComboBox cmb4 = new JComboBox();
		cmb4.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cmb4.getSelectedIndex() == 0 || cmb4.getSelectedIndex() == 1){
					lblSemestre.setText("Semestre");
				}else{
					lblSemestre.setText("Bimestre");
				}
			}
		});
		cmb4.setModel(new DefaultComboBoxModel(new String[] {"Sistemas de Informa\u00E7\u00E3o", "Zootecnia", "Ensino M\u00E9dio", "Subsequente"}));
		cmb4.setBounds(167, 303, 255, 27);
		add(cmb4);
		
		txt5 = new JTextField();
		txt5.setColumns(10);
		txt5.setBounds(167, 348, 255, 27);
		add(txt5);
		
		JButton btncad = new JButton("Cadastrar");
		btncad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!.");
				Aluno a = new Aluno();
				a.setId(txt1.getText());
				a.setEmail(txt2.getText());
				a.setTel(txt3.getText());
				a.setSemestre(Integer.parseInt(txt5.getText()));
				a.setCurso(cmb4.getSelectedItem().toString());
				
				dao.con();
				dao.cad(a);
				dao.desc();
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");
				txt5.setText("");
				cmb4.setSelectedItem("Sistemas de Informação");
			}
		});
		btncad.setForeground(Color.WHITE);
		btncad.setFont(new Font("Arial", Font.PLAIN, 18));
		btncad.setBackground(new Color(50, 205, 50));
		btncad.setBounds(288, 396, 134, 35);
		add(btncad);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(pCadastro.class.getResource("/images/ifce-logo2.jpg")));
		label_6.setBounds(500, 55, 246, 106);
		add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(pPesquisa3.class.getResource("/images/aluno.png")));
		label_7.setBounds(522, 201, 192, 192);
		add(label_7);

	}
}
