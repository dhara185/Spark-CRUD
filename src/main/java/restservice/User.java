package restservice;

public class User {

	private int id;
	private String strFirstName;
	private String strLastName;
	private int nAge;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStrFirstName() {
		return strFirstName;
	}

	public void setStrFirstName(String strFirstName) {
		this.strFirstName = strFirstName;
	}

	public String getStrLastName() {
		return strLastName;
	}

	public void setStrLastName(String strLastName) {
		this.strLastName = strLastName;
	}

	public int getnAge() {
		return nAge;
	}

	public void setnAge(int nAge) {
		this.nAge = nAge;
	}

}
