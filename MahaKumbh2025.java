import java.util.*;

public class MahaKumbh2025 {

    // Station connections (graph)
    private Map<String, Set<String>> graph = new HashMap<>();
    // Restrictions for each source station
    private Map<String, Set<String>> restrictions = new HashMap<>();
    // Stores answers for travel queries
    private List<String> results = new ArrayList<>();

    // === Graph Operations ===

    // Create a bidirectional connection
    private void connectStations(String a, String b) {
        graph.computeIfAbsent(a, k -> new HashSet<>()).add(b);
        graph.computeIfAbsent(b, k -> new HashSet<>()).add(a);
    }

    // Remove an existing connection
    private void disconnectStations(String a, String b) {
        if (graph.containsKey(a)) graph.get(a).remove(b);
        if (graph.containsKey(b)) graph.get(b).remove(a);
    }

    // === Travel Check ===

    // Public wrapper for travel check
    private String checkTravel(String src, String dest) {
        return canTravel(src, dest) ? "yes" : "no";
    }

    // BFS to verify if a path exists avoiding restrictions
    private boolean canTravel(String src, String dest) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        Set<String> restricted = restrictions.getOrDefault(src, Collections.emptySet());

        queue.add(src);
        visited.add(src);

        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (curr.equals(dest)) return true;

            for (String neighbor : graph.getOrDefault(curr, Collections.emptySet())) {
                if (!visited.contains(neighbor) && !restricted.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        return false;
    }

    // === Input Handling ===

    // Read initial connections
    private void readInitialConnections(Scanner in, int n) {
        for (int i = 0; i < n; i++) {
            String[] arr = in.nextLine().trim().split(" ");
            String src = arr[0];
            for (int j = 1; j < arr.length; j++) {
                connectStations(src, arr[j]);
            }
        }
    }

    // Read restrictions data
    private void readRestrictions(Scanner in, int r) {
        for (int i = 0; i < r; i++) {
            String[] arr = in.nextLine().trim().split(" ");
            String src = arr[0];
            Set<String> restricted = new HashSet<>();
            for (int j = 1; j < arr.length; j++) {
                restricted.add(arr[j]);
            }
            restrictions.put(src, restricted);
        }
    }

    // Process each query and store the result
    private void processQueries(String[] queries) {
        for (String q : queries) {
            if (q.contains(" to ")) {
                handleTravelQuery(q);
            } else if (q.contains(" connects ")) {
                handleConnectQuery(q);
            } else if (q.contains(" disconnects ")) {
                handleDisconnectQuery(q);
            }
        }
    }

    // === Query Handlers ===

    private void handleTravelQuery(String query) {
        String[] parts = query.split(" to ");
        String src = parts[0].trim();
        String dest = parts[1].trim();
        results.add(checkTravel(src, dest));
    }

    private void handleConnectQuery(String query) {
        String[] parts = query.split(" connects ");
        connectStations(parts[0].trim(), parts[1].trim());
    }

    private void handleDisconnectQuery(String query) {
        String[] parts = query.split(" disconnects ");
        disconnectStations(parts[0].trim(), parts[1].trim());
    }

    // === Output ===

    private void printResults() {
        for (String res : results) {
            System.out.println(res);
        }
    }

    // === Main Entry Point ===

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        MahaKumbh2025 mk = new MahaKumbh2025();

        int N = Integer.parseInt(in.nextLine().trim());
        mk.readInitialConnections(in, N);

        int Q = Integer.parseInt(in.nextLine().trim());
        String[] queries = new String[Q];
        for (int i = 0; i < Q; i++) {
            queries[i] = in.nextLine().trim();
        }

        int R = Integer.parseInt(in.nextLine().trim());
        mk.readRestrictions(in, R);

        mk.processQueries(queries);
        mk.printResults();

        in.close();
    }
}
