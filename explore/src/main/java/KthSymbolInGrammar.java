import java.util.ArrayList;
import java.util.List;

/**
 * KthSymbolInGrammar
 *
 * @author john
 * @since 2022-01-13
 */
public class KthSymbolInGrammar {
    public int kthGrammar(int n, int k) {
        return row(n).get(k - 1);
    }

    public List<Integer> row(int n) {
        if (n == 1) {
            return List.of(1);
        }

        if (n == 2) {
            return List.of(0, 1);
        }


        List<Integer> row1 = new ArrayList<>(row(n - 1));
        List<Integer> row2 = row1.stream().map(integer -> {
            if (integer == 0) {
                return 1;
            }
            return 0;
        }).toList();

        row1.addAll(row2);
        return row1;
    }

    public static void main(String[] args) {
        KthSymbolInGrammar kth = new KthSymbolInGrammar();

        System.out.println(kth.row(1));
        System.out.println(kth.row(2));
        System.out.println(kth.row(3));
        System.out.println(kth.row(4));

        System.out.println(kth.kthGrammar(1,1));
        System.out.println(kth.kthGrammar(2,1));
        System.out.println(kth.kthGrammar(3,1));
//        System.out.println(kth.kthGrammar(30,434991989));
    }
}
