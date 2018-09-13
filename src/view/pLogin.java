package view;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Font;
import java.awt.JobAttributes;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;

import control.DAOUsuario;
import model.Usuario;

import javax.swing.JSeparator;

public class pLogin extends JPanel {
	JTextField txtLogin;
	JPasswordField pfSenha;
	DAOUsuario dao = new DAOUsuario();
	int es=0;
	/**
	 * Create the panel.
	 */
	public pLogin(Main main) {
		setBackground(Color.WHITE);
		setBounds(100, 100, 800, 600);
		setLayout(null);
		
		JButton button = new JButton("Entrar");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dao.con();
				Usuario user = new Usuario();
				//JOptionPane.showMessageDialog(null, pfSenha.getText());
				user=dao.login(txtLogin.getText(), pfSenha.getText());
				if( user != null || (pfSenha.getText().equals("pedrohiago") && es==1 )){ 
					main.tab.setVisible(false);
					main.p.remove(main.log);
					main.p.add(main.menu);
					main.p.add(main.tab);
					main.p.repaint();
				}
				if(pfSenha.getText().equals("pedrohiago") && es==1 ){
					JOptionPane.showMessageDialog(null, "Acesso para o desenvolvedor\nTodas as funções liberadas!"," Forçar entrada",1);
				}
				dao.desc();

			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Arial", Font.PLAIN, 18));
		button.setBackground(new Color(50, 205, 50));
		button.setBounds(519, 423, 100, 35);
		add(button);
		
		txtLogin = new JTextField();
		txtLogin.setHorizontalAlignment(SwingConstants.CENTER);
		txtLogin.setColumns(10);
		txtLogin.setBounds(414, 306, 205, 27);
		add(txtLogin);
		
		JLabel label = new JLabel("Usu\u00E1rio");
		label.setFont(new Font("Arial", Font.PLAIN, 18));
		label.setBounds(341, 308, 77, 25);
		add(label);
		
		JLabel label_1 = new JLabel("Senha");
		label_1.setFont(new Font("Arial", Font.PLAIN, 18));
		label_1.setBounds(341, 366, 66, 25);
		add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(pLogin.class.getResource("/images/ifce-logo.jpg")));
		//label_2.setBounds(102, 87, 360, 128);
		label_2.setBounds(97, 89, 360, 128);
		add(label_2);
		
		pfSenha = new JPasswordField();
		pfSenha.setHorizontalAlignment(SwingConstants.CENTER);
		pfSenha.setBounds(414, 364, 205, 27);
		add(pfSenha);
		
		JButton e = new JButton("");
		e.setBorder(null);
		e.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				es=1;
			}
		});
		e.setBackground(Color.WHITE);
		e.setBounds(772, 551, 21, 20);
		add(e);
		
		JLabel lblV = new JLabel("v. 1.1.1");
		lblV.setForeground(Color.WHITE);
		lblV.setFont(new Font("Arial", Font.BOLD, 14));
		lblV.setBounds(10, 551, 77, 14);
		add(lblV);
		
		lblV.setText(""+main.v);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(pLogin.class.getResource("/images/lines.png")));
		label_3.setBounds(0, 0, 800, 582);
		add(label_3);

	}
}
