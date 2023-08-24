package api.test;

import api.utilities.Constants;
import api.utilities.ExtentReport;
import api.utilities.HelperUtility;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class BaseTest {

    @BeforeSuite
    public void setUpSuite() {
        ExtentReport.initialize();
        HelperUtility helper = new HelperUtility();
    }
    @AfterSuite
    public void afterSuite() throws IOException {
        ExtentReport.report.flush();
//        Uncomment this lines to launch browser and open report after execution
//        File htmlFile = new File(Constants.EXTENTREPORTPATH);
//        Desktop.getDesktop().browse(htmlFile.toURI());
    }


}
