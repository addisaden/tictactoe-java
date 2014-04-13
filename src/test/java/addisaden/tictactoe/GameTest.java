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
     * Teste ob man auf jedes Feld ziehen kann
     */
    @Test
    public void testGameMoveToEveryPosition() throws Exception
    {
        // no moves
        for(int i = 0; i < 9; i++) {
            assertEquals(0, game.get(i));
        }

        // x Moves
        for(int i = 0; i < 9; i++) {
            Game g = new Game();

            g.move(i);

            assertEquals(1, g.get(i));
        }

        // o Moves
        for(int i = 0; i < 9; i++) {
            Game g = new Game();

            if(i == 0)
                g.move(1);
            else
                g.move(0);

            g.move(i);

            assertEquals(2, g.get(i));
        }
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
