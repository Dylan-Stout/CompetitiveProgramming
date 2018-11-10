package com.crackingthecodinginterview.test.chapter8;

import java.util.ArrayList;
import java.util.List;

public class ParensCombo {
	
	public static List<String> generateParenthesis(int n)
	{
		ArrayList<String> result = new ArrayList<String>(); 
		parensComboHelper(0,n,n,n,new StringBuilder(), result); 
		return result; 
	}
	
	public static void parensComboHelper(int open, int toClose, int left, int right, StringBuilder sb, ArrayList<String> result)
	{
		if(left==0 && right ==0)
			result.add(sb.toString());
		
		if(open==0 && left >0)
		{
			sb.append("("); 
			parensComboHelper(open+1, toClose+1, left-1, right, sb, result); 
			sb.setLength(sb.length()-1);
		}else if(open>=1)
		{
			if(left>0)
			{
				sb.append("("); 
				parensComboHelper(open+1, toClose+1, left-1, right, sb, result); 
				sb.setLength(sb.length()-1);
			}
			sb.append(")"); 
			parensComboHelper(open-1, toClose-1, left, right-1, sb, result); 
			sb.setLength(sb.length()-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(generateParenthesis(5).toString()); 
		System.out.println(generateParenthesis(4).toString()); 
		System.out.println(generateParenthesis(3).toString()); 
		System.out.println(generateParenthesis(2).toString()); 
		System.out.println(generateParenthesis(1).toString());  
	}

}
