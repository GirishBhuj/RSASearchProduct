package Learning;

import java.util.LinkedHashSet;

public class FindDuplicateCharacters {

	public static void RemoveDuplicates(int[] mIntArray)
	{
		LinkedHashSet<Integer> mSet = new LinkedHashSet<Integer>();
		
		for (int mCounter=0;mCounter < mIntArray.length;mCounter++)
		{
			mSet.add(mIntArray[mCounter]);
		}
        System.out.println(mSet);
	}
	
    public static void main(String[] args)
    {
        String string1 = "Great responsibility";  
        int count;  
        
        int IntArray[] = {1,2,44,8,5,2,9,4,7,44,5,53,1,53,43,};
        RemoveDuplicates(IntArray);
                
        //Converts given string into character array  
        char string[] = string1.toCharArray();  
          
        System.out.println("Duplicate characters in a given string: ");  
        //Counts each character present in the string  
        for(int i = 0; i <string.length; i++)
        {  
            count = 1;

            for(int j = i+1; j <string.length; j++)
            {  
                //System.out.println("string[i] "+string[i]);
            	//System.out.println("string[i] "+string[j]); 
                if(string[i] == string[j] && string[i] != ' ')
                {  
                    count++;  
                    //Set string[j] to 0 to avoid printing visited character  
                    string[j] = '0';  
                }
            }  
            //A character is considered as duplicate if count is greater than 1  
            if(count > 1 && string[i] != '0')  
                System.out.println(string[i]);
        }  
    }  
}
