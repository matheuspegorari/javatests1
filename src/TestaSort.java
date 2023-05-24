import java.util.ArrayList;
import static java.util.Comparator.comparing;

public class TestaSort {
    public static void main(String[] args) {
        String palavra1 = "Oi";
        String palavra2 = "Como vai você?";
        String palavra3 = "Tudo bem?";

        ArrayList<String> palavras = new ArrayList<>();

        palavras.add(palavra1);
        palavras.add(palavra2);
        palavras.add(palavra3);

        palavras.sort(comparing(String::length));

        System.out.println(palavras);
    }
}
