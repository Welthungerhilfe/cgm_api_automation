package api.utils;

import java.io.File;

public class OutputUtil extends PathConfig{

    public static void createOutputDirectory() {
        String timestamp = System.getProperty("current.date");
        String outputDirName = "Output_" + timestamp;

        /** Output Directory Structure Definition **/
        PathConfig.setOutputDirName(outputDirName);
        PathConfig.setOutputDir("./Output/" + outputDirName);
        //PathConfig.setReportsPath(PathConfig.getOutputDir() + File.separator + "Reports" + File.separator);
        PathConfig.setApplogsPath(PathConfig.getOutputDir() + File.separator + "logs" + File.separator);

        new File(PathConfig.getOutputDir()).mkdir();
        new File(PathConfig.getlogsPath()).mkdir();
        //new File(PathConfig.getReportsPath()).mkdir();
    }
    

	public static void main(String a[])
    {
    	OutputUtil msr = new OutputUtil();
    System.out.println();
    }

}
