package com.example;


import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TicTacToeBoardTest {
  /*
   * Testing strategy
   *
   * Partitions evaluate() inputs as follows:
   * InvalidBoard_IllegalArgumentException, InvalidBoard, ValidBoardNowinner, ValidBoardXwins, and ValidBoardOwins.
   */

  @Test (expected = IllegalArgumentException.class)
  public void testInvalidBoard_IllegalArgumentException() {
    TicTacToeBoard board = new TicTacToeBoard("O..X.");
  }


  @Test
  public void testInvalidBoard_MoveNumber() {
    TicTacToeBoard board = new TicTacToeBoard("X.X.XO.XO");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }

  @Test
  public void testInvalidBoard_DoubleWin() {
    TicTacToeBoard board = new TicTacToeBoard(".OX.OX.OX");
    assertEquals(Evaluation.UnreachableState, board.evaluate());
  }

  @Test
  public void testValidBoardNoWinner_Unfinished() {
    TicTacToeBoard board = new TicTacToeBoard("XOOOX..X.");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }

  @Test
  public void testValidBoardNoWinner_Finished() {
    TicTacToeBoard board = new TicTacToeBoard("XOOOXXXXO");
    assertEquals(Evaluation.NoWinner, board.evaluate());
  }

  @Test
  public void testValidBoardXWins_Vertical() {
    TicTacToeBoard board = new TicTacToeBoard(".XOOX..X.");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValidBoardXWins_CaseSensitive() {
    TicTacToeBoard board = new TicTacToeBoard("oOx.X.x..");
    assertEquals(Evaluation.Xwins, board.evaluate());
  }

  @Test
  public void testValidBoardOWins_Horizontal() {
    TicTacToeBoard board = new TicTacToeBoard("x..OoOX..");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValidBoardOWins_SpecialCharacters() {
    TicTacToeBoard board = new TicTacToeBoard("?oXxO^xO7");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValidBoardOWins_Diagonal() {
    TicTacToeBoard board = new TicTacToeBoard("O.XXo..xO");
    assertEquals(Evaluation.Owins, board.evaluate());
  }

  @Test
  public void testValidBoardOWins_DoubleWin() {
    TicTacToeBoard board = new TicTacToeBoard("OXoOoXOxX");
    assertEquals(Evaluation.Owins, board.evaluate());
  }
}
