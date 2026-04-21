public class DistinctSubsequences {

    public static int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        int[][] dp = new int[m + 1][n + 1];

    
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

    
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }

    public static void runTest(String s, String t) {
        System.out.println("Input: \"" + s + "\", \"" + t + "\"");
        int result = numDistinct(s, t);
        System.out.println("Distinct Subsequences: " + result);
        System.out.println("----------------------");
    }

    public static void main(String[] args) {

        runTest("rabbbit", "rabbit");
        runTest("babgbag", "bag");   
        runTest("aaaaa", "aa");     
    }
}
