package p2;

import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader("DATA21.txt"));
		//Loop for 10 test cases
		for (int x=0;x<10;x++) {
			//Read in a line, split for R, T, A
			StringTokenizer s= new StringTokenizer(in.readLine());
			int R = Integer.parseInt(s.nextToken());
			int T = Integer.parseInt(s.nextToken());
			String A=s.nextToken();
			Map<String, String> rules = new HashMap<String, String>();


			//Loop R times
			for (int r=0;r<R;r++) {
				//Read in line, split it and add to 2d array
				s=new StringTokenizer(in.readLine());
				rules.put(s.nextToken(), s.nextToken());
			}
			//loop T times
			for (int trials=0;trials<T;trials++) {
				String output="";
				//loop A times
				for (int pos=0;pos<A.length();pos++) {
					//compare current letter to each entry in 2D array. If it matches, replace.
					output+=rules.get(A.substring(pos,pos+1));
				}
				A=output;
			}
			System.out.println(A.substring(0,1)+A.substring(A.length()-1,A.length())+" "+String.valueOf(A.length()));
		}
		in.close();
	}

}
