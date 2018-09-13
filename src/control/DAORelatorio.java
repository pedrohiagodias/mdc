package control;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Copia;
import model.Relatorio;

public class DAORelatorio extends DAO {
	
	String r;
	public Relatorio pesq(){
		Relatorio a = new Relatorio();
		try{
			//pesquisa
			String query = "select * from relatorio ORDER BY id DESC LIMIT 1;";
			this.result = this.stat.executeQuery(query);
			this.stat = this.con.createStatement(); 
			result.next();

			a.setId(this.result.getInt("id"));
			a.setDt(this.result.getString("dt"));
		}catch(Exception e){
			//JOptionPane.showMessageDialog(null, "Não encontrado!");
		}
		return a;
	}
	
	public void cad(Relatorio a){ //passar parametros
		try{
			String query = "insert into relatorio ("
					+ "dt, id) values "
					+ "('"+a.getDt()+"', '"+a.getId()+"');";
			this.stat.executeUpdate(query);
			//JOptionPane.showMessageDialog(null, "Relatório registrado!");
		}catch(Exception e){
			//JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
		}
	}
	
	public void edit(Relatorio a,int id){ //passar parametros
		try{
			String query = "update relatorio set dt ='"+a.getDt()+
					"' where id = '"+id+"';";
			this.stat.executeUpdate(query);
			//JOptionPane.showMessageDialog(null, "Cópias adicionadas!");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
		}
	}
	
}
