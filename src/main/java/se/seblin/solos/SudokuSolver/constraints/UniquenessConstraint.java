package se.seblin.solos.SudokuSolver.constraints;

import se.seblin.solos.SudokuSolver.entity.Cell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UniquenessConstraint {

  private boolean violated;

  private char[] charSet;
  
  private List<Cell> belongingCells = new ArrayList<>();
  private List<Character> allowedCharacters;

  private Map<Character, Integer> charCounts = new HashMap<>();

  public UniquenessConstraint(char[] charSet) {

    this.charSet = charSet;
    this.update();

  }

  public UniquenessConstraint(List<Cell> belongingCells, char[] charSet) {

    this.charSet = charSet;
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

    this.setCharCountsToZero();
    this.violated = false;

    for (Cell belongingCell:belongingCells) {
     //System.out.println("Cell Value: " + belongingCell.getValue()); //DEBUGGING LINE
      if (belongingCell.isEmpty) {
        continue;
      }
      charCounts.put(belongingCell.getValue(), charCounts.get(belongingCell.getValue()) + 1);
      if (charCounts.get(belongingCell.getValue()) > 1) {
        this.violated = true;
      }
    }

    this.allowedCharacters = new ArrayList<>();
    for (Character charSetChar:charSet) {
      if (charCounts.get(charSetChar) == 0) {
        this.allowedCharacters.add(charSetChar);
      }
    }



  }

  public List<Character> getListOfAllowedValues() {
    return this.allowedCharacters;
  }

  // ----- Private Methods ----- //

  private void setCharCountsToZero() {

    for (Character charSetChar:charSet) {
      charCounts.put(charSetChar, 0);
    }

  }

}
