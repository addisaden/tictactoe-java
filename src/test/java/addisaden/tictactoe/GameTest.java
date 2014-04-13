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
    public void setUp()
    {
        game = new Game();
    }

    /**
     * Teste ob man auf jedes Feld ziehen kann
     */
    @Test
    public void testGameMoveToEveryPosition() throws Exception
    {
        // no moves
        for(int i = 0; i < 9; i++)
        {
            assertEquals(0, game.get(i));
        }

        // x Moves
        for(int i = 0; i < 9; i++)
        {
            Game g = new Game();

            g.move(i);

            assertEquals(1, g.get(i));
        }

        // o Moves
        for(int i = 0; i < 9; i++)
        {
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
     * Teste Gewinner
     */
    @Test
    public void testGameWinner()
    {
        int[][] winnerpositions = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6}
        };

        int[] loosermoves = {0, 1, 4, 5, 6, 8, 2, 3, 7};

        for(int i = 0; i < winnerpositions.length; i++)
        {
            int[] wp = winnerpositions[i];


            Game x_game = new Game();

            for(i = 0; i < 3; i++)
            {
                assertEquals(0, x_game.winner());

                x_game.move(wp[i]);

                if(i >= 2)
                    break;

                for(int j = 0; j < loosermoves.length; j++) {
                    if(x_game.get(loosermoves[j]) != 0)
                        continue;

                    if( loosermoves[j] != wp[0] &&
                        loosermoves[j] != wp[1] &&
                        loosermoves[j] != wp[2]) {
                        x_game.move(loosermoves[j]);
                        break;
                    }
                }
            }

            assertEquals(1, x_game.winner());


            Game o_game = new Game();

            for(i = 0; i < 3; i++)
            {
                assertEquals(0, o_game.winner());

                for(int j = 0; j < loosermoves.length; j++) {
                    if(o_game.get(loosermoves[j]) != 0)
                        continue;

                    if( loosermoves[j] != wp[0] &&
                        loosermoves[j] != wp[1] &&
                        loosermoves[j] != wp[2]) {
                        o_game.move(loosermoves[j]);
                        break;
                    }
                }

                o_game.move(wp[i]);
            }

            assertEquals(2, o_game.winner());
        }
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
