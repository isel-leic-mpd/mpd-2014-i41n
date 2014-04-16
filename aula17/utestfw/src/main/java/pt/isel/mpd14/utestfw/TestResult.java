/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pt.isel.mpd14.utestfw;

/**
 *
 * @author Miguel Gamboa at CCISEL
 */
public interface TestResult {

    /**
     * Adds an error to the list of errors. The passed in exception caused the
     * error.
     * @param test
     * @param t
     */
    void addError(Test test, Throwable t);

    /**
     * Adds a failure to the list of failures. The passed in exception caused
     * the failure.
     * @param test
     * @param t
     */
    void addFailure(Test test, AssertionFailedError t);

    /**
     * Informs the result that a test was completed.
     * @param test
     */
    void endTest(Test test);

    /**
     * Gets the number of detected errors.
     * @return
     */
    int errorCount();

    /**
     * Gets the number of detected failures.
     * @return
     */
    int failureCount();

    void printReport();

    /**
     * Gets the number of run tests.
     * @return
     */
    int runCount();

    /**
     * Informs the result that a test will be started.
     * @param test
     */
    void startTest(Test test);

    /**
     * Returns whether the entire test was successful or not.
     * @return
     */
    boolean wasSuccessful();
    
}
