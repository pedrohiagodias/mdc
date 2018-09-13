package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import control.DAO;
import control.DAOUsuario;
import junit.framework.Assert;
import model.Usuario;

public class DAOUsuarioTest {
	private static DAOUsuario daousuario;
	private static Usuario usuario;
	
	
	@BeforeClass
    public static void connect() {
		daousuario = new DAOUsuario();
		usuario = new Usuario();	
		
		daousuario.con();
    }
	
	@AfterClass
    public static void cleanDb()  {
		try {
			daousuario.del(usuario);
			daousuario.desc();			
		}catch(Exception err) {
			throw new Error(err.toString());
		}
    }
	
	
	@Test
	public void testCad() {
		try {
	        usuario.setEmail("devlacerda@gmail.com");
	        usuario.setId("20152085010080");
	        usuario.setSenha("123456");
	        usuario.setTurno("Manhã");
	        usuario.setTel("(88) 99367761");
	        
			daousuario.cad(usuario);
		}catch(Exception err) {
			fail("Error ao cadastrar usuario " + err.getMessage());
		}
	}
	
	@Test
	public void testLogin() {
		Usuario tempUser = new Usuario();
		try {
			tempUser = daousuario.login(usuario.getId(), usuario.getSenha());
			Assert.assertEquals(usuario.getId(), tempUser.getId());
		}catch(Exception err) {
			fail("Error ao realizer login");
		}
	}

	
	@Test 
	public void testEdit() {
		usuario.setEmail("the.matheus6@gmail.com");
		try {			
			daousuario.edit(usuario);
		}catch(Exception err) {
			fail("Falha ao editar usuario");
		}		
	}
	
	
	@Test
	public void testPesq() {
		Usuario tempUser = new Usuario();
		
		try {
			tempUser = daousuario.pesq(usuario.getId());
			Assert.assertEquals(usuario.getId(), tempUser.getId());
		}catch(Exception err) {
			fail("Falha ao buscar usuario " + err.getMessage());
		}
	}
	
	
}
