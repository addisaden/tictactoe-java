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

            for(int j = 0; j < 3; j++)
            {
                assertEquals(0, x_game.winner());

                x_game.move(wp[j]);

                if(j >= 2)
                    break;

                for(int k = 0; k < loosermoves.length; k++) {
                    if( loosermoves[k] != wp[0] &&
                        loosermoves[k] != wp[1] &&
                        loosermoves[k] != wp[2] &&
                        x_game.get(loosermoves[k]) == 0)
                    {
                        x_game.move(loosermoves[k]);
                        break;
                    }
                }
            }

            assertEquals(1, x_game.winner());


            Game o_game = new Game();

            for(int j = 0; j < 3; j++)
            {
                assertEquals(0, o_game.winner());

                for(int k = 0; k < loosermoves.length; k++) {
                    if( loosermoves[k] != wp[0] &&
                        loosermoves[k] != wp[1] &&
                        loosermoves[k] != wp[2] &&
                        o_game.get(loosermoves[k]) == 0)
                    {
                        o_game.move(loosermoves[k]);
                        break;
                    }
                }

                o_game.move(wp[j]);
            }

            assertEquals(2, o_game.winner());
        }
    }

    /**
     * Game gibt an ob ein Test zuende ist
     *
     * Ein Spiel sollte zuende sein, wenn jemand gewonnen hat
     * oder alle Felder belegt sind.
     */
    @Test
    public void testGameEnds()
    {
        Game empty_game = new Game();
        assertEquals(false, empty_game.end());

        int[][] endgames = {
            {0, 4, 1, 3, 2},
            {0, 3, 1, 4, 6, 5},
            {0, 1, 2, 4, 3, 5, 7, 6, 8}
        };

        for(int endgame = 0; endgame < endgames.length; endgame++)
        {
            Game the_endgame = new Game();
            int[] endgame_moves = endgames[endgame];

            // Set moves
            for(int endgame_move = 0; endgame_move < endgame_moves.length; endgame_move++)
            {
                the_endgame.move(endgame_moves[endgame_move]);
            }

            assertEquals(true, the_endgame.end());
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
