import java.util.*;

public class MahaKumbh {
	
    private static Map<String, Set<String>> g = new HashMap<>();
    private static Map<String, Set<String>> restrict = new HashMap<>();
    private static List<String> ans = new ArrayList<>();
    
    // Bidirectional Connect Station
    private static void connect(String x, String y) {
    	if (!g.containsKey(x)) {
        g.put(x, new HashSet<>());
        }
        g.get(x).add(y);
        
        if (!g.containsKey(y)) {
        g.put(y, new HashSet<>());
        }
        g.get(y).add(x);
    }
    
    // Remove existing connection
    private static void disconnect(String a, String b) {
    	if (g.containsKey(a)) {
        g.get(a).remove(b);
        }
        if (g.containsKey(b)) {
        g.get(b).remove(a);
        }
    }
    
    // BFS
    private static boolean canVisit(String s, String d) {
    Set<String> visit = new HashSet<>();
    Queue<String> q = new LinkedList<>();
    Set<String> restricted = restrict.getOrDefault(s, Collections.emptySet());
    
    q.add(s);
    visit.add(s);
    
    while (!q.isEmpty()) {
    	String temp = q.poll();

        if (temp.equals(d)) {
        return true;
        }
        
        Set<String> S = g.getOrDefault(temp, Collections
        								.emptySet());
                                        
        for (String str : S) {
        if (!visit.contains(str) && !restricted.contains(str)) {
        visit.add(str);
        
        q.add(str);
        }
        }
    }
    return false;
    }

    // Method for travel check
    private static String checkTravel(String s, String d) {
        boolean reach = canVisit(s, d);
        if (reach) {
            return "yes";
        } else {
            return "no";
        }
    }

    
    // Query handle methods
    private static void travelQuery(String str) {
        String[] parts = str.split(" to ");
        String s = parts[0].trim();
        String d = parts[1].trim();
        ans.add(checkTravel(s, d));
    }
    
    private static void connectQuery(String str) {
        String[] parts = str.split(" connects ");
        connect(parts[0].trim(), parts[1].trim());
    }
    
    private static void disconnectQuery(String str) {
        String[] parts = str.split(" disconnects ");
        disconnect(parts[0].trim(), parts[1].trim());
    }

    // Process output
    private static void output(String[] S) {
        for (String str : S) {
            if (str.contains(" to ")) {
                travelQuery(str);
            }
            else if (str.contains(" connects ")) {
                connectQuery(str);
            } else if (str.contains(" disconnects ")) {
                disconnectQuery(str);
            }
        }
    }
    
    // Print output
    private static void print() {
    for (int i = 0; i < ans.size(); i++) {
    System.out.println(ans.get(i));
    }
    }


    // Read input
    private static void readConnection(Scanner in, int n) {
        for (int i = 0; i < n; i++) {
            String[] arr = in.nextLine().trim().split("\\s+");
            String str = arr[0];
            for (int j = 1; j < arr.length; j++) {
                connect(str, arr[j]);
            }
        }
    }

    // read restrict data
    private static void readRestrictions(Scanner in, int n) {
        for (int i = 0; i < n; i++) {
            String[] arr = in.nextLine().trim().split("\\s+");
            String str = arr[0];
            Set<String> res = new HashSet<>();
            for (int j = 1; j < arr.length; j++) {
                res.add(arr[j]);
            }
            restrict.put(str, res);
        }
    }
    
    // Main method
    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in);

        int N = Integer.parseInt(in.nextLine().trim());
        readConnection(in, N);

        int Q = Integer.parseInt(in.nextLine().trim());
        String[] arr = new String[Q];
        for (int i = 0; i < Q; i++) {
        arr[i] = in.nextLine().trim();
        }
        
        int R = Integer.parseInt(in.nextLine().trim());
        readRestrictions(in, R);
        output(arr);
        print();

        in.close(); 
        
    } 
}