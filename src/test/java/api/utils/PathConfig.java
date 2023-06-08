package api.utils;

public class PathConfig {

    private final static String PROPERTIES_ROUTES = "./cgm_api_automation/resources/routes.properties";
    private final static String PROPERTIES_LOG4J = "./cgm_api_automation/resources/log4j2.xml";

    private static String OUTPUT_DIR_NAME = "";
    private static String OUTPUT_DIR = "";
    private static String REPORTS_PATH = "";
    private static String APPLOGS_PATH = "";

    public static String getLog4JPropertiesPath() {
        return PROPERTIES_LOG4J;
    }

    public static String getOutputDirName() {
        return OUTPUT_DIR_NAME;
    }

    public static void setOutputDirName(String outputDirName) {
        OUTPUT_DIR_NAME = outputDirName;
    }

    public static String getOutputDir() {
        return OUTPUT_DIR;
    }

    public static void setOutputDir(String outputDir) {
        OUTPUT_DIR = outputDir;
    }

    public static String getReportsPath() {
        return REPORTS_PATH;
    }

    public static void setReportsPath(String reportsPath) {
        REPORTS_PATH = reportsPath;
    }

    public static String getlogsPath() {
        return APPLOGS_PATH;
    }

    public static void setApplogsPath(String applogsPath) {
        APPLOGS_PATH = applogsPath;
    }

    public static String getPropertiesRoutes() {
        return PROPERTIES_ROUTES;
    }

    public static String getPropertiesLog4j() {
        return PROPERTIES_LOG4J;
    }
    
	public static void main(String a[])
    {
    	PathConfig msr = new PathConfig();
    	 System.out.println();
    }
}
