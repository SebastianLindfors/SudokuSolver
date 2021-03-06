package se.seblin.solos.SudokuSolver.entity;

import se.seblin.solos.SudokuSolver.constraints.UniquenessConstraint;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {

  boolean valid = false;

  private char[] charSet;

  Cell[][] cellGrid;

  List<UniquenessConstraint> listOfConstraints = new ArrayList<>();

  String horizontalLine = "";

  int size;

  public Sudoku() {}

  public void updatePosition(int x, int y, char newCharacter) {

    boolean newCharacterInSet = false;
    for (char character:charSet) {
      if (character == newCharacter) {
        newCharacterInSet =true;
        break;
      }
    }
    if (!newCharacterInSet) {
      throw new IllegalArgumentException("The character " + newCharacter + " is not part of the charSet for this sudoku.");
    }
    cellGrid[x][y].setValue(newCharacter);
  }

  //----- Getters -----//

  public int getSize() {
    return size;
  }

  public boolean isValid() {
    return this.valid;
  }

  public void addConstraints(UniquenessConstraint newConstraint) {
    if (!listOfConstraints.contains(newConstraint)) {
      this.listOfConstraints.add(newConstraint);
    }
  }

  public void removeConstraints(UniquenessConstraint constraint) {
    if (listOfConstraints.contains(constraint)) {
      this.listOfConstraints.remove(constraint);
    }
    else {
      throw new IllegalArgumentException("Could not remove constraint: Not in sudoku constraint list");
    }
  }

  private void generateHorizontalLine() {
    for (int i = 0; i < charSet.length; i++) {
      this.horizontalLine += "__";
    }
    this.horizontalLine += "\n";
  }

  private boolean checkIfAnyConstraintsAreViolated() {
    for (UniquenessConstraint constraint : listOfConstraints) {
      if (constraint.isViolated()) {
        return true;
      }
    }
    return false;
  }

  private List<UniquenessConstraint> getViolatedConstraints() {
    List<UniquenessConstraint> violatedConstraints = new ArrayList<>();
    for (UniquenessConstraint constraint : listOfConstraints) {
      if (constraint.isViolated()) {
        violatedConstraints.add(constraint);
      }
    }
    return violatedConstraints;
  }

  private List<UniquenessConstraint> getNonViolatedConstraints() {
    List<UniquenessConstraint> nonViolatedConstraints = new ArrayList<>();
    for (UniquenessConstraint constraint : listOfConstraints) {
      if (!constraint.isViolated()) {
        nonViolatedConstraints.add(constraint);
      }
    }
    return nonViolatedConstraints;
  }

}
