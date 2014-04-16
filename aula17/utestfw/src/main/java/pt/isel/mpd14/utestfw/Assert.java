package pt.isel.mpd14.utestfw;

/**
 * A set of assert methods.  Messages are only displayed when an assert fails.
 */

public class Assert {

	/**
	 * Asserts that two objects are equal. If they are not
	 * an AssertionFailedError is thrown with the given message.
	 */
	static void assertEquals(String message, Object expected, Object actual) {
		if (expected == null && actual == null)
			return;
		if (expected != null && expected.equals(actual))
			return;
		throw new AssertionFailedError(message != null? message : "" + " expected:<"+expected+"> but was:<"+actual+">");
	}
	/**
	 * Asserts that two objects are equal. If they are not
	 * an AssertionFailedError is thrown.
	 */
	static public void assertEquals(Object expected, Object actual) {
	    assertEquals(null, expected, actual);
	}
}
