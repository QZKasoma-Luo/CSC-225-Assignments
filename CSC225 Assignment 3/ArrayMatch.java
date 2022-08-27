/*
 * CSC 225 - Assignment 3
 * Name:
 * Student number:
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;


public class ArrayMatch {


	/*public static int[] slicingArray(int[] array, int array_length, String direction){

		int[] Array_sliced = new int[array_length];

		return Array_sliced;

	}*/

	/*
	 * match
	 * Purpose: Determine if the two given arrays 'match'
	 * Parameters: int[] a, int[] b - the two arrays
	 * Returns: boolean - true if arrays 'match', false otherwise
	 * Preconditions: a and b have the same number of elements
	 */
	public static boolean match(int[] a, int[] b) {
		// TODO complete the implementation
		boolean flag = false;
		for(int counter = 0; counter < a.length; counter++){
			if(a[counter] != b[counter]){
				break;
			}else{
				if(counter == a.length - 1){
					flag = true;
					//return flag;
				}
			}
		}
		if((a.length)%2 != 0){
				return flag;
		}else{
			int[] a1 = new int[a.length/2];
			int[] b1 = new int[a.length/2];
			int[] a2 = new int[a.length/2];
			int[] b2 = new int[a.length/2];
			for(int index = 0; index < a.length/2; index++){
				a1[index] = a[index];
				b1[index] = b[index];
			}
			int i = 0;
			for(int index = a.length/2; index < a.length; index++){
				a2[i] = a[index];
				b2[i] = b[index];
				i++;
			}

			if(match(a1,b1) == true && match(a2,b2) == true){
				flag = true;
				return flag;
			}

			if(match(a1,b1) == true && match(a1, b2) == true){
				flag = true;
				return flag;
			}

			if(match(a2,b1) == true && match(a2, b2) == true){
				flag = true;
				return flag;
			}
		}
		return flag; // change this - set to false so it compiles
	}

	/*
	 * fillArray
	 * Purpose: Fills arrays with contents read from Scanner
	 * Parameters: int[] x, Scanner fileReader
	 * Returns: nothing
	 */
	public static void fillArray(int[] x, Scanner fileReader) throws NoSuchElementException {
		Scanner f = new Scanner(fileReader.nextLine());
		for (int i = 0; i < x.length; i++) {
			x[i] = f.nextInt();
		}
	}

	/*
	 * a3Setup
	 * Purpose: Initializes the input arrays for Assignment 3 match detection
	 *          by reading data from the text file named fname
	 * Parameters: String fname - name of the file containig input data
	 * Returns: nothing
	 */
	public static void a3Setup(String fname) {
		Scanner fileReader = null;
		int[] A = null;
		int[] B = null;

		try {
			fileReader = new Scanner(new File(fname));
		} catch (FileNotFoundException e) {
			System.out.println("Error finding input file");
			e.printStackTrace();
			return;
		}

		try {
			int size = Integer.parseInt(fileReader.nextLine());
			A = new int[size];
			B = new int[size];
			fillArray(A, fileReader);
			fillArray(B, fileReader);
		} catch (NoSuchElementException e) {
			System.out.println("Error reading input file data");
			e.printStackTrace();
		}

		if (match(A,B)) {
			System.out.println("match found");
		} else {
			System.out.println("no matches");
		}
	}

	public static void main(String[] args) {
		if (args.length < 1) {
			System.out.println("Incorrect usage, should be:");
			System.out.println("java MysteryArray filename.txt");
			return;
		}
		a3Setup(args[0]);
	}
}
