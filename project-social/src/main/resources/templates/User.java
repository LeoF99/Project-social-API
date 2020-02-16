
public class User {
	private final int id;
	private String name;
	private String email;
	private String username;
	private String phoneNumber;
	
	public User(int id, String name, String email,String username, String phoneNumber) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.username = username;
		this.phoneNumber = phoneNumber;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getUsername() {
		return this.username;
	}
	
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
