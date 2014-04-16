package pt.isel.mpd14.utestfw.app;

import pt.isel.mpd14.utestfw.Assert;
import pt.isel.mpd14.utestfw.ConsoleResult;
import pt.isel.mpd14.utestfw.Expect;
import pt.isel.mpd14.utestfw.TestCase;
import pt.isel.mpd14.utestfw.TestRunner;



public class AppTestCalculator {

    public static void main(String[] args) throws Exception {
        TestRunner tr = new TestRunner(new ConsoleResult());
        tr.doRun(new TestAdd());
        tr.doRun(new TestSub());
        // tr.doRun(new TestDiv1());
        // tr.doRun(new TestDiv2());
        tr.printReport();

    }
}


class TestAdd extends TestCase {

    public TestAdd() {
        super("Test Add function");
    }

    @Override
    public void runTest() {
        Assert.assertEquals(7, new Calculator().add(3, 4));
    }
}

class TestSub extends TestCase {

    public TestSub() {
        super("Test Sub function");
    }

    @Override
    public void runTest() {
        Assert.assertEquals(-3, new Calculator().sub(3, 7));
    }
}

@Expect(ArithmeticException.class)
class TestDiv1 extends TestCase {

    public TestDiv1() {
        super("Test Div1 function");
    }

    @Override
    public void runTest() {
        new Calculator().div(3, 0);
    }
}

@Expect(ArithmeticException.class)
class TestDiv2 extends TestCase {

    public TestDiv2() {
        super("Test Div2 function");
    }

    @Override
    public void runTest() {
        new Calculator().div(0, 2);
    }
}
