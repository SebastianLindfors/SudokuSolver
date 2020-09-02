package se.seblin.solos.SudokuSolver.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

  @Test
  public void testGetCharSet() {

    char[] charSet = new char[] {'1','2','3'};
    Cell testCell = new Cell(charSet);

    assertEquals(charSet, testCell.getCharSet());
  }

  @Test
  public void testSetValueGetValue() {

    char[] charSet = new char[] {'1','2','3'};
    Cell testCell = new Cell(charSet);

    char testChar = '1';
    testCell.setValue(testChar);

    assertEquals(testChar, testCell.getValue());

  }

  @Test
  public void testIsEmpty() {

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

}