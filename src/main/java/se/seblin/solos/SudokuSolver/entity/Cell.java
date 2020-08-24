package se.seblin.solos.SudokuSolver.entity;

import se.seblin.solos.SudokuSolver.constraints.UniquenessConstraint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cell {

  public boolean isEmpty;

  char[] charSet;

  final char emptyChar = '-';

  char value;

  List<UniquenessConstraint> constraintsList = new ArrayList<>();

  public Cell(char value, char[] charSet) {

    this.charSet = charSet;
    if (!verifyCharinCharSet(value)) {
      throw new IllegalArgumentException(value + "not in the provided charSet");
    }

    this.value = value;
    this.isEmpty = false;


  }

  public Cell(char[] charSet) {

    this.charSet = charSet;

    this.isEmpty = true;

  }

  private boolean isEmpty() {
    return this.isEmpty;
  }

  public void setEmpty(Boolean boolVal) {

    this.isEmpty = boolVal;

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

  public ArrayList<Character> getAllowedValues() { //TODO Test this method!

    int i = 0;
    char[][] allowedValues = new char[constraintsList.size()][];
    for (UniquenessConstraint constraint:constraintsList) {
      allowedValues[i] = constraint.getListOfAllowedValues();
      i++;
    }


    Map<Character, Integer> timesOccured = new HashMap<>();
    for (char[] values: allowedValues) {
      for (char c:values) {
        timesOccured.put(c,timesOccured.getOrDefault(c,0) + 1);
      }
    }

    ArrayList<Character> verifiedValues = new ArrayList<>();
    for (char key: timesOccured.keySet()) {
      if (timesOccured.get(key) == allowedValues.length) {
        verifiedValues.add(key);
      }
    }
    
    return verifiedValues;
  }

  public char getValue() {

    if (this.isEmpty()) {
      return emptyChar;
    }
    else {
      return value;
    }
  }



}
