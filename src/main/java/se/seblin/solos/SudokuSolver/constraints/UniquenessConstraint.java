package se.seblin.solos.SudokuSolver.constraints;

import se.seblin.solos.SudokuSolver.entity.Cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniquenessConstraint {

  private char[] charSet;

  private boolean violated;

  private List<Cell> belongingCells = new ArrayList<>();

  private Map<Character, Integer> charCounts = new HashMap<>();

  public UniquenessConstraint(char[] charSet) {

    this.charSet = charSet;
    this.setCharCountsToZero();

  }

  public UniquenessConstraint(List<Cell> belongingCells, char[] charSet) {

    this.charSet = charSet;
    this.setCharCountsToZero();

    this.belongingCells = belongingCells;
    this.update();

  }

  public void addCell(Cell newCell) {
    belongingCells.add(newCell);
    this.update();
  }

  public List<Cell> getBelongingCells() {
      return belongingCells;
  }

  public boolean isViolated() { return violated; }

  public void setViolated(boolean newValue) {this.violated = newValue; }

  public void update() {
    //TODO Check all cells and update
  }

  public char[] getListOfAllowedValues() {

    //TODO Real code here
    return new char[0];
  }

  // ----- Private Methods ----- //

  private void setCharCountsToZero() {

    for (Character charSetChar:charSet) {
      charCounts.put(charSetChar, 0);
    }

  }

}
