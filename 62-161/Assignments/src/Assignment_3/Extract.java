package Assignment_3;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Extract {
	public static void main(String[] args) throws IOException {
		
		Scanner Source = new Scanner(new File(args[0]));    // open the Source file and read
		
		File Target=new File(args[1]);  // Create new file for output
		
		int[] indices=new int[args.length-2];   // Array
		
		for(int i=2;i<args.length;i++){      // read the indices
			indices[i-2]=Integer.parseInt(args[i]);
		}
		
		Arrays.sort(indices);   // sort the indices
		
		int numLines=0;     // line number
		
		while(Source.hasNextLine()){     // read each line from source file
			String word=Source.next();      // read next line
			numLines++;
		}
		
		String[] lines=new String[numLines];        // read data from source file to the array
		Source = new Scanner(new File(args[0]));
		
		int lineNum=0;
		
		while(Source.hasNextLine()){        // read next line
			lines[lineNum++]=Source.next();
		}

		FileWriter FWrite = new FileWriter(Target);   // output the specified lines
		
		for (int index : indices) {
			FWrite.write(lines[index-1] + "\n");      // write data to the target file
		}
		FWrite.close();     // FileWriter Close
	}
}