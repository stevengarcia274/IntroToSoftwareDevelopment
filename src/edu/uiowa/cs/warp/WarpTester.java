package edu.uiowa.cs.warp;



import argparser.ArgParser;
import argparser.BooleanHolder;
import argparser.DoubleHolder;
import argparser.StringHolder;
import edu.uiowa.cs.warp.SystemAttributes.ScheduleChoices;
import edu.uiowa.cs.warp.Visualization.SystemChoices;
import edu.uiowa.cs.warp.Visualization.WorkLoadChoices;
import argparser.IntHolder;



/**
 * @author sgoddard
 *
 */
public class WarpTester {

	private static final Integer NUM_CHANNELS = 16; // default number of wireless channels available for scheduling (command line option)
	private static final Double MIN_LQ = 0.9; // default minimum Link Quality in system (command line option)
	private static final Double E2E = 0.99; // default end-to-end reliability for all flows (command line option)
	private static final String DEFAULT_OUTPUT_SUB_DIRECTORY = "OutputFiles/";
	private static final ScheduleChoices DEFAULT_SCHEDULER = ScheduleChoices.PRIORITY;
	private static final Integer DEFAULT_FAULTS_TOLERATED = 0; 
	
	private static Integer nChannels; // number of wireless channels available for scheduling
	private static Integer numFaults; // number of faults tolerated per edge
	private static Double minLQ;  // global variable for minimum Link Quality in system, later we can add local minLQ for each link
	private static Double e2e;  // global variable for minimum Link Quality in system, later we can add local minLQ for each link
	private static String outputSubDirectory; // default output subdirectory (from working directory) where output files will be placed (e.g., gv, wf, ra)
	private static Boolean gvRequested; // GraphVis file requested flag
	private static Boolean wfRequested; // WARP file requested flag
	private static Boolean raRequested; // Reliability Analysis file requested flag
	private static Boolean simRequested; // Simulation file requested flag
	private static Boolean allRequested; // all out files requested flag
	private static Boolean latencyRequested; // latency report requested flag
	private static Boolean schedulerRequested = false;
	private static Boolean verboseMode; // verbose mode flag (mainly for running in IDE)
	private static String inputFile; // inputFile from which the graph workload is read
	private static ScheduleChoices schedulerSelected; // Scheduler requested
	
	public static void main(String[] args) {
		// parse command-line options and set WARP system parameters
		setWarpParameters(args);
		
		// and print out the values if in verbose mode
		if (verboseMode) {
			printWarpParameters();
		}
		
		// Create and visualize the workload
		// inputFile string, which may be null, 
		WorkLoad workLoad = new WorkLoad(numFaults, minLQ, e2e, inputFile); 
		if (allRequested) {
			for (WorkLoadChoices choice : WorkLoadChoices.values()) {
				visualize(workLoad, choice); // visualize all Program choices
			}
			// Create and visualize the Warp System
			if (schedulerRequested) {
				Warp warp = SystemFactory.create(workLoad,nChannels,schedulerSelected);
				verifyPerformanceRequirements(warp);
				for (SystemChoices choice : SystemChoices.values()) {
					visualize(warp, choice); // visualize all System choices
				}
			} else { // create a system for all scheduler choices
				for (ScheduleChoices sch: ScheduleChoices.values()) {
					schedulerSelected = sch;
					Warp warp = SystemFactory.create(workLoad,nChannels,schedulerSelected);
					verifyPerformanceRequirements(warp);
					for (SystemChoices choice : SystemChoices.values()) {
						visualize(warp, choice);  // visualize all System choices
					}
				}
			}
		} else { // visualize warp workload, source program and other requested items
			visualize(workLoad, WorkLoadChoices.INPUT_GRAPH);
			if (wfRequested) {
				visualize(workLoad, WorkLoadChoices.COMUNICATION_GRAPH);
			}
			if (gvRequested) {
				visualize(workLoad, WorkLoadChoices.GRAPHVIZ);
			}
			Warp warp = SystemFactory.create(workLoad,nChannels,schedulerSelected);
			verifyPerformanceRequirements(warp);
			visualize(warp, SystemChoices.SOURCE);
			if (latencyRequested) {
				visualize(warp, SystemChoices.LATENCY_REPORT);
			}
			if (raRequested) {
				visualize(warp, SystemChoices.RELIABILITIES);
			}			
		}
			
	}
	
	private static void visualize (WorkLoad workLoad, WorkLoadChoices choice) {
		var viz = VisualizationFactory.createWorkLoadVisualization(workLoad, 
				outputSubDirectory, choice);
		if (viz != null) {
			if (verboseMode) {
				viz.toDisplay();
			}
			viz.toFile();
		}
	}
	
	private static void visualize (Warp warp, SystemChoices choice) {
		var viz = VisualizationFactory.createProgramVisualization(warp, 
				outputSubDirectory, choice);
		if (viz != null) {
			viz.toFile();
		}
	}
	
	private static void verifyPerformanceRequirements(Warp warp) {
		verifyDeadlines(warp);
		verifyReliabilities(warp);
	}
	
	private static void verifyReliabilities(Warp warp) {
		if (schedulerSelected != ScheduleChoices.RTHART ) {
			/* RealTime HART doesn't adhere to reliability targets */	
			if (!warp.reliabilitiesMet()) {
				System.err.printf("\n\tERROR: Not all flows meet the end-to-end "
						+ "reliability of %s under %s scheduling.\n",
						String.valueOf(e2e), schedulerSelected.toString());
			} else if (verboseMode) {
				System.out.printf("\n\tAll flows meet the end-to-end reliability "
						+ "of %s under %s scheduling.\n",
						String.valueOf(e2e), schedulerSelected.toString());
			}
		}
	}

	private static void verifyDeadlines(Warp warp) {
		if (!warp.deadlinesMet()) {
			System.err.printf(
					"\n\tERROR: Not all flows meet their deadlines under %s scheduling.\n", 
					schedulerSelected.toString());
			visualize(warp, SystemChoices.DEADLINE_REPORT);
		} else if (verboseMode) {
			System.out.printf(
					"\n\tAll flows meet their deadlines under %s scheduling.\n", 
					schedulerSelected.toString());
		} 
	}
	
	private static void setWarpParameters (String[] args) { // move command line parsing into this function--need to set up globals?
		
		// create holder objects for storing results ...
	    // BooleanHolder debug = new BooleanHolder();
		StringHolder schedulerSelected = new StringHolder();
		IntHolder channels = new IntHolder();
		IntHolder faults = new IntHolder();
		DoubleHolder m = new DoubleHolder();
		DoubleHolder end2end = new DoubleHolder();
		BooleanHolder gv = new BooleanHolder();
		BooleanHolder wf = new BooleanHolder();
		BooleanHolder ra = new BooleanHolder();
		BooleanHolder s = new BooleanHolder();
		BooleanHolder all = new BooleanHolder();
		BooleanHolder latency = new BooleanHolder();
		BooleanHolder verbose = new BooleanHolder();
		StringHolder input = new StringHolder();
		StringHolder output = new StringHolder();
    
		// create the parser and specify the allowed options ...
		ArgParser parser = new ArgParser("java -jar warp.jar");
	    parser.addOption ("-sch, --schedule %s {priority,rm,dm,rtHart,poset} #scheduler options", schedulerSelected);
	    parser.addOption ("-c, --channels %d {[1,16]} #number of wireless channels", channels);
	    parser.addOption ("-m %f {[0.5,1.0]} #minimum link quality in the system", m);
	    parser.addOption ("-e, --e2e %f {[0.5,1.0]} #global end-to-end communcation reliability for all flows", end2end);
	    parser.addOption ("-f, --faults %d {[1,10]} #number of faults per edge in a flow (per period)", faults);
	    parser.addOption ("-gv %v #create a graph visualization (.gv) file for GraphViz", gv);
	    parser.addOption ("-wf  %v #create a WARP (.wf) file that shows the maximum number of transmissions on each segment of the flow needed to meet the end-to-end reliability", wf);
	    parser.addOption ("-ra  %v #create a reliability analysis file (tab delimited .csv) for the warp program", ra);
	    parser.addOption ("-s  %v #create a simulator input file (.txt) for the warp program", s);
	    parser.addOption ("-a, --all  %v #create all output files (activates -gv, -wf, -ra, -s)", all);
	    parser.addOption ("-l, --latency  %v #prints end-to-end latency for each flow instance", latency);
	    parser.addOption ("-i, --input %s #<InputFile> of graph flows (workload)", input);
	    parser.addOption ("-o, --output %s #<OutputDIRECTORY> where output files will be placed", output);
	    parser.addOption ("-v, --verbose %v #Echo input file name and parsed contents. Then for each flow instance: show maximum E2E latency and min/max communication cost for that instance of the flow", verbose);
	    // parser.addOption ("-d, -debug, --debug %v #Debug mode: base directory = $HOME/Documents/WARP/", debug);
		
    
		// match the arguments ...
		parser.matchAllArgs (args);
		
		// Set WARP system configuration options
		if (channels.value > 0) {
			nChannels = channels.value; // set option specified
		} else {
			nChannels = NUM_CHANNELS; // set to default
		}
		if (faults.value > 0) { // global variable for # of Faults tolerated per edge 
			numFaults = faults.value; // set option specified
		} else {
			numFaults = DEFAULT_FAULTS_TOLERATED; // set to default
		}
		if (m.value > 0.0) { // global variable for minimum Link Quality in system 
			minLQ = m.value; // set option specified
		} else {
			minLQ = MIN_LQ; // set to default
		}
		if (end2end.value > 0.0) { // global variable for minimum Link Quality in system
			e2e = end2end.value; // set option specified
		} else {
			e2e = E2E; // set to default
		}		
		if (output.value != null) { // default output subdirectory (from working directory)
			outputSubDirectory = output.value; // set option specified
		} else {
			outputSubDirectory = DEFAULT_OUTPUT_SUB_DIRECTORY; // set to default
		}

		gvRequested = gv.value; // GraphVis file requested flag
		wfRequested = wf.value; // WARP file requested flag
		raRequested = ra.value; // Reliability Analysis file requested flag
		simRequested = s.value; // Simulation file requested flag
		allRequested = all.value; // all out files requested flag
		latencyRequested = latency.value; // latency report requested flag
		verboseMode = verbose.value; // verbose mode flag (mainly for running in IDE)
		// debugMode = debug.value; // debug mode flag (mainly for running in IDE)
		inputFile = input.value; // input file specified
		if (schedulerSelected.value != null) {  // can't switch on a null value so check then switch
			schedulerRequested = true;
			switch (schedulerSelected.value) {
		        case "priority":
		        	WarpTester.schedulerSelected = ScheduleChoices.PRIORITY;
		            break;
		                
		        case "rm":
		        	WarpTester.schedulerSelected = ScheduleChoices.RM;
		            break;
		                 
		        case "dm":
		        	WarpTester.schedulerSelected = ScheduleChoices.DM;
		            break;
		            
		        case "rtHart":
		        	WarpTester.schedulerSelected = ScheduleChoices.RTHART;
		            break;
		                    
		        case "poset":
		        	WarpTester.schedulerSelected = ScheduleChoices.POSET_PRIORITY;
		            break;
		            
		        default:
		        	WarpTester.schedulerSelected = ScheduleChoices.PRIORITY;
		            break;
			}
		} else { // null value when no scheduler specified; so use default
			WarpTester.schedulerSelected = DEFAULT_SCHEDULER;
		}
	}
	
	private static void printWarpParameters ( ) {  // print all system configuration parameters
		// Print out each of the system configuration values
		System.out.println ("WARP system configuration values:");
		System.out.println ("\tScheduler=" + schedulerSelected);
		System.out.println ("\tnChanels=" + nChannels);
		System.out.println ("\tnumFaults=" + numFaults);
		System.out.println ("\tminLQ=" + minLQ);
		System.out.println ("\tE2E=" + e2e);
		System.out.println ("\tgvRequest flag=" + gvRequested);
		System.out.println ("\twfRequest flag=" + wfRequested);
		System.out.println ("\traRequest flag=" + raRequested);
		System.out.println ("\tsimRequest flag=" + simRequested);
		System.out.println ("\tallOutFilesRequest flag=" + allRequested);
		System.out.println ("\tlatency flag=" + latencyRequested);
		if (inputFile != null) {
			System.out.println ("\tinput file=" + inputFile);
		} else {
			System.out.println ("\tNo input file specified; will be requested when needed.");
		}
		System.out.println ("\toutputSubDirectory=" + outputSubDirectory);
		System.out.println ("\tverbose flag=" + verboseMode);
		// System.out.println ("\tdebug flag=" + debugMode);
	}
	
}
