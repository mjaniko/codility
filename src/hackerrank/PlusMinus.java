package hackerrank;

public class PlusMinus {

    // Complete the plusMinus function below.
    static void solution(int[] arr) {
        float zero = 0;
        float negative = 0;
        float pos = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                pos++;
            } else if (arr[i] == 0) {
                zero++;
            } else if (arr[i] < 0) {
                negative++;
            }
        }
        pos /= arr.length;
        negative /= arr.length;
        zero /= arr.length;
        System.out.println(pos);
        System.out.println(negative);
        System.out.println(zero);
        float val = 1.12345678901234f;
        System.out.println(val);
    }


    static String timeConversion(String s) {
        /*
         * Write your code here.
         */

        // 07:05:45PM
        // 19:05:45
        int time = Integer.parseInt(s.substring(0, 2));
        String period = s.substring(s.length() - 2);
        if (period.equals("PM")) {
            if(time > 12){
                time = Math.abs(12 - (24 - time));
            }
            else if(time <= 24){
                time = Math.abs(24 - (12 - time));
            }
        } else {
            if(time >= 12){
                time = Math.abs(12 - (24 - time));
            } else if(time <= 24){
                time = Math.abs(24 - (12 - time));
            }
        }
        return (time < 10 ? "0" + time : time) + s.substring(2, s.length() - 2);
    }

    public static void main(String[] args) {
        PlusMinus pm = new PlusMinus();
        pm.solution(new int[]{-4, 3, -9, 0, 4, 1});
        System.out.println(pm.timeConversion("06:40:03AM"));
        System.out.println(pm.timeConversion("17:40:03PM"));
        System.out.println(pm.timeConversion("07:05:45PM"));
        System.out.println(pm.timeConversion("04:59:59AM"));
        System.out.println(pm.timeConversion("12:45:54PM"));
    }
}
