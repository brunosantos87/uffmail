package UFFMail;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class StudentDAOImpl implements StudentDAO{

	private File f = new File("src/main/resources/datasets/alunos.csv");
	private Scanner line, s;
	@Override
	public long create(Student aStudent) {
		
		return 0;
	}

	@Override
	public void update(Student aStudent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student getStudent(long number) throws StudentNotFoundException {
		// TODO Auto-generated method stub
		Student aStudent = null;
		String student, name, email, uffmail, status;
		String tel;
		long id;
		boolean found = false;
		
		try {
			line = new Scanner(f);
			line.nextLine(); //consome a primeira linha do arquivo (nome, matricula, etc...)
			
			while(!found && line.hasNextLine()) {
				 student = line.nextLine();
				 s = new Scanner(student);
				 s.useDelimiter(",");
				 
				 name = s.next();
				 id = Long.parseLong(s.next());
				 if(id == number) {
					 tel = s.next();
					 email = s.next();
					 uffmail = s.next();
					 status = s.next();
					 
					 aStudent = new Student(id, name, tel, email, uffmail, status == "ativo");
					 found = true;
				 }
				 
				 s.close();
			
			}
			if(aStudent == null)
				throw new StudentNotFoundException("Estudante nao encontrado");
			
			
		}
		catch(FileNotFoundException e) {

			e.printStackTrace();
		}
		finally {
			line.close();
			s.close();
		}
		 
		return aStudent;
		
	}

	@Override
	public ArrayList<String> getUffMails() {
		ArrayList<String> uffmails = null;
		try {
			uffmails = new ArrayList<String>();
			line = new Scanner(f);
			while(line.hasNextLine()) {
				s = new Scanner(line.nextLine());
				s.useDelimiter(",");
				for(int i = 0; i < 4; i++)
					s.next();
				uffmails.add(s.next());
			}
			
			
				
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}
		return uffmails;
	}
	
	
}
