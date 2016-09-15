package com.paulo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.List;

import org.dbunit.Assertion;
import org.dbunit.DatabaseUnitException;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.Test;

import com.paulo.model.Usuario;

public class UsuarioDAOTest {

	private UsuarioDAO dao = new UsuarioDAOImpl();
	private IDatabaseTester databaseTester;

	@Before
	public void setUp() throws Exception {
		databaseTester = new JdbcDatabaseTester("org.postgresql.Driver", UsuarioDAO.JDBC_POSTGRESQL, UsuarioDAO.USUARIO,
				UsuarioDAO.SENHA);
		databaseTester.setDataSet(getDataSet("/usuario.xml"));
		databaseTester.onSetup();
	}

	@Test
	public void deveInserirUsuario() throws Exception {
		Usuario usuario = new Usuario("zezinho", "jose@coursera.org", "José", "joseph", 30);

		dao.inserir(usuario);

		assertTable("/verifica-insert.xml");
	}

	@Test
	public void deveRecuperarUsuarioPorLogin() {
		String login = "mariazinha";

		Usuario usuario = dao.recuperar(login);

		assertNotNull(usuario);
		assertEquals(login, usuario.getLogin());
	}

	@Test
	public void deveAdicionarPontosParaUsuario() throws Exception {
		String login = "mariazinha";

		dao.adicionarPontos(login, 20);

		assertTable("/verifica-update.xml");
	}
	
	@Test
	public void deveListarUsuariosOrdenadosPorPontos() throws Exception {
		List<Usuario> usuarios = dao.ranking();
		
		assertNotNull(usuarios);
		assertEquals(2, usuarios.size());
		assertEquals("mariazinha", usuarios.get(0).getLogin());
	}

	private IDataSet getDataSet(String file) throws DataSetException {
		return new FlatXmlDataSetBuilder().build(getClass().getResourceAsStream(file));
	}

	private void assertTable(String file) throws SQLException, Exception, DataSetException, DatabaseUnitException {
		IDataSet currentDataSet = databaseTester.getConnection().createDataSet();
		ITable currentTable = currentDataSet.getTable("usuario");

		IDataSet expectedDataSet = getDataSet(file);
		ITable expectedTable = expectedDataSet.getTable("usuario");

		Assertion.assertEquals(expectedTable, currentTable);
	}
}
