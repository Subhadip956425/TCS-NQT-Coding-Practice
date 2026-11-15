package Trie;

public class Longest_Word_With_All_Prefix {
    static class Node {
        Node[] children;
        boolean eow;

        public Node() {
            children = new Node[26]; // a to z
            for (int i=0; i<26; i++) {
                children[i] = null;
            }
            eow = false;
        }
    }

    //    Root node
    static Node root = new Node();

    //    --------------- Insert
    static void insert(String word) {
        Node curr = root;
        for (int i=0; i<word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            if (i == word.length()-1) {
                curr.children[idx].eow = true;
            }
            curr = curr.children[idx];
        }
    }

    //  --------------------  Search
    static boolean search(String key) {
        Node curr = root;
        for (int i=0; i<key.length(); i++) {
            int idx = key.charAt(i) - 'a';
            Node node = curr.children[idx];

            if (node == null) {
                return false;
            }

            if (i==key.length()-1 && node.eow==false) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

//    Find the longest word

    public static String ans = "";

    public static String longestWord(Node root, StringBuilder temp) {
        if (root == null) {
            return "";
        }



        for (int i=0; i<26; i++) {
            if (root.children[i] != null && root.children[i].eow == true) {
                temp.append((char) (i + 'a'));

                if (temp.length() > ans.length()) {
                    ans = temp.toString();
                }

                // Recursive call
                longestWord(root.children[i], temp);

                // After backtrack delete character
                temp.deleteCharAt(temp.length() - 1);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"a", "banana", "app", "appl", "apple", "apply", "ap"};

        for (int i=0; i<words.length; i++) {
            // Insert each word to trie
            insert(words[i]);
        }

        System.out.println(longestWord(root, new StringBuilder("")));
    }
}
