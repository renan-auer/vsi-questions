import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnagramGenerator {

    public static List<String> generateAnagrams(String input) {
        if (input == null || input.isEmpty() || !input.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Input must be non-empty and contain only letters.");
        }

        List<String> result = new ArrayList<>();
        permute(input.toCharArray(), 0, result);
        return result;
    }

    private static void permute(char[] chars, int currentIndex, List<String> result) {
        if (currentIndex == chars.length - 1) {
            result.add(new String(chars));
            return;
        }

        for (int i = currentIndex; i < chars.length; i++) {
            swap(chars, currentIndex, i);
            permute(chars, currentIndex + 1, result);
            swap(chars, currentIndex, i); // backtrack
        }
    }

    private static void swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        String input = "abc";
        List<String> anagrams = generateAnagrams(input);
        System.out.println("Anagrams of '" + input + "': " + anagrams);
    }
}

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

class AnagramGeneratorTest {

    @Test
    void testGenerateAnagramsNormalCase() {
        List<String> anagrams = AnagramGenerator.generateAnagrams("abc");
        List<String> expected = List.of("abc", "acb", "bac", "bca", "cab", "cba");
        Collections.sort(anagrams);
        Collections.sort(expected);
        assertEquals(expected, anagrams);
    }

    @Test
    void testGenerateAnagramsSingleLetter() {
        List<String> anagrams = AnagramGenerator.generateAnagrams("a");
        assertEquals(List.of("a"), anagrams);
    }

    @Test
    void testGenerateAnagramsInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> AnagramGenerator.generateAnagrams(""));
        assertThrows(IllegalArgumentException.class, () -> AnagramGenerator.generateAnagrams(null));
        assertThrows(IllegalArgumentException.class, () -> AnagramGenerator.generateAnagrams("123"));
    }
}
