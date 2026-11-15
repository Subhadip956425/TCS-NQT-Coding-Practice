package Hashing;

import java.util.HashSet;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        // Use hash sets for row, column, and box checks
        HashSet<Character>[] rowset = new HashSet[9];
        HashSet<Character>[] colset = new HashSet[9];
        HashSet<Character>[][] boxset = new HashSet[3][3];

        for (int i=0; i<9; i++) {
            rowset[i] = new HashSet<>();
            colset[i] = new HashSet<>();
        }

        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                boxset[i][j] = new HashSet<>();
            }
        }

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                char num = board[i][j];

                if(num == '.') continue;

                if(rowset[i].contains(num) || colset[j].contains(num) || boxset[i/3][j/3].contains(num)) {
                    return false;
                }

                rowset[i].add(num);
                colset[j].add(num);
                boxset[i/3][j/3].add(num);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        ValidSudoku solver = new ValidSudoku();

        char[][] board1 = {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(solver.isValidSudoku(board1)); // true

        char[][] board2 = {
            {'8','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
        System.out.println(solver.isValidSudoku(board2)); // false
    }
}
