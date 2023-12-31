package api.utilities;

import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;

public class ExtentReport {
    public static ExtentReports report=null;
    public static String extentreportpath="";


    //To avoid external initialization
    private ExtentReport() {
        extentreportpath=Constants.EXTENTREPORTPATH;
        report=new ExtentReports(extentreportpath);
        report.loadConfig(new File(Constants.EXTENTCONFIGFILEPATH));

    }

    public static void initialize()
    {
        new ExtentReport();
    }


}
