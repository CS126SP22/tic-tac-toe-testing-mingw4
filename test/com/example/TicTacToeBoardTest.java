package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TicTacToeBoardTest {
  /*
   * Testing strategy
   *
   * Partitions evaluate() outcomes as follows:
   * UnreachableState, Nowins, Xwins, Owins, and IllegalArgumentException
   */


  private boolean
  @Test
  public void testValidBoardNoWinner() {
    TicTacToeBoard board = new TicTacToeBoard("O...X.X..");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }
}
