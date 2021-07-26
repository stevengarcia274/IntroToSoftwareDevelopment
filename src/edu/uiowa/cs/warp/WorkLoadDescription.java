/**
 * 
 */
package edu.uiowa.cs.warp;

/**
 * @author sgoddard
 *
 */
public class WorkLoadDescription extends VisualizationObject {

	private static final String EMPTY = "";
	private static final String INPUT_FILE_SUFFIX = ".wld";
	
	private Description description;
	private String inputGraphString;
	private FileManager fm; 
	private String inputFileName;

	WorkLoadDescription(String inputFileName){
		super(new FileManager(), EMPTY, INPUT_FILE_SUFFIX); // VisualizationObject constructor
		this.fm = this.getFileManager();
		initialize(inputFileName);
	}

	@Override
	public Description visualization() {
		return description;
	}

	@Override
	public Description fileVisualization() {
		return description;
	}

//	@Override
//	public Description displayVisualization() {
//		return description;
//	}
	
	@Override
	public String toString() {
		return inputGraphString;
	}
	
	public String getInputFileName() {
		return inputFileName;
	}

	private void initialize(String inputFile) {
		// Get the input graph file name and read its contents
		InputGraphFile gf = new InputGraphFile(fm);
		inputGraphString = gf.readGraphFile(inputFile);
		this.inputFileName = gf.getGraphFileName();
		description = new Description(inputGraphString);
	}
}
