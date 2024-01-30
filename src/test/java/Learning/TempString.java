package Learning;

public class TempString {

	public static void main(String[] args) 
	{
		String str1 = "Girish";
		String str2 = "Ramesh";
		String str3 = "Bhujbal";
		
		//Add 3 strings
		System.out.println(str1.concat(str2).concat(str3));

		String inputString = "Helloo World";

        int lowercaseCount = 0;
        int uppercaseCount = 0;

        for (int i = 0; i < inputString.length(); i++)
         {
            char currentChar = inputString.charAt(i);

            if (Character.isLowerCase(currentChar))
            {
                lowercaseCount++;
            } else if (Character.isUpperCase(currentChar))
            {
                uppercaseCount++;
            }
        }
		
 	   System.out.println("Lowercase characters: "+ lowercaseCount);
 	   
		/* Print odd and even numbers
		for (int i = 0; i < 50; i++)
        {
           int mReminder;           
           if (i%2==0)
           {
        	   System.out.println("Even number: "+i);               
           } else
           {        	   
          		System.out.println("Odd number: "+ i);                              
           }
       }
       */
 	   
 	   // Reverse the string
 	   
 		        String original = "Hello, World!";
 		        
 		        // Using char array
 		        char[] charArray = original.toCharArray();
 		        for (int i = 0, j = charArray.length - 1; i < j; i++, j--) {
 		            char temp = charArray[i];
 		            charArray[i] = charArray[j];
 		            charArray[j] = temp;
 		        }
 		        String reversedString = new String(charArray);
 		        
 		        System.out.println("Original string: " + original);
 		        System.out.println("Reversed string: " + reversedString);
	}
}
