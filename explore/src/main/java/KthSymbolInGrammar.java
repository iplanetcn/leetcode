/**
 * KthSymbolInGrammar
 *
 * @author john
 * @since 2022-01-13
 */
public class KthSymbolInGrammar {
    public int kthGrammar(int n, int k) {
        if (n == 1) {
            return 0;
        }

        if (k % 2 == 0) {
            return kthGrammar(n - 1, k / 2) == 0 ? 1 : 0;
        } else {
            return kthGrammar(n - 1, (k + 1) / 2);
        }
    }

    public static void main(String[] args) {
        KthSymbolInGrammar kth = new KthSymbolInGrammar();

        System.out.println(kth.kthGrammar(1,1));
        System.out.println(kth.kthGrammar(2,1));
        System.out.println(kth.kthGrammar(3,2));
        System.out.println(kth.kthGrammar(4,5));
        System.out.println(kth.kthGrammar(30,434991989));
    }
}
