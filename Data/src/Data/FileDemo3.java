
//Demonstration of serializable Interface on file
//This adds capacity to an object to be transferrable over a network
//by default all object in server are model and are serializable
package Data;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;
import java.util.Scanner;
class Employee implements Serializable{
	private int Id;
	private String Name;
	private double salary;
	// press alt shift s
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public Employee(int id, String name, double salary) {
		super();
		Id = id;
		Name = name;
		this.salary = salary;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(Id, Name, salary);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Id == other.Id && Objects.equals(Name, other.Name)
				&& Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
	}
	
	
}
public class FileDemo3 {
	public static void main(String [] args) throws Exception{
		//serializable requires buffering, binary file
		//file location
		File file = new File("C:\\Users\\91949\\Desktop\\Eclipse_Workspace\\TechM\\Data\\empl.dat");
		// this is a binary stream attached to read a binary data
		FileOutputStream fout = new FileOutputStream(file);
		//this is encapsulates the binary data together in the form of object
		ObjectOutputStream oout = new ObjectOutputStream(fout);
		Employee [] ob = new Employee[10];
		Scanner sc =new Scanner(System.in);
		int id;
		String n;
		double s;
		for (int i=0;i<=10;i++) {
			ob[i]=new Employee();
			System.out.println("Enter "+i+"the employee data id name salary");
			id=sc.nextInt();
			ob[i].setId(id);
			n=sc.next();
			ob[i].setName(n);
			s=sc.nextDouble();
			ob[i].setSalary(s);
			oout.writeObject(ob[i]);
			System.out.println(i+"object is serialized");
		}
		
		
		FileInputStream fin = new FileInputStream(file);
		ObjectInputStream oin = new ObjectInputStream(fin);
		Employee ob2 =(Employee)oin.readObject();
		System.out.println("Employee id number "+ob2.getId());
		System.out.println("Employee name "+ob2.getName());
		System.out.println("Employee salary "+ob2.getSalary());
		System.out.println("Object is De-serialized");
		
	}

	

}
