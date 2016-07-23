package interviewquestions;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class StringPerms {

    public Set<String> calculatePermutations(String string) {
        if (string.length() <= 1) new HashSet<String>(Collections.singletonList(string));

        

        Set<String> result = new HashSet<>();

        return result;
    }

    public static void main(String[] args) {
        String in = "alangeorge";
        StringPerms stringPerms = new StringPerms();

        System.out.println(stringPerms.calculatePermutations(in));
    }
}
