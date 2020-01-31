import org.junit.platform.launcher.listeners.TestExecutionSummary;

import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) {
        JUnitTestRunner runner = new JUnitTestRunner();
        runner.execute();

        TestExecutionSummary summary = runner.getListener().getSummary();
        summary.printTo(new PrintWriter(System.out));
    }
}
