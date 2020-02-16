
import java.util.ArrayList;

public class Task {
	private final int id;
	private String name;
	private String description;
	private ArrayList<User> participants = new ArrayList<User>();
	private boolean status;
	
	public Task(int id, String name, String description, boolean status) {
		this.id = id;
		this.name = name;
		this.description = description;
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
	
	public ArrayList<User> getParticipants(){
		return this.participants;
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
	
	public void setStatus(boolean status) {
		this.status = status;
	}
}
