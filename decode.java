import java.util.Stack;

public class decode {
    private morseTree tree;

    public decode(morseTree tree) {
        this.tree = tree;
    }

    // Use stack to reverse the incoming Morse code message
    public String reverseString(String message) {
        Stack<Character> stack = new Stack<>();
        StringBuilder reversedMessage = new StringBuilder();

        // pushing characters to stack
        for (char c : message.toCharArray()) {
            stack.push(c);
        }

        // pop to get reversed
        while (!stack.isEmpty()) {
            reversedMessage.append(stack.pop());
        }

        return reversedMessage.toString();
    }

    // Decode the message
    public String decodeMessage(String message) {
        Stack<String> stack = new Stack<>();
        StringBuilder decodedMessage = new StringBuilder();

        String[] morseCharacters = message.split(" ");

        // Push Morse code the stack
        for (String morseChar : morseCharacters) {
            stack.push(morseChar);
        }

        // Pop from the stack and decode
        while (!stack.isEmpty()) {
            String morseCode = stack.pop();

            if (morseCode.equals("/")) {
                decodedMessage.append(" ");
            } else {
                Character decodedChar = tree.decode(morseCode);
                if (decodedChar != null) {
                    decodedMessage.append(decodedChar);
                } else {
                    decodedMessage.append("unknoiwn"); // Handle unknown characters
                }
            }
        }

        return decodedMessage.toString();
    }

    // Reverse decoded message with stack
    public String reverseDecodedMessage(String decodedMessage) {
        Stack<Character> stack = new Stack<>();
        StringBuilder reversedMessage = new StringBuilder();


        for (char c : decodedMessage.toCharArray()) {
            stack.push(c);
        }

        // Pop each character to get the reversed string
        while (!stack.isEmpty()) {
            reversedMessage.append(stack.pop());
        }

        return reversedMessage.toString();
    }
}
