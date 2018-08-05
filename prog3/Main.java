import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // Run the test. 
        String s = args[0];
        int index = Integer.parseInt(args[1]);
        System.out.println(TokenMatcher.getToken(s.toCharArray(), index).tag);
    }

}
