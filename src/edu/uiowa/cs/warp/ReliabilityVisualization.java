package edu.uiowa.cs.warp;

import java.util.ArrayList;

/**
 * ReliabilityVisualization creates the visualizations for
 * the reliability analysis of the WARP program. <p>
 * 
 * CS2820 Fall 2021 Project: Implement this class to create
 * the file visualization that is requested in WarpTester.
 * 
 * @author sgoddard
 *
 */
public class ReliabilityVisualization  extends VisualizationObject {

	
	private static final String SOURCE_SUFFIX = ".ra";
	private static final String OBJECT_NAME = "Reliability Analysis";
	private Warp warp;
	private ReliabilityAnalysis ra;
	
	/**
	 *	This is the constructor for the ReliabilityVisualization object,
	 *	which takes a Warp object and stores it, then runs 
	 *	ReliabilityAnalysis on it.
	 *
	 *	@param Warp Warp object passed in
	 */
	
	ReliabilityVisualization(Warp warp) {
		super(new FileManager(), warp, SOURCE_SUFFIX);
		this.warp = warp;
		this.ra = warp.toReliabilityAnalysis();
	}
	
	/**
	 * The public method visualization takes the 
	 * stored information from the ReliabilityVisualization object
	 * and uses it to generate a table visualization of the stored
	 * ReliabilityAnalysis data.
	 * 
	 * @return content The formatted ReliabilityAnalysis data
	 */
	@Override
	public Description visualization() {
		Description content = new Description();
		int REMOVE_LAST_TAB = 1;
		var warpToPro = warp.toProgram();
		
		//var orderedNodes = warpToPro.toWorkLoad().getNodesOrderedAlphabetically(); 
		//var orderedFlows = warpToPro.toWorkLoad().getFlowNames();
		var orderedFlows = warpToPro.toWorkLoad().getFlowNamesInPriorityOrder();
		String flowString = "";
		//create column names that should be in the format of flowName:node
		for(int i = 0; i < orderedFlows.size(); i++) {
			var nodesIn = warpToPro.toWorkLoad().getNodesInFlow(orderedFlows.get(i));
			for(int t = 0; t < nodesIn.length; t++) {
				flowString += String.format("%s:%s\t", orderedFlows.get(i), nodesIn[t]);
				
			}
			
		}
		
		flowString = flowString.substring(0, flowString.length() - REMOVE_LAST_TAB) + "\n";
		content.add(flowString);
		
		//generate reliabilityTable that will be displayed in the file
    	ReliabilityTable insertTable = new ReliabilityTable();
    	insertTable = ra.getReliabilities();
    	//parse through the rows of reliability table and add them to the string
    	//so they can be displayed in the file
    	for(int rowIndex = 0; rowIndex < insertTable.size(); rowIndex++) {
    		String addString = "";
    		ReliabilityRow rowArrayList = insertTable.get(rowIndex);
    		for(int i = 0; i < rowArrayList.size(); i++){
    			if(i != (rowArrayList.size() - 1)) {
    				addString = addString + rowArrayList.get(i) + "\t";
    			}else {
    				addString = addString + rowArrayList.get(i); 
    			}
    		}
    		//addString = addString + rowArrayList + "\n";
    		addString = addString + "\n";
    		content.add(addString);		
    	}
		
    	return content;
	}

	/**
	 * This createHeader method is an Override of the one 
	 * found in the VisualizationObject class, with this
	 * one being refactored to specifically generate headers
	 * for .ra files, getting the graph name, scheduler name,
	 * minimum packet reception rate, number of channels,and 
	 * number of transmissions.
	 * 
	 * @return header The formatted header information returned as a Description object
	 */
	@Override
	public Description createHeader() {
		Description header = new Description();
		
		header.add(String.format(
				"Reliability Analysis for graph %s created with the following parameters:\n",
				warp.getName()));
    	header.add(String.format(
    			"Scheduler Name:\t%s\n",warp.getSchedulerName()));
    	header.add(String.format(
    			"M:\t%s\n",String.valueOf(warp.getMinPacketReceptionRate())));
    	header.add(String.format("E2E:\t%s\n",String.valueOf(warp.getE2e())));
    	header.add(String.format("nChannels:\t%d\n",warp.getNumChannels()));
    	/* The following parameters are only output when special schedules are requested */
    	if (warp.getNumTransmissions() > 0) { // only specify when NumTransmissions is fixed
    		header.add(String.format("nTransmissions:\t%d)\n",warp.getNumTransmissions()));
    	}
    	if (!warp.getOptimizationFlag()) { // only specify when optimization not requested
    		header.add("Optimization Requested:\tFalse\n") ;
    	}
		return header;
	}
	
/* File Visualization for workload defined in Example.txt follows. Note
 * that your Authentication tag will be different from this example. The
 * rest of your output in the file ExamplePriority-0.9M-0.99E2E.ra
 * should match this output, where \tab characters are used a column
 * delimiters.
// Course CS2820 Authentication Tag: r3XWfL9ywZO36jnWMZcKC2KTB2hUCm3AQCGxREWbZRoSn4/XdrQ/QuNQvtzAxeSSw55bWTXwbI9VI0Om+mEhNd4JC2UzrBBrXnHmsbPxbZ8=
Reliability Analysis for graph Example created with the following parameters:
Scheduler Name:	Priority
M:	0.9
E2E:	0.99
nChannels:	16
F0:A	F0:B	F0:C	F1:C	F1:B	F1:A
1.0	0.9	0.0	1.0 0.0 0.0
1.0	0.99	0.81	1.0	0.0 	0.0
1.0	0.999	0.972	1.0	0.0 	0.0
1.0	0.999	0.9963	1.0	0.0 	0.0
1.0	0.999	0.9963	1.0	0.9 	0.0
1.0	0.999	0.9963	1.0	0.99	0.81
1.0	0.999	0.9963	1.0	0.999	0.972
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
1.0	0.999	0.9963	1.0	0.999	0.9963
*/
}