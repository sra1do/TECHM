//LambdaExpression is a piece code witten for anonymous class
//that implements Functional interface
//An interface that contains only one abstarct method
//create a functional imterface shape
//keep one method
//find area of circle and square
package Data;
interface myinterface{
	public abstract void service1();
	public void service2();
	void service3();
}
//partial implementation is not allowed
class myclass1 implements myinterface{
	public void service1() {}
	public void service2() {}
	public void service3() {}
}
class myclass2 implements myinterface{
	public void service1() {}
	public void service2() {}
	public void service3() {}
}
public class TestLambdaExpressions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		myinterface mi = new myclass1();
		mi.service1();
		mi= new myclass2();
		mi.service1();

	}

}
