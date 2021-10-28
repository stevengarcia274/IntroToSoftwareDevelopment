package edu.uiowa.cs.warp;

import java.util.*;
/**
 * Provides information on graphs that are given through .txt files
 * 
 * @author sgoddard
 */
public class WorkLoadDescription extends VisualizationObject {
   private static final String EMPTY = "";
   
   private static final String INPUT_FILE_SUFFIX = ".wld";
   
   private Description description;
   private String inputGraphString;
   private FileManager fm;
   private String inputFileName;
   
   public String getInputFileName() {
      return this.inputFileName;
   }
   
   /*package*/ WorkLoadDescription (String inputFileName) {
      super(new FileManager(), EMPTY, INPUT_FILE_SUFFIX); // VisualizationObject constructor
      		this.fm = this.getFileManager();
      		initialize(inputFileName);
      	}
   
   @Override
   public Description visualization () 
   {
      return description;
      	}
   @Override
   public Description fileVisualization () 
   {
      return description;
      	}
   @Override
   public String toString () 
   {
      return inputGraphString;
      	}
   private void initialize(String inputFile) {
      // Get the input graph file name and read its contents
      		InputGraphFile gf = new InputGraphFile(fm);
      		inputGraphString = gf.readGraphFile(inputFile);
      		this.inputFileName = gf.getGraphFileName();
      		description = new Description(inputGraphString);
      	}
   
   public static void main(String[] args) {
      //Declarations at the beginning of block 
      		int REMOVE_CURLY = 3; //constant to remove curly bracket
      		int FLOW_NUM = 1; //used to increment printed flow numbers
      		String Temp; //temporary string to hold graph title 
      		String graphToString; //used to manipulate file contents
      		String[] fileLines; //temporary array to hold contents
      		ArrayList<String> sortingList = new ArrayList<>(); //ArrayList used to sort
      		
      		WorkLoadDescription inputGraph = new WorkLoadDescription("StressTest4.txt"); 
      		
      		graphToString = inputGraph.toString(); 
      		
      		fileLines = graphToString.split("\n"); //each line becomes its own element in array
      				
      		//add graph contents to ArrayList
      		for(int i = 0; i < fileLines.length; i ++) {
      			
      			sortingList.add(fileLines[i]);
      			
      		}
      		
      		Temp = sortingList.remove(0); //remove brackets and title to focus on sorting
      		
      		sortingList.remove(sortingList.size() - 1 );
      		
      		Collections.sort(sortingList); //sort
      		//Collections.sort(sortingList, String.CASE_INSENSITIVE_ORDER);
      		
      		//print graph title followed by sorted contents
      		System.out.println(Temp.substring(0, Temp.length() - REMOVE_CURLY));
      		
      		for(int k = 0; k < sortingList.size(); k ++) {
      			
      			System.out.println("Flow " + (k + FLOW_NUM) + ": " + sortingList.get(k));
      		
      		}
      	}
   
   }
