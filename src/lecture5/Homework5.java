package lecture5;

import java.util.Scanner;

public class Homework5 {

    public static void main(String[] args) {
        task4();
    }

    /**
     * Да се напише програма която изисква от потребителя да въведе
     * 2 числа n и m. След това да се построи матрица с размер n x m по следният
     * начин (примерите са дадени за въведени n=4 и m=4). Няма ограничение n да бъде равно на m:
     * <p>
     * Пример:
     * <pre>
     * {
     *      {    1,  5,  9,  13  },
     *      {    2,  6,  10, 14  },
     *      {    3,  7,  11, 15  },
     *      {    4,  8,  12, 16  }
     * }
     * </pre>
     */
    private static void task1() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Въведете брой редове: ");
        int row = scanner.nextInt();

        System.out.print("Въведете брой колони: ");
        int col = scanner.nextInt();

        int[][] matrix = new int[row][col];

        int counter = 1;

        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                matrix[j][i] = counter;
                counter++;
            }
        }

        for (int i = 0; i < row; i++) {
            System.out.print("[\t");
            for (int j = 0; j < col; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.print("]\n");
        }
    }

    /**
     * Да се напише програма която изисква от потребителя да въведе
     * 2 числа n и m. След това да се построи матрица с размер n x m по следният
     * начин (примерите са дадени за въведени n=4 и m=4). Няма ограничение n да бъде равно на m:
     * <p>
     * Пример:
     * <pre>
     * {
     *      {    1,  8,  9,  16  },
     *      {    2,  7,  10, 15  },
     *      {    3,  6,  11, 14  },
     *      {    4,  5,  12, 13  }
     * }
     * </pre>
     */
    private static void task2() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Въведете брой редове: ");
        int rowCount = scanner.nextInt();

        System.out.print("Въведете брой колони: ");
        int colCount = scanner.nextInt();

        int[][] matrix = new int[rowCount][colCount];

        int counter = 1;

        for (int col = 0; col < colCount; col++) {

            if (col % 2 == 0) {

                for (int j = 0; j < rowCount; j++) {
                    matrix[j][col] = counter;
                    counter++;
                }
            } else {
                for (int row = rowCount - 1; row >= 0; row--) {
                    matrix[row][col] = counter;
                    counter++;
                }
            }
        }

        for (int i = 0; i < rowCount; i++) {
            System.out.print("[\t");
            for (int j = 0; j < colCount; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.print("]\n");
        }
    }

    /**
     * Да се напише програма която изисква от потребителя да въведе
     * 2 числа n и m. След това да се построи матрица с размер n x m по следният
     * начин (примерите са дадени за въведени n=4 и m=4). Няма ограничение n да бъде равно на m:
     * <p>
     * Пример:
     * <pre>
     * {
     *      {    1,  8,  9,  16  },
     *      {    2,  7,  10, 15  },
     *      {    3,  6,  11, 14  },
     *      {    4,  5,  12, 13  }
     * }
     * </pre>
     */
    private static void task2SecondVariation() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Въведете брой редове: ");
        int rowCount = scanner.nextInt();

        System.out.print("Въведете брой колони: ");
        int colCount = scanner.nextInt();

        int[][] matrix = new int[rowCount][colCount];

        int counter = 1;

        for (int col = 0; col < colCount; col++) {
            for (int row = 0; row < rowCount; row++) {

                int currentRow = row;

                if (col % 2 != 0) {
                    currentRow = rowCount - 1 - row;
                }

                matrix[currentRow][col] = counter;

                counter++;
            }
        }

        for (int i = 0; i < rowCount; i++) {
            System.out.print("[\t");
            for (int j = 0; j < colCount; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.print("]\n");
        }
    }

    /**
     * Да се напише програма която изисква от потребителя да въведе
     * 2 числа n и m. След това да се построи матрица с размер n x m по следният
     * начин (примерите са дадени за въведени n=4 и m=4). Няма ограничение n да бъде равно на m:
     * <p>
     * Пример:
     * <pre>
     * {
     *      {   7,  11, 14, 16  },
     *      {   4,  8,  12, 15  },
     *      {   2,  5,  9,  13  },
     *      {   1,  3,  6,  10  }
     * }
     * </pre>
     */
    private static void task3() {
        int rowCount = 4;
        int colCount = 4;
        int[][] matrix = new int[rowCount][colCount];

        int counter = 1;

        for (int row = rowCount - 1; row >= -rowCount; row--) {
            for (int col = 0; col < colCount; col++) {

                int diagonalRow = row + col;

                if (diagonalRow >= 0 && diagonalRow < rowCount) {
                    matrix[diagonalRow][col] = counter++;
                }

            }
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[\t");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.print("]\n");
        }
    }

    /**
     * Да се напише програма която изисква от потребителя да въведе
     * 2 числа n и m. След това да се построи матрица с размер n x m по следният
     * начин (примерите са дадени за въведени n=4 и m=4). Няма ограничение n да бъде равно на m:
     * <p>
     * Пример:
     * <pre>
     * {
     *      {   1,  3,  6,  10  }
     *      {   2,  5,  9,  13  }
     *      {   4,  8,  12, 15  }
     *      {   7,  11, 14, 16  }
     * }
     * </pre>
     */
    private static void task3SecondVariation() {
        int rowCount = 3;
        int colCount = 3;
        int[][] matrix = new int[rowCount][colCount];

        int counter = 1;

        for (int row = 0; row <= rowCount + colCount - 2; row++) {
            for (int col = 0; col <= row; col++) {

                int diagonalRow = row - col;

                if (diagonalRow < rowCount && col < colCount) {
                    matrix[diagonalRow][col] = counter++;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[\t");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.print("]\n");
        }
    }

    /**
     * Да се напише програма която изисква от потребителя да въведе
     * 2 числа n и m. След това да се построи матрица с размер n x m по следният
     * начин (примерите са дадени за въведени n=4 и m=4). Няма ограничение n да бъде равно на m:
     * <p>
     * Пример:
     * <pre>
     * {
     *      {   1,  2,  3,  4  },
     *      {   12, 13, 14, 5  },
     *      {   11, 16, 15, 6  },
     *      {   10, 9,  8,  7  }
     * }
     * </pre>
     */
    private static void task4() {
        int rows = 4;
        int cols = 4;
        int counter = 1;

//        00 01 02 03
//        13 23 33
//        32 31 30


        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (i == 0) {
                    matrix[i][j] = counter++;
                }
//
//                if (i == 1 && j == cols - 1) {
//                    matrix[i][j] = counter++;
//                }
//
//                if (i == 2 && j == cols - 1) {
//                    matrix[i][j] = counter++;
//                }
//
//                if (i == 3 && j == cols - 1) {
//                    matrix[i][j] = counter++;
//                }

                if (i != 0 && j == cols - 1) {
                    matrix[i][j] = counter++;
                }

                if (i == rows - 1 && j != cols - 1) {
                    matrix[i][cols - 2 - j] = counter++;
                }
            }
        }

        printMatrix(matrix);
    }

    /**
     * TODO (mzlatev) working solution from a student. Rework it so that it populates the value of the matrix
     */
    public static void task4Main(String[] args) {
        int R = 4;
        int C = 4;
        int a[][] = {{1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}};
        spiralPrint(R, C, a);
    }

    static void spiralPrint(int m, int n, int a[][]) {
        int i, k = 0, l = 0;
        /*  k - starting row index
        m - ending row index
        l - starting column index
        n - ending column index
        i - iterator
        */

        while (k < m && l < n) {
            // Print the first row from the remaining rows
            for (i = l; i < n; ++i) {
                System.out.print(a[k][i] + " ");
            }
            k++;

            // Print the last column from the remaining columns
            for (i = k; i < m; ++i) {
                System.out.print(a[i][n - 1] + " ");
            }
            n--;

            // Print the last row from the remaining rows */
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    System.out.print(a[m - 1][i] + " ");
                }
                m--;
            }

            // Print the first column from the remaining columns */
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    System.out.print(a[i][l] + " ");
                }
                l++;
            }
        }
    }

    /**
     * Да се завърти двумерен масив (за по-лесно квадратен с четен брой елементи – 4х4, 6х6 и т.н.)
     * по часовниковата стрелка:
     * Например за дадената матрица:
     * <p>
     * { 1     12   13     5 }
     * { 6     17   8      4 }
     * { 3     2    13     8 }
     * { 0     14   5      2 }
     * <p>
     * След завъртането да се получи:
     * <p>
     * { 0     3    6      1 }
     * { 14    2    17    12 }
     * { 5     13   8     13 }
     * { 2     8    4      5 }
     */
    private static void task5RotateMatrixClockWiseSolution1() {

        int[][] matrix = {
                {1, 12, 13, 5},
                {6, 17, 8, 4},
                {3, 2, 13, 8},
                {0, 14, 5, 2},
        };

        printMatrix(matrix);
        System.out.println("===============");

        int[][] rotatedMatrix = new int[matrix[0].length][matrix.length];

        for (int col = 0; col < matrix.length; col++) {
            for (int row = 0; row < matrix[col].length; row++) {

                int lastRow = matrix.length - col - 1;

                rotatedMatrix[row][col] = matrix[lastRow][row];
            }

            printMatrix(rotatedMatrix);
        }

        System.out.println("===============");
        printMatrix(rotatedMatrix);
    }

    /**
     * Да се завърти двумерен масив (за по-лесно квадратен с четен брой елементи – 4х4, 6х6 и т.н.)
     * по часовниковата стрелка:
     * Например за дадената матрица:
     * <p>
     * { 1     12   13     5 }
     * { 6     17   8      4 }
     * { 3     2    13     8 }
     * { 0     14   5      2 }
     * <p>
     * След завъртането да се получи:
     * <p>
     * { 0     3    6      1 }
     * { 14    2    17    12 }
     * { 5     13   8     13 }
     * { 2     8    4      5 }
     */
    private static void task5RotateMatrixClockWiseSolution2() {

        int[][] matrix = {
                {1, 12, 13, 5},
                {6, 17, 8, 4},
                {3, 2, 13, 8},
                {0, 14, 5, 2},
        };

        printMatrix(matrix);
        System.out.println("===============");

        for (int i = 0; i < matrix.length / 2; i++) {
            for (int j = i; j < matrix.length - i - 1; j++) {
                int topLeftRow = i;
                int topLeftCol = j;

                int topRightRow = j;
                int topRightCol = matrix.length - 1 - i;

                int bottomRightRow = matrix.length - 1 - i;
                int bottomRightCol = matrix.length - 1 - j;

                int bottomLeftRow = matrix.length - 1 - j;
                int bottomLeftCol = i;

                int topLeft = matrix[topLeftRow][topLeftCol];
                int topRight = matrix[topRightRow][topRightCol];

                int bottomRight = matrix[bottomRightRow][bottomRightCol];
                int bottomLeft = matrix[bottomLeftRow][bottomLeftCol];

                matrix[topLeftRow][topLeftCol] = bottomLeft;
                matrix[topRightRow][topRightCol] = topLeft;

                matrix[bottomRightRow][bottomRightCol] = topRight;
                matrix[bottomLeftRow][bottomLeftCol] = bottomRight;

                printMatrix(matrix);
            }
        }

        System.out.println("===============");
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        System.out.println();

        for (int i = 0; i < matrix.length; i++) {
            System.out.print("[\t");
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println("]");
        }
    }

}
