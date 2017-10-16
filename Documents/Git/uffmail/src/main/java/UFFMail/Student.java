package UFFMail;

public class Student {
	
	private long id;
	private String name;
	private String tel;
	private String email;
	private String uffMail;
	private boolean status;
	
	
	
	public Student(long id, String name, String tel, String email, String uffMail, boolean status) {
		this.id = id;
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.uffMail = uffMail;
		this.status = status;
	}

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUffMail() {
		return uffMail;
	}
	public void setUffMail(String uffMail) {
		this.uffMail = uffMail;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	
}
