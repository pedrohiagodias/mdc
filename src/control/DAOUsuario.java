package control;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.Usuario;

public class DAOUsuario extends DAO {
	
	String r;
	public Usuario pesq(String id){
		Usuario a = new Usuario();
		try{
			//pesquisa
			String query = "select * from user where id = '"+id+"';";
			this.result = this.stat.executeQuery(query);
			this.stat = this.con.createStatement(); 
			result.next();

			a.setId(this.result.getString("id"));
			a.setEmail(this.result.getString("email"));
			a.setTel(this.result.getString("tel"));
			
			a.setSenha(this.result.getString("sen"));
			a.setTurno(this.result.getString("turno"));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "N�o encontrado!");
		}
		return a;
	}
	
	public void cad(Usuario a){ //passar parametros
		try{
			String query = "insert into user ("
					+ "id, email, tel, "
					+ "sen, turno) values "
					+ "('"+a.getId()+"', '"+a.getEmail()+"', '"+a.getTel()+"', "
					+ "'"+a.getSenha()+"','"+a.getTurno()+"');";
			this.stat.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
			throw new Error("Error ao cadastrar usuário " + e.toString());
		}
	}
	
	public void edit(Usuario a){ //passar parametros
		try{
			String query = "update user set id ='"+a.getId()+"', email ='"+a.getEmail()+"', tel ='"+a.getTel()+
			"', sen ='"+a.getSenha()+"', turno ='"+a.getTurno()+"' where id = "+a.getId()+";";
			this.stat.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Altera��es realizadas com sucesso!");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
		}
	}
	
	public void del(Usuario a){
		try{
			String query = "delete from user where id = "+a.getId()+";";
			this.stat.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Usu�rio Excluido!");
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro: "+e.getMessage());
		}	
	}
	
	public Usuario login(String login, String senha){
		Usuario user = new Usuario();
		try{
			//pesquisa
			String query = "select id, sen from user where id = '"+login+"' and sen = '"+senha+"';";
			this.result = this.stat.executeQuery(query);
			this.stat = this.con.createStatement(); 
			result.next();
			user.setId(result.getString("id"));
			user.setSenha(result.getString("sen"));
			//JOptionPane.showMessageDialog(null, "id >"+user.getId()+"sen >"+user.getSenha());
		}catch(Exception e){
			user = null;
			JOptionPane.showMessageDialog(null, "Login ou senha inv�lidos!"," Erro ao entrar!",2);
		}
		return user;
	}
	
}
