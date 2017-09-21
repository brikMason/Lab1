package lab1;
/**
 * CS 2003 - Lab 1
 * Code to find the maximum integer in a given file
 * NOTE:
 * there are bugs including those causing compilation errors and
 * resulting in runtime logical problems
 *
 * @author
 */

import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;
import java.io.File;
import java.io.IOException;


public class Lab1a {
    
    /**stores the data retrieved from the file */
    Vector <Integer> intVector; 
    /** variable used to compute the run-time */
    long startTime, endTime, totalTime;
    /** Constructor: computes the running time and call readFile
     * method
     */
    
    /**
     * Reads the file prints the contents and finds the maximum 
     *
     * @author Wes Maxwwell
     * @since 2017-08-31
     * @version 0.1
     * @param  none
     * @return      none
     */
    public void lab() {
	startTime = System.currentTimeMillis();
	readFile();
	endTime = System.currentTimeMillis();    
	totalTime = endTime - startTime;
	System.out.println("total time taken: " + totalTime + " milliseconds");
    }

    /* Method description here */
    public void readFile() {
	    int max = 0, count=0;
	    Integer elt;
	    Scanner input = null;
		try {
		    File inputFile = new File("/Users/wesmaxwell/Downloads/Lab 1/Lab1a.dat");
		    input = new Scanner(inputFile);
		    intVector = new Vector<Integer>();
	
		    // store all elements in a vector
		    while ((elt = input.nextInt())!= null) {
				count++;
				intVector.addElement(elt);
		    }
		}catch(IOException e) {
			//
		    System.err.println("IOException in reading input file!!!");
		}catch(NoSuchElementException e) {
			//
		    System.err.println("finished read ints");
		}finally {
		    input.close();
		}
		try {
		    // print on the terminal each elements of intVector
		    System.out.printf("There are %d integers in the input file:\n", count);
		    for (int value: intVector)
			System.out.printf("%d ",value);
		    System.out.println();
		    
		    // Find the max   
		    for(int i=1;i<intVector.size();i++){
			    	int value=intVector.get(i);
			    	if(max < value)
			    		max = value;
		    }
	
		    //output results
		    System.out.printf("The maximum integer in the input file is %d\n",max);
		} 
		catch (Exception e) {
		}	
    } //end readFile()
    
    /**
     * Instantiates Lab1a and executes lab()
     *
     * @author Wes Maxwwell
     * @since 2017-08-31
     * @version 0.1
     * @param  none
     * @return      none
     */
    public static void main(String args[]) {
    		(new Lab1a()).lab();
    } //end main
    
} //end class Lab1a
