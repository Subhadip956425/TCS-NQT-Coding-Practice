import java.util.*;

public class FinalPosition {
    static class Slider {
        int x1, y1, x2, y2;
        public Slider(int x1, int y1, int x2, int y2) {
            this.x1 = x1; this.y1 = y1;
            this.x2 = x2; this.y2 = y2;
        }
        // Check if a given point (x,y) lies on the slider
        boolean onSlider(int x, int y) {
            // Check segment and 45-degree line
            int dx = x2 - x1, dy = y2 - y1;
            if (dx == 0 || dy == 0 || Math.abs(dx) != Math.abs(dy))
                return false;
            // Is (x, y) between endpoints?
            if (x < Math.min(x1, x2) || x > Math.max(x1, x2)) return false;
            if (y < Math.min(y1, y2) || y > Math.max(y1, y2)) return false;
            // Satisfies line equation
            return (x - x1) * dy == (y - y1) * dx;
        }
        // Returns landing point if ball falls vertically onto slider
        Integer landingY(int x, int ballY) {
            // Only if slider crosses x between endpoints and below ball
            if ((x1 <= x && x2 >= x) || (x2 <= x && x1 >= x)) {
                // Slope
                int dx = x2 - x1, dy = y2 - y1;
                if (dx == 0) return null;
                int y = y1 + (x - x1) * dy / dx;
                if (y < ballY && y >= 0 &&
                    y >= Math.min(y1, y2) && y <= Math.max(y1, y2))
                    return y;
            }
            return null;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        List<Slider> sliders = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] tokens = in.nextLine().split(" ");
            int x1 = Integer.parseInt(tokens[0]), y1 = Integer.parseInt(tokens[1]);
            int x2 = Integer.parseInt(tokens[2]), y2 = Integer.parseInt(tokens[3]);
            sliders.add(new Slider(x1, y1, x2, y2));
        }
        String[] start = in.nextLine().split(" ");
        int bx = Integer.parseInt(start[0]), by = Integer.parseInt(start[1]);

        while (true) {
            // First, drop ball using gravity to next slider or ground
            int nextY = 0;
            Slider targetSlider = null;
            int landY = nextY;
            for (Slider s : sliders) {
                Integer y = s.landingY(bx, by);
                if (y != null && y > nextY) {
                    nextY = y;
                    landY = y;
                    targetSlider = s;
                }
            }
            // Ball lands on slider (if found), else ground
            by = nextY;
            if (targetSlider == null) {
                // Ball lands on ground
                break;
            }
            // Now, ball is at (bx, by) on slider - slide to other endpoint
            if (bx == targetSlider.x1 && by == targetSlider.y1) {
                bx = targetSlider.x2;
                by = targetSlider.y2;
            } else {
                bx = targetSlider.x1;
                by = targetSlider.y1;
            }
            // At the end of the slider, check if standing still (on intersection or out edge)
            // If ball is at a position where it can't fall further, exit
            boolean found = false;
            for (Slider s : sliders) {
                if (s.onSlider(bx, by)) {
                    found = true;
                    break;
                }
            }
            if (!found) break;
        }
        System.out.println(bx + " " + by);
    }
}
