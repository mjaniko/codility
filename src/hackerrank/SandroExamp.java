package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SandroExamp {

    public int solution(int[] a) {
        int leftSum = a[0];
        int rightSum = 0;

        for (int i = 0; i < a.length; i++) {
            rightSum += a[i];
        }

        for (int i = 0; i < a.length - 1; i++) {
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += a[i + 1];
            rightSum -= a[i];
        }
        return -1;//otherwise we return -1 as not found
    }

    static int getCoutnries() {

        HttpURLConnection con = null;
        try {
            URL url = new URL("https://restcountries.eu/rest/v2/all");
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Accept-Charset", "utf-8");
            int responseCode = con.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String inpLine;
                StringBuilder responseBody = new StringBuilder();
                while ((inpLine = in.readLine()) != null) {
                    responseBody.append(inpLine);
                }
                in.close();
                if (responseBody.length() > 0) {
                    System.out.println(responseBody.toString());

                    Pattern propertiesValuePattern = Pattern.compile("\"region\"\\s*:\\s*\"([^\"]*)\"");
                    Matcher messageMatcher = propertiesValuePattern.matcher(responseBody);
                    while (messageMatcher.find()) {
                        // Get the group matched using group() method
                        //System.out.println("OUT:" + messageMatcher.group(1));
                    }

                  // "population"\s*:(\d+)

                    Pattern populationPattern = Pattern.compile("\"population\"\\s*:\"((\\\\\"|[^\"])*)\"");
                    Matcher populationMatcher = populationPattern.matcher(responseBody);
                    while (populationMatcher.find()) {
                        // Get the group matched using group() method
                        System.out.println("POP:" + populationMatcher.group());
                    }
                }
            } else {
                System.out.println("GET request not worked");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void main(String[] args) {
        SandroExamp se = new SandroExamp();
        System.out.println(se.solution(new int[]{1, 2, 3, 4, 6}));
        System.out.println(se.getCoutnries());
    }


}
