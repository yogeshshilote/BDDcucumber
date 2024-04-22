package cucumber1;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
	public static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = createInstance("Report/extent.html");
        }
        return extent;
    }

    private static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
        htmlReporter.config().setCss("C:\\Users\\yoges\\eclipse-workspace\\cucumber1\\src\\main\\resource\\extent-report.css"); // Set the path to your custom CSS file
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        return extent;
    }

}
