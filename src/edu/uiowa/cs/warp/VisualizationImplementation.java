/**
 * 
 */
package edu.uiowa.cs.warp;

import java.io.File;

/**
 * @author sgoddard
 *
 */
public class VisualizationImplementation implements Visualization {
	
	private Description visualization;
	private Description fileContent; 
	private Description displayContent;
	private String fileName;
	private String inputFileName;
	private String fileNameTemplate;
	private FileManager fm = null; 
	private Warp warp = null;
	private WorkLoad workLoad = null;

		
	public VisualizationImplementation(Warp warp,
			String outputDirectory, SystemChoices choice) {
		this.fm = new FileManager();
		this.warp = warp;
		inputFileName = warp.toWorkload().getInputFileName();
		this.fileNameTemplate  = createFileNameTemplate(outputDirectory);
		createVisualization(choice);
	}
	
	public VisualizationImplementation(WorkLoad workLoad,  
			String outputDirectory, WorkLoadChoices choice) {
		this.fm = new FileManager();
		this.workLoad = workLoad;
		inputFileName = workLoad.getInputFileName();
		this.fileNameTemplate  = createFileNameTemplate(outputDirectory);
		createVisualization(choice);
	}

	@Override
	public void toDisplay() {
		System.out.println(displayContent.toString());
	}

	@Override
	public void toFile() {
		fm.writeFile(fileName,fileContent.toString());
	}
	
	@Override
	public String toString() {
		return visualization.toString();
	}
	
	private void createVisualization(SystemChoices choice) {
		switch (choice) { // select the requested visualization
		case SOURCE:
			createVisualization(new ProgramVisualization(warp));
			break;

		case RELIABILITIES:
			// TODO Implement Reliability Analysis Visualization
			createVisualization(new ReliabilityVisualization(warp));
			break;

		case SIMULATOR_INPUT:
			// TODO Implement Simulator Input Visualization
			createVisualization(new NotImplentedVisualization("SimInputNotImplemented"));
			break;
		
		case LATENCY_REPORT:
			createVisualization(new ReportVisualization(fm, warp,
					warp.toProgram().latencyReport(), "Latency"));	
			break;
		
		case DEADLINE_REPORT:
			createVisualization(new ReportVisualization(fm, warp,
					warp.toProgram().deadlineMisses(), "DeadlineMisses"));	
			break;
			
		default:	
			createVisualization(new NotImplentedVisualization("UnexpectedChoice"));
			break;
		}
	}
	
	private void createVisualization(WorkLoadChoices choice) {
		switch (choice) { // select the requested visualization
		case COMUNICATION_GRAPH:
			// createWarpVisualization();
			createVisualization(new CommunicationGraph(fm, workLoad));
			break;

		case GRAPHVIZ:
			createVisualization(new GraphViz(fm, workLoad.toString()));	
			break;
			
		case INPUT_GRAPH:
			createVisualization(workLoad);	
			break;
			
		default:	
			createVisualization(new NotImplentedVisualization("UnexpectedChoice"));
			break;
		}
	}
	
	private <T extends VisualizationObject> void createVisualization(T obj) {
		visualization = obj.visualization();
		fileContent = obj.fileVisualization();
		/* display is file content printed to console */
		displayContent = obj.displayVisualization(); 
		fileName = obj.createFile (fileNameTemplate); // in output directory
	}
	
	private String createFileNameTemplate(String outputDirectory) {
		String fileNameTemplate;
		var workingDirectory = fm.getBaseDirectory();
		var newDirectory = fm.createDirectory(workingDirectory, outputDirectory);
		// Now create the fileNameTemplate using full output path and input filename 
		if (inputFileName.contains("/")) {
			var index = inputFileName.lastIndexOf("/")+1;
			fileNameTemplate = newDirectory + File.separator + inputFileName.substring(index);
		} else {
			fileNameTemplate = newDirectory + File.separator + inputFileName;
		}
		return fileNameTemplate;
	}
	
}
