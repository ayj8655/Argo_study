package sampleCode;

import java.io.*;
import java.util.*;

public class String_reverse {

	public static void main(String[] args) {
		String abc = "abcde";
		
		StringBuffer sb = new StringBuffer(abc);
		String reverse = sb.reverse().toString();
		System.out.println(reverse);
		
		String rever = "";
		
		int i = abc.length();
		for (int j = i-1; j>=0;j--) {
			rever = rever + abc.charAt(j);
		}
		
		System.out.println(rever);
	}

}
