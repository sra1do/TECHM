package Repositaries;
import java.util.List;
import Entities.Student;
public interface StudentDAO {
	public boolean createConnection()throws Exception ;
	public int insertStudent(Student s);
	public int updateStudent(int sid,Student s);
	public int deleteStudent(int sid);
	public List<Student> fetchAllStudent();
	public Student fetchAStudent(int sid);
}