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
import javax.swing.SwingConstants;

import control.DAOCopia;
import control.DAORelatorio;
import control.DataSoma;
import control.GeraPDF;
import model.Copia;
import model.Relatorio;

import javax.swing.JSeparator;
import java.awt.Dimension;
import java.awt.SystemColor;

public class pMenu extends JPanel {

	GeraPDF pdf = new GeraPDF();
	/**
	 * Create the panel.
	 */
	DAOCopia daoc = new DAOCopia(); 
	DAORelatorio daor = new DAORelatorio();
	
	DataSoma d = new DataSoma();
	
	public pMenu(Main main) {
		setBackground(Color.WHITE);
		setBounds(100, 100, 800, 600);
		setLayout(null);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(pMenu.class.getResource("/images/ifce-logo.jpg")));
		label_2.setBounds(79, 70, 360, 128);
		add(label_2);
		
		JButton btnPesquisa = new JButton(" Pesquisa");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.p.remove(main.menu);
				main.p.add(main.pesq);
				main.p.add(main.tab);
				main.tab.setVisible(true);
				main.status.setText("Pesquisar");
				main.p.repaint();
			}
		});
		btnPesquisa.setIcon(new ImageIcon(pMenu.class.getResource("/images/search.png")));
		btnPesquisa.setForeground(Color.WHITE);
		btnPesquisa.setFont(new Font("Arial", Font.PLAIN, 18));
		btnPesquisa.setBackground(new Color(50, 205, 50));
		btnPesquisa.setBounds(79, 233, 177, 33);
		add(btnPesquisa);
		
		JButton btnCadastro = new JButton(" Cadastro");
		btnCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				main.p.remove(main.menu);
				main.p.add(main.cad);
				main.p.add(main.tab);
				main.tab.setVisible(true);
				main.status.setText("Cadastrar");
				main.p.repaint();
			}
		});
		btnCadastro.setIcon(new ImageIcon(pMenu.class.getResource("/images/note_add.png")));
		btnCadastro.setForeground(Color.WHITE);
		btnCadastro.setFont(new Font("Arial", Font.PLAIN, 18));
		btnCadastro.setBackground(new Color(50, 205, 50));
		btnCadastro.setBounds(79, 286, 177, 33);
		add(btnCadastro);
		
		JButton btnGerarRelatrio = new JButton(" Gerar Relat\u00F3rio");
		btnGerarRelatrio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] options = { "Confirmar", "Cancelar" };
				int r = JOptionPane.showOptionDialog(null, "Clique Confirmar para continuar\nOs dados das cópias semanais irão ser resetados!", "Informação", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				if(r==0){
					Copia c = new Copia();
					daoc.con();
		
					daor.con();
					Relatorio re = new Relatorio();
					re=daor.pesq();
					c=daoc.pesq(re.getId());
					re.setDt(d.hj);
					daor.edit(re, re.getId());
					//JOptionPane.showMessageDialog(null, c.getId());
					Relatorio re2 = new Relatorio();
					re2.setId(re.getId()+1);
				    daor.cad(re2); //
					DataSoma d = new DataSoma();
					String info = "TOTAL DE CÓPIAS TIRADAS: "+(c.getAlu()+c.getPerdidas()+c.getProf())+"\n"
							+ "CÓPIAS PERDIDAS: "+c.getPerdidas()+""
									+ "\nCÓPIAS C/REQUISIÇÃO: "+c.getProf()+""
											+ "\nCÓPIAS PAGAS: "+c.getAlu();
					pdf.gerar(d.hj,info);
					c.setId(c.getId()+1);
					c.setAlu(0);
					c.setPerdidas(0);
					c.setProf(0);
					daoc.cad(c);
					daor.desc();
					
					daoc.desc();
				}
				
			}
		});
		btnGerarRelatrio.setIcon(new ImageIcon(pMenu.class.getResource("/images/pdf.png")));
		btnGerarRelatrio.setForeground(Color.WHITE);
		btnGerarRelatrio.setFont(new Font("Arial", Font.PLAIN, 18));
		btnGerarRelatrio.setBackground(new Color(50, 205, 50));
		btnGerarRelatrio.setBounds(278, 286, 242, 33);
		add(btnGerarRelatrio);
		
		JSeparator separator = new JSeparator();
		separator.setSize(new Dimension(9, 9));
		separator.setPreferredSize(new Dimension(9, 9));
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setForeground(new Color(50, 205, 50));
		separator.setBounds(598, -22, 10, 615);
		add(separator);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.control);
		panel.setBounds(598, 0, 203, 593);
		add(panel);
		panel.setLayout(null);
		
		JButton btnSair = new JButton(" Sair     ");
		btnSair.setIcon(new ImageIcon(pMenu.class.getResource("/images/home_next.png")));
		btnSair.setBounds(26, 70, 136, 33);
		panel.add(btnSair);
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.p.removeAll();
				main.p.add(main.log);
				main.log.pfSenha.setText("");
				main.log.txtLogin.setText("");
				main.p.repaint();
			}
		});
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Arial", Font.PLAIN, 18));
		btnSair.setBackground(new Color(204, 0, 0));
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 87, 35, 12);
		panel.add(separator_1);
		separator_1.setForeground(new Color(50, 205, 50));
		
		JButton btnInfo = new JButton(" Sobre  ");
		btnInfo.setIcon(new ImageIcon(pMenu.class.getResource("/images/info.png")));
		btnInfo.setBounds(26, 114, 136, 33);
		panel.add(btnInfo);
		btnInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "\n                        Mecanografia Digital Center\n"
						+ "Software desenvolvido para facilitar a gerência\n"
						+ "do setor de mecanografia do IFCE - Campus Crato.      \n"
						+ "-----------------------------------------------------------------------------\n\n"
						+ "                                 Equipe do Projeto:\n"
						+ "David Kelvy (Gerente)\n"
						+ "Bárbara Joana (Analista)\n"
						+ "Pedro Henrique Lobo (Arquiteto)\n"
						+ "Pedro Hiago Dias (Desenvolvedor)\n"
						+ "Matheus Soares (Testador)\n"
						+ "-----------------------------------------------------------------------------"
						+ "               \n\n","Informações", 1);
			}
		});
		btnInfo.setForeground(Color.WHITE);
		btnInfo.setFont(new Font("Arial", Font.PLAIN, 18));
		btnInfo.setBackground(new Color(50, 205, 50));
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(50, 205, 50));
		separator_2.setBounds(0, 130, 38, 12);
		panel.add(separator_2);
		
		JButton btnBackup = new JButton(" Backup");
		btnBackup.setVisible(false);
		btnBackup.setIcon(new ImageIcon(pMenu.class.getResource("/images/backup.png")));
		btnBackup.setForeground(Color.WHITE);
		btnBackup.setFont(new Font("Arial", Font.PLAIN, 18));
		btnBackup.setBackground(new Color(50, 205, 50));
		btnBackup.setBounds(26, 158, 136, 33);
		panel.add(btnBackup);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setVisible(false);
		separator_3.setForeground(new Color(50, 205, 50));
		separator_3.setBounds(0, 174, 38, 12);
		panel.add(separator_3);
		
		JButton btnVersion = new JButton("");
		btnVersion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "\n                                  Detalhes de versão\n"
						+ "-----------------------------------------------------------------------------\n"
						+ "1.1.5 >"
						+ "\n     . testes adicionados"
						+ "\n     . especificação de semestre/bimestre (cad. Aluno)"
						+ "\n     . botão cancelar na alteração de dados"
						+ "\n     . detelhes de versão"
						+ "\n<"
						+ "\n-----------------------------------------------------------------------------"
						+ "               \n\n","Informações", 1);
			}
		});
		btnVersion.setIcon(new ImageIcon(pMenu.class.getResource("/images/infoVersion.png")));
		btnVersion.setBounds(138, 508, 16,16);
		panel.add(btnVersion);
		
		JLabel lblV = new JLabel("vers\u00E3o 1.1.1");
		lblV.setHorizontalAlignment(SwingConstants.CENTER);
		lblV.setForeground(new Color(0, 102, 0));
		lblV.setFont(new Font("Arial", Font.BOLD, 14));
		lblV.setBounds(-8, 508, 195, 16);
		panel.add(lblV);
		
		lblV.setText("versão "+main.v);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 475, 23, 90);
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(172, 475, 23, 90);
		panel.add(panel_4);
		
		
		JButton btnControleCopias = new JButton(" Controle de C\u00F3pias Perdidas ");
		btnControleCopias.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				main.p.remove(main.menu);
				main.p.add(main.concop);
				main.p.add(main.tab);
				main.tab.setVisible(true);
				main.status.setVisible(false);
				main.cmbOp.setVisible(false);
				main.p.repaint();
			}
		});
		btnControleCopias.setIcon(new ImageIcon(pMenu.class.getResource("/images/page.png")));
		btnControleCopias.setForeground(Color.WHITE);
		btnControleCopias.setFont(new Font("Arial", Font.PLAIN, 18));
		btnControleCopias.setBackground(new Color(50, 205, 50));
		btnControleCopias.setBounds(79, 342, 441, 33);
		add(btnControleCopias);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(35, 526, 730, 96);
		add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(55, -25, 533, 96);
		add(panel_2);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(pMenu.class.getResource("/images/lines.png")));
		label.setBounds(55, -22, 489, 884);
		add(label);

	}
}
