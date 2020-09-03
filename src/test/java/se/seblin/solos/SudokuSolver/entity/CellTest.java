package se.seblin.solos.SudokuSolver.entity;

import org.junit.jupiter.api.Test;
import se.seblin.solos.SudokuSolver.constraints.UniquenessConstraint;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

  @Test
  void testGetCharSet() {

    char[] charSet = new char[] {'1','2','3'};
    Cell testCell = new Cell(charSet);

    assertEquals(charSet, testCell.getCharSet());
  }

  @Test
  void testSetValueGetValue() {

    char[] charSet = new char[] {'1','2','3'};
    Cell testCell = new Cell(charSet);

    char testChar = '1';
    testCell.setValue(testChar);

    assertEquals(testChar, testCell.getValue());

  }

  @Test
  void testIsEmpty() {

    char[] charSet = new char[] {'1','2','3'};
    Cell testCell = new Cell(charSet);

    char testChar = '1';
    char emptyChar = '-';

    assertEquals(true, testCell.isEmpty());

    testCell.setValue(testChar);

    assertEquals(false, testCell.isEmpty());

    testCell.setValue(emptyChar);

    assertEquals(true, testCell.isEmpty());

  }

  @Test
  void testSetConstraintGetConstraint() {

    char[] charSet = new char[] {'1','2','3'};
    Cell testCell = new Cell(charSet);

    UniquenessConstraint testConstraint = new UniquenessConstraint();
    List<UniquenessConstraint> testList = new ArrayList<UniquenessConstraint>();
    testList.add(testConstraint);

    testCell.addConstraint(testConstraint);

    assertEquals(testList, testCell.getConstraintsList());

  }

}