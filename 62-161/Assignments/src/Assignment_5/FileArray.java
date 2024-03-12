package Assignment_5;

import java.io.*;

public class FileArray {

	public static void writeArray(String FileName, int[] NumOut) throws IOException{

		FileOutputStream FileOutStream = new FileOutputStream(FileName);
		DataOutputStream DataOutStream = new DataOutputStream(FileOutStream);

		// display the number
		System.out.print("The number in the array are : ");
		for (int index : NumOut) System.out.print(index + ", ");
		System.out.println("\n" + "Writing the number in the array to the binary-file " + FileName + "...");

		// write the array method on output file object
		for (int index : NumOut) DataOutStream.writeInt(index);

		System.out.print("Done. \n");

		// close stream object
		DataOutStream.close();
	}

	// definition of the static readArray method
	public static void readArray(int[] NumIN) throws IOException {
		boolean bool = false;

		// create the filestream
		FileInputStream FileInStream = new FileInputStream("MyNumbers.txt");
		DataInputStream DataInStream = new DataInputStream(FileInStream);

		// display output
		System.out.println("\nReading numbers from file " + "MyNumbers.txt" + "...");

		// try-catch block for invalid file name
		int i =0;
		while (!bool){
			try {
				NumIN[i] = DataInStream.readInt();
				i++;
			} catch (FileNotFoundException e) {
				System.out.print("File not found");
			} catch (EOFException e){
				bool = true;
			}
		}
		System.out.println("Done.\n");
		// close the file.
		DataInStream.close();
	}
}
