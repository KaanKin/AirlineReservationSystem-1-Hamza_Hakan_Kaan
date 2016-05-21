package ars;

import static org.junit.Assert.*;

import org.junit.Test;

public class SQLiteConnTest {

	@Test
	public void testDbConnector() {
		SQLiteConn Test = new SQLiteConn();
		Test.dbConnector();
	}

}
