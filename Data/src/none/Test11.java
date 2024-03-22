//Implemet the following scenario using Collection
//Students of section 8cse1 are assigned with 5 subjects
//Each  subject is alloted to more than one faculty
//Each faculty ia also assigned to other courses
//for other sections.
//Each subject have 3 different assessement for evaluation
//Find each student total marks in every subject
//Find assigned faculty for every student
//find the details of faulty and their course.
package none;
import java.util.*;
class Student{
	private int id;
	private String name;
	private String address;
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
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
}
class course{
	private String cid;
	private String cname;
	private String ctype;
	private String domain;
	@Override
	public int hashCode() {
		return Objects.hash(cid, cname, ctype, domain);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		course other = (course) obj;
		return Objects.equals(cid, other.cid) && Objects.equals(cname, other.cname)
				&& Objects.equals(ctype, other.ctype) && Objects.equals(domain, other.domain);
	}
	public course() {
		super();
		// TODO Auto-generated constructor stub
	}
	public course(String cid, String cname, String ctype, String domain) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.ctype = ctype;
		this.domain = domain;
	}
	@Override
	public String toString() {
		return "course [cid=" + cid + ", cname=" + cname + ", ctype=" + ctype + ", domain=" + domain + "]";
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
}
class Facualty{
	private int empid;
	private String nfame;
	private String qualification;
	private String designation;
	public Facualty() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Facualty(int empid, String nfame, String qualification, String designation, List<course> courses) {
		super();
		this.empid = empid;
		this.nfame = nfame;
		this.qualification = qualification;
		this.designation = designation;
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Facualty [empid=" + empid + ", nfame=" + nfame + ", qualification=" + qualification + ", designation="
				+ designation + ", courses=" + courses + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(courses, designation, empid, nfame, qualification);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Facualty other = (Facualty) obj;
		return Objects.equals(courses, other.courses) && Objects.equals(designation, other.designation)
				&& empid == other.empid && Objects.equals(nfame, other.nfame)
				&& Objects.equals(qualification, other.qualification);
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getNfame() {
		return nfame;
	}
	public void setNfame(String nfame) {
		this.nfame = nfame;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public List<course> getCourses() {
		return courses;
	}
	public void setCourses(List<course> courses) {
		this.courses = courses;
	}
	private List<course> courses;
}
class Subject{
	private String SubCode;
	private String SubName;
	private int credit;
	private int marks[];
	public Subject() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Subject(String subCode, String subName, int credit, int[] marks, List<Facualty> list) {
		super();
		this.SubCode = subCode;
		this.SubName = subName;
		this.credit = credit;
		this.marks = marks;
		this.faculties = list;
	}
	@Override
	public String toString() {
		return "Subject [SubCode=" + SubCode + ", SubName=" + SubName + ", credit=" + credit + ", marks="
				+ Arrays.toString(marks) + ", faculties=" + faculties + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(marks);
		result = prime * result + Objects.hash(SubCode, SubName, credit, faculties);
		return result;
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
		return Objects.equals(SubCode, other.SubCode) && Objects.equals(SubName, other.SubName)
				&& credit == other.credit && Objects.equals(faculties, other.faculties)
				&& Arrays.equals(marks, other.marks);
	}
	public String getSubCode() {
		return SubCode;
	}
	public void setSubCode(String subCode) {
		SubCode = subCode;
	}
	public String getSubName() {
		return SubName;
	}
	public void setSubName(String subName) {
		SubName = subName;
	}
	public int getCredit() {
		return credit;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public int[] getMarks() {
		return marks;
	}
	public void setMarks(int[] marks) {
		this.marks = marks;
	}
	public List<Facualty> getFaculties() {
		return faculties;
	}
	public void setFaculties(List<Facualty> faculties) {
		this.faculties = faculties;
	}
	private List<Facualty> faculties;
}
public class Test11 {

    public static void main(String[] args) {
        // Creating sample data
        Student student1 = new Student(1, "John Doe", "123 Main St");
        Student student2 = new Student(2, "Jane Smith", "456 Elm St");

        course course1 = new course("CSE101", "Computer Science", "Core", "Computer Science");
        course course2 = new course("MAT101", "Mathematics", "Core", "Mathematics");

        Facualty faculty1 = new Facualty(101, "Dr. Smith", "Ph.D.", "Professor", Arrays.asList(course1, course2));
        Facualty faculty2 = new Facualty(102, "Dr. Johnson", "Ph.D.", "Associate Professor", Arrays.asList(course1));

        Subject subject1 = new Subject("CSE101", "Introduction to Java", 3, new int[]{80, 85, 90}, Arrays.asList(faculty1, faculty2));
        Subject subject2 = new Subject("MAT101", "Calculus", 3, new int[]{75, 80, 85}, Arrays.asList(faculty2));

        Map<Student, List<Subject>> table = new HashMap<>();
        table.put(student1, Arrays.asList(subject1, subject2));
        table.put(student2, Arrays.asList(subject2)); // Assuming both students take the same subjects

        // Find each student total marks in every subject
        for (Map.Entry<Student, List<Subject>> entry : table.entrySet()) {
            Student student = entry.getKey();
            List<Subject> subjects = entry.getValue();
            System.out.println("Student: " + student.getName());
            for (Subject subject : subjects) {
                int totalMarks = Arrays.stream(subject.getMarks()).sum();
                System.out.println("Subject: " + subject.getSubName() + ", Total Marks: " + totalMarks);
            }
        }

        // Find assigned faculty for every student
        System.out.println("\nAssigned Faculty for Each Student:");
        for (Map.Entry<Student, List<Subject>> entry : table.entrySet()) {
            Student student = entry.getKey();
            List<Subject> subjects = entry.getValue();
            System.out.println("Student: " + student.getName());
            for (Subject subject : subjects) {
                List<Facualty> faculties = subject.getFaculties();
                System.out.println("Subject: " + subject.getSubName() + ", Faculties: " + faculties);
            }
        }

        // Find the details of faculty and their courses
        System.out.println("\nDetails of Faculty and Their Courses:");
        List<Facualty> allFaculties = Arrays.asList(faculty1, faculty2); // Assuming there are more faculties
        for (Facualty faculty : allFaculties) {
            System.out.println("Faculty: " + faculty.getNfame() + ", Courses: " + faculty.getCourses());
        }
    }
}