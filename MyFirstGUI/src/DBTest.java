import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBTest {

	public static void main(String[] args) {
		try {
			new DBTest();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public DBTest() throws SQLException {

		Connection conn = DriverManager.getConnection("jdbc:ucanaccess://C:/Users/Jakob/dbtest.accdb;memory=false");

		Statement stmt = conn.createStatement();
		stmt.execute("INSERT INTO address ( vorname, nachname, ort, plz ) "
				+ "VALUES ('Jakob', 'Omega', 'Rubinstrasse', 14)"
		        + "VALUES ('Mario', 'Kart' 'Magentaroad', 8)");
	}

}
