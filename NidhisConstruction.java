import java.awt.Point;
import java.util.*;

public class NidhisConstruction {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read number of placement commands
        int numCommands = Integer.parseInt(scanner.nextLine());
        String[][] commands = new String[numCommands][3];

        for (int i = 0; i < numCommands; i++) {
            commands[i] = scanner
                    .nextLine()
                    .split(" ");
        }

        // Sort commands: first by existing cube, then by new cube
        Arrays.sort(commands, (a, b) -> {
            int exist1 = Integer.parseInt(a[0]);
            int exist2 = Integer.parseInt(b[0]);
            if (exist1 != exist2) return exist1 - exist2;
            return Integer.parseInt(a[1]) - Integer.parseInt(b[1]);
        });

        // Maps to track cube positions
        Map<Integer, Point> cubePositions = new HashMap<>();
        Map<Point, Integer> positionCubes = new HashMap<>();

        // Start with the first cube at (0,0)
        cubePositions.put(1, new Point(0, 0));
        positionCubes.put(new Point(0, 0), 1);

        // Process all placement commands
        for (String[] cmd : commands) {
            int existingCube = Integer.parseInt(cmd[0]);
            int newCube = Integer.parseInt(cmd[1]);
            String direction = cmd[2];

            Point existingPos = cubePositions.get(existingCube);
            Point newPos = newPosition(existingPos, direction);

            // If new position is occupied, remove the old cube
            if (positionCubes.containsKey(newPos)) {
                int oldCube = positionCubes.get(newPos);
                cubePositions.remove(oldCube);
                positionCubes.remove(newPos);
            }

            // Place new cube
            cubePositions.put(newCube, newPos);
            positionCubes.put(newPos, newCube);
        }

        // Read query cube
        int queryCube = Integer.parseInt(scanner.nextLine());
        Point queryPos = cubePositions.get(queryCube);

        // Check neighbors
        int up = cubeAt(positionCubes, queryPos.x, queryPos.y + 1);
        int down = cubeAt(positionCubes, queryPos.x, queryPos.y - 1);
        int left = cubeAt(positionCubes, queryPos.x - 1, queryPos.y);
        int right = cubeAt(positionCubes, queryPos.x + 1, queryPos.y);

        System.out.println(up + " " + down + " " + left + " " + right);
        scanner.close();
    }

    // Helper to compute new position based on direction
    private static Point newPosition(Point current, String direction) {
        int dx = 0, dy = 0;
        switch (direction.toLowerCase()) {
            case "top": dy = 1; break;
            case "down": dy = -1; break;
            case "left": dx = -1; break;
            case "right": dx = 1; break;
        }
        return new Point(current.x + dx, current.y + dy);
    }

    // Helper to safely get cube at a position, or -1 if empty
    private static int cubeAt(Map<Point, Integer> map, int x, int y) {
        return map.getOrDefault(new Point(x, y), -1);
    }
}
