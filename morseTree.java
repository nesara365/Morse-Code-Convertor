public class morseTree {
    private node root;

    public morseTree() {
        root = new node(null);
    }

    // Insert a character and corresponding Morse code
    public void insert(String morseCode, char letter) {
        node current = root;

        for (char c : morseCode.toCharArray()) {
            if (c == '.') {
                if (current.left == null) {
                    current.left = new node(null);
                }
                current = current.left;
            } else if (c == '-') {
                if (current.right == null) {
                    current.right = new node(null);
                }
                current = current.right;
            }
        }

        current.letter = letter;
    }

    // Decode Morse code to letter
    public Character decode(String morseCode) {
        node current = root;

        for (char c : morseCode.toCharArray()) {
            if (c == '.') {
                current = current.left;
            } else if (c == '-') {
                current = current.right;
            }

            if (current == null) {
                return null;
            }
        }

        return current.letter;
    }

    // Print the dictionary using in-order traversal
    public void printDictionary() {
        printInOrder(root);
    }

    private void printInOrder(node node) {
        if (node != null) {
            printInOrder(node.left);
            if (node.letter != null) {
                System.out.println(node.letter);
            }
            printInOrder(node.right);
        }
    }
}
