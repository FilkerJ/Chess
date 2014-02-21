package model;

import model.*;
import model.Pawn;
import model.Rook;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RookTest extends ChessPieceTest {

   @Override
   protected IChessPiece make(Player p) {
      return new Rook(p);
   }

   @Override
   protected Move getValidMove(int row, int col) {
      int newRow = row + 1;

      return new Move(row, col, newRow, col);
   }

   @Test
   public void canMoveInRow() throws Exception {
      board.set(piece, 1, 1);
      assertTrue("Rook Test 1", piece.isValidMove(new Move(1, 1, 1, 6), board));
   }

   @Test
   public void canMoveInColumn() throws Throwable {
	   board.set(piece, 1, 1);
       assertTrue("Rook Test 2", piece.isValidMove(new Move(1, 1, 6, 1), board));
   }

   @Test
   public void cannotMoveDiagonal() throws Throwable {
	  board.set(piece, 1, 1);
      assertFalse("Rook Test 3", piece.isValidMove(new Move(1, 1, 3, 3), board));
   }
   
   @Test
   public void cannotMoveIfPieceInTheWay() throws Throwable { 
	   board.set(piece, 7, 0);
	   board.set(new Pawn(Player.WHITE), 5, 0);
	   assertFalse(piece.isValidMove(new Move(7, 0, 4, 0), board));
   }
   
   @Test
   public void canMoveBackwards() throws Throwable { 
	   board.set(piece, 7, 0);
	   assertTrue(piece.isValidMove(new Move(7, 0, 4, 0), board));
   }
   
   @Test
   public void canMoveCloseInRow() throws Exception {
      board.set(piece, 1, 1);
      assertTrue("Rook Test 1", piece.isValidMove(new Move(1, 1, 1, 2),
    		  board));
   }

   @Test
   public void canMoveCloseInColumn() throws Throwable {
	   board.set(piece, 1, 1);
       assertTrue("Rook Test 2", piece.isValidMove(new Move(1, 1, 0, 1),
    		   board));
   }
   
   @Test
   public void cantMoveAnywhereElse() throws Throwable {
	   board.set(piece, 4, 4);
	   
	   for (int r = 0; r < 8; r++){
			for (int c = 0; c < 8; c++){
				if ( r != 4 && c != 4 || r == 4 && c == 4)
					assertFalse(piece.isValidMove(new Move(4, 4, r, c), 
							board));
				else
					assertTrue(piece.isValidMove(new Move(4, 4, r, c), 
							board));
			}
	   }
   }

}