package edu.uiowa.cs.warp;

import static org.junit.jupiter.api.Assertions.*;


import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class WorkLoadTest {
	//Declare variables to hold the work loads of various test .txt files
	WorkLoad stressTest4WorkLoad;
	WorkLoad seeSprayWorkLoad;
	WorkLoad test1WorkLoad;
	WorkLoad addFlowTest;
	WorkLoad addFlowCompare;
	WorkLoad addFlowCompareTwo;
	
	
	@BeforeEach
	public void setUp() {
		Double 	WORKLOAD_M = 3.0;
		Double WORKLOAD_E2E = 2.0;
		//Create work load for stressTest4.txt
		stressTest4WorkLoad = new WorkLoad(WORKLOAD_M, WORKLOAD_E2E, "stressTest4.txt");
		//Create work load for SeeSpray.txt
		seeSprayWorkLoad = new WorkLoad(WORKLOAD_M, WORKLOAD_E2E, "SeeSpray.txt");
		//Create work load for Test1.txt
		test1WorkLoad = new WorkLoad(WORKLOAD_M, WORKLOAD_E2E, "Test1.txt");
		//Create workLoad for addFlowTest.txt
		addFlowTest = new WorkLoad(WORKLOAD_M, WORKLOAD_E2E, "addFlowTest.txt");
		//Create workLoad for addFlowTest_compare.txt
		addFlowCompare = new WorkLoad(WORKLOAD_M, WORKLOAD_E2E, "addFlowTest_compare.txt");
		addFlowCompareTwo = new WorkLoad(WORKLOAD_M, WORKLOAD_E2E, "addFlowTest2_compare.txt");
	}
	
	@Test
	void testAddFlow() {
		ArrayList<String> EXPECTED_OUTPUT = new ArrayList<String>();
		ArrayList<String> addFlowOutput = new ArrayList<String>();
		//how do we add flows--is it just the flow name like 'F11'
		addFlowTest.addFlow("F11");
		//creating output
		addFlowOutput = addFlowTest.getFlowNamesInOriginalOrder();
		
		EXPECTED_OUTPUT = addFlowCompare.getFlowNamesInOriginalOrder();
		
		assertEquals(EXPECTED_OUTPUT, addFlowOutput, "New flow 'F11' added to workload");
	}
	
	@Test
	void testAddFlowMultiple() {
		ArrayList<String> EXPECTED_OUTPUT = new ArrayList<String>();
		ArrayList<String> addFlowOutput = new ArrayList<String>();
		
		//how do we add flows--is it just the flow name like 'F11'
		addFlowTest.addFlow("F11");
		addFlowTest.addFlow("F21");
		addFlowTest.addFlow("F18");
		addFlowTest.addFlow("F13");
		//creating output
		addFlowOutput = addFlowTest.getFlowNamesInOriginalOrder();
		
		EXPECTED_OUTPUT = addFlowCompareTwo.getFlowNamesInOriginalOrder();
		
		assertEquals(EXPECTED_OUTPUT, addFlowOutput, "Multiple flows added to workload");
	}

	@Test
	void testAddNodeToFlowOnce() {
		//Expected string of array of nodes
		String EXPECTED_NODE_STRING = "[B, C, D, A]";
		String[] actualNodes;
		String actualNodeString;
		
		//Add node named 'A' to flow named 'F1'
		stressTest4WorkLoad.addNodeToFlow("F1","A");
		//Get the nodes in flow 'F1' which should now also contain A
		actualNodes = stressTest4WorkLoad.getNodesInFlow("F1");
		//Convert the array containing the nodes to string
		actualNodeString = Arrays.toString(actualNodes);
		
		//Compare expected with result
		assertEquals(EXPECTED_NODE_STRING, actualNodeString,
				"Flow F1 in stressTest4.txt after adding a single node 'A'");
	}
	@Test
	void testAddNodeToFlowMultiple() {
		//Expected string of array of nodes
		String EXPECTED_NODE_STRING = "[B, C, D, A, E, J]";
		String[] actualNodeArray;
		String actualNodeString;
		
		//Add nodes 'A', 'E', and 'J' to flow 'F6' in stressTest4.txt
		stressTest4WorkLoad.addNodeToFlow("F6","A");
		stressTest4WorkLoad.addNodeToFlow("F6","E");
		stressTest4WorkLoad.addNodeToFlow("F6","J");
		//Get the nodes in flow 'F6' which should now also contain 'A', 'E', and 'J'
		actualNodeArray = stressTest4WorkLoad.getNodesInFlow("F6");
		//Convert the array containing the nodes to a string
		actualNodeString = Arrays.toString(actualNodeArray);
		
		//Compare expected with results
		assertEquals(EXPECTED_NODE_STRING, actualNodeString,
				"Flow F6 in stressTest4.txt after adding nodes 'A', 'E' and 'J'");
	}
	@Test
	void testAddNodeToFlowAlphanumeric() {
		//Expected string of array of nodes
		String EXPECTED_NODE_STRING = "[C1, B1, A]";
		String[] actualNodeArray;
		String actualNodeString;
		
		//Add a node 'A' to flow 'F1A' in Test1.txt
		test1WorkLoad.addNodeToFlow("F1A","A");
		//Get the nodes in flow 'F1A' that should now contain 'A'
		actualNodeArray = test1WorkLoad.getNodesInFlow("F1A");
		//Convert the array containing the nodes to a string
		actualNodeString = Arrays.toString(actualNodeArray);
		
		//Compare expected with results
		assertEquals(EXPECTED_NODE_STRING, actualNodeString,
				"Flow F1A in Test1.txt after adding a node 'A'");
	}
	
	
	@Test
	void testGetFlowPriorityStringString() {
		/*nodes that belong to flows that are already created in the file should
		 * have priority 0*/
		Integer EXPECTED_NODE_PRIORITY = 0;
		Integer actualNodePriority = stressTest4WorkLoad.getFlowPriority("F1","D");
		
		//next test will check that this method returns the correct priority when a new node is added
		assertEquals(EXPECTED_NODE_PRIORITY, actualNodePriority, 
				"Priority of node 'D,' belonging to flow 'F1' returned");
	}
	
	@Test
	void testGetFlowPriorityAddedNode() {
		Integer EXPECTED_NODE_PRIORITY = 3;
		Integer actualNodePriority;
		
		//add node to flow
		stressTest4WorkLoad.addNodeToFlow("F1", "Y");
		//because they're 3 nodes in the flow this new flows priority should be 3
		//new nodes priority will be index in flow, and indexing starts at 0 
		actualNodePriority = stressTest4WorkLoad.getFlowPriority("F1","Y");
		//check if expected and actual is equal
		assertEquals(EXPECTED_NODE_PRIORITY, actualNodePriority, "Priority of newly added node 'Y' in flow 'F1'");
	}
	
	@Test
	void testGetFlowPriorityString() {
		//from stressTest doc. we know F1 priority is 1
		Integer EXPECTED_PRIORITY = 1; 
		//test it 
		Integer actualPriority = stressTest4WorkLoad.getFlowPriority("F1");
		
		assertEquals(EXPECTED_PRIORITY, actualPriority, "Initial priotiry of F1 returned");
	}
	
	@Test
	void testGetFlowPriorityStringAddedFlow() {
		Integer EXPECTED_PRIORITY = 10; 
		Integer actualPriority;

		//add flow to flowPriorityTest WorkLoad
		stressTest4WorkLoad.addFlow("F13");
		/* When new flow added, priority set to index, this is the 10th flow added,
		 * however indexing starts at 0, so new flow has priority 10
		 */
		
		//test it 
		actualPriority = stressTest4WorkLoad.getFlowPriority("F13");
		assertEquals(EXPECTED_PRIORITY, actualPriority, "Priotiry of newly added flow 'F13' returned");
	}

	@Test
	void testSetFlowPriority() {
		//initialize an individual variable to hold 30
		Integer EXPECTED = 30;
		
		//set flow F5's priority to 30, different than its initial priority of 5
		stressTest4WorkLoad.setFlowPriority("F5", 30);
		
		//compare expected priority with actual 
		assertTrue(EXPECTED == stressTest4WorkLoad.getFlowPriority("F5"), 
				"Priority of flow 'F5' changed, then checked");
	}

	@Test
	void testSetFlowDeadlineOnce() {
		//The expected deadline should be 100 because we set it to that
		Integer EXPECTED_DEADLINE = 100;
		Integer actualDeadline;
		
		//Set the deadline of flow 'F5' in stressTest4.txt to 100
		stressTest4WorkLoad.setFlowDeadline("F5", 100);
		//Get the actual deadline of the flow 'F5'
		actualDeadline = stressTest4WorkLoad.getFlowDeadline("F5");
		
		//Compare expected with actual deadline
		assertTrue(EXPECTED_DEADLINE == actualDeadline,
				"Deadline of flow F5 in stressTest4.txt after setting it to 100");
	}

	@Test
	void testSetFlowDeadlineOverwrite() {
		//The expected deadline should be 75 because we set it to that
		Integer EXPECTED_DEADLINE = 75;
		Integer actualDeadline;
		
		//Set the deadline of flow 'F1' in stressTest4.txt to 100
		stressTest4WorkLoad.setFlowDeadline("F1", 100);
		//Set the deadline of flow 'F1' in stressTest4.txt to 75
		stressTest4WorkLoad.setFlowDeadline("F1", 75);
		//Get the actual deadline of the flow 'F5'
		actualDeadline = stressTest4WorkLoad.getFlowDeadline("F1");
		
		//Compare expected with actual deadline
		assertTrue(EXPECTED_DEADLINE == actualDeadline,
				"Deadline of flow F1 in stressTest4.txt after setting it to 100 then 75");
	}
	
	@Test
	void testSetFlowDeadlineAlphanumeric() {
		//The expected deadline should be 100 because we set it to that
		Integer EXPECTED_DEADLINE = 100;
		Integer actualDeadline;
		
		//Set the deadline of flow 'F1A' in Test1.txt to 100
		test1WorkLoad.setFlowDeadline("F1A", 100);
		//Get the actual deadline of the flow 'F1A'
		actualDeadline = test1WorkLoad.getFlowDeadline("F1A");
		
		//Compare expected with actual deadline
		assertTrue(EXPECTED_DEADLINE == actualDeadline,
				"Deadline of flow F1A in Test1.txt after setting it to 100");
	}
	
	@Test
	void testGetFlowDeadlineOnce() {
		//Expected deadline should be 75 for flow 'F5'
		Integer EXPECTED_DEADLINE = 75;
		//Get the deadline for flow 'F5' in stressTest4.txt
		Integer actualDeadline = stressTest4WorkLoad.getFlowDeadline("F5");
		
		//Compare expected deadline with actual deadline
		assertEquals(EXPECTED_DEADLINE, actualDeadline,
				"Getting flow F5's deadline from stressTest4.txt");
	}
	
	@Test
	void testGetFlowDeadlineOnceAlphanumeric() {
		//Expected deadline should be 25 for flow 'F1A'
		Integer EXPECTED_DEADLINE = 25;
		//Get the deadline for flow 'F1A' in Test1.txt
		Integer actualDeadline = test1WorkLoad.getFlowDeadline("F1A");
		
		//Compare expected deadline with actual deadline
		assertEquals(EXPECTED_DEADLINE, actualDeadline,
				"Getting flow F1A's deadline from Test1.txt");
	}
	
	void testGetFlowDeadlineMultiple() {
		//Expected deadline for flow 'F1' is 20
		Integer EXPECTED_DEADLINE = 20;
		//Expected deadline or flow 'F2' is 50
		Integer EXPECTED_DEADLINE2 = 50;
		//Get deadline for flow 'F1' in stressTest4.txt
		Integer actualDeadline = stressTest4WorkLoad.getFlowDeadline("F1");
		//Get deadline for flow 'F2' in stressTest4.txt
		Integer actualDeadline2 = stressTest4WorkLoad.getFlowDeadline("F2");
		//Hold the actual results in one array and hold the expected in another
		Integer [] actualDeadlines = {actualDeadline, actualDeadline2};
		Integer [] expectedDeadlines = {EXPECTED_DEADLINE, EXPECTED_DEADLINE2};
		
		//Compare expected with actual
		assertEquals(expectedDeadlines, actualDeadlines,
				"Getting flow F1's deadline and then flow F2's deadline from stressTest4.txt");
	}

	@Test
	void testGetFlowTxPerLink() {
		//Based on what I learned from investigating the code, getFlowTxPerLink will always return 1 
		//initiate an expectedValue to 1
		Integer EXPECTED_VALUE = 1;
		//initiate actualValue
		Integer actualValue = stressTest4WorkLoad.getFlowTxPerLink("F8");
		
		assertEquals(EXPECTED_VALUE, actualValue, "Flow 'F8' txPerLink returned");
	}
	
	@Test
	void testGetFlowTxPerLinkNewFlowNoNodes() {
		//Based on what I learned from investigating the code, getFlowTxPerLink will always return 1 
		//initiate an expectedValue to 1
		Integer EXPECTED_VALUE = 1;
		Integer actualValue;
		
		//add flow with no nodes
		stressTest4WorkLoad.addFlow("F13");
		//initiate actualValue
		actualValue = stressTest4WorkLoad.getFlowTxPerLink("F13");
		
		assertEquals(EXPECTED_VALUE, actualValue, "New flow 'F13' txPerLink returned");
	}
	
	@Test
	void testSetFlowsInRMorderOnce() {
		//Expected order of flows
		String EXPECTED_FLOWS = "[F1, F2, F3, F4, F5, F6, F7, F8, F9, F10]";
		String actualFlows;
		//Arrange flows by period
		stressTest4WorkLoad.setFlowsInRMorder();
		
		//Actual order of flows
		actualFlows = stressTest4WorkLoad.getFlowNamesInPriorityOrder().toString();
		//Compare expected with actual
		assertEquals(EXPECTED_FLOWS, actualFlows,
				"Flows in stressTest4.txt arranged by period");
	}
	@Test
	void testSetFlowsInRMorderOverwrite() {
		//Expected order of flows arranged by period
		String EXPECTED_FLOWS = "[F1, F2, F3, F4, F5, F6, F7, F8, F9, F10]";
		String actualFlows;
		
		//Arrange in order according to period twice
		stressTest4WorkLoad.setFlowsInRMorder();
		stressTest4WorkLoad.setFlowsInRMorder();
		 
		//Actual order of flows arranged by period
		actualFlows = stressTest4WorkLoad.getFlowNamesInPriorityOrder().toString();
		//Compare expected with actual
		assertEquals(EXPECTED_FLOWS, actualFlows,
				"Flows in stressTest4.txt after being arranged by period twice");

	}
	@Test
	void testSetFlowsInRMorderMultiple() {
		//Expected flows for both files being arranged by period
		String EXPECTED_FLOWS = "[F1, F2, F3, F4, F5, F6, F7, F8, F9, F10]";
		String EXPECTED_FLOWS2 = "[F1B, F1A]";
		String [] expectedFlowsArray = {EXPECTED_FLOWS, EXPECTED_FLOWS2};

		
		//Arrange stressTest4.txt's flows by period
		stressTest4WorkLoad.setFlowsInRMorder();
		//Arrange Test1.txt's flows by period
		test1WorkLoad.setFlowsInRMorder();
		
		//Using an array to compare both results at once
		String [] actualFlowsArray = {stressTest4WorkLoad.getFlowNamesInPriorityOrder().toString(),
				test1WorkLoad.getFlowNamesInPriorityOrder().toString()};
		//Convert arrays to strings
		String expectedFlows = Arrays.toString(expectedFlowsArray);
		String actualFlows = Arrays.toString(actualFlowsArray);
		//Compare expected with actual
		assertEquals(expectedFlows, actualFlows,
				"Flows in stressTest4.txt and Test1.txt being arranged by period");
	}
	
	@Test
	void testSetFlowsInRMorderLargeAlphanumeric() {
		//Arrange flows by period
		seeSprayWorkLoad.setFlowsInRMorder();
		//Expected order of flows
		String EXPECTED_FLOWS = "[F6A, F6B, F2A, F28A, F16A, F28B, F2B, F16B, F24A, F12A, F24B, "
				+ "F12B, F20A, F20B, F7B, F7A, F19A, F3B, F19B, F3A, F27A, F15A, F27B, F15B, F23A, "
				+ "F11A, F23B, F11B, F8A, F8B, F4A, F18A, F4B, F18B, F26A, F14A, F26B, F14B, F22A, F10A, "
				+ "F22B, F10B, F30A, F30B, F9B, F9A, F5B, F5A, F29A, F17A, F29B, F1B, F17B, F1A, F25A, F13A, "
				+ "F25B, F13B, F21A, F21B]"; 
		//Actual order of flows
		String actualFlows = seeSprayWorkLoad.getFlowNamesInPriorityOrder().toString();
		//Compare expected with actual
		assertEquals(EXPECTED_FLOWS, actualFlows,
				"Large number of alphanumeric flows in SeeSpray.txt arranged by period");
	}

	@Test
	void testGetNodesOrderedAlphabetically() {
		//create String array that contains the expected values
		String[] EXPECTED = {"A","B","C","D","E","F","G","H","I","J","K","L"};
		//order the nodes found in actualWorkLoad alphabetically
		String[] actualNodes = stressTest4WorkLoad.getNodesOrderedAlphabetically();
		
		assertTrue(Arrays.equals(EXPECTED, actualNodes), 
				"An array containg all nodes found in actualWorkLoad ordered alphabetically");
	}
	
	@Test
	void testGetNodesOrderedAlphabeticallyAddNumberNode() {
		//create String array that contains the expected values
		String[] EXPECTED = {"1","10","7","A","B","C","D","E","F","G","H","I","J","K","L","M","S","Z"};
		String[] actualNodes;
		
		//add some nodes, some being numbers, so we can see sorters efficiency
		stressTest4WorkLoad.addNodeToFlow("F3", "Z");
		stressTest4WorkLoad.addNodeToFlow("F9", "S");
		stressTest4WorkLoad.addNodeToFlow("F5", "M");
		stressTest4WorkLoad.addNodeToFlow("F1", "1");
		stressTest4WorkLoad.addNodeToFlow("F1", "7");
		stressTest4WorkLoad.addNodeToFlow("F1", "10");
		
		//order the nodes found in actualWorkLoad alphabetically
		actualNodes = stressTest4WorkLoad.getNodesOrderedAlphabetically();
		
		assertTrue(Arrays.equals(EXPECTED, actualNodes), 
				"An array containg all nodes found in actualWorkLoad ordered alphabetically");
	}
	
	@Test
	void testGetNodesOrderedAlphabeticallyAddNodes() {
		String[] actualNodes;
		//create String array that contains the expected values
		String[] EXPECTED = {"A","B","C","D","E","F","G","H","I","J","K","L", "M", "N", "S", "U", "Z"};
		
		//add some nodes, NOT in alphabetical order, so we can see sorters efficiency
		stressTest4WorkLoad.addNodeToFlow("F3", "Z");
		stressTest4WorkLoad.addNodeToFlow("F9", "S");
		stressTest4WorkLoad.addNodeToFlow("F5", "U");
		stressTest4WorkLoad.addNodeToFlow("F5", "M");
		stressTest4WorkLoad.addNodeToFlow("F1", "N");
		//order the nodes found in actualWorkLoad alphabetically
		actualNodes = stressTest4WorkLoad.getNodesOrderedAlphabetically();
		
		assertTrue(Arrays.equals(EXPECTED, actualNodes), 
				"An array containg all nodes found in actualWorkLoad ordered alphabetically");
	}

	@Test
	void testGetFlowNamesOnce() {
		//Flow names for stressTest4.txt
		String EXPECTED_FLOW_NAMES = "[F1, F5, F2, F4, F3, F6, F7, F8, F9, F10]";
		//Actual flow names using getFlowNames
		String actualFlowNames = Arrays.toString(stressTest4WorkLoad.getFlowNames());
		//Compare expected with actual
		assertEquals(EXPECTED_FLOW_NAMES, actualFlowNames,
				"Get flow names once for stressTest4.txt");
	}
	
	@Test
	void testGetFlowNamesAlphanumeric() {
		//The flow names of Test1.txt
		String EXPECTED_FLOW_NAMES = "[F1A, F1B]";
		//Actual flow names using getFlowNames
		String actualFlowNames = Arrays.toString(test1WorkLoad.getFlowNames());
		//Compare expected with actual
		assertEquals(EXPECTED_FLOW_NAMES, actualFlowNames,
				"Get flow names once for alphanumeric workload of Test1.txt");
	}

	@Test
	void testGetFlowNamesOverwrite() {
		//Flow names for stressTest4.txt
		String EXPECTED_FLOW_NAMES = "[F1, F5, F2, F4, F3, F6, F7, F8, F9, F10]";
		//Actual flow names using getFlowNames multiple times
		String actualFlowNames = Arrays.toString(stressTest4WorkLoad.getFlowNames());
		//Overwrite itself using same method again
		actualFlowNames = Arrays.toString(stressTest4WorkLoad.getFlowNames());
		//Compare expected with actual
		assertEquals(EXPECTED_FLOW_NAMES, actualFlowNames,
				"Get flow names of stressTest4.txt after already getting them once");
	}
	
	@Test
	void testGetFlowNamesLargeAlphanumeric() {
		//The flow names of SeeSpray.txt
		String EXPECTED_FLOW_NAMES = "[F1A, F1B, F2A, F2B, F3A, F3B, F4A, F4B, F5A, F5B, F6A, F6B, F7A, F7B, "
				+ "F8A, F8B, F9A, F9B, F10A, F10B, F11A, F11B, F12A, F12B, F13A, F13B, F14A, F14B, F15A, F15B, "
				+ "F16A, F16B, F17A, F17B, F18A, F18B, F19A, F19B, F20A, F20B, F21A, F21B, F22A, F22B, F23A, F23B, "
				+ "F24A, F24B, F25A, F25B, F26A, F26B, F27A, F27B, F28A, F28B, F29A, F29B, F30A, F30B]";
		//Actual flow names using getFlowNames
		String actualFlowNames = Arrays.toString(seeSprayWorkLoad.getFlowNames());
		//Compare expected with actual
		assertEquals(EXPECTED_FLOW_NAMES, actualFlowNames,
				"Get flow names once for large alphanumeric workload of SeeSpray.txt");
	}
	
	@Test
	void testGetNodeIndex() {
		/* After examining file, this is an array of how letters corresponding indexes
		 * should appear in the array*/
		Integer[] ACTUAL_INDEX = {3, 0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11};
		//For this test, I'm sorting nodes found in actualWorkLoad alphabetically
		String[] nodesInDoc = stressTest4WorkLoad.getNodesOrderedAlphabetically();
		//I'm then putting it's corresponding index into an Integer array
		Integer[] nodeIndexes = new Integer[nodesInDoc.length];
	
		for(int i = 0; i < nodesInDoc.length; i++) {
			//putting letters corresponding index into nodeIndexes
			nodeIndexes[i] = stressTest4WorkLoad.getNodeIndex(nodesInDoc[i]);
		}
		
		//check if the arrays are equal
		assertTrue(Arrays.equals(nodeIndexes, ACTUAL_INDEX), 
				"An array containg the indexes of nodes, corresponding to the name of the "
				+ "Node in alphabetical order");
	}

	@Test
	void testGetNodeIndexExisting() {
		/* After examining file, this is an array of how letters corresponding indexes
		 * should appear in the array*/
		Integer[] ACTUAL_INDEXES = {3, 0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11};
		//For this test, I'm sorting nodes found in actualWorkLoad alphabetically
		String[] nodesInDoc = stressTest4WorkLoad.getNodesOrderedAlphabetically();
		//I'm then putting it's corresponding index into an Integer array
		Integer[] nodeIndexes = new Integer[nodesInDoc.length];
		
		/* adding an already existing node, index should remain the same,
		 * for this example adding A who's index should remain 3*/
		stressTest4WorkLoad.addNodeToFlow("F1", "A"); //flow F1 does not have a node A
		
		for(int i = 0; i < nodesInDoc.length; i++) {
			//putting letters corresponding index into nodeIndexes
			nodeIndexes[i] = stressTest4WorkLoad.getNodeIndex(nodesInDoc[i]);
		}
		
		
		//check if the arrays are equal
		assertTrue(Arrays.equals(nodeIndexes, ACTUAL_INDEXES), 
				"An array containg the indexes of nodes, corresponding to the name of the "
				+ "Node in alphabetical order");
	}
	
	@Test
	void testGetNodeIndexAddNodes() {
		/* After examining file, this is an array of how letters corresponding indexes
		 * should appear in the array*/
		Integer[] ACTUAL_INDEXES = {3, 0, 1, 2, 4, 5, 6, 7, 8, 9, 10, 11, 14, 13, 15, 12};
		String[] nodesInDoc;
		Integer[] nodeIndexes;
		
		//Going to add some nodes to make sure indexes increment correctly
		stressTest4WorkLoad.addNodeToFlow("F5", "Z");
		stressTest4WorkLoad.addNodeToFlow("F3", "S");
		stressTest4WorkLoad.addNodeToFlow("F9", "M");
		stressTest4WorkLoad.addNodeToFlow("F2", "X");
						
		//For this test, I'm sorting nodes found in actualWorkLoad alphabetically
		nodesInDoc = stressTest4WorkLoad.getNodesOrderedAlphabetically();
		//I'm then putting it's corresponding index into an Integer array
		nodeIndexes = new Integer[nodesInDoc.length];
		
		for(int i = 0; i < nodesInDoc.length; i++) {
			//putting letters corresponding index into nodeIndexes
			nodeIndexes[i] = stressTest4WorkLoad.getNodeIndex(nodesInDoc[i]);
		}
		
		
		//check if the arrays are equal
		assertTrue(Arrays.equals(nodeIndexes, ACTUAL_INDEXES), 
				"An array containg the indexes of nodes, corresponding to the name of the "
				+ "Node in alphabetical order");
	}
	
	@Test
	void testGetNodesInFlowOnce() {
		//Nodes in flow 'F5' of stressTest4.txt
		String EXPECTED_NODES = "[A, B, C, D, E]";
		//Actual nodes in flow 'F5' of stressTest4.txt
		String actualNodes = Arrays.toString(stressTest4WorkLoad.getNodesInFlow("F5"));
		//Compare actual with expected
		assertEquals(EXPECTED_NODES, actualNodes,
				"Get nodes in flow F5 of stressTest4.txt");
	}

	@Test
	void testGetNodesInFlowMultiple() {
		//Nodes in flows 'F1', 'F2', and 'F5' of stressTest4.txt
		String EXPECTED_NODES_F1 = "[B, C, D]";
		String EXPECTED_NODES_F2 = "[C, D, E, F, G, H, I]";
		String EXPECTED_NODES_F5 = "[A, B, C, D, E]";
		//Actual nodes in flow 'F1' of stressTest4.txt
		String actualNodesF1 = Arrays.toString(stressTest4WorkLoad.getNodesInFlow("F1"));
		//Actual nodes in flow 'F2' of stressTest4.txt
		String actualNodesF2 = Arrays.toString(stressTest4WorkLoad.getNodesInFlow("F2"));
		//Actual nodes in flow 'F5' of stressTest4.txt
		String actualNodesF5 = Arrays.toString(stressTest4WorkLoad.getNodesInFlow("F5"));
		//Use arrays to compare all results at once
		String [] expectedNodesArray = {EXPECTED_NODES_F1, EXPECTED_NODES_F2, EXPECTED_NODES_F5};
		String [] actualNodesArray = {actualNodesF1, actualNodesF2, actualNodesF5};
		//Convert arrays to strings
		String expectedNodes = Arrays.toString(expectedNodesArray);
		String actualNodes = Arrays.toString(actualNodesArray);
		//Compare actual with expected
		assertEquals(expectedNodes, actualNodes.toString(),
				"Get nodes in flows F1, F2, and F5 of stressTest4.txt");
	}
	
	@Test
	void testGetHyperPeriod() {
		Integer EXPECTED_HYPERPERIOD = 300;
		Integer actualHyperPeriod;
		//hyperPeriod just means the LCM of all the distinct periods//
		//for this workLoad we should get a hyper period of 300 --> the LCM of (20, 75, 50, 100)
		actualHyperPeriod = stressTest4WorkLoad.getHyperPeriod();
		
		assertEquals(EXPECTED_HYPERPERIOD, actualHyperPeriod, "actualWorkLoad's hyperPeriod returned");
	}
	
	@Test
	void testGetHyperPeriodAddFlow() {
		Integer EXPECTED_HYPERPERIOD = 2100;
		Integer actualHyperPeriod;
		//now we are going to add a flow and set its period
		stressTest4WorkLoad.addFlow("F13");
		stressTest4WorkLoad.setFlowPeriod("F13", 35);
		//our new expectedHyperPeriod should be 2100 -> LCM of (20, 75, 50, 100, 35)
		actualHyperPeriod = stressTest4WorkLoad.getHyperPeriod();
		
		assertEquals(EXPECTED_HYPERPERIOD, actualHyperPeriod, 
				"hyperPeriod returned should reflect the addition of a new flow, 'F13'");
	}

	@Test
	void testGetHyperPeriodNoSpecifiedPeriods() {
		//creating a WorkLoad who's flow's do not explicitly have periods
		WorkLoad actualWorkLoad = new WorkLoad(3.0, 2.0, "Example2.txt");
		//when flow periods not specified all periods default to 100, making LCM of all periods 100
		Integer expectedHyperPeriod = 100;
		Integer actualHyperPeriod = actualWorkLoad.getHyperPeriod();
		
		assertEquals(expectedHyperPeriod, actualHyperPeriod, 
				"hyperPeriod of a WorkLoad who's flows do not explicityly have periods listed");
	}
	
	@Test
	void testGetTotalCommunicationCostOnce() {
		//Expected communication cost of flow 'F1' should be 2
		Integer EXPECTED_COMMUNICATION_COST = 2;
		//Get actual communication cost
		Integer actualTotalCommunicationCost = stressTest4WorkLoad.getTotalCommunicationCost("F1");
		//Compare actual communication cost of flow 'F1' with expected
		assertEquals(EXPECTED_COMMUNICATION_COST, actualTotalCommunicationCost,
				"Get flow F1's total communication cost in stressTest4.txt");
	}
	
	@Test
	void testGetTotalCommunicationCostAlphanumeric() {
		//Expected communication cost of flow 'F1A' should be 1
		Integer EXPECTED_COMMUNICATION_COST = 1;
		//Get actual communication cost of flow 'F1A'
		Integer actualTotalCommunicationCost = test1WorkLoad.getTotalCommunicationCost("F1A");
		//Compare actual communication cost of flow 'F1' with expected
		assertEquals(EXPECTED_COMMUNICATION_COST, actualTotalCommunicationCost,
				"Get flow F1A's total communication cost from alphanumeric workload of Test1.txt");
	}
	
	@Test
	void testGetTotalCommunicationCostMultiple() {
		//Expected communication cost of flow 'F1' should be 2
		Integer EXPECTED_COMMUNICATION_COST_F1 = 2;
		//Expected communication cost of flow 'F2' should be 6
		Integer EXPECTED_COMMUNICATION_COST_F2 = 6;
		//Expected communication cost of flow 'F3' should be 5
		Integer EXPECTED_COMMUNICATION_COST_F3 = 5;
		//Put expected results in array
		Integer [] expectedTotalCommunicationCostArray = {EXPECTED_COMMUNICATION_COST_F1,
				EXPECTED_COMMUNICATION_COST_F2, EXPECTED_COMMUNICATION_COST_F3};
		//Put actual results in array
		Integer [] actualTotalCommunicationCostArray = {stressTest4WorkLoad.getTotalCommunicationCost("F1"),
				stressTest4WorkLoad.getTotalCommunicationCost("F2"), stressTest4WorkLoad.getTotalCommunicationCost("F3")};
		//Convert arrays to strings
		String expectedTotalCommunicationCost = Arrays.toString(expectedTotalCommunicationCostArray);
		String actualTotalCommunicationCost = Arrays.toString(actualTotalCommunicationCostArray);
		//Compare actual communication cost of flows 'F1', 'F2', and 'F3' with expected
		assertEquals(expectedTotalCommunicationCost, actualTotalCommunicationCost,
				"Get flows F1, F2, and F3's total communication cost from stressTest4.txt");
	}
	
	@Test
	void testGetLinkCommunicationCosts() {
		Integer[] EXPECTED_COSTS = {1, 1, 0};
		Integer[] linkCosts;
		/* In linkCommunicationCosts each node has a cost depending on how many other 
		 * nodes it communicates with. It's expected that each node in the flow will 
		 * have a cost of 1, EXCEPT for the last one who's cost is 0, because it doesn't
		 * communicate with anyone, all these values are stored in an array*/
		//so F1's array should look like [1,1,0] b/c it has three total nodes in it's flow
		linkCosts = stressTest4WorkLoad.getLinkCommunicationCosts("F1");
		
		assertTrue(Arrays.equals(EXPECTED_COSTS, linkCosts), 
				"LinkCommunicationCost of flow, 'F1' returned");
		
	}
	
	@Test
	void testGetLinkCommunicationCostsOneNode() {
		Integer[] EXPECTED_COSTS = {};
		Integer[] linkCosts;
		//add flow
		stressTest4WorkLoad.addFlow("F17");
		//add one node to that flow
		stressTest4WorkLoad.addNodeToFlow("F17", "A");
		//with one node that doesn't communicate to any other node the array should be empty --> I believe
		linkCosts = stressTest4WorkLoad.getLinkCommunicationCosts("F17");
		
		assertTrue(Arrays.equals(EXPECTED_COSTS, linkCosts), 
				"LinkCommunicationCost of flow, 'F17' returned");
		
	}


	@Test
	void testMaxFlowLengthOnce() {
		//Expected max flow length of stressTest4.txt is 8
		Integer EXPECTED_MAX_FLOW_LENGTH = 8;
		//Find actual using function
		Integer actualMaxFlowLength = stressTest4WorkLoad.maxFlowLength();
		//Compare expected with actual
		assertEquals(EXPECTED_MAX_FLOW_LENGTH, actualMaxFlowLength,
				"Max flow length of a workload of stressTest4.txt");
	}
	
	@Test
	void testMaxFlowLengthOverwrite() {
		//Expected max flow length of stressTest4.txt is 8
		Integer EXPECTED_MAX_FLOW_LENGTH = 8;
		//Find actual using function twice, see if it changes anything
		Integer actualMaxFlowLength = stressTest4WorkLoad.maxFlowLength();
		//Overwrite itself using method again
		actualMaxFlowLength = stressTest4WorkLoad.maxFlowLength();
		//Compare expected with actual
		assertEquals(EXPECTED_MAX_FLOW_LENGTH, actualMaxFlowLength,
				"Max flow length of a workload of stressTest4.txt using the method twice");
	}
	
	@Test
	void testMaxFlowLengthAlphanumeric() {
		//Expected max flow length of Test1.txt is 2
		Integer EXPECTED_MAX_FLOW_LENGTH = 2;
		//Find actual using function twice, see if it changes anything
		Integer actualMaxFlowLength = test1WorkLoad.maxFlowLength();
		//Compare expected with actual
		assertEquals(EXPECTED_MAX_FLOW_LENGTH, actualMaxFlowLength,
				"Max flow length of a workload of Test1.txt with alphanumeric flows");
	}
	
	@Test
	void testMaxFlowLengthLargeAlphanumeric() {
		//Expected max flow length of SeeSpray.txt
		Integer EXPECTED_MAX_FLOW_LENGTH = 2;
		//Find actual max flow length
		Integer actualMaxFlowLength = seeSprayWorkLoad.maxFlowLength();
		//Compare expected with actual
		assertEquals(EXPECTED_MAX_FLOW_LENGTH, actualMaxFlowLength,
				"Max flow length of a workload of SeeSpray.txt with a large number of flows");
	}

}
