package addisaden.tictactoe;

class Game
{
  private int[] spielfeld = new int[9];

  Game()
  {
    for(int i = 0; i < spielfeld.length; i++)
    {
      spielfeld[i] = 0;
    }
  }

  public void print_spielfeld()
  {
    for(int i = 0; i < spielfeld.length; i++)
    {
      System.out.print(spielfeld[i]);
      System.out.print(" ");

      if(i % 3 == 2)
        System.out.println();
    }
  }
}