package com.example;


/**
 * Rule extends as follows in higher n * n dimensions:
 *
 * The player who succeeds in placing the number of dimension
 * of his/her mark in a horizontal or vertical row wins.
 *
 * The player who succeeds in filling one of the diagonals
 * fully with his/hers mark wins.
 */

public class TicTacToeBoard {
  int dimension;
  String board;

  /**
   * This method should load a string into your TicTacToeBoard class.
   * @param board The string representing the board
   */
  public TicTacToeBoard(String board) {
    //standard 3 * 3 TicTacToeBoard.
    this.dimension = 3;
    this.board = board;
    if (board.length() != (dimension * dimension)) {
      throw new IllegalArgumentException("Board is illegal due to incorrect string length.");
    }
  }

  /**
   * This method should return the result whether certain player fills all positions on a certain row.
   * @param  player The checked player in lower case.
   * @return times horizontal condition for possible wins are reached.
   */
  private int CheckHorizontals (char player) {
    String unified_board = board.toLowerCase();
    //count times at which requirements are satisfied.
    int count = 0;
    for (int row = 0; row < dimension; row++) {
      boolean win = true;
      for (int column = 0; column < dimension; column++) {
        if (unified_board.charAt(row * dimension + column) != player) {
          win = false;
          break;
        }
      }
      if (win) {
        count++;
      }
    }
    return count;
  }

  /**
   * This method should return the result whether certain player fills all positions on a certain column.
   * @param  player The checked player in lower case.
   * @return times vertical condition for possible wins are reached.
   */
  private int CheckVerticals (char player) {
    String unified_board = board.toLowerCase();
    //count times at which requirements are satisfied.
    int count = 0;
    for (int column = 0; column < dimension; column++) {
      boolean win = true;
      for (int row = 0; row < dimension; row++) {
        if (unified_board.charAt(row * dimension + column) != player) {
          win = false;
          break;
        }
      }
      if (win) {
        count++;
      }
    }
    return count;
  }


  /**
   * This method should return the result whether certain player fills all positions on the diagonal.
   * @param  player The checked player in lower case.
   * @return times Diagonal condition for possible wins are reached.
   */
  private int CheckDiagonal (char player) {
    String unified_board = board.toLowerCase();
    //count times at which requirements are satisfied.
    int countRight = 1;
    for (int column = 0; column < dimension; column++) {
      if (unified_board.charAt(column * dimension + column) != player) {
        countRight = 0;
      }
    }
    int countLeft = 1;
    for (int row = dimension; row > 0; row--) {
      if (unified_board.charAt(row * dimension - row) != player) {
          countLeft = 0;
      }
    }
    return countLeft + countRight;
  }



  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins)
   * @return an enum value corresponding to the board evaluation
   */
  public Evaluation evaluate() {
    //Check whether the board is legal by checking length.
    if (board.length() != (dimension * dimension)) {
      throw new IllegalArgumentException("Board is illegal due to incorrect string length.");
    }

    //Unify the board by changing all characters into lower cases.
    String unified_board = board.toLowerCase();

    //Count the number of moves of x and o;
    int xnum = 0;
    int onum = 0;

    for (int pos = 0; pos < board.length(); pos++) {
      char curr = unified_board.charAt(pos);
      if (curr == 'x') {
        xnum++;
      } else if (curr == 'o') {
        onum++;
      }
    }

    //Check whether the board is invalid.

    //Check number of moves.
    if (Math.abs(xnum - onum) > 1) {
      return Evaluation.UnreachableState;
    }

    //Count win times.
    int xWinTimes;
    int oWinTimes;
    xWinTimes = CheckDiagonal('x') + CheckHorizontals('x') + CheckVerticals('x');
    oWinTimes = CheckDiagonal('o') + CheckHorizontals('o') + CheckVerticals('o');

    //Check different players double win.
    if (xWinTimes != 0 && oWinTimes != 0) {
      return Evaluation.UnreachableState;
    }

    //Check same player, the number of same type of Horizontal or Vertical win is larger than 1.
    if (CheckHorizontals('x') > 1 || CheckHorizontals('y') > 1
            || CheckVerticals('x') > 1 || CheckVerticals('y') > 1) {
      return Evaluation.UnreachableState;
    }

    //Check if x wins.
    if (CheckDiagonal('x') == 1 || CheckDiagonal('x') == 2 || CheckHorizontals('x') == 1 || CheckVerticals('x') == 1) {
      return Evaluation.Xwins;
    }

    //Check if o wins.
    if (CheckDiagonal('o') == 1 || CheckDiagonal('o') == 2 || CheckHorizontals('o') == 1 || CheckVerticals('o') == 1) {
      return Evaluation.Owins;
    }

    //If x didn't win, o didn't win, and the board is valid, then there is no winner.
    return Evaluation.NoWinner;
  }
}
