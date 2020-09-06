package se.seblin.solos.SudokuSolver.constraints;

import org.junit.jupiter.api.Test;
import se.seblin.solos.SudokuSolver.entity.Cell;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UniquenessConstraintTest {

  @Test
  void testAddCell() {

    UniquenessConstraint testConstraint = new UniquenessConstraint();
    Cell testCell = new Cell(new char[]{1,2,3});
    List<Cell> testList = new ArrayList<>();

    testConstraint.addCell(testCell);
    testList.add(testCell);

    assertEquals(testList, testConstraint.getBelongingCells());

  }

  @Test
  void testUpdate

}