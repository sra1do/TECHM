package JDBC;

/* for section 8CSE students are alloted with 6 subjects
implement database 8CSE to keep the above information
permanently*/
//MANY-MANY requires 3 tables : 2 for entities 1 for relationship


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
class Student {
	private int id;
	private String name;
	private String address;
	private Set<Subject> subjects;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Set<Subject> getSubjects() {
		return subjects;
	}
	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	public Student(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public Student() {
		super();
	}
	@Override
	public String toString() {
		return "Stud [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(address, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(address, other.address) && id == other.id && Objects.equals(name, other.name);
	}
	
}
class Subject {
	private String subjectCode;
	private String subjectName;
	private int credit;
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public Subject(String subjectCode, String subjectName, int credit) {
		super();
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.credit = credit;
	}
	public Subject() {
		super();
	}
	@Override
	public String toString() {
		return "Subject [subjectCode=" + subjectCode + ", subjectName=" + subjectName + ", credit=" + credit + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(credit, subjectCode, subjectName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		return credit == other.credit && Objects.equals(subjectCode, other.subjectCode)
				&& Objects.equals(subjectName, other.subjectName);
	}
	
}
interface StudentDAO {
	public boolean createConnection()throws Exception ;
	public int insertStudent(Student s);
	public int updateStudent(int sid,Student s);
	public int deleteStudent(int sid);
	public List<Student> fetchAllStudent();
	public Student fetchAStudent(int sid);
}
interface SubjectDAO {
	public boolean createConnection()throws Exception ;
	public int insertSubject(Subject s);
	public int updateSubject(String scode,Subject s);
	public int deleteSubject(String scode);
	public List<Subject> fetchAllSubject();
	public Subject fetchASubject(String scode);
}
class SubjectDAOImpl implements SubjectDAO {
	private static SubjectDAOImpl ob=null;
	private Connection contodb=null;
	private SubjectDAOImpl() {}
	public static SubjectDAOImpl returnInstance() {
		if(ob==null)
			ob=new SubjectDAOImpl();
		return ob;
	}
	public boolean createConnection()throws Exception {
		contodb=DriverManager.getConnection(
	       "jdbc:mysql://localhost:3306/8cse","root","sravan");
		Class.forName("com.mysql.cj.jdbc.Driver");
		if(contodb!=null)
			return true;
		else
			return false; 
	}
	public int insertSubject(Subject s) {
		int response=0;
		try {
		PreparedStatement ps=contodb.prepareStatement(
				"insert into subject values(?,?,?)");
		ps.setString(1, s.getSubjectCode());
		ps.setString(2, s.getSubjectName());
		ps.setInt(3, s.getCredit());
		response=ps.executeUpdate();
		}catch(Exception e) {}
		return response;
	}
	public int updateSubject(String sid,Subject s) {
		int response=0;
		try {
		PreparedStatement ps=contodb.prepareStatement(
				"update subject set subName=?,credit=? where subcode=? ");
		ps.setString(1, s.getSubjectName());
		ps.setInt(2, s.getCredit());
		ps.setString(3, sid);
		response=ps.executeUpdate();
		}catch(Exception e) {}
		return response;
	}
	public int deleteSubject(String scode) {
		int response=0;
		try {
		PreparedStatement ps=contodb.prepareStatement(
				"delete from subject where where subcode=? ");
		ps.setString(1, scode);
		response=ps.executeUpdate();
		}catch(Exception e) {}
			return response;
	}
	public List<Subject> fetchAllSubject(){
		List<Subject> subjectsFetched=new ArrayList<Subject>();
		try {
			PreparedStatement ps=contodb.prepareStatement(
					"select * from subject ");
			ResultSet rs=ps.executeQuery();
			Subject s=new Subject();
			while(rs.next()) {
			s.setSubjectCode(rs.getString(1));
			s.setSubjectName(rs.getString(2));
			s.setCredit(rs.getInt(3));
			subjectsFetched.add(s);
			}
			}catch(Exception e) {}
		return subjectsFetched;
	}
	public Subject fetchASubject(String scode) {
		Subject subjectFetched=new Subject();
		try {
			PreparedStatement ps=contodb.prepareStatement(
					"select * from subject where subcode=? ");
			ps.setString(1, scode);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				subjectFetched.setSubjectCode(rs.getString(1));
				subjectFetched.setSubjectName(rs.getString(2));
				subjectFetched.setCredit(rs.getInt(3));
			}
			}catch(Exception e) {}
		return subjectFetched;
	}
}
class StudentDAOImpl implements StudentDAO {
	private static StudentDAOImpl ob=null;
	private Connection contodb=null;
	private StudentDAOImpl() {}
	public static StudentDAOImpl returnInstance() {
		if(ob==null)
			ob=new StudentDAOImpl();
		return ob;
	}
	public boolean createConnection()throws Exception {
		contodb=DriverManager.getConnection("jdbc:mysql://localhost:3306/8cse","root","sravan");
		Class.forName("com.mysql.cj.jdbc.Driver");
		if(contodb!=null)
			return true;
		else
			return false; 
	}
	public int insertStudent(Student s) {
		int response=0,response2=0;
		try {
		PreparedStatement ps=contodb.prepareStatement(
				"insert into student values(?,?,?)");
		//before doing this insert subject in subject table
		PreparedStatement ps2=contodb.prepareStatement(
				"insert into enrollment values(?,?)");
		ps.setInt(1, s.getId());
		ps.setString(2, s.getName());
		ps.setString(3, s.getAddress());
		response=ps.executeUpdate();
		ps2.setInt(1, s.getId());
		Set<Subject> subjects=s.getSubjects();
		//System.out.println(subjects);
	    for(Subject sub:subjects) {
	    	ps2.setString(2, sub.getSubjectCode());
	    	response2=ps2.executeUpdate();
	    	if(response2!=1)break;
	    }
		}catch(Exception e) {}
		if(response==1 && response2==1)
		return 1;
		else return 0;
	}
	public int updateStudent(int sid,Student s) {
		int response=0;
		try {
		PreparedStatement ps=contodb.prepareStatement(
				"update student set name=?,address=? where id=? ");
		ps.setString(1, s.getName());
		ps.setString(2, s.getAddress());
		ps.setInt(3, sid);
		response=ps.executeUpdate();
		}catch(Exception e) {}
		return response;
	}
	public int deleteStudent(int sid) {
		int response=0,response2=0;
		try {
		PreparedStatement ps=contodb.prepareStatement(
				"delete from student where where id=? ");
		PreparedStatement ps2=contodb.prepareStatement(
				"delete from enrollment where where id=? ");
		ps.setInt(1, sid);
		ps2.setInt(1, sid);
		response=ps.executeUpdate();
		response2=ps2.executeUpdate();
		}catch(Exception e) {}
		if(response==1 && response2==1)
			return 1;
		else return 0;
	}
	public List<Student> fetchAllStudent(){
		List<Student> studentsFetched=new ArrayList<Student>();
		try {
			PreparedStatement ps=contodb.prepareStatement(
					"select * from student ");
			ResultSet rs=ps.executeQuery();
			Student s=new Student();
			while(rs.next()) {
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setAddress(rs.getString(3));
			studentsFetched.add(s);
			}
			}catch(Exception e) {}
		return studentsFetched;
	}
	public Student fetchAStudent(int sid) {
		Student studentFetched=new Student();
		try {
			PreparedStatement ps=contodb.prepareStatement(
					"select * from student where id=? ");
			ps.setInt(1, sid);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				studentFetched.setId(rs.getInt(1));
				studentFetched.setName(rs.getString(2));
				studentFetched.setAddress(rs.getString(3));
			}
			}catch(Exception e) {}
		return studentFetched;
	}
}

public class Test12 {
	public static void main(String[] args) throws Exception{
		StudentDAOImpl ds=	StudentDAOImpl.returnInstance();
		SubjectDAOImpl ds2=	SubjectDAOImpl.returnInstance();
		boolean res=ds.createConnection();
		boolean res2=ds2.createConnection();
		if(res==true && res2==true ) {
			//insert subject first
			Subject sub=new Subject();
			sub.setSubjectCode("CSE3001");
			sub.setSubjectName("java");
			sub.setCredit(3);
			ds2.insertSubject(sub);
			sub.setSubjectCode("CSE3002");
			sub.setSubjectName("Python");
			sub.setCredit(3);
			ds2.insertSubject(sub);
			sub.setSubjectCode("CSE3003");
			sub.setSubjectName("C#");
			sub.setCredit(3);
			ds2.insertSubject(sub);
			sub.setSubjectCode("CSE3004");
			sub.setSubjectName("java advanced");
			sub.setCredit(3);
			ds2.insertSubject(sub);
			sub.setSubjectCode("CSE3005");
			sub.setSubjectName("java fullstack");
			sub.setCredit(3);
			//then enroll subject to student
			Student s=new Student();
			s.setId(100);
			s.setName("sunny");
			s.setAddress("bangalore");
			Set<Subject> subjects=new HashSet<Subject>();
			subjects.add(new Subject("CSE3001","java",3));
			subjects.add(new Subject("CSE3002","Python",3));
			subjects.add(new Subject("CSE3003","C#",3));
			subjects.add(new Subject("CSE3004","java advanced",3));
			subjects.add(new Subject("CSE3005","java fullstack",3));
			s.setSubjects(subjects);
			int r=ds.insertStudent(s);
			if(r==1)
				System.out.println("student inserted");
			else
				System.out.println("error in insertion");
			
			List<Student> studentsFetched=ds.fetchAllStudent();
			List<Subject> subjectsFetched=ds2.fetchAllSubject();
			System.out.println(studentsFetched);
			System.out.println(subjectsFetched);
		}
	}

}