package tests;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import control.DataSoma;
import junit.framework.Assert;

public class DataSomaTest {
	private static DataSoma datasoma;
	final String DATE_FORMAT = "dd/MM/yyyy";
	final String RAW_FINAL_DATE = "03-08-2018";
	final String PARSED_FINAL_DATE = "08/03/2018";
	final String REPLACED_FINAL_DATE = "03/08/2018";
	
	
	
	
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		datasoma = new DataSoma();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testDataSoma() {
		SimpleDateFormat formatador = new SimpleDateFormat(DATE_FORMAT);
		Date date = new Date();
		String tempData = formatador.format(date);
		
		Assert.assertEquals(tempData, datasoma.hj);
	}

	@Test
	public void testConverteDataBrasil() {
		SimpleDateFormat formatador = new SimpleDateFormat(DATE_FORMAT);
		Date date = new Date();
		String convertedDate;
		String tempDate = formatador.format(date);
		convertedDate = datasoma.converteDataBrasil(RAW_FINAL_DATE);
		
		Assert.assertEquals(REPLACED_FINAL_DATE, convertedDate);
	}

	@Test
	public void testVerificaMascaraData() {
		String rawDate = RAW_FINAL_DATE;
		String parsedDate = datasoma.verificaMascaraData(rawDate);
		
		Assert.assertEquals(REPLACED_FINAL_DATE, parsedDate);
	}

	@Test
	public void testSomaData() {
		String rawDate = RAW_FINAL_DATE;
		int days = 8;
		String expectedDate = "16/03/2018";
		String finalDate = datasoma.somaData(rawDate, days);
		
		Assert.assertEquals(expectedDate, finalDate);
	}
}
