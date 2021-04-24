package hackerrank;

public class MinCostClimbingStairs {

    public int solution(int[] cost) {
        int[] temp = new int[cost.length];
        temp[0] = cost[0];
        temp[1] = cost[1];
        for (int i = 2; i < cost.length; i++) {
            temp[i] = cost[i] + Math.min(temp[i - 1], temp[i - 2]);
        }
        return Math.min(temp[cost.length - 1], temp[cost.length - 2]);
    }

    public static void main(String[] args) {
        MinCostClimbingStairs mccs = new MinCostClimbingStairs();
        System.out.println(mccs.solution(new int[]{10, 15, 20}));
        System.out.println(mccs.solution(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
