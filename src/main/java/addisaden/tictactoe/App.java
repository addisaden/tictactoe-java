package addisaden.tictactoe;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
        Game the_game = new Game();

        the_game.move(0);
        the_game.move(1);
        the_game.move(2);

        System.out.println(the_game);
    }
}
