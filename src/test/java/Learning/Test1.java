package Learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class Test1 {

	
	public static void main(String[] args)
	{
		Interview mInv = new Interview();
		mInv.m2 ();
		mInv.m3();

		ArrayList<Integer> mArrayList = new ArrayList<Integer>
		(Arrays.asList(23,54,539,23,54,58,24,25));
		
		LinkedHashSet<Integer> mLinkedHashSet = new LinkedHashSet<>(mArrayList);
		ArrayList<Integer> mArrayList1 = new ArrayList<Integer>(mLinkedHashSet);
		System.out.println(mArrayList1);
		
		ArrayList<String> mStrArrayList = new ArrayList<String>
		(Arrays.asList("Anju","Manju","Sanju","Manju","Kale","Gallo","Ganju","Kale"));
		LinkedHashSet<String> mStrLinkedHashSet = new LinkedHashSet<String>(mStrArrayList);
		ArrayList<String> mStrArrayList1 = new ArrayList<String>(mStrLinkedHashSet);
		System.out.println(mStrArrayList1);
		
	
        HashMap<String,String> mCapitals = new HashMap<String,String>();
        mCapitals.put("India","New Delhi");mCapitals.put("Russia","Moscow");
        mCapitals.put("Shrilanka","Colombo");

        for (String mValue : mCapitals.values()) {System.out.println(mValue);}
       
	}
}
