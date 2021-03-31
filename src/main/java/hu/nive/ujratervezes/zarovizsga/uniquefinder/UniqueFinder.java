package hu.nive.ujratervezes.zarovizsga.uniquefinder;

import java.util.ArrayList;
import java.util.List;


public class UniqueFinder {


    public List<Character> uniqueChars(String s) {
        if (s == null || s.isBlank()) {
            throw new IllegalArgumentException("String most not be empty");
        }

        List<Character> uniques = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (!uniques.contains(c))
                uniques.add(c);
        }
        return uniques;
    }
}
