package se.seblin.solos.SudokuSolver.entity;

import se.seblin.solos.SudokuSolver.constraints.UniquenessConstraint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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



}
