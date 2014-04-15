package addisaden.tictactoe;

class Game
{
  private int[] spielfeld = new int[9];

  /**
   * Zählt die Züge
   *
   * Wenn gerade, dann ist X am Zug. Ansonsten O.
   */
  private int current_move = 0;

  /**
   * Konstruktor initialisiert Spielfeld
   */
  Game()
  {
    for(int i = 0; i < spielfeld.length; i++)
    {
      spielfeld[i] = 0;
    }
  }

  /**
   * Ziehe auf das Feld angegebene Feld
   */
  public void move(int position) throws IndexOutOfBoundsException, IllegalArgumentException
  {
    is_valid_position(position);
    is_empty_position(position);

    spielfeld[position] = (current_move % 2) + 1;
    current_move++;
  }

  public int get(int position) throws IndexOutOfBoundsException
  {
    is_valid_position(position);

    return spielfeld[position];
  }

  public int winner()
  {
    int[][] winner_positions = {
      {0, 1, 2},
      {3, 4, 5},
      {6, 7, 8},
      {0, 3, 6},
      {1, 4, 7},
      {2, 5, 8},
      {0, 4, 8},
      {2, 4, 6}
    };

    for(int i = 0; i < winner_positions.length; i++) {
      int a = spielfeld[winner_positions[i][0]];
      int b = spielfeld[winner_positions[i][1]];
      int c = spielfeld[winner_positions[i][2]];

      if(a > 0 && a == b && a == c) {
        return a;
      }
    }

    return 0;
  }

  public boolean end()
  {
    if(winner() > 0)
      return true;

    boolean result = true;

    for(int i = 0; i < spielfeld.length; i++)
    {
      if(spielfeld[i] == 0)
      {
        result = false;
        break;
      }
    }

    return result;
  }

  /**
   * String-Repräsentation des Spielfeldes
   */
  public String toString()
  {
    String result = "";
    Integer tmp = null;

    for(int i = 0; i < spielfeld.length; i++)
    {
      switch(spielfeld[i]) {
        case 0: result += " ";
                break;
        case 1: result += "X";
                break;
        case 2: result += "O";
                break;
      }

      if(i % 3 != 2)
        result += " | ";
      else if(i < spielfeld.length - 1)
        result += "\n";
    }

    return result;
  }

  /**
   * Überprüft ob ein Feld existiert
   */
  private void is_valid_position(int position) throws IndexOutOfBoundsException
  {
    if(position < 0 || position >= spielfeld.length)
      throw new IndexOutOfBoundsException("Position nicht vorhanden");
  }

  /**
   * Überprüft ob ein Feld schon belegt ist
   */
  private void is_empty_position(int position) throws IllegalArgumentException
  {
    if(spielfeld[position] != 0)
      throw new IllegalArgumentException("Position ist nicht leer");
  }
}