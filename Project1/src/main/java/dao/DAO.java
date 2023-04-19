package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import model.JobTypes;
import model.User;
import java.util.ArrayList;

public class DAO {

	private DataSource ds;

	// DEFINICIJA KONEKCIONIH STRINGOVA

	// MySQL zahtevi
	private static String SELECT_USER = "SELECT * FROM registered_users WHERE userName = ? AND password = ?";
	private static String INSERT_USER = "INSERT INTO registered_users (id, name, userName, email, password, position) "
	        							+"VALUES (NULL, ?, ?, ?, ?, ?)";

	// DEFINICIJA KONSTRUKTORA ZA PODESAVNJE KONEKCIJE � UVEK ISTO
	public DAO(){

		try {
			InitialContext cxt = new InitialContext();
			if ( cxt == null ) { 
			} 
			ds = (DataSource) cxt.lookup( "java:/comp/env/jdbc/mysql" ); 
			if ( ds == null ) { 
			} 		
		} catch (NamingException e) {
		}
	}

	// METODE za bazu podataka ' user_database '

	//////////////////////////////////////////////////////////////////////////////////////
	public void registerNewUser(String name, String userName,String email, String password,  JobTypes position){

		Connection con = null;
		PreparedStatement pstm = null;

		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU 

		try {

			con = ds.getConnection();
			pstm = con.prepareStatement(INSERT_USER);

			pstm.setString(1, name);
			pstm.setString(2, userName);
			pstm.setString(3, email);
			pstm.setString(4, password);
	        pstm.setString(5, position.toString());

			pstm.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	/////////////////////////////////////////////////////////////////////////////
	
	public boolean alreadyRegistered(String userName, String password){
		
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		// POMOCNE PROMENLJIVE ZA KONKRETNU METODU
		ArrayList<User> registeredUsers = new ArrayList<>();
		
            try {
			con = ds.getConnection();
			pstm = con.prepareStatement(SELECT_USER);

			// DOPUNJAVANJE SQL STRINGA, SVAKI ? SE MORA PODESITI 
			pstm.setString(1, userName);
			pstm.setString(2, password);
			pstm.execute();

			rs = pstm.getResultSet();
			
			if (rs.next()) {
				User user = new User();
				
				user.setUserName(rs.getString("userName"));
				user.setPassword(rs.getString("password"));
				
				registeredUsers.add(user);
			}
			
			for (User user : registeredUsers) {
				if (user.getUserName() == userName && user.getPassword() == password) {
					return true;
				}
			}
				
			
//****KRAJ OBRADE ResultSet-a	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// VRACANJE REZULTATA AKO METODA VRACA REZULTAT
		return false; 
	}

	
	
	

}
