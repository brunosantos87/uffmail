package UFFMail;

import java.util.ArrayList;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PersonForm {

    @NotNull
    @Size(min=2, max=30)
    private String name;

   
    @Min(18)
    private Integer age;
    
    @NotNull
    private Long id;
    
    private ArrayList<String> emails;

    public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
		StudentAppService studentAppService = new StudentAppService();
		setName(studentAppService.getStudent(id).getName().split(" ")[0]);
		setEmails(studentAppService.emails(id));
	}

	public ArrayList<String> getEmails() {
		return emails;
	}

	public void setEmails(ArrayList<String> emails) {
		this.emails = emails;
	}

	public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String toString() {
        return "Person(Name: " + this.name + ", Age: " + this.age + ")";
    }
}