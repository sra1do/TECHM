package Data;
interface shape{
	void area();
}
class circle implements shape{
	public void area() {
		int r=5;
		double a=3.14*r*r;
		System.out.println("Area of circle is "+a);
	}
}
class square implements shape{
	public void area() {
		int s=5;
		double a=s*s;
		System.out.println("Area of Square is "+a);
	}
}
public class Test4 {
//with class
	public static void main(String[] args) {
		/*shape s=new circle();
		s.area();
		s=new square();
		s.area();*/
//without class
		shape s =()->{
			int r=5;
			double a=3.14*r*r;
			System.out.println("Area of circle is "+a);
		};
		s.area();
		s=()->{
			int sd=5;
			double a=sd*sd;
			System.out.println("Area of Square is "+a);	
		};
		s.area();
	}

}
