package pt.isel.mpd14.utestfw;

public interface Test {

    /**
     * Gets the name of a TestCase
     *
     * @return the name of the TestCase
     */
    public String getName();

    /**
     * Runs a test and collects its result in a TestResult instance.
     *
     * @param result
     */
    public void run(TestResult result);
}
