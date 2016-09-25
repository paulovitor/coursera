package dao;

import org.dbunit.Assertion;
import org.dbunit.IDatabaseTester;
import org.dbunit.JdbcDatabaseTester;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;

public class AbstractDAOTest {

    private IDatabaseTester databaseTester;

    protected void setUp(String... xmls) throws Exception {
        databaseTester = new JdbcDatabaseTester("org.postgresql.Driver", AbstractDAO.JDBC_POSTGRESQL, AbstractDAO.USUARIO,
                AbstractDAO.SENHA);
        for (int i = 0; i < xmls.length; i++) {
            DatabaseOperation.INSERT.execute(databaseTester.getConnection(), getDataSet(xmls[i]));
        }
    }

    protected void tearDown(String... xmls) throws Exception {
        for (int i = xmls.length - 1; i >= 0; i--) {
            DatabaseOperation.DELETE_ALL.execute(databaseTester.getConnection(), getDataSet(xmls[i]));
        }
    }

    protected void assertTable(String file, String tabela) throws Exception {
        IDataSet currentDataSet = databaseTester.getConnection().createDataSet();
        ITable currentTable = currentDataSet.getTable(tabela);

        IDataSet expectedDataSet = getDataSet(file);
        ITable expectedTable = expectedDataSet.getTable(tabela);

        Assertion.assertEquals(expectedTable, currentTable);
    }

    protected void assertTable(String file, String tabela, String[] ignoreCols) throws Exception {
        IDataSet currentDataSet = databaseTester.getConnection().createDataSet();
        ITable currentTable = currentDataSet.getTable(tabela);

        IDataSet expectedDataSet = getDataSet(file);
        ITable expectedTable = expectedDataSet.getTable(tabela);

        Assertion.assertEqualsIgnoreCols(expectedTable, currentTable, ignoreCols);
    }

    private IDataSet getDataSet(String file) throws DataSetException {
        return new FlatXmlDataSetBuilder().build(getClass().getResourceAsStream(file));
    }
}
