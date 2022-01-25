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

  /**
   * This method should load a string into your TicTacToeBoard class.
   * @param board The string representing the board
   */
  public TicTacToeBoard(String board) {

  }

  /**
   * Checks the state of the board (unreachable, no winner, X wins, or O wins)
   * @return an enum value corresponding to the board evaluation
   */
  public Evaluation evaluate() {
    return Evaluation.UnreachableState;
  }
}
