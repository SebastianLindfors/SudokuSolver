package se.seblin.solos.SudokuSolver.entity;

public class Sudoku {

  char[] charSet;
  char[][] charGrid;

  String horizontalLine = "";

  int size;

  public Sudoku() {

    charSet = new char[] {'1','2','3','4','5','5','6','7','8','9'};
    size = charSet.length;

    charGrid = new char[size][size];

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

    charGrid[x][y] = newCharacter;
  }

  //----- Getters -----//

  public int getSize() {
    return size;
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





}
