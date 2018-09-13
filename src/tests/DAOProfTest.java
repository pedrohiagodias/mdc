package tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import control.DAOProf;
import junit.framework.Assert;
import model.Prof;
import model.Usuario;

public class DAOProfTest {
	private static DAOProf daoprof;
	private static Prof professor;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
			daoprof = new DAOProf();
			professor = new Prof();
			
			daoprof.con();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		daoprof.del(professor);
		daoprof.desc();
	}

	@Test
	public void testCad() {
		try {
			professor.setCop(0);
			professor.setEmail("devlacerda@gmail.com");
			professor.setId("20152085010080");
			professor.setTel("(88) 999367761");
		
			daoprof.cad(professor);
		}catch(Exception err) {
			fail(err.toString());
		}
		
	}
	
	@Test
	public void testPesq() {
		Prof tempProf = new Prof();
		
		try {
			tempProf = daoprof.pesq(professor.getId());
			Assert.assertEquals(professor.getId(), tempProf.getId());
		}catch(Exception err) {
			fail("Falha ao buscar professor " + err.toString());
		}
	}


	@Test
	public void testEdit() {
		
		Prof tempProf = new Prof();
		
		try {
			professor.setEmail("the.matheus@gmail.com");
			daoprof.edit(professor);
			tempProf = daoprof.pesq(professor.getId());
			Assert.assertEquals("the.matheus@gmail.com", tempProf.getEmail());
		}catch(Exception err) {
			fail("Error ao editar professor " + err.toString());
		}
	}

	@Test
	public void testEditcop() {
		Prof tempProf = new Prof();
		try {
			professor.setCop(3);
			daoprof.editcop(professor);
			tempProf = daoprof.pesq(professor.getId());
			Assert.assertEquals(3, tempProf.getCop());
		}catch(Exception err) {
			fail("Error ao editar as copias do professor " + err.toString());
		}
	}
}
