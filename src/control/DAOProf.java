package control;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Aluno;
import model.Prof;

public class DAOProf extends DAO {
	
	String r;
	public Prof pesq(String id){
		Prof a = new Prof();
		try{
			//pesquisa
			String query = "select * from prof where id = '"+id+"';";
			this.result = this.stat.executeQuery(query);
			this.stat = this.con.createStatement(); 
			result.next();

			a.setId(this.result.getString("id"));
			a.setEmail(this.result.getString("email"));
			a.setTel(this.result.getString("tel"));
			a.setCop(this.result.getInt("cop"));
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Não encontrado!");
		}
		return a;
	}
	
	public void cad(Prof a){ //passar parametros
		try{
			String query = "insert into prof ("
					+ "id, email, tel, cop) values "
					+ "('"+a.getId()+"', '"+a.getEmail()+"', '"+a.getTel()+"', '"+a.getCop()+"');";
			this.stat.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
		}
	}
	
	public void edit(Prof a){ //passar parametros
		try{
			String query = "update prof set id ='"+a.getId()+"', email ='"+a.getEmail()+"', tel ='"+a.getTel()+
			"' where id = "+a.getId()+";";
			this.stat.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Alterações realizadas com sucesso!");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
		}
	}
	
	public void editcop(Prof a){ //passar parametros
		try{
			String query = "update prof set cop ='"+a.getCop()+"' where id = "+a.getId()+";";
			this.stat.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Cópias adicionadas!");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
		}
	}
	
	public void del(Prof a){
		try{
			String query = "delete from prof where id = "+a.getId()+";";
			this.stat.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Professor Excluido!");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
		}	
	}
	
}
