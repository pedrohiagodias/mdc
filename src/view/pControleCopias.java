
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

import control.DAOCopia;
import control.DAORelatorio;
import control.DataSoma;
import model.Copia;
import model.Relatorio;

import javax.swing.JSeparator;

public class pControleCopias extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txt00;
	private JTextField txt6;
	JButton btnadd;
	
	DataSoma d = new DataSoma(); 
	
	DAOCopia daoc = new DAOCopia();
	
	Copia c = new Copia();
	
	DAORelatorio daor = new DAORelatorio();

	public pControleCopias() {
		setBackground(Color.WHITE);
		setBounds(100, 100, 800, 500);
		setLayout(null);
		
		JLabel lblPesquisaAluno = new JLabel("Controle de C\u00F3pias Perdidas");
		lblPesquisaAluno.setFont(new Font("Arial", Font.PLAIN, 24));
		lblPesquisaAluno.setBounds(157, 78, 330, 25);
		add(lblPesquisaAluno);
		
		JLabel label_6 = new JLabel("");
		label_6.setIcon(new ImageIcon(pControleCopias.class.getResource("/images/ifce-logo.jpg")));
		label_6.setBounds(234, 316, 330, 160);
		add(label_6);
		
		txt00 = new JTextField();
		txt00.setHorizontalAlignment(SwingConstants.CENTER);
		txt00.setColumns(10);
		txt00.setBounds(270, 134, 82, 27);
		add(txt00);
		
		JLabel lblAddCpias = new JLabel("ADD C\u00F3pias");
		lblAddCpias.setFont(new Font("Arial", Font.PLAIN, 18));
		lblAddCpias.setBounds(157, 135, 100, 25);
		add(lblAddCpias);
		
		btnadd = new JButton("");
		btnadd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

					daoc.con();
					
					daor.con();
					Relatorio re = new Relatorio();
					re=daor.pesq();
				    daor.desc();
					
					c=daoc.pesq(re.getId());
					int a = c.getPerdidas();
					int r = a+Integer.parseInt(txt00.getText());
					txt6.setText(r+"");
					c.setPerdidas(Integer.parseInt(txt6.getText()));
					daoc.edit(c,c.getId());
					daoc.desc();
					JOptionPane.showMessageDialog(null, "Cópias adicionadas!");
					txt00.setText("");
			}
		});
		btnadd.setIcon(new ImageIcon(pControleCopias.class.getResource("/images/add.png")));
		btnadd.setBounds(362, 133, 33, 28);
		add(btnadd);
		
		JLabel lblLimite = new JLabel("Total");
		lblLimite.setFont(new Font("Arial", Font.PLAIN, 18));
		lblLimite.setBounds(157, 173, 100, 25);
		add(lblLimite);
		
		txt6 = new JTextField();
		txt6.setHorizontalAlignment(SwingConstants.CENTER);
		txt6.setText("0");
		txt6.setEditable(false);
		txt6.setColumns(10);
		txt6.setBounds(270, 172, 82, 27);
		add(txt6);
		
		daor.con();
		Relatorio re = new Relatorio();
		re=daor.pesq();
	    daor.desc();
		
		daoc.con();
		c=daoc.pesq(re.getId());
		daoc.desc();
		txt6.setText(""+c.getPerdidas());
		
		JSeparator separator = new JSeparator();
		separator.setBounds(48, 271, 697, 25);
		separator.setForeground(new Color(50, 205, 50));
		add(separator);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(pControleCopias.class.getResource("/images/trash.png")));
		label.setBounds(497, 55, 143, 175);
		add(label);

	}
}

