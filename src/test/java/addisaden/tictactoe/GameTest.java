package addisaden.tictactoe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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

    /**
     * Setze auf belegtes Feld
     */
    @Test(expected = IllegalArgumentException.class)
    public void testGameInvalidMove() throws IllegalArgumentException
    {
        game.move(0);
        game.move(0);
    }

    /**
     * Setze auf ungültiges Feld
     */
    @Test(expected = IndexOutOfBoundsException.class)
    public void testGameInvalidPositionOnMove() throws IndexOutOfBoundsException
    {
        game.move(-1);
    }

    /**
     * Ausgabe des TicTacToes
     */
    @Test
    public void testGameStringGamefield()
    {
        assertEquals("  |   |  \n  |   |  \n  |   |  ", game.toString());
        game.move(0);
        assertEquals("X |   |  \n  |   |  \n  |   |  ", game.toString());
        game.move(8);
        assertEquals("X |   |  \n  |   |  \n  |   | O", game.toString());
    }
}
