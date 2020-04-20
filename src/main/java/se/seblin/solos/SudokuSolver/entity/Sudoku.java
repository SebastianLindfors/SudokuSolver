package se.seblin.solos.SudokuSolver.entity;

public class Sudoku {

  char[] charSet;
  char[][] charGrid;

  String horizontalLine = "";

  public Sudoku() {

    charSet = new char[] {'1','2','3','4','5','5','6','7','8','9'};
    charGrid = new char[charSet.length][charSet.length];

    generateHorizontalLine();

  }

  public String toString() {
    StringBuilder outputString = new StringBuilder();

    outputString.append(this.horizontalLine);
    for (int i = 0; i < charGrid.length; i++) {
      outputString.append(generateRowString(i))
          .append(horizontalLine);
    }

    return outputString.toString();
  }

  private void generateHorizontalLine() {
    for (int i = 0; i < charSet.length; i++) {
      this.horizontalLine += "__";
    }
    this.horizontalLine += "\n";
  }

  private String generateRowString(int rowNumber) {
    String outputString = "|";
    for (int i = 0; i < charSet.length; i++) {
      outputString += charGrid[rowNumber][i] + "|";
    }
    outputString += "\n";

    return outputString;
  }





}
