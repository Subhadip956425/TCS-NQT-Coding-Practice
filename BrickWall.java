import java.util.*;

public class BrickWall {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        char[][] wall = new char[N][N];
        int sx = 0, sy = 0, dx = 0, dy = 0;

        // Parse compressed input
        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            int idx = 0, p = 0;

            while (idx < s.length() && p < N) {
                int len = 0;
                // Read number of bricks
                while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
                    len = len * 10 + (s.charAt(idx) - '0');
                    idx++;
                }
                char typ = s.charAt(idx++);
                // Fill the row
                for (int j = 0; j < len && p < N; j++) {
                    wall[i][p] = typ;
                    if (typ == 'S') { sx = i; sy = p; }
                    if (typ == 'D') { dx = i; dy = p; }
                    p++;
                }
            }

            if (p != N) {
                throw new RuntimeException("Row " + i + " does not have exactly N cells after parsing");
            }
        }

        // Cost array: minimum green bricks broken to reach each cell
        int[][] cost = new int[N][N];
        for (int[] c : cost) Arrays.fill(c, Integer.MAX_VALUE);
        cost[sx][sy] = 0;

        // Directions: up, down, left, right
        int[] dxs = {0, 0, 1, -1};
        int[] dys = {1, -1, 0, 0};

        // 0-1 BFS using Deque
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerFirst(new int[]{sx, sy, 0});

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int x = cur[0], y = cur[1], brk = cur[2];

            if (x == dx && y == dy) {
                System.out.println(brk);
                return;
            }

            for (int k = 0; k < 4; k++) {
                int nx = x + dxs[k];
                int ny = y + dys[k];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N && wall[nx][ny] != 'R') {
                    int extra = (wall[nx][ny] == 'G') ? 1 : 0;

                    if (cost[nx][ny] > brk + extra) {
                        cost[nx][ny] = brk + extra;

                        if (extra == 1) {
                            dq.offerLast(new int[]{nx, ny, cost[nx][ny]});
                        } else {
                            dq.offerFirst(new int[]{nx, ny, cost[nx][ny]});
                        }
                    }
                }
            }
        }
    }
}
