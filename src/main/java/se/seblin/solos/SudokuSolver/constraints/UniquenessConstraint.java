package se.seblin.solos.SudokuSolver.constraints;

import se.seblin.solos.SudokuSolver.entity.Cell;

import java.util.ArrayList;
import java.util.List;

public class UniquenessConstraint {

  private List<Cell> belongingCells = new ArrayList<>();

  public UniquenessConstraint() {}

  public UniquenessConstraint(List<Cell> belongingCells) {

    this.belongingCells = belongingCells;

  }

  public void addCell(Cell newCell) {
    belongingCells.add(newCell);
  }

  public List<Cell> getBelongingCells() {
      return belongingCells;
  }
}
