package view;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class Main extends JFrame {
	String v="1.1.5";

	JPanel p = new JPanel();
	pLogin log = new pLogin(this);
	pCadastro cad = new pCadastro();
	pCadastro2 cad2 = new pCadastro2();
	pCadastro3 cad3 = new pCadastro3();
	
	pPesquisa pesq = new pPesquisa();
	pPesquisa2 pesq2 = new pPesquisa2();
	pPesquisa3 pesq3 = new pPesquisa3();
	
	pControleCopias concop = new pControleCopias();
	
	pMenu menu = new pMenu(this);
	JPanel tab = new JPanel();
	private final JButton btnVoltar = new JButton("<  Voltar");
	JLabel status = new JLabel("Cadastrar");

	JComboBox cmbOp;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		
		log.setLocation(0, 0);
		menu.setLocation(0, 0);
		
		cad.setLocation(0, 30);
		cad2.setLocation(0, 30);
		cad3.setLocation(0, 30);
		
		pesq.setLocation(0, 30);
		pesq2.setLocation(0, 30);
		pesq3.setLocation(0, 30);
		
		concop.setLocation(0, 30);
		
		setTitle("Mecanografia Digital Center");
		setBounds(100, 100, 800, 600);
		
		//setUndecorated(true); // retira -_x
        setResizable(false);
		setLocationRelativeTo(null);
		
		p.setBackground(Color.WHITE);
		p.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(p);
		p.setLayout(null);
		p.add(log);
		tab.setBackground(SystemColor.controlHighlight);
		tab.setBounds(0, 0, 795, 27);
		
		tab.setLayout(null);
		
		cmbOp = new JComboBox();
		cmbOp.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(status.getText() == "Cadastrar"){
					if(cmbOp.getSelectedItem() == "Alunos"){
						p.add(cad);
						p.remove(cad2);
						p.remove(cad3);
						p.repaint();
						//
					}else if(cmbOp.getSelectedItem() == "Professores"){
						p.add(cad2);
						p.remove(cad);
						p.remove(cad3);
						p.repaint();
					}else if(cmbOp.getSelectedItem() == "Usuários"){
						p.add(cad3);
						p.remove(cad2);
						p.remove(cad);
						p.repaint();
					}
				}else{
					if(cmbOp.getSelectedItem() == "Alunos"){
						p.add(pesq);
						p.remove(pesq2);
						p.remove(pesq3);
						p.repaint();
					}else if(cmbOp.getSelectedItem() == "Professores"){
						p.add(pesq2);
						p.remove(pesq);
						p.remove(pesq3);
						p.repaint();
					}else if(cmbOp.getSelectedItem() == "Usuários"){
						p.add(pesq3);
						p.remove(pesq2);
						p.remove(pesq);
						p.repaint();
					}
				
				}
				
			}
		});
		cmbOp.setBounds(312, 0, 108, 27);
		tab.add(cmbOp);
		cmbOp.setModel(new DefaultComboBoxModel(new String[] {"Alunos", "Professores", "Usu\u00E1rios"}));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cmbOp.setSelectedItem("Alunos");
				p.removeAll();
				p.add(menu);
				p.repaint();
				status.setVisible(true);
				cmbOp.setVisible(true);
				tab.setVisible(false);
			}
		});
		btnVoltar.setBounds(0, 0, 84, 27);
		
		tab.add(btnVoltar);
		status.setHorizontalAlignment(SwingConstants.CENTER);
		status.setBounds(238, 6, 74, 14);
		
		tab.add(status);

	}
}
