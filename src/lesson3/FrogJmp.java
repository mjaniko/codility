package lesson3;

public class FrogJmp {

    /**
     * 1 Min
     * Detected time complexity: O(1)
     * @param X
     * @param Y
     * @param D
     * @return
     */
    public int solution(int X, int Y, int D) {
        int coefficent = (Y - X) / D;
        int coff = ((Y - X) % D) > 0 ? D : 0;
        return ((coefficent * D) + coff) / D;
    }

    /**
     * 1 Min
     * Detected time complexity: O(1)
     * @param X
     * @param Y
     * @param D
     * @return
     */
    public int solution2(int X, int Y, int D) {
        long difference = Y - X;
        long plus = 0;// note: need to decide if to "plus one" or not
        if (difference % D != 0) // using "mod" to decide
            plus = 1;// if not "perfectly Divisible", then plus one
        long hop =0; // number of hops the frog needs to jump
        hop = difference / D;
        hop = hop + plus;
        return (int)hop;
    }

    public static void main(String[] args) {
        FrogJmp fj = new FrogJmp();
        int X = 10;
        int Y = 100;
        int D = 30;
        System.out.println(fj.solution(X, Y, D));
        System.out.println(fj.solution2(X, Y, D));
    }

}
