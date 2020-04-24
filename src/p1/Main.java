package p1;
import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new FileReader("DATA12.txt"));
		//Loop 10 times for the ten test cases
		for (int testCase=0;testCase<10;testCase++) {

			//Read a line and split it into N, M, D
			StringTokenizer st= new StringTokenizer(in.readLine()," ");
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			int shirtTotal=N;
			int laundry=0;
			//Read the next line for M values, split it into an array, sort the array
			int[] events = new int[M];
			st = new StringTokenizer(in.readLine()," ");
			for (int x=0;x<events.length;x++) {
				events[x]=Integer.parseInt(st.nextToken());
			}
			Arrays.sort(events);
			int eventPos=0;
			//loop D times
			for (int days=1;days<=D;days++) {

				//For each day, check if N is 0. if so, add to laundry and reset N to shirt total
				if (N==0) {
					laundry++;
					N=shirtTotal;
				}
				//If there is an event, add 1 to shirt total
				boolean matched=false;
				do {
					matched=false;
					if (eventPos<events.length) {
						if (events[eventPos]==days) {
							shirtTotal++;
							N++;
							eventPos++;
							matched=true;
						}
					}
				}while (matched);
				//reduce N by 1
				N--;

			}
			System.out.println(laundry);

		}

		in.close();
	}

}
