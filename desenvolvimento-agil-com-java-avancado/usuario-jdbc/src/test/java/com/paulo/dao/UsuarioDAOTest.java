package com.paulo.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.paulo.model.Usuario;

public class UsuarioDAOTest {

	private UsuarioDAO dao = new UsuarioDAOImpl();
	private IDatabaseTester databaseTester;

	@Before
	public void setUp() throws Exception {
		databaseTester = new JdbcDatabaseTester("org.postgresql.Driver", UsuarioDAO.JDBC_POSTGRESQL,
				UsuarioDAO.USUARIO, UsuarioDAO.SENHA);
		IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(getClass().getResourceAsStream("/usuario.xml"));
		databaseTester.setDataSet(expectedDataSet);
		databaseTester.onSetup();
	}

	@After
	public void tearDown() {
	}

	@Test
	public void deveInserirUsuario() {
		Usuario usuario = new Usuario("zezinho", "jose@coursera.org", "José", "joseph", 10);

		dao.inserir(usuario);

		// assert
	}

	@Test
	public void deveRecuperarUsuarioPorLogin() {
		String login = "maria";

		Usuario usuario = dao.recuperar(login);

		assertNotNull(usuario);
		assertEquals(login, usuario.getLogin());
	}

}
