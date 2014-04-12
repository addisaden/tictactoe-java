package addisaden.tictactoe;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class GameTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public GameTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( GameTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testGameMove()
    {
        Game g = new Game();
        try {
            g.move(0);
            g.move(0);
            assert(false);
        } catch (Exception e) {
            assert(true);
        }
    }
}
