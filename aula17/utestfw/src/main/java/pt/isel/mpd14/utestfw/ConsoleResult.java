package pt.isel.mpd14.utestfw;

import java.util.LinkedList;
import java.util.List;

/**
 * A <code>TestResult</code> collects the results of executing a test case. 
 * The test framework distinguishes between <i>failures</i> and <i>errors</i>. 
 * A failure is anticipated and checked for with assertions. 
 * Errors are unanticipated problems like an {@link ArrayIndexOutOfBoundsException}.
 *
 * @see Test
 */
public class ConsoleResult implements TestResult{

    protected List<TestStatus> fTestsStatus;
    protected int fRunTests, fErrors, fFailures;

    public ConsoleResult() {
        fTestsStatus = new LinkedList<>();
    }

    /**
     * Adds an error to the list of errors. The passed in exception caused the
     * error.
     * @param test
     * @param t
     */
    @Override
    public  void addError(Test test, Throwable t) {
        fTestsStatus.add(new TestStatusError(test.getName(), t));
        fErrors++;
    }

    /**
     * Adds a failure to the list of failures. The passed in exception caused
     * the failure.
     * @param test
     * @param t
     */
    @Override
    public void addFailure(Test test, AssertionFailedError t) {
        fTestsStatus.add(new TestStatusFailure(test.getName(), t));
        fFailures++;
    }

    /**
     * Informs the result that a test was completed.
     * @param test
     */
    @Override
    public void endTest(Test test) {
        fTestsStatus.add(new TestStatusSucceeded(test.getName()));
    }

    /**
     * Gets the number of detected errors.
     * @return 
     */
    @Override
    public int errorCount() {
        return fErrors;
    }

    /**
     * Gets the number of detected failures.
     * @return 
     */
    @Override
    public int failureCount() {
        return fFailures;
    }

    /**
     * Gets the number of run tests.
     * @return 
     */
    @Override
    public int runCount() {
        return fRunTests;
    }

    /**
     * Informs the result that a test will be started.
     * @param test
     */
    @Override
    public void startTest(Test test) {
        fRunTests++;
    }

    /**
     * Returns whether the entire test was successful or not.
     * @return 
     */
    @Override
    public boolean wasSuccessful() {
        return failureCount() == 0 && errorCount() == 0;
    }

    @Override
    public void printReport() {
        for (TestStatus ts : fTestsStatus) {
            System.out.println(ts);
        }
    }
}
