import java.util.*;

import static java.lang.String.format;
import static java.util.Collections.emptyList;

public class AutoCompleteTrie {

    public Node root = new Node('/');

    class Node {
        final Character value;
        Map<Character, Node> children = new HashMap<>();
        private boolean word = false;

        Node(final Character nodeValue) {
            this.value = nodeValue;
        }

        Character getValue() {
            return value;
        }

        Map<Character, Node> getChildren() {
            return children;
        }

        boolean isWord() {
            return word;
        }

        void addWord() {
            word = true;
        }
    }

    public void insert(final String word) {
        if(word != null) {
            // Variables used to traverse the tree
            Node node = root;
            Map<Character, Node> subtree = root.children;

            for (int level = 0; level < word.length(); level++) {
                Character value = word.charAt(level);
                node = subtree.get(value);
                if (node == null) {
                    node = new Node(value);
                    subtree.put(value, node);
                }
                // Prepare to go one level down
                subtree = subtree.get(value).children;
            }
            node.addWord();
        }
    }

    public List<String> suggest(final String prefix) {
        List<String> suggestions = new ArrayList<>();
        Node node = root;
        Map<Character, Node> subtree = root.children;
        StringBuilder path = new StringBuilder();

        // Travers the trie up to the given prefix
        for (int level = 0; level < prefix.length(); level++) {
            Character value = prefix.charAt(level);
            node = subtree.get(value);
            if (node == null) {
                return emptyList();
            }
            path.append(value);
            subtree = node.children;
        }

        // Search in the trie for words that start with the given prefix
        findSuggestions(node, suggestions, path);

        return suggestions;
    }

    // Recursive method used to find suggestions
    private void findSuggestions(final Node node, final List<String> suggestions,
                                 final StringBuilder path) {
        if (node.isWord()) {
            suggestions.add(path.toString());
        }

        Map<Character, Node> children = node.children;
        if (children.isEmpty()) {
            // We have reached a leaf node
            return;
        }

        for (Node subtree : children.values()) {
            // Traverse the subtree searching for words
            path.append(subtree.value);
            findSuggestions(subtree, suggestions, path);
            path.setLength(path.length() - 1);
        }
    }


    public static void main(final String args[]) {
        AutoCompleteTrie trie = new AutoCompleteTrie();

        final List<String> words = Arrays.asList(
                "ABAD",
                "ABACO",
                "ASTRAZENECA",
                "BACHILLER",
                "CAMILLA",
                "ETHER",
                "MARXISM",
                "STELLAR",
                "XLM");
        for (final String word : words) {
            trie.insert(word);
        }


        System.out.println("Words in the trie " + words);

        // System.out.println(trie.search("ABAD"));
        // System.out.println(trie.search("ABADIA"));
        // System.out.println(trie.search("ABACO"));
        // System.out.println(trie.search("ABA"));
        // System.out.println();

        String prefix = "Y";
        System.out.println(format("Suggesting for %s", prefix));
        System.out.println(format("  %s", trie.suggest(prefix)));
        System.out.println();

        prefix = "A";
        System.out.println(format("Suggesting for %s", prefix));
        System.out.println(format("  %s", trie.suggest(prefix)));
        System.out.println();

        prefix = "ABA";
        System.out.println(format("Suggesting for %s", prefix));
        System.out.println(format("  %s", trie.suggest(prefix)));
        System.out.println();

        prefix = "X";
        System.out.println(format("Suggesting for %s", prefix));
        System.out.println(format("  %s", trie.suggest(prefix)));
    }
}
