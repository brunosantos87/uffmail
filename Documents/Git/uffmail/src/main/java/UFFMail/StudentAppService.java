package UFFMail;

import java.util.ArrayList;

public class StudentAppService {
	
	private static StudentDAO studentDAO = new StudentDAOImpl();
	
	public Student getStudent(long id) {
		try {
			return studentDAO.getStudent(id);
			
		}
		catch(StudentNotFoundException e) {
			 System.err.println(e.getMessage());
		}
		return null;
	}
	
	public ArrayList<String> emails(long number){
		ArrayList<String> emails = new ArrayList<String>();
		ArrayList<String> results = new ArrayList<String>();
		
		String  candidateEmail;
		Student student = getStudent(number);
		
		String domain = "@id.uff.br";
		
		String[] name = student.getName().split(" ");
		emails = studentDAO.getUffMails();
		
		candidateEmail = name[0].toLowerCase() + "_" + name[1].toLowerCase() + domain;
		if(!emails.contains(candidateEmail))
			results.add(candidateEmail);
		
		candidateEmail = name[0].toLowerCase() + name[2].toLowerCase() + domain;
		if(!emails.contains(candidateEmail))
			results.add(candidateEmail);
		
		candidateEmail = name[0].toLowerCase() + name[1].toLowerCase().substring(0, 1) + name[2].toLowerCase().substring(0, 1) + domain;
		if(!emails.contains(candidateEmail))
			results.add(candidateEmail);
		
		candidateEmail = name[0].toLowerCase() + name[1].toLowerCase() + domain;
		if(!emails.contains(candidateEmail))
			results.add(candidateEmail);
		
		candidateEmail = name[0].toLowerCase().substring(0, 1) + name[1].toLowerCase() + name[2].toLowerCase() + domain;
		if(!emails.contains(candidateEmail))
			results.add(candidateEmail);
		
		for(int i = 0; i < results.size();i++) {
			System.out.println(results.get(i));
		}
		return results;
		
		
	}
}
