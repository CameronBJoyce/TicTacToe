package edu.wofford;

import org.junit.*;
import static org.junit.Assert.*;
import org.hamcrest.MatcherAssert.*;

public class TicTacToeModelTest {


   @Test
   public void testMakeMoveCenterRight() {
      TicTacToeModel ticTacTest = new TicTacToeModel();
      ticTacTest.makeMove(1,2);
      assertEquals("1 2 is a legal move","X" ,ticTacTest.getMark(1,2));
   }
   @Test
   public void testMakeMoveOutsideBoard() {
      TicTacToeModel ticTacTest = new TicTacToeModel();
      ticTacTest.makeMove(1,3);
      for(int r = 0; r <3; r++) {
         for(int c = 0; c <3; c++) {
            assertEquals(" ", ticTacTest.getMark(r,c));
         }
      }
      ticTacTest.makeMove(4,0);
      for(int r = 0; r <3; r++) {
         for(int c = 0; c <3; c++) {
            assertEquals(" ", ticTacTest.getMark(r,c));
         }
      }
      ticTacTest.makeMove(-1,-3);
      for(int r = 0; r <3; r++) {
         for(int c = 0; c <3; c++) {
            assertEquals(" ", ticTacTest.getMark(r,c));
         }
      }
   }

   @Test
   public void testIsDraw() {
      TicTacToeModel ticTacTest = new TicTacToeModel();
      for(int r = 0; r <3; r++) {
         for(int c = 0; c <3; c++) {
            assertEquals(!ticTacTest.getMark(r,c).equals(" "),ticTacTest.isDraw());
         }
      }
   }

   @Test
   public void testConstructor() {
      TicTacToeModel ticTacTest = new TicTacToeModel();
      for(int r = 0; r <3; r++) {
         for(int c = 0; c <3; c++) {
            assertEquals(" ", ticTacTest.getMark(r,c));
         }
      }
   }
//
//   @Test
//   public void testIsDraw() {
//      String expectedMarks[] = {"X","O"};
//      TicTacToeModel ticTacTest = new TicTacToeModel();
//      for(int r = 0; r <3; r++) {
//         for(int c = 0; c <3; c++) {
//            assertTrue(ticTacTest.getMark(r,c)).isIn("X", "O");
//         }
//      }
//   }
   @Test
   public void testCheckWin() {
      TicTacToeModel ticTacTest = new TicTacToeModel();
      ticTacTest.makeMove(1,0);
      ticTacTest.makeMove(0,1);
      ticTacTest.makeMove(1,1);
      ticTacTest.makeMove(2,2);
      assertEquals(false, ticTacTest.didWin());
      ticTacTest.makeMove(1,2);
      assertEquals(true, ticTacTest.didWin());


   }
   @Test
   public void testPrintWinner() {
      TicTacToeModel ticTacTest = new TicTacToeModel();
     // assertEquals("true",true);
   }



   @Test
   public void testShowBoard() {
      TicTacToeModel ticTacTest = new TicTacToeModel();
      for(int r = 0; r < 4; r++) {
         for(int c = 0; c < 4; c++) {
       //     assertEquals();
         }
      }
   }


}