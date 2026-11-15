import java.util.*;

public class Main {

    static int S;
    static char[][][] cube;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        S = sc.nextInt();
        sc.nextLine();

        cube = new char[S][S][S];

        for (int layer = 0; layer < S; layer++) {
            for (int row = 0; row < S; row++) {
                String line = sc.nextLine().trim();
                for (int col = 0; col < S; col++) {
                    cube[layer][row][col] = line.charAt(col);
                }
            }
        }

        int[] start = {sc.nextInt(), sc.nextInt(), sc.nextInt()};
        int[] goal = {sc.nextInt(), sc.nextInt(), sc.nextInt()};

        System.out.println(bfs(start, goal));
    }

    static int bfs(int[] start, int[] goal) {
        Queue<int[]> q = new LinkedList<>();
        boolean[][][] visited = new boolean[S][S][S];

        q.offer(new int[]{start[0], start[1], start[2], 0});
        visited[start[0]][start[1]][start[2]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int L = cur[0], R = cur[1], C = cur[2], steps = cur[3];

            if (L == goal[0] && R == goal[1] && C == goal[2]) {
                return steps;
            }

            for (int[] next : getNeighbors(L, R, C)) {
                int nL = next[0], nR = next[1], nC = next[2];
                if (nL >= 0 && nL < S && nR >= 0 && nR < S && nC >= 0 && nC < S &&
                        !visited[nL][nR][nC] && cube[nL][nR][nC] != 'E') {
                    visited[nL][nR][nC] = true;
                    q.offer(new int[]{nL, nR, nC, steps + 1});
                }
            }
        }

        return -1;
    }

    static List<int[]> getNeighbors(int L, int R, int C) {
        List<int[]> neighbors = new ArrayList<>();
        char cell = cube[L][R][C];

        if (cell == 'E') return neighbors;

        // All non-empty cells allow 4-directional movement on same layer
        neighbors.add(new int[]{L, R, C-1});  // left
        neighbors.add(new int[]{L, R, C+1});  // right
        neighbors.add(new int[]{L, R-1, C});  // front (up)
        neighbors.add(new int[]{L, R+1, C});  // back (down)

        // Special connections
        if (cell == 'R') {
            neighbors.add(new int[]{L, R-1, C+1});  // upper-right
            // Reverse: cells that can connect TO this R
            if (R+1 < S && C-1 >= 0 && cube[L][R+1][C-1] == 'R') {
                neighbors.add(new int[]{L, R+1, C-1});
            }
        }

        if (cell == 'L') {
            neighbors.add(new int[]{L, R-1, C-1});  // upper-left
            // Reverse
            if (R+1 < S && C+1 < S && cube[L][R+1][C+1] == 'L') {
                neighbors.add(new int[]{L, R+1, C+1});
            }
        }

        if (cell == 'F') {
            neighbors.add(new int[]{L+1, R, C});  // next layer same position
            // Reverse
            if (L-1 >= 0 && cube[L-1][R][C] == 'F') {
                neighbors.add(new int[]{L-1, R, C});
            }
        }

        if (cell == 'B') {
            neighbors.add(new int[]{L+1, R-1, C});  // next layer upper
            // Reverse
            if (L-1 >= 0 && R+1 < S && cube[L-1][R+1][C] == 'B') {
                neighbors.add(new int[]{L-1, R+1, C});
            }
        }

        return neighbors;
    }
}
