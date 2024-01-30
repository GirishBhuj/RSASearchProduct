package Learning;

//Inheritance: Java Program to implement To display the method print the addition and subtraction by using abstraction

//Abstract Class
abstract class arithmetic_operation {
	abstract void printInfo();
}

//Class addition
class addition extends arithmetic_operation {
	void printInfo()
	{
		int a = 3;
		int b = 4;
		System.out.println(a + b);
	}
}

//Class subtraction
class subtraction extends arithmetic_operation {
	void printInfo()
	{
		int c = 4;
		int d = 5;
		System.out.println(c - d);
	}
}

//Driver Class
public class InheritanceSampleCode {
	public static void main(String args[])
	{
		arithmetic_operation n = new addition();
		n.printInfo();
		arithmetic_operation y = new subtraction();
		y.printInfo();
	}
}