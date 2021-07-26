/**
 * 
 */
package edu.uiowa.cs.warp;

/**
 * @author sgoddard
 *
 */
abstract class VisualizationObject {

	private FileManager fm;
	private String suffix;
	private String nameExtension;
	private static final String NOT_IMPLEMENTED = "This visualization has not been implemented.";

	VisualizationObject(FileManager fm, WorkLoad workLoad, String suffix) {
		this.fm = fm;
		this.nameExtension = String.format("-%sM-%sE2E",String.valueOf(workLoad.getMinPacketReceptionRate()),String.valueOf(workLoad.getE2e())); 
		this.suffix = suffix; 
	}
	
	VisualizationObject(FileManager fm, SystemAttributes warp, String suffix) {
		this.fm = fm;
		if (warp.getNumFaults() > 0) {
			this.nameExtension = nameExtension(warp.getSchedulerName(),
					warp.getNumFaults()); 
		} else {
			this.nameExtension = nameExtension(warp.getSchedulerName(),
					warp.getMinPacketReceptionRate(),
					warp.getE2e()); 
		}
		this.suffix = suffix;
	}
	
	VisualizationObject(FileManager fm, SystemAttributes warp, String nameExtension, String suffix) {
		this.fm = fm;
		if (warp.getNumFaults() > 0) {
			this.nameExtension = nameExtension(warp.getSchedulerName(),
					warp.getNumFaults()) + nameExtension; 
		} else {
			this.nameExtension = nameExtension(warp.getSchedulerName(),
					warp.getMinPacketReceptionRate(),
					warp.getE2e()) + nameExtension; 
		}
		
		this.suffix = suffix;
	}
	
	VisualizationObject(FileManager fm, String nameExtension, String suffix) {
		this.fm = fm;
		this.nameExtension = nameExtension; 
		this.suffix = suffix;
	}
	
	private String nameExtension(String schName, Double m, double e2e) {
		String extension = String.format("%s-%sM-%sE2E",
				schName,
				String.valueOf(m),
				String.valueOf(e2e)); 
		return extension;
	}
	
	private String nameExtension(String schName, Integer numFaults) {
		String extension = String.format("%s-%sFaults",
				schName,
				String.valueOf(numFaults)); 
		return extension;
	}

	/**
	 * @return the fm
	 */
	public FileManager getFileManager() {
		return fm;
	}

	public Description visualization() {
		Description content = new Description();
		content.add(NOT_IMPLEMENTED);
		return content;
	}
	
	public String createFile (String fileNameTemplate) {
        return fm.createFile(fileNameTemplate, nameExtension, suffix );
    }
	
	public Description fileVisualization() {
		Description fileContent = createHeader();
    	fileContent.addAll(visualization());
    	fileContent.addAll(createFooter());
    	return fileContent;
	}
		
	public Description displayVisualization() {
		return visualization();
	}
	
	public Description createHeader ( )  {
		Description header = new Description();
		return header;
	}
	
	public Description createFooter ( )  {
		Description footer = new Description();
		return footer;
	}

}
