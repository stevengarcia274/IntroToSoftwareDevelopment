package edu.uiowa.cs.warp;

import java.util.ArrayList;
import java.util.*;
import edu.uiowa.cs.warp.WarpDSL.InstructionParameters;

/**
 * ReliabilityAnalysis analyzes the end-to-end reliability
 * of messages transmitted in flows for the WARP system. <p>
 *  
 * Let M represent the Minimum Packet Reception Rate on an
 * edge in a flow. The end-to-end reliability for each
 * flow, flow:src->sink, is computed iteratively as follows:<br>
 * (1)The flow:src node has an initial probability of 1.0 when
 * it is released. All other initial probabilities are 0.0. (That
 * is, the reset of the nodes in the flow have an initial probability
 * value of 0.0.) <br>
 * (2) each src->sink pair probability is computed as
 * NewSinkNodeState = (1-M)*PrevSnkNodeState + M*PrevSrcNodeState <br>
 * This value represents the probability that the message as been 
 * received by the node SinkNode.
 * Thus, the NewSinkNodeState probability will increase each time 
 * a push or pull is executed with SinkNode as a listener. <p>
 * 
 * The last probability state value for any node is the reliability of
 * the message reaching that node, and the end-to-end reliability of
 * a flow is the value of the last Flow:SinkNode probability.<p>
 * 
 * CS2820 Fall 2021 Project: Implement this class to compute the
 * probabilities the comprise the ReliablityMatrix, which is the core
 * of the file visualization that is requested in WarpTester.<p>
 * 
 * To do this, you will need to retrieve the program source,
 * parse the instructions for each node, in each time slot,
 * to extract the src and snk nodes in the instruction and then
 * apply the message success probability equation defined above.<p>
 * 
 * I recommend using the getInstructionParameters method of the 
 * WarpDSL class to extract the src and snk nodes from the instruction 
 * string in a program schedule time slot.
 * 
 * @author sgoddard
 *  *
 */

public class ReliabilityAnalysis {
   private static final double DEFAULT_E2E = 0.99;
   private static final double DEFAULT_MIN_PACKET_RECEPTION_RATE = 0.9;
	
   private double e2e;
   private double minPacketReceptionRate;
   private Integer numFaults;
   private ReliabilityTable raTable = new ReliabilityTable();//table for verifyReliabilities
   private static boolean whichResult;//if true return nTxPerLink
   					   				//if false return getFixedTxPerLink
   
   private Program program;
   
   /** 
    * Creates an object ReliabilityAnalysis with the specified information
    * @param program
    */
   public ReliabilityAnalysis (Program program) {
	      // TODO Auto-generated constructor stub
	   
	   this.program = program;
	   this.e2e = program.getE2e();
	   this.minPacketReceptionRate = program.getMinPacketReceptionRate();
	   this.numFaults = program.getNumFaults();
	   
	}
   
   /**
    * This public constructor is when the constructor call has both a specific
    * e2e and a specific minimum packet reception rate and does not take in 
    * numfaults
    * @param e2e
    * @param minPacketReceptionRate
    */
   public ReliabilityAnalysis (Double e2e, Double minPacketReceptionRate) {
		  this.e2e = e2e;
		  this.minPacketReceptionRate = minPacketReceptionRate;
		  whichResult = true;
		  
	      
	   }
   
   /**
    * This public constructor is for when the constructor call only gives
    * an integer representing the numFaults and uses the default e2e and
    * default minimum packet reception rate
    * @param numFaults
    */
   public ReliabilityAnalysis (Integer numFaults) {
		  this.numFaults = numFaults; 
		  this.e2e = DEFAULT_E2E;
		  this.minPacketReceptionRate = DEFAULT_MIN_PACKET_RECEPTION_RATE;
		  whichResult = false;
		  
   }

   /**
    * Helper function that's intended purpose is to 
    * check the values at the end of an ra table and insure
    * that they meet the minimum e2e reliability value
    * @return Boolean
    */
   public Boolean verifyReliabilities() {
	  ReliabilityTable verifyTable = this.raTable;
	  ReliabilityRow lastRow = new ReliabilityRow();
	  int nColumn = verifyTable.getNumColumns();
	   for(int i = 0; i < nColumn;i++) {
		   lastRow.add(verifyTable.get(verifyTable.size()-1, i));
	   }
	   for(int i = 0; i < lastRow.size(); i++) {
		   if(lastRow.get(i) < e2e) {
			   return false;
		   }
	   } 
	   	return true;
   }
   
   /**
    * Helper function that maps flows to columns as they
    * appear in the flow.
    * @param enterWorkLoad
    * @return
    */
   private Map<String, Integer> mapOfFlows(WorkLoad enterWorkLoad){
	   //helper function that maps the flow:node to it's column in our table
	   //this will come in handy when we want to update values
	   
	   Map<String, Integer> reliabilityMap = new HashMap<String, Integer>();
	   String flowString;
	   Integer numColums = 0;
	   var flowNames = enterWorkLoad.getFlowNamesInPriorityOrder();
	   
	   for(int i = 0; i < flowNames.size(); i++) {
		   var nodesIn = enterWorkLoad.getNodesInFlow(flowNames.get(i));
		   for(int t = 0; t < nodesIn.length; t++) {
			   flowString = "";
			   flowString += String.format("%s:%s", flowNames.get(i), nodesIn[t]);
			   //System.out.println(flowString + " " + numColums);
			   reliabilityMap.put(flowString, numColums);
			   numColums++;
		   }
				
	   }
	   //Map<String, Integer> reliabilityMap = new HashMap<String, Integer>();
	   return reliabilityMap; 
   }
   
   /**
    * Helper function that maps the flow:node to it's column in our table
	* which will be used when we want to update values
    * @param enterWorkLoad
    * @return reliabilityMap
    */
   private Map<String, Integer[]> flowStartAndEnds(WorkLoad enterWorkLoad){
	   //helper function that maps the flow's start and end nodes to it's column in our ra table
	   
	   Map<String, Integer[]> reliabilityMap = new HashMap<String, Integer[]>();
	   String flowString;
	   Integer numColums = 0;
	   int START_AND_END = 2;
	   int START = 0;
	   int END = 1;
	   var flowNames = enterWorkLoad.getFlowNamesInPriorityOrder();
	   
	   for(int i = 0; i < flowNames.size(); i++) {
		   var nodesIn = enterWorkLoad.getNodesInFlow(flowNames.get(i));
		   flowString = "";
		   flowString += String.format("%s", flowNames.get(i));
		   
		   Integer[] places = new Integer[START_AND_END];
		   places[START] = numColums;
		   
		   //keeps track of how many flows each node has
		   for(int t = 0; t < nodesIn.length; t++) {
			   numColums++;
		   }
		   places[END] = numColums;
		   reliabilityMap.put(flowString, places);
				
	   }
	   //Map<String, Integer> reliabilityMap = new HashMap<String, Integer>();
	   return reliabilityMap; 
   }
   
   /**
    * Helper function that finds flows to be reset.
    * @param i
    * @param enterWorkLoad
    * @return resetFlows
    */
   private ArrayList<String> additionalFlowsToReset(int i, WorkLoad enterWorkLoad){
	   ArrayList<String> resetFlows = new ArrayList<String>();//ArrayList that will hold other flows that need
	   														  //to be reset
	   
	   var flowNames = enterWorkLoad.getFlowNamesInPriorityOrder();
	   String checkFlow;//current flow of each iteration
	   
	   for(int t = 0; t < flowNames.size(); t++) {
		   checkFlow = flowNames.get(t);
		   /*
		   if(checkFlow.equals(curFlow)) {
			   System.out.println("curFlow skipped");
			   continue;
		   }*/
		   //find if checkFlow is a flow that needs to be reset
		   Integer curPeriod = enterWorkLoad.getFlowPeriod(checkFlow);
		   Integer curPhase = enterWorkLoad.getFlowPhase(checkFlow);
		   if((i % curPeriod) == curPhase) {
			   resetFlows.add(checkFlow);//add to our list
		   }   
		   
	   }
	   
	   
	   return resetFlows;
   }
   
   /**
    * Helper function that generates to first row of a ra table.
    * @param enterWorkLoad
    * @return returnNewSnk
    */
   private ReliabilityRow initialRow(WorkLoad enterWorkLoad){
	   var flowNames = enterWorkLoad.getFlowNamesInPriorityOrder();
	   ReliabilityRow intRow = new ReliabilityRow();
	   int size = 0;
	   double SNK_NODE = 1.0;
	   double INTIAL_VALUE = 0.0;
	   
	   
	   for(int i = 0; i < flowNames.size(); i++) {
		   var nodesIn = enterWorkLoad.getNodesInFlow(flowNames.get(i));
		   for(int t = 0; t < nodesIn.length; t++) {
			   //flowString += String.format("%s:%s\t", flowNames[i], nodesIn[t]);
			   if(t == 0) {
				   intRow.add(size, SNK_NODE);
				   
			   }else{
				   intRow.add(size, INTIAL_VALUE);
			   }
			   size++;
		   }
				
	   }
	   
	   return intRow;
   }
   
   /**
    * Helper function that updates the state of sink nodes.
    * @param PrevSnkNodeState
    * @param PrevSrcNodeState
    * @return returnNewSnk
    */
   private Double calcNewSnkNodeState(Double PrevSnkNodeState, Double PrevSrcNodeState) {
	   Double returnNewSnk = (1 - minPacketReceptionRate) * PrevSnkNodeState 
			   + minPacketReceptionRate * PrevSrcNodeState; 
	   
	   
	   return returnNewSnk;
   }
   
   /**
    * This function generates a ra table and populates it with
    * the calculated values.
    * @return ReliabilityTable
    */
   public ReliabilityTable getReliabilities() {
      WorkLoad myWorkLoad = program.toWorkLoad();
      ProgramSchedule proSched = program.getSchedule(); //programSchedule Table
      Map<String, Integer> meMap = mapOfFlows(myWorkLoad); //Map of Flow:Node and corresponding Column
      Map<String, Integer[]> locMap = flowStartAndEnds(myWorkLoad);
      //create initial ReliabilityTable 
      ReliabilityTable  finalReliabilityTable = new ReliabilityTable();
      ReliabilityRow initialSetRow = initialRow(myWorkLoad); //initialRow
      ReliabilityRow prevRow = new ReliabilityRow();
      WarpDSL dsl = new WarpDSL();
      //ArrayList that will hold instructions found in each cell
      ArrayList<InstructionParameters> instrucList = new ArrayList<InstructionParameters>();
      String instruction;//raw instruction from program schedule table 
      int PREVIOUS = 1;
      double RESET = 0.0;
      int START = 0;
      int END = 1;
      boolean needReset;
      
      int nTimeSlots = proSched.size();
      int nColumns = meMap.size();
      int nColumnsSched = proSched.get(0).size();
      
      
      //add the empty row to our table the same amount of time as there are rows
      //in the schedule
      ReliabilityRow insertRow = new ReliabilityRow();
      
      for (int rowIndex = 0; rowIndex < nTimeSlots; rowIndex++) {
    	  
    	  //finalReliabilityTable.add(initialSetRow);
    	  finalReliabilityTable.add(insertRow);
    	  
      }
   
      
      //ReliabilityRow insertRow = new ReliabilityRow(); //this row keeps the updated values
      for (int z = 0; z < nColumns; z++) {
    	  insertRow.add(initialSetRow.get(z));
	  }
      
      //parse through ProgramSchedule Table
      for(int i = 0; i < nTimeSlots; i++) {//iterate through each row in schedule table
    	  ArrayList<String> resetNodesVisited = new ArrayList<String>();
    	  int nonCount = 0;
    	  
    	  for(int j = 0; j < nColumnsSched; j++) {//iterate through each cell in the row
    		  instruction = proSched.get(i, j);//get the instruction string from cell
    		  instrucList = dsl.getInstructionParameters(instruction);
    		  
    		  
    		  
    		  //for(InstructionParameters entry : instrucList) {
    		  for(int x = 0; x < instrucList.size(); x++) {
    			  
    			  InstructionParameters curIn = instrucList.get(x);
    			  String curName = curIn.getName();//can be push, pull, wait, sleep
    			  
    			  
    			  if(curName.equals("push") || curName.equals("pull") ) {
    				  //System.out.println(instrucList.get(x).getFlow());
        			  String curFlow = curIn.getFlow();
        			  String curSnk = curIn.getSnk();
        			  String curSrc = curIn.getSrc();
        			  Integer curPeriod = myWorkLoad.getFlowPeriod(curFlow);
        			  Integer curPhase = myWorkLoad.getFlowPhase(curFlow);
    				  
        			  
        			  //System.out.println(instrucList.get(x).getName());
    				  //figure out prevRow
    				  if(i == 0 || (i % curPeriod) == curPhase) {
    					  prevRow = initialSetRow;
    					  //System.out.println("CONDITION MET AT " + i);
    					  //System.out.println(initialSetRow.toString());
    					  needReset = true;
    				  }else{
    					  prevRow = finalReliabilityTable.get(i - PREVIOUS);  
    					  needReset = false;
    				  }
    				  //System.out.println("i: " + i + " prevRow" + prevRow);
    				  //figure out src and snk node coordinates
    				  String snkKey = String.format("%s:%s", curFlow, curSnk);
    				  String srcKey = String.format("%s:%s", curFlow, curSrc);
    				  
    				  Integer snkColumn = meMap.get(snkKey);//get snkColumn from map
    				  Integer srcColumn = meMap.get(srcKey);//get srcColumn from map
    				  
    				  Double PrevSnkNodeState = prevRow.get(snkColumn);//values of snkNode from prev timeSlot
    				  Double PrevSrcNodeState = prevRow.get(srcColumn);//values of srcNode from prev timeSlot
    				  
    				  //cell calculations
    				  Double NewSnkNodeState = calcNewSnkNodeState(PrevSnkNodeState, PrevSrcNodeState);
    				  
    				  //finalReliabilityTable.set(i, snkColumn, NewSnkNodeState);
    				  
    				  if(needReset == true) {
    					  //multiple flows may meet the reset criteria in a particular time slot
    					  ArrayList<String> flowResets = additionalFlowsToReset(i, myWorkLoad);
    					  for(int s = 0; s < flowResets.size(); s++) {
    						  
    						  String workFlow = flowResets.get(s);//current flow that needs to be reset
    						  if(resetNodesVisited.contains(workFlow)) {
    							  //keep track of flows that are reset in the same time slot
    							  //so they are not updated and reset again
    							  continue;
    						  }
    						  
    						  Integer[] startAndEnd = locMap.get(workFlow);//column index of where flows begin and end
    						  int start = startAndEnd[START] + 1;//we DO NOT want to update the src node of the flow
    						  int end = startAndEnd[END];
    						  while(start < end) {
    							  insertRow.set(start, RESET);
    							  start = start + 1;
    						  }
    						  
    					  }
    					  
    					  resetNodesVisited.add(curFlow);
    					  
    					  
    					  
    				  }
    				  
    				  
    				  
    				  insertRow.set(snkColumn, NewSnkNodeState);
    				  //need a newRow that resets each time otherwise table will 
    				  //NOT progress correctly
    				  ReliabilityRow newRow = new ReliabilityRow();
    				  
    				  //iterate through the updated row, insert values into fresh row
    				  for (int z = 0; z < nColumns; z++) {
    					  newRow.add(insertRow.get(z));
    				  }
    				  
    				  
    				  //add fresh row to table
    				  finalReliabilityTable.set(i, newRow);
    				  //System.out.println(meMap.get(srcKey));  
    				  
    			  }else {
    				  //this checks if whole row of the program schedule is filled with sleep or wait instructions
    				  nonCount = nonCount + 1;
    			  }
    			  	  
    		  }
    		 
    		    
    	  }
    	  
    	  if(nonCount == nColumnsSched) {
    		  //System.out.println(nonCount);
    		  
    		  //if row is full of sleeps we need an independent row that won't be changed
    		  ReliabilityRow nothingRow = new ReliabilityRow();
			  
			  //iterate through the updated row, insert values into fresh row
			  for (int z = 0; z < nColumns; z++) {
				  nothingRow.add(insertRow.get(z));
			  }
			  
			  
			  //add fresh row to table
			  finalReliabilityTable.set(i, nothingRow);
    		  
    	  }
      }
      
      this.raTable = finalReliabilityTable;
      //return finalReliabilityTable;
      return raTable;
   }
   
   /**
    * Public function designed to return an ArrayList, representing a flow's 
    * numTxPerLinkAndTotalCost, results are meant to vary depending on the
    * instance of the ReliabilityAnalysis object that is created.
    * 
    * @param flow Name of the flow that calculations should be done on
    * @return An ArrayList of Integers that either represents the 
    *         FixedTxPerLinkAndTotalTxCost or nTxPerLinkAndTotalTxCost depending
    *         on the parameters feed into the ReliabilityAnalysis constructor
    */
   public ArrayList<Integer> numTxPerLinkAndTotalCost(Flow flow) {
	    if(whichResult == true) {
	    	var nodesInFlow = flow.nodes;
	        var nNodesInFlow = nodesInFlow.size(); // The last entry will contain the worst-case cost of
	                                               // transmitting E2E in isolation
	        var nPushes = new ArrayList<Integer>(nNodesInFlow + 1);//OUR CODE
	          											// Array to track nPushes for each node in this
	                                                     // flow (same as nTx per link)
	        
	        for(int i = 0; i < nNodesInFlow+1; i++) {
	        	nPushes.add(0);
	        } // initialize to all 0 values
	        var nHops = nNodesInFlow - 1;
	        // minLinkReliablityNeded is the minimum reliability needed per link in a flow to hit E2E
	        // reliability for the flow
	        Double minLinkReliablityNeded = Math.max(e2e, Math.pow(e2e, (1.0 / (double) nHops))); // use max
	                                                                                              // to
	                                                                                              // handle
	                                                                                              // rounding
	                                                                                              // error
	                                                                                              // when
	                                                                                              // e2e ==
	                                                                                              // 1.0
	        // Now compute reliability of packet reaching each node in the given time slot
	        // Start with a 2-D reliability window that is a 2-D matrix of no size
	        // each row is a time slot, stating at time 0
	        // each column represents the reliability of the packet reaching that node at the
	        // current time slot (i.e., the row it is in)
	        // will add rows as we compute reliabilities until the final reliability is reached
	        // for all nodes.
	        var reliabilityWindow = new ReliabilityTable();
	        var newReliabilityRow = new ReliabilityRow();
	        for (int i = 0; i < nNodesInFlow; i++) {
	          newReliabilityRow.add(0.0); // create the the row initialized with 0.0 values
	        }
	        reliabilityWindow.add(newReliabilityRow); // now add row to the reliability window, Time 0
	        ReliabilityRow tmpVector = reliabilityWindow.get(0);;
	        ReliabilityRow currentReliabilityRowArrayList = new ReliabilityRow();
	        currentReliabilityRowArrayList.addAll(tmpVector);
	        // Want reliabilityWindow[0][0] = 1.0 (i.e., P(packet@FlowSrc) = 1
	        // So, we initialize this first entry to 1.0, wich is reliabilityWindow[0][0]
	        // We will then update this row with computed values for each node and put it
	        // back in the matrix
	        currentReliabilityRowArrayList.set(0, 1.0);
	        // initialize (i.e., P(packet@FlowSrc) = 1
	        Double e2eReliabilityState = currentReliabilityRowArrayList.get(nNodesInFlow - 1); // the analysis will end
	                                                                              // when the 2e2
	                                                                              // reliability matrix is
	                                                                              // met, initially the
	                                                                              // state is not met and
	                                                                              // will be 0 with this
	                                                                              // statement
	        var timeSlot = 0; // start time at 0
	        while (e2eReliabilityState < e2e) { // change to while and increment increment timeSlot because
	                                            // we don't know how long this schedule window will last
	          ReliabilityRow prevReliabilityRow = new ReliabilityRow();
	          prevReliabilityRow.clear();
	          prevReliabilityRow.addAll(currentReliabilityRowArrayList); 							// would
	          currentReliabilityRowArrayList.clear();            									 // be
	          currentReliabilityRowArrayList.addAll(newReliabilityRow);                               // reliabilityWindow[timeSlot]
	                                                                                                   // if
	                                                                                                   // working
	                                                                                                   // through
	                                                                                                   // a
	                                                                                                   // schedule
	          // Now use each flow:src->sink to update reliability computations
	          // this is the update formula for the state probabilities
	          // nextState = (1 - M) * prevState + M*NextHighestFlowState
	          // use MinLQ for M in above equation

	          for (int nodeIndex = 0; nodeIndex < (nNodesInFlow - 1); nodeIndex++) { // loop through each
	                                                                                 // node in the flow and
	                                                                                 // update the sates for
	                                                                                 // each link (i.e.,
	                                                                                 // sink->src pair)
	            var flowSrcNodeindex = nodeIndex;
	            var flowSnkNodeindex = nodeIndex + 1;
	            var prevSrcNodeState = prevReliabilityRow.get(flowSrcNodeindex);
	            var prevSnkNodeState = prevReliabilityRow.get(flowSnkNodeindex);
	            Double nextSnkState;
	            if ((prevSnkNodeState < minLinkReliablityNeded) && prevSrcNodeState > 0) { // do a push
	                                                                                       // until PrevSnk
	                                                                                       // state > e2e to
	                                                                                       // ensure next
	                                                                                       // node reaches
	                                                                                       // target E2E BUT
	                                                                                       // skip if no
	                                                                                       // chance of
	                                                                                       // success (i.e.,
	                                                                                       // source doesn't
	                                                                                       // have packet)
	              nextSnkState = ((1.0 - minPacketReceptionRate) * prevSnkNodeState) + (minPacketReceptionRate * prevSrcNodeState); // need to
	                                                                                      // continue
	                                                                                      // attempting to
	                                                                                      // Tx, so update
	              nPushes.set(nodeIndex, nPushes.get(nodeIndex) + 1); // our CODE         // current state
	               // increment the number of pushes for for this node to snk node
	            } else {
	              nextSnkState = prevSnkNodeState; // snkNode has met its reliability. Thus move on to the
	                                               // next node and record the reliability met
	            }

	            if (currentReliabilityRowArrayList.get(flowSrcNodeindex) < prevReliabilityRow.get(flowSrcNodeindex)) { // probabilities
	                                                                                                  // are
	                                                                                                  // non-decreasing
	                                                                                                  // so
	                                                                                                  // update
	                                                                                                  // if
	                                                                                                  // we
	                                                                                                  // were
	                                                                                                  // higher
	                                                                                                  // by
	                                                                                                  // carring
	                                                                                                  // old
	                                                                                                  // value
	              currentReliabilityRowArrayList.set(flowSrcNodeindex, prevReliabilityRow.get(flowSrcNodeindex));                                                                                    // forward
	              																					// carry
	                                                                                              // forward
	                                                                                              // the
	                                                                                              // previous
	                                                                                              // state
	                                                                                              // for the
	                                                                                              // src
	                                                                                              // node,
	                                                                                              // which
	                                                                                              // may get
	                                                                                              // over
	                                                                                              // written
	                                                                                              // later
	                                                                                              // by
	                                                                                              // another
	                                                                                              // instruction
	                                                                                              // in this
	                                                                                              // slot
	            }
	            currentReliabilityRowArrayList.set(flowSnkNodeindex, nextSnkState);;
	          }

	          e2eReliabilityState = currentReliabilityRowArrayList.get(nNodesInFlow - 1);
	          ReliabilityRow currentReliabilityVector = new ReliabilityRow();
	          // convert the row to a vector so we can add it to the reliability window
	          
	          //REMINDER THIS IS WHERE WE LEFT OFF need to change the .addAll
	          currentReliabilityVector = currentReliabilityRowArrayList;
	          
	          if (timeSlot < reliabilityWindow.size()) {
	            reliabilityWindow.set(timeSlot, (currentReliabilityVector));
	          } else {
	            reliabilityWindow.add(currentReliabilityVector);
	          }
	          timeSlot += 1; // increase to next time slot
	        }
	        var size = reliabilityWindow.size();
	        nPushes.set(nNodesInFlow, size);
	        							// The total (worst-case) cost to transmit E2E in isolation with
	                                      // specified reliability target is the number of rows in the
	                                      // reliabilityWindow
	        // Now convert the array to the ArrayList needed to return
	        return nPushes; 	
	    	
	    }else{//END OF IF
	    	var nodesInFlow = flow.nodes;
	        var nNodesInFlow = nodesInFlow.size();
	        ArrayList<Integer> txArrayList = new ArrayList<Integer>();
	        /*
	         * Each node will have at most numFaults+1 transmissions. Because we don't know which nodes will
	         * send the message over an edge, we give the cost to each node.
	         */
	        for (int i = 0; i < nNodesInFlow; i++) {
	          txArrayList.add(numFaults + 1);
	        }
	        /*
	         * now compute the maximum # of TX, assuming at most numFaults occur on an edge per period, and
	         * each edge requires at least one successful TX.
	         */
	        var numEdgesInFlow = nNodesInFlow - 1;
	        var maxFaultsInFlow = numEdgesInFlow * numFaults;
	        txArrayList.add(numEdgesInFlow + maxFaultsInFlow);
	        return txArrayList;
	    	
	   
	    }//END OF ELSE
   }
   
   
   
 }
