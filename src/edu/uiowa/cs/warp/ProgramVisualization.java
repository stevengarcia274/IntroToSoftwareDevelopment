/**
 * 
 */
package edu.uiowa.cs.warp;

import java.util.ArrayList;

/**
 * @author sgoddard
 *
 */
public class ProgramVisualization extends VisualizationObject {

	private static final String SOURCE_SUFFIX = ".dsl";
	private ProgramSchedule sourceCode;
	private Program program;
	
	ProgramVisualization(Warp warp) {
		super(new FileManager(), warp, SOURCE_SUFFIX);
		this.program = warp.toProgram();
		this.sourceCode = program.getSchedule();
	}

	@Override
	public Description visualization () {
		Description content = new Description();
    	var orderedNodes = program.toWorkLoad().getNodesOrderedAlphabetically();  

    	/* create schedule output header of column node names in order, with \t as  separator */
    	String nodeString = "Time Slot\t";
    	/* loop through the node names, stopping just before last name */
    	for (int i =0; i < orderedNodes.length-1; i++) { 
    		/* add each name to the string, with \t between each name */
    		nodeString += String.format("%s\t", orderedNodes[i]);
    	}
    	/* add the last name with \n instead of \t at the end */
    	nodeString += String.format("%s\n", orderedNodes[orderedNodes.length-1]); 
    	content.add(nodeString);

    	for (int rowIndex = 0;rowIndex < sourceCode.size(); rowIndex++) {
    		ArrayList<String> rowArrayList = sourceCode.get(rowIndex);
    		var row = rowArrayList.toArray(new String[rowArrayList.size()]);
    		String rowString = String.format("%d\t", rowIndex) + String.join("\t",row) + "\n";
    		content.add(rowString);
    	}
    	return content;
    }

	@Override
	public Description createHeader()  {
		Description header = new Description();
		
		header.add(String.format(
				"WARP system for graph %s created with the following parameters:\n",
				program.getName()));
    	header.add(String.format(
    			"Scheduler Name:\t%s\n",program.getSchedulerName()));
    	header.add(String.format(
    			"M:\t%s\n",String.valueOf(program.getMinPacketReceptionRate())));
    	header.add(String.format("E2E:\t%s\n",String.valueOf(program.getE2e())));
    	header.add(String.format("nChannels:\t%d\n",program.getNumChannels()));
    	/* The following parameters are only output when special schedules are requested */
    	if (program.getNumTransmissions() > 0) { // only specify when NumTransmissions is fixed
    		header.add(String.format("nTransmissions:\t%d)\n",program.getNumTransmissions()));
    	}
    	if (!program.getOptimizationFlag()) { // only specify when optimization not requested
    		header.add("Optimization Requested:\tFalse\n") ;
    	}
		return header;
	}
	
}
