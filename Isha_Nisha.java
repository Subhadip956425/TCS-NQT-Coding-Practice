import java.util.*;

public class Isha_Nisha {

    static int N1, N2;
    static char[][] matrix;
    static String str;

    static int min = Integer.MAX_VALUE;


    static List<Info> clu = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N1 = sc.nextInt();
        N2 = sc.nextInt();
        sc.nextLine();

        matrix = new char[N1][N2];
        for (int i = 0; i < N1; i++) {
            String line = sc.nextLine().replace(" ", "");
            for (int j = 0; j < N2; j++) {
                matrix[i][j] = line.charAt(j);
            }
        }

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            clu.add(new Info(t, x1, y1, x2, y2));
        }

        sc.nextLine();
        str = sc.nextLine().trim();

        vis = new boolean[N1][N2];

        boolean start = false;


        for (int i = 0; i < N1; i++) {
            for (int j = 0; j < N2; j++) {
                if (matrix[i][j] == str.charAt(0)) {
                    start = true;


                    int fault = 0;
                    for (Info cl : clu) {
                        if (cl.isViolate(1, i + 1, j + 1))
                            fault++;
                    }

                    dfs(i, j, 0, fault);
                }
            }
        }

        if (!start) {
            System.out.println("Impossible");
            return;
        }

        if (min == Integer.MAX_VALUE) {
            System.out.println("Impossible");
        } else if (min == 0) {
            System.out.println("All clues are correct");
        } else {
            System.out.println(min);
        }
    }


    static int[] r_direc = {1, -1, 0, 0};
    static int[] c_direc = {0, 0, 1, -1};

    static class Info {
        int time;
        int x1, y1;
        int x2, y2;
        Info(int time, int x1, int y1, int x2, int y2) {
            this.time = time;
            this.x1 = x1;
            this.x2 = x2;
            this.y1 = y1;
            this.y2 = y2;
        }

        // check if violates Info
        boolean isViolate(int t, int r, int c) {
            if (t != time) {
                return false;
            }


            boolean ir = (r >= x1 && r <= x2);
            boolean ic = (c >= y1 && c <= y2);

            return ir && ic;
        }
    }

    static boolean[][] vis;

    static void dfs(int r, int c, int id, int f) {
        if (id == str.length() - 1) {
            min = Math.min(min, f);
            return;
        }

        vis[r][c] = true;

        char exp = str.charAt(id + 1);

        for (int i = 0; i < 4; i++) {
            int n_row = r + r_direc[i];
            int n_col = c + c_direc[i];

            if (n_row < 0 || n_row >= N1 || n_col < 0 || n_col >= N2) continue;

            if (vis[n_row][n_col]) continue;
            if (matrix[n_row][n_col] != exp) continue;


            int next = id + 2;

            int addF = 0;

            for (int j = clu.size() - 1; j >= 0; j--) {
                Info info = clu.get(j);

                if (info.time != next) continue;

                int r1 = n_row + 1;  // converting to 1-based
                int c1 = n_col + 1;

                if (r1 >= info.x1 && r1 <= info.x2 &&
                        c1 >= info.y1 && c1 <= info.y2) {
                    addF++;
                }
            }


            int total = addF + f;
            if (total < min) {
                dfs(n_row, n_col, id + 1, f + addF);
            }
        }

        vis[r][c] = false;
    }

}
