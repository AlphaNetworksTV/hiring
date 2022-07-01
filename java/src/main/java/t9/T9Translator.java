package t9;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class T9Translator {

    /**
     * Translate a stream of bytes containing only T9 keyboard characters to a
     * human-readable text.
     * Only characters 2-9, 0, space are allowed as input using standard layout
     * representation:
     * 2 -> abc
     * 3 -> def
     * 4 -> ghi
     * 5 -> jkl
     * 6 -> mno
     * 7 -> pqrs
     * 8 -> tuc
     * 9 -> wxyz
     * 0 -> a space
     * space -> a "pause"
     * A space is used to represent some time between two presses of the same
     * button.
     * For instance, to write "hihi": "44 444 44 444"
     * Pauses can be repeated multiple time, including between two different key
     * presses and should not impact output
     */

    public static Map<String, Character> T9 = new HashMap<>();
    static {
        T9.put("2", 'a');
        T9.put("22", 'b');
        T9.put("222", 'c');
        T9.put("3", 'd');
        T9.put("33", 'e');
        T9.put("333", 'f');
        T9.put("4", 'g');
        T9.put("44", 'h');
        T9.put("444", 'i');
        T9.put("5", 'j');
        T9.put("55", 'k');
        T9.put("555", 'l');
        T9.put("6", 'm');
        T9.put("66", 'n');
        T9.put("666", 'o');
        T9.put("7", 'p');
        T9.put("77", 'q');
        T9.put("777", 'r');
        T9.put("7777", 's');
        T9.put("8", 't');
        T9.put("88", 'u');
        T9.put("888", 'v');
        T9.put("9", 'w');
        T9.put("99", 'x');
        T9.put("999", 'y');
        T9.put("9999", 'z');
        T9.put("0", ' ');
    }

    public String translate(InputStream stream) throws IOException {
        // print(stream);
        String output = "";
        String val = stream.toString();
        String[] vals = val.split("\\s+");

        for (String string : vals) {
            output += T9.get(string);
        }

        return output;
    }

}
