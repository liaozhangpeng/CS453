import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArrayList<Token> list = new ArrayList<Token>();

        while (scanner.current.tag != Token.Tag.EOF) {

            list.add(scanner.current);
            scanner.Advance();

        }
      
        String json = JSON.toJson(list);
        System.out.println(json);

    }

}
