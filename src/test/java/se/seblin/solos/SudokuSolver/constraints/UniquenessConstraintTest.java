package se.seblin.solos.SudokuSolver.constraints;

import org.junit.jupiter.api.Test;
import se.seblin.solos.SudokuSolver.entity.Cell;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UniquenessConstraintTest {

  @Test
  void testAddCell() {

    UniquenessConstraint testConstraint = new UniquenessConstraint(new char[] {1,2,3});
    Cell testCell = new Cell(new char[]{1,2,3});
    List<Cell> testList = new ArrayList<>();

    testConstraint.addCell(testCell);
    testList.add(testCell);

    assertEquals(testList, testConstraint.getBelongingCells());

  }

  @Test
  void testViolatedTrue() {

    UniquenessConstraint testConstraint = new UniquenessConstraint(new char[] {'1','2','3'});
    Cell testCell1 = new Cell(new char[]{'1','2','3'});
    Cell testCell2 = new Cell(new char[]{'1','2','3'});

    Character testChar = '1';
    testCell1.setValue(testChar);
    testCell2.setValue(testChar);

    testConstraint.addCell(testCell1);
    testConstraint.addCell(testCell2);

    assertEquals(true, testConstraint.isViolated());

  }

  @Test
  void testViolatedFalse() {

    UniquenessConstraint testConstraint = new UniquenessConstraint(new char[] {'1','2','3'});
    Cell testCell1 = new Cell(new char[]{'1','2','3'});
    Cell testCell2 = new Cell(new char[]{'1','2','3'});

    Character testChar1 = '1';
    Character testChar2 = '2';
    testCell1.setValue(testChar1);
    testCell2.setValue(testChar2);

    testConstraint.addCell(testCell1);
    testConstraint.addCell(testCell2);

    assertEquals(false, testConstraint.isViolated());

  }

}