public class Main {
    public static void main(String[] args) {
        // morse code tree create
        morseTree tree = new morseTree();

        // Arrays for Morse codes and corresponding letters
        String[] morseCodes = {
                ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---",
                "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-",
                "..-", "...-", ".--", "-..-", "-.--", "--.."
        };

        char[] letters = {
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
                'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
                'U', 'V', 'W', 'X', 'Y', 'Z'
        };

        // Insert into the morseTree using the arrays
        for (int i = 0; i < morseCodes.length; i++) {
            tree.insert(morseCodes[i], letters[i]);
        }

        // In-order traversal dictionary print
        tree.printDictionary();
        System.out.println();

        // reverse decode
        decode decoder = new decode(tree);

        String sampleMorseMessage = "/ -- . ..-. ...- --- .-. .--. / . .... - / . -... ..-. --- ... / - ... .-. .. .-..";

        // Reverse the message
        String reversedMessage = decoder.reverseString(sampleMorseMessage);

        // Decode the reversed message
        String decodedMessage = decoder.decodeMessage(reversedMessage);


        String reversedDecodedMessage = decoder.reverseDecodedMessage(decodedMessage);

        // Print statements for decode and reverse
        System.out.println("Decoded Message: " + decodedMessage);
        System.out.println("Reversed Message: " + reversedDecodedMessage);
    }
}
