//create a functional interface 3d shape for finding volume of sphere,cylinder,sube
package Data;
@FunctionalInterface
interface threeDshape{
	void volume(double x,double y);
}
public class Test5 {

	public static void main(String[] args) {
		threeDshape s=(x,y)->{
			System.out.println("Volume of anonymous sphere is "+(4.0/3*3.14*x*x*x));
		};
		s.volume(3.4, 4.5);
		s=(x,y)->{
			System.out.println("Volume of anonymous Cylinder is "+(3.14*x*x*y));
		};
		s.volume(3.2, 2.6);
		s=(x,y)->{
			System.out.println("Volume of anonymous Cube is "+(x*x*x));
		};
		s.volume(1.4, 4.2);
	}

}
