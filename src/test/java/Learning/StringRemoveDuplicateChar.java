package Learning;
import java.util.LinkedHashSet; 

public class StringRemoveDuplicateChar 
{

	public static void main(String[] args)
	{
        String str = "javaTpoint is not best learning website";   
        removeDuplicates(str);
	}

	
	    static void removeDuplicates(String str)   
	    {     
	        //Create LinkedHashSet of type character   
	        LinkedHashSet<Character> set = new LinkedHashSet<>();   
	        //Add each character of the string into LinkedHashSet   
	        for(int i=0;i<str.length();i++)   
	            set.add(str.charAt(i));   
	            
	        // print the string after removing duplicate characters   
	        for(Character ch : set)   
	            System.out.print(ch);   
	    }
}