package addisaden.tictactoe;

class Game
{
  private int[] spielfeld = new int[9];

  private int current_move = 0;

  Game()
  {
    for(int i = 0; i < spielfeld.length; i++)
    {
      spielfeld[i] = 0;
    }
  }

  public void move(int position) throws IndexOutOfBoundsException, IllegalArgumentException
  {
    is_valid_position(position);
    is_empty_position(position);

    spielfeld[position] = (current_move % 2) + 1;
    current_move++;
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

  private void is_valid_position(int position) throws IndexOutOfBoundsException
  {
    if(position < 0 || position >= spielfeld.length)
      throw new IndexOutOfBoundsException("Position nicht vorhanden");
  }

  private void is_empty_position(int position) throws IllegalArgumentException
  {
    if(spielfeld[position] != 0)
      throw new IllegalArgumentException("Position ist nicht leer");
  }
}