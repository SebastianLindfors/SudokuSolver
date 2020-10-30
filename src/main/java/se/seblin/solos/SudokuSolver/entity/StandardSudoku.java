package se.seblin.solos.SudokuSolver.entity;

import se.seblin.solos.SudokuSolver.constraints.UniquenessConstraint;

public class StandardSudoku extends Sudoku {

  public StandardSudoku() {

    charSet = new char[] {'1','2','3','4','5','5','6','7','8','9'};
    size = charSet.length;

    cellGrid = new Cell[size][size];
    for (int i = 0; i < size; i++) {
      UniquenessConstraint rowConstraint = new UniquenessConstraint(charSet);

      for (int j = 0; j < size; j++) {

        cellGrid[i][j] = new Cell(' ', this.charSet);
        rowConstraint.addCell(cellGrid[i][j]);
      }
    }
  }

}


