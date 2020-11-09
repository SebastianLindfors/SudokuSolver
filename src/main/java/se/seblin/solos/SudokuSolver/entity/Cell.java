package se.seblin.solos.SudokuSolver.entity;

import se.seblin.solos.SudokuSolver.constraints.UniquenessConstraint;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cell {

  public boolean isEmpty;

  final char[] charSet;

  final char emptyChar = '-';

  char value;

  List<UniquenessConstraint> constraintsList = new ArrayList<>();

  // ----- Constructors ----- //

  public Cell(char value, char[] charSet) {

    this.charSet = charSet;
    if (!verifyCharinCharSet(value)) {
      throw new IllegalArgumentException(value + "not in the provided charSet");
    }
    if (!verifyCharinCharSet(emptyChar)) {
      throw new IllegalArgumentException(value + "the empty marker may not be in the charSet.");
    }

    this.value = value;
    this.isEmpty = false;


  }

  public Cell(char[] charSet) {

    this.charSet = charSet;

    if (verifyCharinCharSet(emptyChar)) {
      throw new IllegalArgumentException(value + "the empty marker may not be in the charSet.");
    }

    this.isEmpty = true;

  }

  // ----- Other Methods ----- //

  public boolean isEmpty() {
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

    List<List<Character>> allowedValues = new ArrayList<>();
    for (UniquenessConstraint constraint:constraintsList) {
      allowedValues.add(constraint.getListOfAllowedValues());
    }


    Map<Character, Integer> timesOccurred = new HashMap<>();
    for (List<Character> listOfCharacters: allowedValues) {
      for (Character character:listOfCharacters) {
        timesOccurred.put(character,timesOccurred.getOrDefault(character,0) + 1);
      }
    }

    ArrayList<Character> verifiedValues = new ArrayList<>();
    for (char key: timesOccurred.keySet()) {
      if (timesOccurred.get(key) == allowedValues.size()) {
        verifiedValues.add(key);
      }
    }
    
    return verifiedValues;
  }

  public void setValue(char newValue) {

    if (newValue == emptyChar) {
      this.value = newValue;
      this.isEmpty = true;
      return;
    }
    else if (!verifyCharinCharSet(newValue)) {
      throw new IllegalArgumentException(newValue + " is not in the charSet of this cell.");
    }

    this.value = newValue;
    this.isEmpty = false;

    this.updateConstraints();

  }

  public char getValue() {

    if (this.isEmpty()) {
      return emptyChar;
    }
    else {
      return value;
    }
  }

  public char[] getCharSet() {
    return this.charSet;
  }

  public List<UniquenessConstraint> getConstraintsList() { return this.constraintsList; }

  public void updateConstraints() {

    //TODO Add code here that updataes the constraints, this code should be run everytime the cell value changes
    for (UniquenessConstraint constraint:constraintsList) {
      constraint.update();
    }
  }



}
