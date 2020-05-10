public class Board {
    int[][] board;

    public Board() {
        this.board = new int[19][19];
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public void move(int type, int pos1, int pos2) {
        board[pos1][pos2] = type;
        showTable();
    }

    public void showTable() {
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                System.out.printf("%d ", board[i][j]);
            }
            System.out.print("\n");
        }
    }
}
