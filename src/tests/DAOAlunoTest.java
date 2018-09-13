package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import control.DAOAluno;
import junit.framework.Assert;
import model.Aluno;

public class DAOAlunoTest {
	private static DAOAluno daoaluno;
	private static Aluno aluno;
	
	

	@BeforeClass
	public static void setUp() throws Exception {
		daoaluno = new DAOAluno();
		aluno = new Aluno();
		
		daoaluno.con();
	}

	@AfterClass
	public static void tearDown() throws Exception {
		daoaluno.del(aluno);
		daoaluno.desc();
	}

	@Test
	public void testCad() {
		try {
			aluno.setCop(0);
			aluno.setCurso("Sistemas de Informação");
			aluno.setDt("teste");
			aluno.setEmail("devlacerda@gmail.com");
			aluno.setId("20152085010080");
			aluno.setSemestre(6);
			aluno.setTel("(88) 9999999");
			
			daoaluno.cad(aluno);			
		}catch(Exception err) {
			fail(err.toString());
		}
	}

	@Test
	public void testPesq() {
		Aluno tempAluno = new Aluno();
		
		try {
			tempAluno = daoaluno.pesq(aluno.getId());
			Assert.assertEquals(aluno.getId(), tempAluno.getId());
		}catch(Exception err) {
			fail(err.toString());
		}
	}

	@Test
	public void testEdit() {
		Aluno tempAluno = new Aluno();
		try {
			tempAluno = daoaluno.pesq(aluno.getId());
			Assert.assertEquals(aluno.getId(), tempAluno.getId());
		}catch(Exception err) {
			fail(err.toString());
		}
	}

	@Test
	public void testEditcop() {
		aluno.setEmail("the.matheus6@gmail.com");
		try {
			daoaluno.edit(aluno);
		}catch(Exception err) {
			fail(err.toString());
		}
	} 
}
