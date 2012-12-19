package lbw.minibookstore.model;

public class Account {
	private String nickName;
	private String password;
	private String gender;
	private String role;
	
	public Account(){
		this.setNickName("");
		this.setPassword("");
		this.setGender("");
		this.setRole("");
	}
	public String toString(){
		return this.nickName+this.password+this.gender+this.role;
	}
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}


}