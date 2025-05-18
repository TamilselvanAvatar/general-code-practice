package hackerRank;

import java.util.*;

/**
*
* Problem Statement :
* <p><a href="https://www.hackerrank.com/challenges/knightl-on-chessboard/problem">https://www.hackerrank.com/challenges/knightl-on-chessboard/problem</a></p>
*
* */
// NOT WORKING
public class knightL {
    static int[][] ans;

    public static void main(String[] args) {
        @SuppressWarnings("resource")
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        ans = new int[n][n];

        for (int a = 1; a < n; a++) {
            for (int b = 1; b < n; b++) {

                if ((a == 1 && b == 1) || (a == n - 1 && b == n - 1)) {

                    ans[0][0] = n;
                    ans[n - 2][n - 2] = 1;

                    continue;
                }
                int dummyArray[][] = { { a, b }, { -a, -b }, { -a, b }, { a, -b } };

                pathFinder(n, a, b, dummyArray);

            }
        }

        for(int[] a1 : ans) {
            for(int b1 : a1) {
                System.out.print(b1 +" ");
            }
            System.out.print("\n");
        }

//        System.out.println("Do you want to continue to view?");
//        ViewSolution.main(n);

    }

    private static void pathFinder(int n, int a, int b, int[][] dummyArray) {
        Deque<Integer> dq = new ArrayDeque<Integer>();
        int x = 0;
        int y = 0;

        dq = possiblePathFinder(dq, n, x, y, dummyArray);
        List<Integer> list = new ArrayList<>();

        while (!dq.isEmpty()) {
            int x1 = dq.pollFirst();
            int y1 = dq.pollFirst();

            if (x1 == n-1 && y1 == n-1) {
                list.add(1);

            }

            if(x1 == 0 && y1 == 0) {
                ans[a-1][b-1] = -1;
                break;
            }
            dq = possiblePathFinder(dq, n, x1, y1, dummyArray);
        }
        int m = 0;
        for(int min : list) {
            if(min == 0) {
                m = min;
            }
            if(min < m) {
                m = min;
            }
        }

        if(ans[a-1][b-1] != -1) {
            ans[a-1][b-1] = m;
        }

    }

    private static Deque<Integer> possiblePathFinder(Deque<Integer> dq,int n, int a, int b, int[][] dummyArray) {
        int x = a;
        int y = b;

        for (int[] xy : dummyArray) {
            if (xy[0] + x > 0 && xy[0] + x < n - 1 && xy[1] + y > 0 && xy[1] + y < n - 1) {

                if (!(x == xy[0] + x && y == xy[1] + y)) {
                    x = xy[0] + x;
                    y = xy[1] + y;

                    dq.addFirst(y);
                    dq.addFirst(x);

                }
            }
            if (xy[1] + x > 0 && xy[1] + x < n - 1 && xy[0] + y > 0 && xy[0] + y < n - 1) {
                if (!(x == xy[1] + x && y == xy[0] + y)) {
                    x = xy[1] + x;
                    y = xy[0] + y;
                    dq.addFirst(y);
                    dq.addFirst(x);
                }
            }

        }

        return dq;

    }
}

class ViewSolution {
    private static int[][] board;
    private static int[] xd = { -1, 1, 1, -1 };
    private static int[] yd = { -1, -1, 1, 1 };
    private static int n;

    public static void main(int val) {
        n = val;
        board = new int[n][n];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                System.out.print(traverse(i, j) + " ");
            }
            System.out.println();
        }

    }

    public static int traverse(int a, int b) {
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], Integer.MAX_VALUE);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        q.add(0);
        board[0][0] = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            int y = q.poll();
            for (int i = 0; i < 4; i++) {
                int a1 = x + xd[i] * a;
                int b1 = y + yd[i] * b;
                if (a1 < n && b1 < n && a1 >= 0 && b1 >= 0 && board[a1][b1] == Integer.MAX_VALUE) {
                    board[a1][b1] = board[x][y] + 1;
                    q.add(a1);
                    q.add(b1);
                }
                int a2 = y + yd[i] * a;
                int b2 = x + xd[i] * b;
                if (a2 < n && b2 < n && a2 >= 0 && b2 >= 0 && board[a2][b2] == Integer.MAX_VALUE) {
                    board[a2][b2] = board[x][y] + 1;
                    q.add(a2);
                    q.add(b2);
                }
            }
        }
        if (board[n - 1][n - 1] == Integer.MAX_VALUE) {
            return -1;
        }
        return (board[n - 1][n - 1]);
    }
}
