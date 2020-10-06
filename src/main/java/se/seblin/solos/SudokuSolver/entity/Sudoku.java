package se.seblin.solos.SudokuSolver.entity;

import se.seblin.solos.SudokuSolver.constraints.UniquenessConstraint;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {

  boolean valid = false;

  char[] charSet;

  char[][] charGrid; // TODO Refactor out thi variable.

  Cell[][] cellGrid;

  List<UniquenessConstraint> listOfConstraints = new ArrayList<>();

  String horizontalLine = "";

  int size;

  public Sudoku() {

    charSet = new char[] {'1','2','3','4','5','5','6','7','8','9'};
    size = charSet.length;

    charGrid = new char[size][size];

    cellGrid = new Cell[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        cellGrid[i][j] = new Cell(' ', this.charSet);
      }
    }

    generateHorizontalLine();

  }

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
    charGrid[x][y] = newCharacter;
  }

  //----- Getters -----//

  public int getSize() {
    return size;
  }

  public boolean isValid() {
    return this.valid;
  }

  public String toString() {
    StringBuilder outputString = new StringBuilder();

    outputString.append(this.horizontalLine);
    for (int i = 0; i < size - 1; i++) {
      outputString.append(generateRowString(i))
          .append(horizontalLine);
    }

    return outputString.toString();
  }

  public void addConstraints(UniquenessConstraint newConstraint) {
    if (!listOfConstraints.contains(newConstraint)) {
      this.listOfConstraints.add(newConstraint);
    }
  }

  private void generateHorizontalLine() {
    for (int i = 0; i < charSet.length; i++) {
      this.horizontalLine += "__";
    }
    this.horizontalLine += "\n";
  }

  private String generateRowString(int rowNumber) {
    String outputString = "|";
    for (int i = 0; i < charSet.length - 1; i++) {
      outputString += charGrid[rowNumber][i] + "|";
    }
    outputString += "\n";

    return outputString;
  }

  private boolean checkIfConstraintsAreViolated() {
    for (UniquenessConstraint constraint : listOfConstraints) {
      if (constraint.isViolated()) {
        return true;
      }
    }
    return false;
  }

  private List<UniquenessConstraint> getViolatedCosntraints() {
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
