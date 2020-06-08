/**
 * An array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index,
 * and the last element of the array is moved to the first place. For example,
 * the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7] (elements are shifted right by one index and 6 is moved to the first place).
 * <p>
 * The goal is to rotate array A K times; that is, each element of A will be shifted to the right K times.
 * <p>
 * Write a function:
 * <p>
 * class Solution { public int[] solution(int[] A, int K); }
 * <p>
 * that, given an array A consisting of N integers and an integer K, returns the array A rotated K times.
 * <p>
 * For example, given
 * <p>
 * A = [3, 8, 9, 7, 6]
 * K = 3
 * the function should return [9, 7, 6, 3, 8]. Three rotations were made:
 * <p>
 * [3, 8, 9, 7, 6] -> [6, 3, 8, 9, 7]
 * [6, 3, 8, 9, 7] -> [7, 6, 3, 8, 9]
 * [7, 6, 3, 8, 9] -> [9, 7, 6, 3, 8]
 * For another example, given
 * <p>
 * A = [0, 0, 0]
 * K = 1
 * the function should return [0, 0, 0]
 * <p>
 * Given
 * <p>
 * A = [1, 2, 3, 4]
 * K = 4
 * the function should return [1, 2, 3, 4]
 * <p>
 * Assume that:
 * <p>
 * N and K are integers within the range [0..100];
 * each element of array A is an integer within the range [−1,000..1,000].
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 * A[0] -ს ვიყენებ მნიშვნელობის შესანახად, დალშე ვაკეთებ შიფთინგს
 * A.length - 1 იმიტომ რომ out of bound exception-ზე არ გავიდე
 */
public class CyclicRotation {

    public int[] solution(int[] A, int K) {
        while (K > 0) {
            for (int i = 0; i < A.length - 1; i++) {
                A[0] += A[i + 1];
                A[i + 1] = A[0] - A[i + 1];
                A[0] = A[0] - A[i + 1];
            }
            K--;
        }
        return A;
    }

    /* utility function to print an array */
    void printArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] A = new int[]{3, 8, 9, 7, 6};
        int K = 3;
        CyclicRotation bg = new CyclicRotation();
        bg.printArray(A);
        bg.solution(A, K);
        bg.printArray(A);
    }
}