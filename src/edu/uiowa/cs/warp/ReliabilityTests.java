package edu.uiowa.cs.warp;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import edu.uiowa.cs.warp.SystemAttributes.ScheduleChoices;

public class ReliabilityTests {
	

	@Test
	public void testNumTxPerLinkAndTotalCostDefaultExample() {
		double e2e = 0.99;
		double m = 0.9;
		WorkLoad wl = new WorkLoad(e2e,m,"Example.txt");
		FlowMap flows = wl.getFlows();
		Flow flowNode = flows.get("F0");
		ReliabilityAnalysis linkTxAndTotalCost = new ReliabilityAnalysis(e2e, m);
		ArrayList<Integer> refactoredResult = linkTxAndTotalCost.numTxPerLinkAndTotalCost(flowNode);
	    ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(3);
		ar.add(3);
		ar.add(0);
		ar.add(4);
		assertEquals(ar, refactoredResult);
	}
	
	@Test
	public void testNumTxPerLinkAndTotalCostDefaultExampleFaults() {
		double e2e = 0.99;
		double m = 0.9;
		int numFaults = 0;
		WorkLoad wl = new WorkLoad(numFaults, e2e,m,"Example.txt");
		FlowMap flows = wl.getFlows();
		Flow flowNode = flows.get("F0");
		ReliabilityAnalysis linkTxAndTotalCost = new ReliabilityAnalysis(numFaults);
	    ArrayList<Integer> refactoredResult = linkTxAndTotalCost.numTxPerLinkAndTotalCost(flowNode);
	    ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(1);
		ar.add(1);
		ar.add(1);
		ar.add(2);
		assertEquals(ar, refactoredResult);
	}

	@Test
	public void testNumTxPerLinkAndTotalCostDefaultExample2() {
		double e2e = 0.99;
		double m = 0.9;
		WorkLoad wl = new WorkLoad(e2e,m,"Example2.txt");
		FlowMap flows = wl.getFlows();
		Flow flowNode = flows.get("F5");
		ReliabilityAnalysis linkTxAndTotalCost = new ReliabilityAnalysis(e2e,m);
	    ArrayList<Integer> refactoredResult = linkTxAndTotalCost.numTxPerLinkAndTotalCost(flowNode);
	    ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(3);
		ar.add(4);
		ar.add(4);
		ar.add(4);
		ar.add(0);
		ar.add(7);
		assertEquals(ar, refactoredResult);
	}
	
	@Test
	public void testNumTxPerLinkAndTotalCostDefaultExample2Faults() {
		double e2e = 0.99;
		double m = 0.9;
		int numFaults = 0;
		WorkLoad wl = new WorkLoad(numFaults, e2e,m,"Example2.txt");
		FlowMap flows = wl.getFlows();
		Flow flowNode = flows.get("F5");
		ReliabilityAnalysis linkTxAndTotalCost = new ReliabilityAnalysis(numFaults);
	    ArrayList<Integer> refactoredResult = linkTxAndTotalCost.numTxPerLinkAndTotalCost(flowNode);
	    ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(1);
		ar.add(1);
		ar.add(1);
		ar.add(1);
		ar.add(1);
		ar.add(4);
		assertEquals(ar, refactoredResult);
	}

	@Test
	public void testNumTxPerLinkAndTotalCostDefaultStressTest4() {
		double e2e = 0.99;
		double m = 0.9;
		WorkLoad wl = new WorkLoad(e2e,m,"StressTest4.txt");
		FlowMap flows = wl.getFlows();
		Flow flowNode = flows.get("F4");
		ReliabilityAnalysis linkTxAndTotalCost = new ReliabilityAnalysis(e2e,m);
	    ArrayList<Integer> refactoredResult = linkTxAndTotalCost.numTxPerLinkAndTotalCost(flowNode);
	    ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(3);
		ar.add(4);
		ar.add(5);
		ar.add(6);
		ar.add(6);
		ar.add(6);
		ar.add(5);
		ar.add(0);
		ar.add(11);
		assertEquals(ar, refactoredResult);	
	}

	@Test
	public void testNumTxPerLinkAndTotalCostDefaultExample3Faults() {
		double e2e = 0.99;
		double m = 0.9;
		int numFaults = 0;
		WorkLoad wl = new WorkLoad(e2e,m,"StressTest4.txt");
		FlowMap flows = wl.getFlows();
		Flow flowNode = flows.get("F4");
		ReliabilityAnalysis linkTxAndTotalCost = new ReliabilityAnalysis(numFaults);
	    ArrayList<Integer> refactoredResult = linkTxAndTotalCost.numTxPerLinkAndTotalCost(flowNode);
	    ArrayList<Integer> ar = new ArrayList<Integer>();
		ar.add(1);
		ar.add(1);
		ar.add(1);
		ar.add(1);
		ar.add(1);
		ar.add(1);
		ar.add(1);
		ar.add(1);
		ar.add(7);
		assertEquals(ar, refactoredResult);
	}
	
	
	@Test
	public void testCreateHeaderExample() {
		int REMOVE_TAG = 1;
		int JUST_HEADER = 6;
		double e2e = 0.99;
		double m = 0.9;
		Integer numChannels = 16;
		String[] fileLines;
		//Initialize separate string that will make up contents of our returned description	
		String addString = "";
		Description compareResults = new Description();//our controlled results (oracle)
		//put contents of oracle file into string which will be used to compare
		WorkLoadDescription testHeader = new WorkLoadDescription("TestExamplePriorityRA.ra");
		
		String printIt = testHeader.toString();//turn to string
		//split string
		fileLines = printIt.split("\n"); //each line becomes its own element in array
		
		//remove authentification tag, and just test header contents
  		for(int i = REMOVE_TAG; i < JUST_HEADER; i ++) {
  			
  			addString = addString + fileLines[i] + "\n";
  		}
  		String newString = addString.replaceAll("\r", "");//return carriage might happen
  		//add out header string into description
  		compareResults.add(newString);
  		
  		//create workload with the necessary values, and specific graph we want to test
  		WorkLoad makeWorkLoad = new WorkLoad(m, e2e, "Example.txt");
  		//create a warp instance
  		WarpSystem makeWarp = new WarpSystem(makeWorkLoad, numChannels, ScheduleChoices.PRIORITY);

  		//create a reliabilityVisualization instance out of that warp instance to test createHeader()
  		//method
  		ReliabilityVisualization vis = new ReliabilityVisualization(makeWarp);
  		//test createHeader() method
  		Description ourResults = vis.createHeader();
  		
  		//compare our results with oracle
		//assertEquals(compareResults.toString(), ourResults.toString(), "Header created successfully");
	
  		assertEquals(compareResults.toString(), ourResults.toString());

		
	}
	
	
	//NOTE: these visualization() tests, actually test our reliabilityTables by testing the table
	//result in our file and comparing it to the table seen in the oracle file
	@Test
	public void testCreateVisualizationExample() {
		int JUST_TABLE = 6;
		double e2e = 0.99;
		double m = 0.9;
		Integer numChannels = 16;
		String[] fileLines;
		//Initialize separate string that will make up contents of our returned description	
		String addString = "";
		Description compareResults = new Description();//our controlled results (oracle)
		//put contents of oracle file into string which will be used to compare
		WorkLoadDescription testTable = new WorkLoadDescription("TestExamplePriorityRA.ra");
		
		String printIt = testTable.toString();//turn to string
		//split string
		fileLines = printIt.split("\n"); //each line becomes its own element in array
		
		//remove authentification tag, and just test header contents
  		for(int i = JUST_TABLE; i < fileLines.length; i ++) {
  			
  			addString = addString + fileLines[i] + "\n";
  		}
  		String newString = addString.replaceAll("\r", "");//return carriage might happen
  		//add out header string into description
  		compareResults.add(newString);
  		//compareResults.add(addString);
  		
  		//create workload with the necessary values, and specific graph we want to test
  		WorkLoad makeWorkLoad = new WorkLoad(m, e2e, "Example.txt");
  		//create a warp instance
  		WarpSystem makeWarp = new WarpSystem(makeWorkLoad, numChannels, ScheduleChoices.PRIORITY);

  		//create a reliabilityVisualization instance out of that warp instance to test createHeader()
  		//method
  		ReliabilityVisualization vis = new ReliabilityVisualization(makeWarp);
  		//test createHeader() method
  		Description ourResults = vis.visualization();
  		

  		//compare our results with oracle
		assertEquals(compareResults.toString(), ourResults.toString());
		
	}
	

	@Test
	public void testVerifyReliablitiesExample() {
		double e2e = 0.99;
		double m = 0.9;
		Integer numChannels = 16;
		
		//create workload with the necessary values, and specific graph we want to test
  		WorkLoad makeWorkLoad = new WorkLoad(m, e2e, "Example.txt");
  		//create a warp instance
  		WarpSystem makeWarp = new WarpSystem(makeWorkLoad, numChannels, ScheduleChoices.PRIORITY);
  		
  		ReliabilityAnalysis myRA = makeWarp.toReliabilityAnalysis();
  		myRA.getReliabilities();
  		
  		boolean verifyResults = myRA.verifyReliabilities();
  		
  		assertEquals(true, verifyResults);
	}
	
	
	@Test
	public void testCreateVisualizationExampleFaults1() {
		int JUST_TABLE = 6;
		double e2e = 0.99;
		double m = 0.9;
		Integer numFaults = 1;
		Integer numChannels = 16;
		String[] fileLines;
		//Initialize separate string that will make up contents of our returned description	
		String addString = "";
		Description compareResults = new Description();//our controlled results (oracle)
		//put contents of oracle file into string which will be used to compare
		WorkLoadDescription testTable = new WorkLoadDescription("ExamplePriority-1FaultsRA.ra");
		
		String printIt = testTable.toString();//turn to string
		//split string
		fileLines = printIt.split("\n"); //each line becomes its own element in array
		
		//remove authentification tag, and just test header contents
  		for(int i = JUST_TABLE; i < fileLines.length; i ++) {
  			
  			addString = addString + fileLines[i] + "\n";
  		}
  		String newString = addString.replaceAll("\r", "");//return carriage might happen
  		//add out header string into description
  		compareResults.add(newString);
  		//compareResults.add(addString);
  		
  		//create workload with the necessary values, and specific graph we want to test
  		WorkLoad makeWorkLoad = new WorkLoad(numFaults, m, e2e, "Example.txt");
  		
  		//create a warp instance
  		WarpSystem makeWarp = new WarpSystem(makeWorkLoad, numChannels, ScheduleChoices.PRIORITY);
  		
  		//create a reliabilityVisualization instance out of that warp instance to test createHeader()
  		//method
  		ReliabilityVisualization vis = new ReliabilityVisualization(makeWarp);
  		//test createHeader() method
  		Description ourResults = vis.visualization();
  		

  		//compare our results with oracle
		assertEquals(compareResults.toString(), ourResults.toString());
		
	}
	
	
	@Test
	public void testVerifyReliablitiesExampleFaults1() {
		double e2e = 0.99;
		double m = 0.9;
		Integer numChannels = 16;
		Integer numFaults = 1;
		
		//create workload with the necessary values, and specific graph we want to test
  		WorkLoad makeWorkLoad = new WorkLoad(numFaults, m, e2e, "Example.txt");
  		//create a warp instance
  		WarpSystem makeWarp = new WarpSystem(makeWorkLoad, numChannels, ScheduleChoices.PRIORITY);
  		
  		//create RA object
  		ReliabilityAnalysis myRA = makeWarp.toReliabilityAnalysis();
  		myRA.getReliabilities();//produce table
  		
  		//verify table
  		boolean verifyResults = myRA.verifyReliabilities();
  		
  		assertEquals(false, verifyResults);
	}
	
	
	@Test
	public void testCreateHeaderStressTest4() {
		int REMOVE_TAG = 1;
		int JUST_HEADER = 6;
		double e2e = 0.99;
		double m = 0.9;
		Integer numChannels = 16;
		String[] fileLines;
		//Initialize separate string that will make up contents of our returned description	
		String addString = "";
		Description compareResults = new Description();//our controlled results (oracle)
		//put contents of oracle file into string which will be used to compare
		WorkLoadDescription testHeader = new WorkLoadDescription("TestStressTest4PriorityRA.ra");
		
		String printIt = testHeader.toString();//turn to string
		//split string
		fileLines = printIt.split("\n"); //each line becomes its own element in array
		
		//remove authentification tag, and just test header contents
  		for(int i = REMOVE_TAG; i < JUST_HEADER; i ++) {
  			
  			addString = addString + fileLines[i] + "\n";
  		}
  		String newString = addString.replaceAll("\r", "");//return carriage might happen
  		//add out header string into description
  		compareResults.add(newString);
  		
  		//create workload with the necessary values, and specific graph we want to test
  		WorkLoad makeWorkLoad = new WorkLoad(m, e2e, "StressTest4.txt");
  		//create a warp instance
  		WarpSystem makeWarp = new WarpSystem(makeWorkLoad, numChannels, ScheduleChoices.PRIORITY);

  		//create a reliabilityVisualization instance out of that warp instance to test createHeader()
  		//method
  		ReliabilityVisualization vis = new ReliabilityVisualization(makeWarp);
  		//test createHeader() method
  		Description ourResults = vis.createHeader();

  		//compare our results with oracle
		assertEquals(compareResults.toString(), ourResults.toString());
		
	}
	
	
	@Test
	public void testCreateVisualizationStressTest4() {
		int JUST_TABLE = 6;
		double e2e = 0.99;
		double m = 0.9;
		Integer numChannels = 16;
		String[] fileLines;
		//Initialize separate string that will make up contents of our returned description	
		String addString = "";
		Description compareResults = new Description();//our controlled results (oracle)
		//put contents of oracle file into string which will be used to compare
		WorkLoadDescription testTable = new WorkLoadDescription("TestStressTest4PriorityRA.ra");
		
		String printIt = testTable.toString();//turn to string
		//split string
		fileLines = printIt.split("\n"); //each line becomes its own element in array
		
		//remove authentification tag, and just test header contents
  		for(int i = JUST_TABLE; i < fileLines.length; i ++) {
  			
  			addString = addString + fileLines[i] + "\n";
  		}
  		String newString = addString.replaceAll("\r", "");//return carriage might happen
  		//add out header string into description
  		compareResults.add(newString);
  		//compareResults.add(addString);
  		
  		//create workload with the necessary values, and specific graph we want to test
  		WorkLoad makeWorkLoad = new WorkLoad(m, e2e, "StressTest4.txt");
  		
  		//create a warp instance
  		WarpSystem makeWarp = new WarpSystem(makeWorkLoad, numChannels, ScheduleChoices.PRIORITY);

  		//create a reliabilityVisualization instance out of that warp instance to test createHeader()
  		//method
  		ReliabilityVisualization vis = new ReliabilityVisualization(makeWarp);
  		
  		//test createHeader() method
  		Description ourResults = vis.visualization();
  		
  		
  		//compare our results with oracle
		assertEquals(compareResults.toString(), ourResults.toString());
		
	}
	
	
	@Test
	public void testVerifyReliablitiesStressTest4() {
		double e2e = 0.99;
		double m = 0.9;
		Integer numChannels = 16;
		
		//create workload with the necessary values, and specific graph we want to test
  		WorkLoad makeWorkLoad = new WorkLoad(m, e2e, "StressTest4.txt");
  		//create a warp instance
  		WarpSystem makeWarp = new WarpSystem(makeWorkLoad, numChannels, ScheduleChoices.PRIORITY);
  		
  		ReliabilityAnalysis myRA = makeWarp.toReliabilityAnalysis();
  		myRA.getReliabilities();
  		
  		boolean verifyResults = myRA.verifyReliabilities();
  		
  		assertEquals(true, verifyResults);
	}
	
	
	@Test
	public void testCreateVisualizationStressTest4_2Faults() {
		int JUST_TABLE = 6;
		double e2e = 0.99;
		double m = 0.9;
		Integer numFaults = 2;
		Integer numChannels = 16;
		String[] fileLines;
		//Initialize separate string that will make up contents of our returned description	
		String addString = "";
		Description compareResults = new Description();//our controlled results (oracle)
		//put contents of oracle file into string which will be used to compare
		WorkLoadDescription testTable = new WorkLoadDescription("StressTest4Priority-2FaultsRA.ra");
		
		String printIt = testTable.toString();//turn to string
		//split string
		fileLines = printIt.split("\n"); //each line becomes its own element in array
		
		//remove authentification tag, and just test header contents
  		for(int i = JUST_TABLE; i < fileLines.length; i ++) {
  			
  			addString = addString + fileLines[i] + "\n";
  		}
  		String newString = addString.replaceAll("\r", "");//return carriage might happen
  		//add out header string into description
  		compareResults.add(newString);
  		//compareResults.add(addString);
  		
  		//create workload with the necessary values, and specific graph we want to test
  		WorkLoad makeWorkLoad = new WorkLoad(numFaults, m, e2e, "StressTest4.txt");
  		
  		//create a warp instance
  		WarpSystem makeWarp = new WarpSystem(makeWorkLoad, numChannels, ScheduleChoices.PRIORITY);

  		//create a reliabilityVisualization instance out of that warp instance to test createHeader()
  		//method
  		ReliabilityVisualization vis = new ReliabilityVisualization(makeWarp);
  		
  		//test createHeader() method
  		Description ourResults = vis.visualization();
  		
  		
  		//compare our results with oracle
		assertEquals(compareResults.toString(), ourResults.toString());
		
	}
	
	
	@Test
	public void testVerifyReliablitiesStressTest4_2Faults() {
		double e2e = 0.99;
		double m = 0.9;
		Integer numChannels = 16;
		Integer numFaults = 2;
		
		//create workload with the necessary values, and specific graph we want to test
  		WorkLoad makeWorkLoad = new WorkLoad(numFaults, m, e2e, "StressTest4.txt");
  		//create a warp instance
  		WarpSystem makeWarp = new WarpSystem(makeWorkLoad, numChannels, ScheduleChoices.PRIORITY);
  		
  		ReliabilityAnalysis myRA = makeWarp.toReliabilityAnalysis();
  		myRA.getReliabilities();
  		
  		boolean verifyResults = myRA.verifyReliabilities();
  		
  		assertEquals(false, verifyResults);
	}
	
	
	@Test
	public void testCreateHeaderWARP_WASHU_MIX() {
		int REMOVE_TAG = 1;
		int JUST_HEADER = 6;
		double e2e = 0.99;
		double m = 0.9;
		Integer numChannels = 16;
		String[] fileLines;
		//Initialize separate string that will make up contents of our returned description	
		String addString = "";
		Description compareResults = new Description();//our controlled results (oracle)
		//put contents of oracle file into string which will be used to compare
		WorkLoadDescription testHeader = new WorkLoadDescription("WARP-WASHU-MIXPriorityRA.ra");
		
		String printIt = testHeader.toString();//turn to string
		//split string
		fileLines = printIt.split("\n"); //each line becomes its own element in array
		
		//remove authentification tag, and just test header contents
  		for(int i = REMOVE_TAG; i < JUST_HEADER; i ++) {
  			
  			addString = addString + fileLines[i] + "\n";
  		}
  		String newString = addString.replaceAll("\r", "");//return carriage might happen
  		//add out header string into description
  		compareResults.add(newString);
  		
  		//create workload with the necessary values, and specific graph we want to test
  		WorkLoad makeWorkLoad = new WorkLoad(m, e2e, "WARP-WASHU-MIX.txt");
  		//create a warp instance
  		WarpSystem makeWarp = new WarpSystem(makeWorkLoad, numChannels, ScheduleChoices.PRIORITY);

  		//create a reliabilityVisualization instance out of that warp instance to test createHeader()
  		//method
  		ReliabilityVisualization vis = new ReliabilityVisualization(makeWarp);
  		//test createHeader() method
  		Description ourResults = vis.createHeader();

  		//compare our results with oracle
		assertEquals(compareResults.toString(), ourResults.toString());
		
	}
	
	
	@Test
	public void testCreateVisualizationWARP_WASHU_MIX() {
		int JUST_TABLE = 6;
		double e2e = 0.99;
		double m = 0.9;
		Integer numChannels = 16;
		String[] fileLines;
		//Initialize separate string that will make up contents of our returned description	
		String addString = "";
		Description compareResults = new Description();//our controlled results (oracle)
		//put contents of oracle file into string which will be used to compare
		WorkLoadDescription testTable = new WorkLoadDescription("WARP-WASHU-MIXPriorityRA.ra");
		
		String printIt = testTable.toString();//turn to string
		//split string
		fileLines = printIt.split("\n"); //each line becomes its own element in array
		
		//remove authentification tag, and just test header contents
  		for(int i = JUST_TABLE; i < fileLines.length; i ++) {
  			
  			addString = addString + fileLines[i] + "\n";
  		}
  		String newString = addString.replaceAll("\r", "");//return carriage might happen
  		//add out header string into description
  		compareResults.add(newString);
  		//compareResults.add(addString);
  		
  		//create workload with the necessary values, and specific graph we want to test
  		WorkLoad makeWorkLoad = new WorkLoad(m, e2e, "WARP-WASHU-MIX.txt");
  		
  		//create a warp instance
  		WarpSystem makeWarp = new WarpSystem(makeWorkLoad, numChannels, ScheduleChoices.PRIORITY);

  		//create a reliabilityVisualization instance out of that warp instance to test createHeader()
  		//method
  		ReliabilityVisualization vis = new ReliabilityVisualization(makeWarp);
  		
  		//test createHeader() method
  		Description ourResults = vis.visualization();
  		
  		
  		//compare our results with oracle
		assertEquals(compareResults.toString(), ourResults.toString());
		
	}
	
	
	@Test
	public void testVerifyReliablitiesWARP_WASHU_MIX() {
		double e2e = 0.99;
		double m = 0.9;
		Integer numChannels = 16;
		
		//create workload with the necessary values, and specific graph we want to test
  		WorkLoad makeWorkLoad = new WorkLoad(m, e2e, "WARP-WASHU-MIX.txt");
  		//create a warp instance
  		WarpSystem makeWarp = new WarpSystem(makeWorkLoad, numChannels, ScheduleChoices.PRIORITY);
  		
  		ReliabilityAnalysis myRA = makeWarp.toReliabilityAnalysis();
  		myRA.getReliabilities();
  		
  		boolean verifyResults = myRA.verifyReliabilities();
  		
  		assertEquals(true, verifyResults);
	}
}

