package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import javax.swing.JTextField;

import control.DAOUsuario;
import model.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class pCadastro3 extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JPasswordField txt4;
	JComboBox cmb5;

	DAOUsuario dao = new DAOUsuario();
	
	/**
	 * Create the panel.
	 */
	public pCadastro3() {
		setBackground(Color.WHITE);
		setBounds(100, 100, 800, 500);
		setLayout(null);
		
		JLabel label = new JLabel("Matr\u00EDcula");
		label.setFont(new Font("Arial", Font.PLAIN, 18));
		label.setBounds(75, 152, 100, 25);
		add(label);
		
		txt4 = new JPasswordField();
		txt4.setBounds(167, 299, 255, 27);
		add(txt4);
		
		JLabel lblCadastroUsurio = new JLabel("Cadastro Usu\u00E1rio");
		lblCadastroUsurio.setFont(new Font("Arial", Font.PLAIN, 24));
		lblCadastroUsurio.setBounds(75, 97, 255, 25);
		add(lblCadastroUsurio);
		
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
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Arial", Font.PLAIN, 18));
		lblSenha.setBounds(75, 301, 82, 25);
		add(lblSenha);
		
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
			public void actionPerformed(ActionEvent e) {
				Usuario a = new Usuario();
				a.setId(txt1.getText());
				a.setEmail(txt2.getText());
				a.setTel(txt3.getText());
				a.setSenha(txt4.getText());
				//JOptionPane.showMessageDialog(null, txt4.getText());
				a.setTurno(cmb5.getSelectedItem().toString());
				
				dao.con();
				dao.cad(a);
				dao.desc();
				txt1.setText("");
				txt2.setText("");
				txt3.setText("");
				txt4.setText("");
				cmb5.setSelectedItem("Manhã");
			}
		});
		btncad.setForeground(Color.WHITE);
		btncad.setFont(new Font("Arial", Font.PLAIN, 18));
		btncad.setBackground(new Color(50, 205, 50));
		btncad.setBounds(288, 397, 134, 35);
		add(btncad);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(pCadastro3.class.getResource("/images/ifce-logo2.jpg")));
		label_6.setBounds(500, 55, 246, 106);
		add(label_6);
		
		JLabel lblTurno = new JLabel("Turno");
		lblTurno.setFont(new Font("Arial", Font.PLAIN, 18));
		lblTurno.setBounds(75, 351, 82, 25);
		add(lblTurno);
		
		cmb5 = new JComboBox();
		cmb5.setModel(new DefaultComboBoxModel(new String[] {"Manh\u00E3", "Tarde", "Noite"}));
		cmb5.setBounds(167, 349, 255, 27);
		add(cmb5);
		
		JLabel label_7 = new JLabel("");
		label_7.setIcon(new ImageIcon(pPesquisa3.class.getResource("/images/usuario.png")));
		label_7.setBounds(522, 201, 192, 192);
		add(label_7);

	}
}
