package se.seblin.solos.SudokuSolver.entity;

import se.seblin.solos.SudokuSolver.constraints.UniquenessConstraint;

import java.util.HashMap;
import java.util.Map;

public class StandardSudoku extends Sudoku {

  public StandardSudoku() {

    charSet = new char[] {'1','2','3','4','5','5','6','7','8','9'};
    size = charSet.length;

    Map<Integer, UniquenessConstraint> rowConstraints = new HashMap();
    Map<Integer, UniquenessConstraint> columnConstraints = new HashMap();
    Map<Integer, UniquenessConstraint> squareConstraints = new HashMap();

    cellGrid = new Cell[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        Cell newCell = new Cell(this.charSet);
        Integer currentSquare = i/3 + j/3;

        rowConstraints.get(i).addCell(newCell);
        columnConstraints.get(i).addCell(newCell);
        squareConstraints.get(currentSquare).addCell(newCell);

        cellGrid[i][j] = newCell;

      }
    }
  }

}


