package se.seblin.solos.SudokuSolver.entity;

import se.seblin.solos.SudokuSolver.constraints.UniquenessConstraint;

import java.util.ArrayList;
import java.util.List;

public class Cell {

  char[] charSet;

  char value;

  List<UniquenessConstraint> constraintsList = new ArrayList<>();

  public Cell(char value, char[] charSet) {

    this.charSet = charSet;
    if (!verifyCharinCharSet(value)) {
      throw new IllegalArgumentException(value + "not in the provided charSet");
    }

    this.value = value;


  }

  public boolean verifyCharinCharSet(char testChar) {

    boolean foundValue = false;
    for (char character:charSet) {
      if (testChar == character) {
        foundValue = true;
        break;
      }
    }

    return foundValue;
  }

  public void addConstraint(UniquenessConstraint constraint) {

    if (!constraintsList.contains(constraint)) {
      constraintsList.add(constraint);
    }

  }

  public char[] getAllowedValues() {

    int i = 0;
    char[][] allowedValues = new char[constraintsList.size()][];
    for (UniquenessConstraint constraint:constraintsList) {
      allowedValues[i] = constraint.getListOfAllowedValues();
      i++;
    }

    char[] verifiedValues = this.charSet.clone();
    for (char[] values: allowedValues) {
      
    }

    //TODO Remove any char not in all allowedValues.

    return verifiedValues;
  }


}
