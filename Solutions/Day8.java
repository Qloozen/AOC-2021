package Solutions;

import java.util.Arrays;
import java.util.List;


import Utilities.AOC;

public class Day8 extends AOC {

    public Day8() {
        super(8);
    }

    @Override
    public void puzzleA(List<String> input) {
        int digits = 0;
        for (String string : input) {
            String[] delimiter = string.split("\\|");
            String[] parts = delimiter[1].trim().split(" ");
            for (String digit : parts) {
                int l = digit.length();
                if(l == 2 || l == 4 || l == 3 || l == 7) {
                    digits ++;
                }
            }
        }
        System.out.println(digits);
    }

    @Override
    public void puzzleB(List<String> input) {
        int sum = 0;
		for(String s : input)
		{
			String[] delimiter = s.split("\\|");
			String[] parts1 = delimiter[0].trim().split(" ");
			String[] parts2 = delimiter[1].trim().split(" ");
			String[] digits = new String[10];
			
            for(String digit : parts1)
			{
				switch(digit.length())
				{
					case 2:
						digits[1] = digit;
						break;
					case 3:
						digits[7] = digit;
						break;
					case 4:
						digits[4] = digit;
						break;
					case 7:
						digits[8] = digit;
						break;
				}
			}
			for(String string : parts1)
			{
				if(string.length() == 6)
				{
                    
					if(isNine(digits, string))
						digits[9] = string;
					else if(isZero(digits, string))
						digits[0] = string;
					else
						digits[6] = string;
				}
			}

			for(String string : parts1)
			{
				if(string.length() == 5)
				{
					if(isThree(digits, string))
						digits[3] = string;
					else if(isFive(digits, string))
						digits[5] = string;
					else
						digits[2] = string;
				}
			}

			for(int i = 0; i < 10; i++)
				digits[i] = sortString(digits[i]);

			int number = 0;
			for(String toFind : parts2)
			{
				String sorted = sortString(toFind);
				for(int i = 0; i < 10; i++)
					if(digits[i].equals(sorted))
						number = (number * 10) + i;
			}
			sum += number;
		}
		System.out.println(sum);
	}

    public String sortString(String s)
	{
		char[] sortedArray = s.toCharArray();
		Arrays.sort(sortedArray);
		return new String(sortedArray);
	}

	public boolean isNine(String[] digits, String s)
	{
		boolean nine = true;
		for(char c : digits[4].toCharArray())
		{
			if(!s.contains(String.valueOf(c)))
			{
				nine = false;
				break;
			}
		}
		return nine;
	}

	public boolean isZero(String[] digits, String sPart)
	{
		boolean one = true;
		for(char c : digits[1].toCharArray())
		{
			if(!sPart.contains(String.valueOf(c)))
			{
				one = false;
				break;
			}
		}
		return one;
	}

	public boolean isThree(String[] digits, String sPart)
	{
		boolean three = true;
		for(char c : digits[1].toCharArray())
		{
			if(!sPart.contains(String.valueOf(c)))
			{
				three = false;
				break;
			}
		}
		return three;
	}

	public boolean isFive(String[] digits, String sPart)
	{
		int missing = 0;
		for(char c : digits[6].toCharArray())
			if(!sPart.contains(String.valueOf(c)))
				missing++;
		return missing == 1;
	}


    
}
