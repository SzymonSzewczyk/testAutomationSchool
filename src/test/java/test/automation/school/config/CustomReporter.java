package test.automation.school.config;

import org.apache.commons.io.FileUtils;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CustomReporter implements IReporter {

    @Override
    public synchronized void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectoryName) {
        File report = new File("target" +File.separator + "summary.log");
        List<String> output = new ArrayList<>();
        suites.forEach(suite -> suite.getResults().forEach((name, result) -> {
            output.add(name + ":");
            output.add("    Passed: " + result.getTestContext().getPassedTests().size());
            output.add("    Failed: " + result.getTestContext().getFailedTests().size());
        }));
        try {
            FileUtils.writeLines(report, output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
