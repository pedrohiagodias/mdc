package tests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import control.DAOCopia;
import junit.framework.Assert;
import model.Copia;

public class DAOCopiaTest {
	private static DAOCopia daocopia;
	private static Copia copia;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		daocopia = new DAOCopia();
		copia = new Copia();
		
		daocopia.con();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		daocopia.desc();
	}

	@Test
	public void testCad() {
		try {
			copia.setAlu(0);
			copia.setDt("01/08/2018");
			copia.setId(12);
			copia.setPerdidas(1);
			copia.setProf(0);			
			daocopia.cad(copia);
		}catch(Exception err) {
			fail("Falha ao cadastrar copias " + err.toString());
		}	
	}

	@Test
	public void testEdit() {
		Copia tempCopia = new Copia();
		try {
			copia.setAlu(2);
			daocopia.edit(copia, copia.getId());
			tempCopia = daocopia.pesq(copia.getId());
			Assert.assertEquals(2, tempCopia.getAlu());
		}catch(Exception err) {
			fail("Falha ao editar copias " + err.toString());
		}
	}

	@Test
	public void testPesq() {
		Copia tempCopia = new Copia();
		try {
			tempCopia = daocopia.pesq(copia.getId());
			Assert.assertEquals(copia.getId(), tempCopia.getId());
		}catch(Exception err) {
			fail("Error ao pesquisar " + err.toString());
		}
	}
}
