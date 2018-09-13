package control;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Aluno;

public class DAOAluno extends DAO {
	
	String r;
	public Aluno pesq(String id){
		Aluno a = new Aluno();
		try{
			//pesquisa
			String query = "select * from aluno where id = '"+id+"';";
			this.result = this.stat.executeQuery(query);
			this.stat = this.con.createStatement(); 
			result.next();

			a.setId(this.result.getString("id"));
			a.setEmail(this.result.getString("email"));
			a.setTel(this.result.getString("tel"));
			
			a.setSemestre(this.result.getInt("sem"));
			a.setCurso(this.result.getString("curso"));
			a.setCop(this.result.getInt("cop"));
			a.setDt(this.result.getString("dt"));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Não encontrado!");
		}
		return a;
	}
	
	public void cad(Aluno a){ //passar parametros
		try{
			String query = "insert into aluno ("
					+ "id, email, tel, "
					+ "sem, curso, cop) values "
					+ "('"+a.getId()+"', '"+a.getEmail()+"', '"+a.getTel()+"',"
					+ "'"+a.getSemestre()+"','"+a.getCurso()+"', '"+a.getCop()+"');";
			this.stat.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
		}
	}
	
	public void edit(Aluno a){ //passar parametros
		try{
			String query = "update aluno set id ='"+a.getId()+"', email ='"+a.getEmail()+"', tel ='"+a.getTel()+
			"', sem ='"+a.getSemestre()+"', curso ='"+a.getCurso()+"', cop ='"+a.getCop()+"' where id = "+a.getId()+";";
			this.stat.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Alterações realizadas com sucesso!");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
		}
	}
	
	public void editcop(Aluno a){ //passar parametros
		try{
			String query = "update aluno set cop ='"+a.getCop()+"',dt = '"+a.getDt()+"' where id = "+a.getId()+";";
			this.stat.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Cópias adicionadas!");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
		}
	}
	
	public void del(Aluno a){
		try{
			String query = "delete from aluno where id = "+a.getId()+";";
			this.stat.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Aluno Excluido!");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
		}	
	}
	
}
