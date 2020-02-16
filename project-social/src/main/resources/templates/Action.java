
public class Action {
	private final int id;
	private String name;
	private String description;
	private String location;
	private boolean status;
	
	public Action(int id, String name, String description, String location, boolean status) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.location = location;
		this.status = status;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	public String getlocation() {
		return this.location;
	}
	
	public boolean getStatus() {
		return this.status;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public void serLocation(String location) {
		this.location = location;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
}
