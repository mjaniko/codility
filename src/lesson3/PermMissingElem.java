package lesson3;

public class PermMissingElem {

    /**
     * Detected time complexity:
     * O(N) or O(N * log(N))
     *
     * @param A
     * @return
     */
    public int solution(int[] A) {
        long N = A.length + 1; // Number of Elements in sum
        long sumAllElements = N * (N + 1) / 2; // we are going to subtract all known values
        long sum = 0L;
        for (int i = 0; i < A.length; i++) {
            sum += A[i];
        }
        return (int) (sumAllElements - sum);
    }

    public int solution2(int[] A, int numerElementsInSum) {
        int result = 0;

        int N = A.length;
        for (int i = 0; i < N; i++) {
            result ^= A[i];
        }

        for (int i = 1; i <= N + numerElementsInSum; i++) {
            result ^= i;
        }
        return result;
    }

    public static void main(String[] args) {
        PermMissingElem pme = new PermMissingElem();
        int[] A = new int[]{2, 3, 1, 5};
        System.out.println(pme.solution(A));
        System.out.println(pme.solution2(A, A.length + 1));
    }
}
