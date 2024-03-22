package Data;
import java.util.*;
class Course {
private String courseId;
private String courseName;
private double credit;
public String getCourseId() {
	return courseId;
}
public void setCourseId(String courseId) {
	this.courseId = courseId;
}
public String getCourseName() {
	return courseName;
}
public void setCourseName(String courseName) {
	this.courseName = courseName;
}
public double getCredit() {
	return credit;
}
public void setCredit(double credit) {
	this.credit = credit;
}
public Course(String courseId, String courseName, double credit) {
	super();
	this.courseId = courseId;
	this.courseName = courseName;
	this.credit = credit;
}
public Course() {
	super();
}
@Override
public String toString() {
	return "Course [courseId=" + courseId + ", courseName=" + courseName + ", credit=" + credit + "]";
}

}
class Studentt implements Comparable<Studentt>{
private int id;
private String name;
private double score;
private String grade;
private Course course;
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
public double getScore() {
	return score;
}
public void setScore(double score) {
	this.score = score;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
public Course getCourse() {
	return course;
}
public void setCourse(Course course) {
	this.course = course;
}
public Studentt(int id, String name, double score, String grade, Course course) {
	super();
	this.id = id;
	this.name = name;
	this.score = score;
	this.grade = grade;
	this.course = course;
}
public Studentt() {
	super();
}
@Override
public String toString() {
	return "Studentt [id=" + id + ", name=" + name + ", score=" + score + ", grade=" + grade + ", course=" + course
			+ "]";
}
public int compareTo(Studentt second) {
	return Integer.compare(this.id,second.id);
}


}
public class Test8 {
	public static void main(String[] args) {
Course c1=new Course("CSE3146","javafullstack",4);
Vector<Studentt> v=new Vector<Studentt>();
List<Studentt> list=new ArrayList<Studentt>();
Studentt s1=new Studentt(1,"sunny",0.0,null,c1);
Studentt s2=new Studentt(2,"money",0.0,null,c1);
Studentt s3=new Studentt(3,"honey",0.0,null,c1);
Studentt s4=new Studentt(4,"johney",0.0,null,c1);
Studentt s5=new Studentt(5,"Tonny",0.0,null,c1);
Studentt s6=new Studentt(6,"Ronny",0.0,null,c1);
Studentt s7=new Studentt(7,"Funny",0.0,null,c1);
Studentt s8=new Studentt(8,"bunny",0.0,null,c1);
list.add(s1);
list.add(s2);
list.add(s3);
list.add(s4);
list.add(s5);
list.add(s6);
list.add(s7);
list.add(s8);
v.add(s1);
v.add(s2);
v.add(s3);
v.add(s4);
double im,em;
//list are iterable 
ListIterator<Studentt> itr=list.listIterator();
double att_percent;
String performance;
Scanner sc=new Scanner(System.in);

for (Studentt i:list) {
	System.out.println("enter attendance, class performance");
			att_percent=sc.nextDouble();
			performance=sc.next();
			if(att_percent==100 && performance.equals("good"))
			{
			im=50;
			em=50;
			i.setScore(im+em);
			i.setGrade("O");
			}else {
			if(att_percent==100 && performance.equals("bad"))
			{
			im=40;
			em=50;
			i.setScore(im+em);
			i.setGrade("A+");
			}else {
			if(att_percent==80 && performance.equals("bad"))
			{
			im=30;
			em=50;
			i.setScore(im+em);;
			i.setGrade("A");
			}else {
			im=10;
			em=50;
			i.setScore(im+em);
			i.setGrade("F");
			}
			}
            }
}
System.out.println(list);
//find any students grade 
Studentt ob=new Studentt(1,"sunny",0.0,null,c1);
Collections.sort(list);
int index=Collections.binarySearch(list, ob);
System.out.println("grade of student ob is "+list.get(index).getGrade());
	}
	}