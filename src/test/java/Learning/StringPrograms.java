package Learning;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;

public class StringPrograms
{
	static final int MAX_CHAR = 256;

	public static void main(String[] args) 
	{
		String str1 = "Girish";
		String str2 = "Ramesh";
		String str3 = "Bhujbal";

		//Add 3 strings
		//System.out.println(str1.concat(str2).concat(str3));

		//CharTypesinString("Helloo World");
		//CheckOddEvenNumbers(80);
		//StringReverse("I love to write Selenium with Java coding");
		//getOccurringChar("I love to write Selenium with Java coding");
		//removeDuplicates("I love to write Selenium with Java coding");
		findAndPrintDuplicateChar("I love to write Selenium with Java coding");

		String inputString = "Banana";
		String mTmp = inputString.replaceAll("", " ");
		System.out.println(mTmp);
		//char secondHighestOccurrence = findSecondHighestOccurrence(inputString);
		//System.out.println("Second highest occurrence: " + secondHighestOccurrence);

		inputString = "I love to write Selenium with Java coding";  

		//getOccuringChar(inputString);

		int[] charCounts = countCharacterOccurrence(inputString);

		// Display the results
		System.out.println("Character occurrence in the string:");
		for (int i = 0; i < charCounts.length; i++)
		{
			char currentChar = (char) i;
			if (charCounts[i] > 0)
			{
				System.out.println("'" + currentChar + "': " + charCounts[i] + " times");
			}
		}
	}

	public static void CharTypesinString(String mStringToCheck)
	{
		int lowercaseCount = 0;
		int uppercaseCount = 0;

		for (int i = 0; i < mStringToCheck.length(); i++)
		{
			char currentChar = mStringToCheck.charAt(i);
			if (Character.isLowerCase(currentChar))
			{lowercaseCount++;}
			else if (Character.isUpperCase(currentChar))
			{ uppercaseCount++;}
		}

		System.out.println("Lowercase characters: "+ lowercaseCount);
		System.out.println("Uppercase characters: "+ uppercaseCount);
	}

	public static void CheckOddEvenNumbers(int mNumToValidate)
	{
		// Print odd and even numbers
		for (int i = 0; i < 50; i++)
		{          
			if (i%2==0)
			{
				System.out.println("Even number: "+i);               
			} else
			{        	   
				System.out.println("Odd number: "+ i);                              
			}
		}
	}

	public static void StringReverse(String mStringArgs)
	{
        StringBuilder str = new StringBuilder(mStringArgs);
        System.out.println(str.reverse());

		// Using char array
		char[] charArray = mStringArgs.toCharArray();
		for (int i = 0, j = charArray.length - 1; i < j; i++, j--)
		{
			char temp = charArray[i];
			charArray[i] = charArray[j];
			charArray[j] = temp;
		}
		String reversedString = new String(charArray);

		System.out.println("Original string: " + mStringArgs);
		System.out.println("Reversed string: " + reversedString);
	}

	static void getOccurringChar(String str)
	{
		// Create an array of size 256 i.e. ASCII_SIZE
		int count[] = new int[MAX_CHAR];
		
		// Initialize count array index
		for (int i = 0; i < str.length(); i++)
			count[str.charAt(i)]++;

		// Create an array of given String size
		char ch[] = new char[str.length()];
		for (int i = 0; i < str.length(); i++)
		{
			ch[i] = str.charAt(i);
			if (ch[i] != ' ')
			{
				int find = 0;
				for (int j = 0; j <= i; j++)
				{
					if (str.charAt(i) == ch[j])
						find++;
				}
				if (find == 1)
				{
					System.out.println("Number of Occurrence of "
							+ str.charAt(i)
							+ " is:" + count[str.charAt(i)]);				
				}			
			}
		}
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

	private static char findSecondHighestOccurrence(String input)
	{
		// Remove spaces and convert the string to lowercase for case-insensitive comparison
		input = input.replaceAll("\\s", "").toLowerCase();

		// Create a map to store the count of each character
		Map<Character, Integer> charCountMap = new HashMap<>();

		// Populate the map with character occurrences
		for (char c : input.toCharArray())
		{
			charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
		}

		// Find the maximum and second maximum occurrences
		int maxCount = 0;
		int secondMaxCount = 0;
		char maxChar = 0;
		char secondMaxChar = 0;

		for (Entry<Character, Integer> entry : charCountMap.entrySet()) {
			int count = entry.getValue();
			if (count > maxCount) {
				secondMaxCount = maxCount;
				secondMaxChar = maxChar;
				maxCount = count;
				maxChar = entry.getKey();
			} else if (count > secondMaxCount && count != maxCount) {
				secondMaxCount = count;
				secondMaxChar = entry.getKey();
			}
		}

		return secondMaxChar;
	}

	private static void findAndPrintDuplicateChar(String inputString)
	{
		// Convert the string to lowercase for case-insensitive comparison
		inputString = inputString.toLowerCase();
		
		// Create a character array to store the occurrences of characters
		int[] charCount = new int[256]; // Assuming ASCII characters

		// Iterate through the string to count character occurrences
		for (int i = 0; i < inputString.length(); i++)
		{
			char currentChar = inputString.charAt(i);
			System.out.println("inputString.charAt(i)" + inputString.charAt(i));
			charCount[currentChar]++;
		}

		// Print duplicate characters
		System.out.println("Duplicate characters in the string:");
		for (int i = 0; i < charCount.length; i++)
		{	
			if (charCount[i] > 1 && Character.isLetterOrDigit((char) i))
			{
				System.out.println((char) i);
			}
		}
	}


	private static void getOccuringChar(String str)  
	{  
		//creating an array of size 256 (ASCII_SIZE)  
		int count[] = new int[MAX_CHAR];  

		//initialize count array index  
		for (int i = 0; i < str.length(); i++)
		{
			System.out.println(str.charAt(i));
			count[str.charAt(i)]++;			
		}

		//create an array of given String size  
		char ch[] = new char[str.length()];  
		for (int i = 0; i < str.length(); i++)   
		{
			ch[i] = str.charAt(i);
			int find = 0;
			for (int j = 0; j <= i; j++)
			{
				//if any matches found  
				if (str.charAt(i) == ch[j])  
					find++;  
			}

			if (find == 1)
				//prints occurrence of the character   
				System.out.println("The occurrence of "+ str.charAt(i)+ " is: " + count[str.charAt(i)]);  
		}
	}

	public static int[] countCharacterOccurrence(String str)
	{
		int[] charCounts = new int[256]; // Assuming ASCII characters
		// Iterate through each character in the string
		for (char c : str.toCharArray())
		{
			// Update the count in the array
			System.out.println("Inside loop c ==>"+c);
			System.out.println("Inside loop charCounts[c] ==>"+ charCounts[c]);
			charCounts[c]++;
		}
		return charCounts;
	}
}