package edu.mum.cs.cs425.MyStudentMgmtApp;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import edu.mum.cs.cs425.MyStudentMgmtApp.model.ClassRoom;
import edu.mum.cs.cs425.MyStudentMgmtApp.model.Student;
import edu.mum.cs.cs425.MyStudentMgmtApp.model.Transcript;
import edu.mum.cs.cs425.MyStudentMgmtApp.repository.ClassRoomRepository;
import edu.mum.cs.cs425.MyStudentMgmtApp.repository.StudentRepository;

@SpringBootApplication
public class MyStudentMgmtApp implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private ClassRoomRepository classRoomRepository;


	public static void main(String[] args) {
		SpringApplication.run(MyStudentMgmtApp.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		ClassRoom classRoom = new ClassRoom("McLaughin Building", "M105");
		ClassRoom classRoom2 = new ClassRoom("McLaughin Building", "M103");

		Transcript trans1 = new Transcript("Bs Computer Science");
		Transcript trans2 = new Transcript("Bs Buisness");
		Transcript trans3 = new Transcript("Bs Software Development");
		
		
		Student student1 = new Student("000-61-0001", "Anna", "Lynn", "Smith", 3.4, LocalDate.of(2019, 05, 24), trans1,
				classRoom);
		
		Student student2 = new Student("000-61-0002", "Eyob", "H", LocalDate.of(2019, 05, 24), trans2, classRoom);
		
		Student student3 = new Student("000-61-0003", "Biniam", "Tsehaye", "Arefaine", 3.0, LocalDate.of(2020, 05, 24), trans3,
				classRoom);
		
		Student student4 = new Student("000-61-0004", "Dave", "A", "Smith", 3.4, LocalDate.of(2019, 05, 24), trans1,
				classRoom2);

		List<Student> list = Arrays.asList(student1, student2, student3, student4);
		classRoom.setStudents(list);

		//saving students to the database
		saveStudent(student1);
		saveStudent(student2);
		saveStudent(student3);
		saveStudent(student4);
		
		//saving classrooms to the database
		saveClassRoom(classRoom);
		saveClassRoom(classRoom2);

		
	}

	private Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	private ClassRoom saveClassRoom(ClassRoom classRoom) {
		return classRoomRepository.save(classRoom);
		
	}

}
