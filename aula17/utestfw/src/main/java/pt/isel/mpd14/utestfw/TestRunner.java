package pt.isel.mpd14.utestfw;

/**
 * @uml.dependency supplier="utestfw.TestResult"
 */
public class TestRunner {

    private final TestResult view;

    public TestRunner(TestResult view) {
        this.view = view;
    }

    /**
     * Runs a test and collects its results on result argument.
     */
    TestResult doRun(Test test, TestResult result) {
        test.run(result);
        return result;
    }

    /**
     * Runs a test and collects its results on result argument.
     * @param test
     */
    public void doRun(Test test) {
        test.run(view);
    }

    public void printReport() {
        view.printReport();
    }
}
