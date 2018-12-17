package application;

import java.util.Arrays;


public class GetNum
{
	public static String blue1In16()
	{
		int a = (int) (Math.random()*16 + 1) ;
		String str = String.valueOf(a) ;
		return str ;
	}
	
	public static String red6In33()
	{
		int[] a = new int[6];

		for (int i = 0; i < a.length; i++)
		{
			oneNum:

			while (true)
			{
				a[i] = (int) (Math.random() * 33 + 1);

				for (int j = 0; j < i; j++)
				{
					if (a[i] == a[j])
					{
						continue oneNum;
					}
				}
				break;
			}

		}
		
		Arrays.sort(a);
		
		String str = "" ;
		for(int i=0; i<a.length; i++)
		{
			str = str + "   " + String.valueOf(a[i]) ; 
		}
		return str ;
	}

}
