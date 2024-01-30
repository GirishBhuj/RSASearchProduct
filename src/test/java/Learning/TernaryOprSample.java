package Learning;

public class TernaryOprSample {

	public static void main(String[] args) {
	    int number = 24;
	    String result = (number > 0) ? "Positive Number" : "Negative Number";
	    System.out.println(result);
	    
	    
	    int marks = 40; 
	    String result1 = (marks > 40) ? "pass" : "fail";
	    System.out.println(result1);

	    int x=69;
	    int y=89;  
	    int z=79;  
	    int largestNumber= (x > y) ? (x > z ? x : z) : (y > z ? y : z);  
	    System.out.println("The largest numbers is:  "+largestNumber); 
	}

}
