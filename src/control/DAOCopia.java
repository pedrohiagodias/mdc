package control;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Aluno;
import model.Copia;
import model.Relatorio;

public class DAOCopia extends DAO {
	
	String r;
	
	public void edit(Copia a,int id){ //passar parametros
		try{
			String query = "update copia set perdidas ='"+a.getPerdidas()+"', prof ='"+a.getProf()+"', alu ='"+a.getAlu()+
					"' where id = '"+id+"';";
			this.stat.executeUpdate(query);
			//JOptionPane.showMessageDialog(null, "Cópias adicionadas!");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
		}
	}
	
	public Copia pesq(int id){
		Copia a = new Copia();
		try{
			//pesquisa
			String query = "select * from copia where id = '"+id+"';";
			this.result = this.stat.executeQuery(query);
			this.stat = this.con.createStatement(); 
			result.next();

			a.setId(this.result.getInt("id"));
			a.setPerdidas(this.result.getInt("perdidas"));
			a.setAlu(this.result.getInt("alu"));
			a.setProf(this.result.getInt("prof"));

		}catch(Exception e){
			//JOptionPane.showMessageDialog(null, "Não encontrado!");
		}
		return a;
	}
	
	public void cad(Copia a){ //passar parametros
		try{
			String query = "insert into copia ("
					+ "id, alu, "
					+ "perdidas, prof) values "
					+ "('"+a.getId()+"', '"+a.getAlu()+"',"
					+ "'"+a.getPerdidas()+"','"+a.getProf()+"');";
			this.stat.executeUpdate(query);
			//JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
		}
	}
	
}
