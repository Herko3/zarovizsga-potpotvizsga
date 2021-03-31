package hu.nive.ujratervezes.zarovizsga.countchars;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class DaVinciCode {

    private final List<Character> ALLOWED_CHARACTERS_TO_SEARCH = List.of('x','0','1');

    public int encode(String path, char searched) {
        if(!ALLOWED_CHARACTERS_TO_SEARCH.contains(searched)){
            throw new IllegalArgumentException("Not valid character to search!");
        }

        List<String> lines = null;
        try {
            lines = Files.readAllLines(Path.of(path));
        } catch (IOException ioe) {
            throw new IllegalStateException("Cannot read file", ioe);
        }

        int sum = 0;
        for (String line : lines) {
            sum += getNumberOfOccurence(searched, line);
        }
        return sum;
    }

    private int getNumberOfOccurence(char searched, String line) {
        int sum = 0;
        for (char c : line.toCharArray()) {
            if (c == searched) {
                sum++;
            }
        }
        return sum;
    }
}
