package tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import control.DAORelatorio;
import junit.framework.Assert;
import model.Relatorio;

public class DAORelatorioTest {
	private static DAORelatorio daorelatorio;
	private static Relatorio relatorio;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		daorelatorio = new DAORelatorio();
		relatorio = new Relatorio();
		daorelatorio.con();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		daorelatorio.desc();	
	}

	@Test
	public void testCad() {
		try {
			relatorio.setDt("04/08/2018");
			relatorio.setId(1234);
	
			daorelatorio.cad(relatorio);
		}catch(Exception err) {
			fail("Falha ao cadastrar relatorio " + err.toString());
		}
	}
	
	
	@Test
	public void testPesq() {
		Relatorio tempRelatorio = new Relatorio();
		
		try {
			tempRelatorio = daorelatorio.pesq();
			Assert.assertEquals(relatorio.getId(), tempRelatorio.getId());
		}catch(Exception err) {
			fail("Falha ao pesquisar relatorio " + err.toString());
		}
		
		
	}


	@Test
	public void testEdit() {
		Relatorio tempRelatorio = new Relatorio();
		
		try {
			relatorio.setDt("05/04/2018");
			daorelatorio.edit(relatorio, relatorio.getId());			
			tempRelatorio = daorelatorio.pesq();
			
			Assert.assertEquals(relatorio.getDt(), tempRelatorio.getDt());
		}catch(Exception err) {
			fail("Falha ao editar relatorio " + err.toString());
		}
	}

}
