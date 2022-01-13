import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PascalTriangleII {
    public List<Integer> getRow(int rowIndex) {
        if (rowIndex < 0 || rowIndex > 33) {
            return null;
        }

        if (rowIndex == 0) {
            return Collections.singletonList(1);
        }

        if (rowIndex == 1) {
            return Arrays.asList(1, 1);
        }

        List<Integer> aboveRow = getRow(rowIndex - 1);
        List<Integer> integers = new ArrayList<>(Arrays.asList(1, 1));
        for (int i = 1; i < aboveRow.size(); i++) {
            integers.add(i, aboveRow.get(i - 1) + aboveRow.get(i));
        }
        return integers;
    }


    public static void main(String[] args) {
        System.out.println(new PascalTriangleII().getRow(0));
        System.out.println(new PascalTriangleII().getRow(1));
        System.out.println(new PascalTriangleII().getRow(2));
        System.out.println(new PascalTriangleII().getRow(3));
        System.out.println(new PascalTriangleII().getRow(4));
    }
}