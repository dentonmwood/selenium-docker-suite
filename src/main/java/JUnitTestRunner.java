import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestPlan;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;

import static org.junit.platform.engine.discovery.DiscoverySelectors.selectPackage;

public class JUnitTestRunner {
    private SummaryGeneratingListener listener;

    public JUnitTestRunner() {
        this.listener = new SummaryGeneratingListener();
    }

    // Taken from https://www.baeldung.com/junit-tests-run-programmatically-from-java
    public void execute() {
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder.request()
                .selectors(selectPackage("com.baylor.ires.tests"))
                .build();
        Launcher launcher = LauncherFactory.create();
        TestPlan plan = launcher.discover(request);
        launcher.registerTestExecutionListeners(this.listener);
        launcher.execute(request);
    }

    public SummaryGeneratingListener getListener() {
        return this.listener;
    }
}
