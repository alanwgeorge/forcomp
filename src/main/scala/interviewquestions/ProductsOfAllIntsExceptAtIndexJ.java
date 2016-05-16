package interviewquestions;

import java.util.Arrays;
import java.util.StringJoiner;

public class ProductsOfAllIntsExceptAtIndexJ {
    public static void main(String[] args) {
        int[] ints1 = new int[]{1, 7, 3, 4};
        int[] ints2 = new int[]{1, 7, 3, 4, 0};
        int[] ints3 = new int[]{1, 2, 6, 5, 9};
        int[] ints4 = new int[]{3, 1, 2, 5, 6, 4};
        int[] ints5 = new int[]{3};
        int[] ints6 = new int[]{};


        ProductsOfAllIntsExceptAtIndexJ products = new ProductsOfAllIntsExceptAtIndexJ();

        products.print(products.getProductsOfAllIntsExceptAtIndex(ints1));
        products.print(products.getProductsOfAllIntsExceptAtIndex(ints2));
        products.print(products.getProductsOfAllIntsExceptAtIndex(ints3));
        products.print(products.getProductsOfAllIntsExceptAtIndex(ints4));
        products.print(products.getProductsOfAllIntsExceptAtIndex(ints5));
        products.print(products.getProductsOfAllIntsExceptAtIndex(ints6));
    }

    private int[] getProductsOfAllIntsExceptAtIndex(int[] ints) {
        int[] result = new int[ints.length];
        Arrays.fill(result, 1);
        int accumRight = 1;
        int accumLeft = 1;
        for (int i = 0; i < ints.length; i++) {
            result[i] *= accumRight;
            result[ints.length - (i + 1)] *= accumLeft;
            accumRight *= ints[i];
            accumLeft *= ints[ints.length - (i + 1)];
        }

        return result;
    }

    private void print(int[] ints) {
        StringJoiner results = new StringJoiner(",", "{", "}");

        for (int i : ints) {
            results.add(Integer.toString(i));
        }
        System.out.println(results.toString());
    }

}
