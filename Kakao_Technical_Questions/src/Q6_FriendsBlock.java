public class Q6_FriendsBlock {

    private int countRemoval(String[] inputBoard, int[] size) {
        int cnt = 0;
        boolean changed;
        // Check if board input is valid
        if (inputBoard.length != size[0]) {
            return -1;
        }
        for (int i = 0; i < size[0]; i ++) {
            if (inputBoard[i].length() != size[1]) {
                return -1;
            }
        }
        char[][] gameBoard = parseBoard(inputBoard);
        printBoard(gameBoard);
        do {
            int[][] markChange = new int[size[0]][size[1]];
            changed = false;
            // Identify tiles to be removed
            for (int i = 0; i < size[0] - 1; i++) {
                for (int j = 0; j < size[1] - 1; j++) {
                    if (gameBoard[i][j] != '\0' && gameBoard[i][j] == gameBoard[i][j+1] && gameBoard[i][j] == gameBoard[i+1][j] &&
                            gameBoard[i][j] == gameBoard[i+1][j+1]) {
                        markChange[i][j] = 1;
                        markChange[i][j+1] = 1;
                        markChange[i+1][j] = 1;
                        markChange[i+1][j+1] = 1;
                        changed = true;
                    }
                }
            }
            // Remove marked tiles
            if (changed) {
                for (int i = 0; i < size[0]; i++) {
                    for (int j = 0; j < size[1]; j++) {
                        if (markChange[i][j] == 1) {
                            gameBoard[i][j] = '\0';
                            cnt += 1;
                        }
                    }
                }
                // Bring down tiles
                for (int j = 0; j < size[1]; j++) {
                    for (int i = size[0] - 1; i > 0; i--) {
                        if (gameBoard[i][j] == '\0') {
                            boolean found = false;
                            int inc = 1;
                            while (inc <= i && !found) {
                                if (gameBoard[i - inc][j] != '\0') {
                                    gameBoard[i][j] = gameBoard[i - inc][j];
                                    gameBoard[i - inc][j] = '\0';
                                    found = true;
                                }
                                inc += 1;
                            }
                        }
                    }
                }
                printBoard(gameBoard);
            }
        } while (changed);
        return cnt;
    }

    private char[][] parseBoard(String[] board) {
        char[][] parsedBoard = new char[board.length][];
        for (int i = 0; i < board.length; i++) {
            parsedBoard[i] = board[i].toCharArray();
        }
        return parsedBoard;
    }

    private void printBoard(char[][] gameBoard) {
        System.out.println("-----------------------");
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (gameBoard[i][j] == '\0') {
                    System.out.print('-');
                } else {
                    System.out.print(gameBoard[i][j]);
                }
            }
            System.out.print("\n");
        }
        System.out.println("-----------------------");
    }

    public static void main(String[] args) {
        // Setup test cases
        String[][] testcase = new String[][] {{"CCBDE", "AAADE", "AAABF", "CCBBF"},
                                              {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"},
                                              {"AAB", "AAC"},
                                              {"AA", "BB", "CC", "CC", "BB", "AA"}};
        int[][] testsize = new int[][] {{4, 5}, {6, 6}, {2, 3}, {6, 2}};

        // Initialize solver
        Q6_FriendsBlock solver = new Q6_FriendsBlock();

        // Test solution
        for (int i = 0; i < testcase.length; i++) {
            System.out.println(solver.countRemoval(testcase[i], testsize[i]));
        }
    }
}
