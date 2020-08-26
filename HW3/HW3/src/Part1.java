/**
 * This class takes a matrix which inside of a file.
 * A binary digital image is represented through a matrix, each element of which is either 1 (white)
 * or 0 (black)
 *
 * Program will calculate the number of
 * "white components". A white component is a set of white matrix locations, such that, between any
 * two of them, there is a path of white matrix locations, where every consecutive pair are adjacent
 * (through their top, left, right or bottom neighbor).
 * *
 */
public class Part1 {

    private int[][] data;
    private int column;
    private int row;


    /**
     * Simple constructor that sets row, column and converts the ASCII file to the integer array.
     * @param file Digital image which represents with matrix.
     * @param row Row of matrix.
     * @param column Column of matrix.
     */
    public Part1(StringBuilder file, int row, int column) {

        this.row = row;
        this.column = column;
        data = new int[row][column];

        file.trimToSize();

        /*Puts every element inside the array.*/
        int x = 0, y = 0;
        for (int i = 0; i < file.capacity(); i++) {
            if (file.charAt(i) == '0' || file.charAt(i) == '1') {
                data[x][y] = file.charAt(i) - 48;

                y++;
                if (y == column) {
                    x++;
                    y = 0;
                }
            }
        }
    }

    /**
     * This class calculates the count of white areas.
     * @return Count of white areas.
     */
    public int calculateWhite() {

        int result = 0;

        /*It holds x and y coordinates inside a two stack.*/
        MyStack<Integer> row_stack = new MyStack<Integer>();
        MyStack<Integer> column_stack = new MyStack<Integer>();

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {

                if (data[i][j] == 1) {
                    data[i][j] = 0;
                    result++;

                    if (i - 1 >= 0) {
                        row_stack.push(i - 1);
                        column_stack.push(j);
                    }

                    if (i + 1 <= row - 1) {
                        row_stack.push(i + 1);
                        column_stack.push(j);
                    }

                    if (j - 1 >= 0) {
                        column_stack.push(j - 1);
                        row_stack.push(i);
                    }

                    if (j + 1 <= column-1) {
                        column_stack.push(j + 1);
                        row_stack.push(i);
                    }


                    while ( !(row_stack.empty()) && !(column_stack.empty()) ) {

                        if (data[row_stack.peek()][column_stack.peek()] == 1) {

                            data[row_stack.peek()][column_stack.peek()] = 0;

                            int r = row_stack.pop();
                            int c = column_stack.pop();

                            if (r - 1 >= 0) {
                                row_stack.push(r - 1);
                                column_stack.push(c);

                            }

                            if (r + 1 <= row - 1) {
                                row_stack.push(r + 1);
                                column_stack.push(c);
                            }

                            if (c - 1 >= 0) {
                                column_stack.push(c - 1);
                                row_stack.push(r);
                            }

                            if (c + 1 <= column-1) {
                                column_stack.push(c + 1);
                                row_stack.push(r);
                            }
                        }
                        else{
                            row_stack.pop();
                            column_stack.pop();
                        }
                    }
                }
            }
        }



        return result;
    }
}
