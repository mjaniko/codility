package hackerrank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://www.hackerrank.com/challenges/diagonal-difference/problem
 */
public class DiagonalDifference {

    /**
     * ყურადღება მისაქცევია დიაგონალზე როგორ ვიღებ ელემენტებს
     * @param arr
     * @return
     */
    public int solution(List<List<Integer>> arr) {
        int N = arr.size()-1; // num elements
        int MAX_N = arr.size() - 1;
        int firstDiagSum = 0;
        int secondDiagSum = 0;
        while (N >= 0) {
            // ერთი მასივი რომელიც დიაგონალზე მიდის ყოველთვის ტოლია N ები
            firstDiagSum += arr.get(N).get(N);
            // მეორეში ვითვლი საპირისპირო მხარეს რა იქნებოდა
            secondDiagSum += arr.get(MAX_N - N).get(N);
            N--;
        }
        return Math.abs(firstDiagSum - secondDiagSum);
    }

    public static void main(String[] args) {
        DiagonalDifference dd = new DiagonalDifference();
        List<List<Integer>> numbers = new ArrayList() {{
            add(Arrays.asList(11, 2, 4));
            add(Arrays.asList(4, 5, 6));
            add(Arrays.asList(10, 8, -12));
        }};
        System.out.println(dd.solution(numbers));

    }
}
