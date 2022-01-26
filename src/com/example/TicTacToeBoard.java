package com.example;

/**
 * Takes in and evaluates a string representing a tic tac toe board.
 */


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
    int count = 1;
    for (int column = 0; column < dimension; column++) {
      if (unified_board.charAt(column * dimension + column) != player) {
        count = 0;
      }
    }
    return count;
  }



  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins)
   * @return an enum value corresponding to the board evaluation
   */
  public Evaluation evaluate() {
    //Check whether the board is legal by checking length.

    return Evaluation.UnreachableState;
  }
}
