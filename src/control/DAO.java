package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class DAO {
	protected Connection con = null;
	protected Statement stat = null;
	protected ResultSet result = null;
	
	public void con(){
		String serv = "jdbc:mysql://localhost:3306/mdc";
		String user = "ifce";
		String pass = "ifcemdc";
		String driver = "com.mysql.jdbc.Driver";
		try{
			Class.forName(driver);
			this.con = DriverManager.getConnection(serv, user, pass);
			this.stat = this.con.createStatement();
			
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro de conex�o: "+e.toString());
			throw new Error(e.toString());
		}
	}
	
	public void desc(){ // desconectar
		try{
			this.con.close();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "Erro: "+e.toString());
			throw new Error(e.toString());
		}	
	}
	
	public boolean isCon(){ //verifica se est� conectado
		if(this.con != null){
			return true;
		}else{
			return false;
		}
	}
}
