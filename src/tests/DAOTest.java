package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import control.DAO;
import junit.framework.Assert;

public class DAOTest {
	DAO dao = null;
	
	
	@Before
	public void setUp() throws Exception {
		dao = new DAO();
		try {
			dao.con();
		}catch(Exception err) {
			fail("Falha na conexão com o banco de dados" + err.getMessage());
		}
	}

	@Test
	public void testDesc() {
		try {
			dao.desc();
		}catch(Exception err) {
			fail("Falha ao desconectar o banco de dados " + err.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testIsCon() {
		Assert.assertTrue(dao.isCon());
	}

}
