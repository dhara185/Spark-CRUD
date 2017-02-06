package restservice;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

	DBMS oDbms = new DBMS();

	public List<User> getAllUser() {
		List<User> oUserList = new ArrayList<User>();
		String query = "SELECT * FROM users";
		ResultSet oUserResultSet = oDbms.executeQuery(query);
		if (oUserResultSet != null) {
			try {
				while (oUserResultSet.next()) {
					User oUser = new User();
					oUser.setId(oUserResultSet.getInt("id"));
					oUser.setStrFirstName(oUserResultSet.getString("fname"));
					oUser.setStrLastName(oUserResultSet.getString("lname"));
					oUser.setnAge(oUserResultSet.getInt("age"));
					oUserList.add(oUser);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return oUserList;
	}

	public User getUserByID(int id) {
		User oUser = new User();
		String query = "SELECT * FROM users WHERE id=" + id;
		ResultSet oUserResultSet = oDbms.executeQuery(query);
		if (oUserResultSet != null) {
			try {
				while (oUserResultSet.next()) {
					oUser.setId(oUserResultSet.getInt("id"));
					oUser.setStrFirstName(oUserResultSet.getString("fname"));
					oUser.setStrLastName(oUserResultSet.getString("lname"));
					oUser.setnAge(oUserResultSet.getInt("age"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return oUser;
	}

	public boolean addUser(User oUser) {
		boolean result = false;
		String query = "INSERT INTO users(fname,lname,age) VALUES('"+ oUser.getStrFirstName() + "','"
				+ oUser.getStrLastName() + "'," + oUser.getnAge() + ")";
		result = oDbms.executeUpdate(query);
		return result;
	}

	public User updateUser(int id, User oUser) {
		boolean result = false;
		User oUserOld=getUserByID(id);
		if(oUserOld.getStrFirstName()!=oUser.getStrFirstName() && oUser.getStrFirstName()!=null){
			oUserOld.setStrFirstName(oUser.getStrFirstName());
		}
		if(oUserOld.getStrLastName()!=oUser.getStrLastName() && oUser.getStrLastName()!=null){
			oUserOld.setStrLastName(oUser.getStrLastName());
		}
		if(oUserOld.getnAge()!=oUser.getnAge() && oUser.getnAge()!=0){
			oUserOld.setnAge(oUser.getnAge());
		}
		oUser=oUserOld;
		String query = "UPDATE users SET fname='" + oUser.getStrFirstName() + "',lname='"
				+ oUser.getStrLastName() + "',age=" + oUser.getnAge() + " WHERE id="+id;
		result = oDbms.executeUpdate(query);
		if(!result){
			oUser=null;
		}
		return oUser;
	}

	public boolean deleteUser(int id) {
		boolean result = false;
		String query = "DELETE FROM users WHERE id=" + id;
		result = oDbms.executeUpdate(query);
		return result;
	}

}
