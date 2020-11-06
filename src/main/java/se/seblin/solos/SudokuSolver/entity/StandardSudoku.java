package se.seblin.solos.SudokuSolver.entity;

import se.seblin.solos.SudokuSolver.constraints.UniquenessConstraint;

import java.util.HashMap;
import java.util.Map;

public class StandardSudoku extends Sudoku {

  private Map<Integer, UniquenessConstraint> rowConstraints = new HashMap();
  private Map<Integer, UniquenessConstraint> columnConstraints = new HashMap();
  private Map<Integer, UniquenessConstraint> squareConstraints = new HashMap();

  public StandardSudoku() {

    charSet = new char[] {'1','2','3','4','5','5','6','7','8','9'};
    size = charSet.length;

    cellGrid = new Cell[size][size];

    for (int i = 0; i < size; i++) {
      UniquenessConstraint rowConstraint = new UniquenessConstraint(charSet);
      UniquenessConstraint columnConstraint = new UniquenessConstraint(charSet);
      UniquenessConstraint squareConstraint = new UniquenessConstraint(charSet);

      listOfConstraints.add(rowConstraint);
      listOfConstraints.add(columnConstraint);
      listOfConstraints.add(squareConstraint);

      rowConstraints.put(i, rowConstraint);
      rowConstraints.put(i, columnConstraint);
      rowConstraints.put(i, squareConstraint);
    }

    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        Cell newCell = new Cell(this.charSet);
        Integer currentSquare = i/3 + j/3;

        rowConstraints.get(i).addCell(newCell);
        columnConstraints.get(j).addCell(newCell);
        squareConstraints.get(currentSquare).addCell(newCell);

        cellGrid[i][j] = newCell;

      }
    }
  }

}


