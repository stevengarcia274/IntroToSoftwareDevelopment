/**
 * 
 */
package edu.uiowa.cs.warp;

/**
 * @author sgoddard
 *
 */
public interface Visualization {
	
	public enum SystemChoices {
		SOURCE, RELIABILITIES, SIMULATOR_INPUT, 
		LATENCY_REPORT, DEADLINE_REPORT
	}
	
	public enum WorkLoadChoices {
		INPUT_GRAPH, COMUNICATION_GRAPH, GRAPHVIZ
	}
	
	public void toDisplay();
	public void toFile();
	public String toString();
}
