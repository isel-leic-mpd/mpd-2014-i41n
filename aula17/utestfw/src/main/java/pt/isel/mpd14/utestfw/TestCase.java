package pt.isel.mpd14.utestfw;

public abstract class TestCase implements Test {

    /**
     * the name of the test case
     */
    private final String fName;

    /**
     * Constructs a test case with the given name.
     *
     * @param name
     */
    public TestCase(String name) {
        fName = name;
    }

    /**
     * Gets the name of a TestCase
     *
     * @return the name of the TestCase
     */
    @Override
    public String getName() {
        return fName;
    }

    /**
     * Runs a test and collects its result in a TestResult instance.
     *
     * @param result
     */
    @Override
    public void run(TestResult result) {
        try {
            result.startTest(this);
            runTest();
            result.endTest(this);

        } catch (AssertionFailedError e) {
            result.addFailure(this, e);
        } catch (RuntimeException e) {
            result.addError(this, e);
            throw e;
        }
    }

    /**
     * Override to run the test and assert its state.
     */
    public abstract void runTest();

    /**
     * Returns a string representation of the test case
     */
    @Override
    public String toString() {
        return getName() + "(" + getClass().getName() + ")";
    }
}
