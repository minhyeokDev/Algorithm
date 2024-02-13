import java.util.*;
import java.io.*;

public class Main {

    static int n;
    static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        board = new char[n][n];

        for (char[] row : board) {
            Arrays.fill(row, '.');
        }
        int x = 0, y = 0;

        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            char move = s.charAt(i);

            if (move == 'U') {
                if (x != 0) {
                    if (board[x][y] == '.') {
                        board[x][y] = '|';
                    } else if (board[x][y] == '-') {
                        board[x][y] = '+';
                    }
                    x--;
                    if (board[x][y] == '.') {
                        board[x][y] = '|';
                    } else if (board[x][y] == '-') {
                        board[x][y] = '+';
                    }
                }
            } else if (move == 'D') {
                if (x != n - 1) {
                    if (board[x][y] == '.') {
                        board[x][y] = '|';
                    } else if (board[x][y] == '-') {
                        board[x][y] = '+';
                    }
                    x++;
                    if (board[x][y] == '.') {
                        board[x][y] = '|';
                    } else if (board[x][y] == '-') {
                        board[x][y] = '+';
                    }
                }
            } else if (move == 'L') {
                if (y != 0) {
                    if (board[x][y] == '.') {
                        board[x][y] = '-';
                    } else if (board[x][y] == '|') {
                        board[x][y] = '+';
                    }
                    y--;
                    if (board[x][y] == '.') {
                        board[x][y] = '-';
                    } else if (board[x][y] == '|') {
                        board[x][y] = '+';
                    }
                }
            } else if (move == 'R') {
                if (y != n - 1) {
                    if (board[x][y] == '.') {
                        board[x][y] = '-';
                    } else if (board[x][y] == '|') {
                        board[x][y] = '+';
                    }
                    y++;
                    if (board[x][y] == '.') {
                        board[x][y] = '-';
                    } else if (board[x][y] == '|') {
                        board[x][y] = '+';
                    }
                }
            }
        }

        //조각도 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

}
