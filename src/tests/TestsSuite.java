package tests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import control.DAORelatorio;


@RunWith(Suite.class)
@Suite.SuiteClasses({
	DAOTest.class,
	DAOUsuarioTest.class,
	DAOAlunoTest.class,
	DAOCopiaTest.class,
	DAOProfTest.class,
	DAORelatorioTest.class,
	DataSomaTest.class
})
public class TestsSuite {

}
