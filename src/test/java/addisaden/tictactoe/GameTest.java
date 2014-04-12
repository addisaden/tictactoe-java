package addisaden.tictactoe;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class GameTest
{
    /**
     * Variable fuer das Testobjekt.
     */
    protected Game game;

    /**
     * Vorbereitungsarbeiten.
     */
    @Before
    public void setUp() {
        game = new Game();
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGameInvalidMove() throws IllegalArgumentException
    {
        game.move(0);
        game.move(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGameInvalidPositionOnMove() throws IndexOutOfBoundsException
    {
        game.move(-1);
    }
}
