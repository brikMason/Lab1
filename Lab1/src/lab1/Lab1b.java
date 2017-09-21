package lab1;
/**
 * CS 2003 - Lab 1. Code to compute the average of doubles from an input
 * file.  NOTE: add data members and methods at your convenience. Use
 * the most accurate data types. You can reuse bits of code from
 * the class Lab1a.
 *
 * @author
 */

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.io.IOException;

public class Lab1b {
    
    // data members

    /** Constructor: calls method readFile that reads the doubles
     * contained in the file "<code>filename</code>" and computes the
     * average of the elements.
     @param filename name of the file containing doubles.
    */
    public Lab1b(String filename) {
	readFile(filename);
    }

    /** Reads double from a file named <code>filename</code> and
     * computes the average of the elements contained in the file 
     * @param filename name of the file containing the doubles 
     * @author Wes Maxwell
     * @since 2017-08-31
     * @version 0.1
     */
    public void readFile(String filename) {
    		Vector<Double> vector = new Vector<Double>();;
	    
	    int count=0;
	    Double elt;
	    Scanner input = null;
		try {
		    File inputFile = new File("/Users/wesmaxwell/Downloads/Lab 1/"+filename);
		    input = new Scanner(inputFile);
	
		    // store all elements in a vector
		    while ((elt = input.nextDouble())!= null) {
				count++;
				vector.addElement(elt);
		    }
		}catch(IOException e) {
			//
		    System.err.println("IOException in reading input file!!!");
		}catch(NoSuchElementException e) {
			//
		    System.err.println("finished read doubles");
		}finally {
		    input.close();
		}
		try {
		    // print on the terminal each elements of intVector
		    System.out.printf("There are %d doubles in the input file:\n", count);
		    for (double value: vector)
		    		System.out.printf("%f ",value);
		    System.out.println();
		    
		    // Find the average
		    double sum = 0.0;
		    for(int i=0;i<vector.size();i++){
			    	double value=vector.get(i);
			    	sum += value;
		    }
	
		    //output results
		    System.out.printf("The maximum integer in the input file is %f\n", (double)sum/vector.size() );
		} 
		catch (Exception e) {
		}	
    } //end readFile()
    
    

    /** main : creates a Lab1b Object with the filename passed in
     * argument*/
    public static void main(String args[]) {
	if (args.length == 0)
	    System.err.println("enter the data file name!");
	else
	    new Lab1b(args[0]);
    } //end main
    
} //end class Lab1b
