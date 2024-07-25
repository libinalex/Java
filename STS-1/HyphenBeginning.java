// Move all hyphen to beginning

// Input: Hello-welcome-you-all
// Output: ---Hellowelcomeyouall

//Method 1: Using Swap 

/*
import java.util.*;
class Main
{


	static void moveSpaceInFront(char str[])
	{

		int n = str.length-1;
		for (int i = n; i>= 0; i--)
			if (str[i] != '-')
			{
				char c = str[n];
				str[n] = str[i];
				str[i] = c;
				n--; 
			}
	}
	public static void main(String[] args)
	{
	    Scanner input=new Scanner(System.in);
	    String s=input.nextLine();
	    
		char str[]= s.toCharArray();
	
		moveSpaceInFront(str);
		System.out.println(String.valueOf(str));
	}
}


*/
//Method 2: Without using Swap 


import java.util.*;
class Main
{

static void moveSpaceInFront(char str[])
{
	
	int n = str.length-1;
	
	for (int j = n; j >= 0; j--)
		if (str[j] != '-')
			str[n--] = str[j];

	while (n >= 0)
		str[n--] = '-';
}

public static void main(String[] args)
	{
	    Scanner input=new Scanner(System.in);
	    String s=input.nextLine();
	    
		char str[]= s.toCharArray();
	
		moveSpaceInFront(str);
		System.out.println(String.valueOf(str));
	}
}