package UFFMail;

import java.util.ArrayList;

public interface StudentDAO {
	
	public long create(Student aStudent);
	
	public void update(Student aStudent);
	
	public void delete(long id);
	
	public Student getStudent(long id)throws StudentNotFoundException;
	
	public ArrayList<String> getUffMails();
	
}
