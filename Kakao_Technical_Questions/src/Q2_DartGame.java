import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Q2_DartGame {

    private int parseScore(int rounds, String score) {
        int[] resScore = new int[rounds];
        int result = 0;
        Pattern ptr = Pattern.compile("(\\d+[S|D|T][#|*]*)(\\d+[S|D|T][#|*]*)(\\d+[S|D|T][#|*]*)");
        Matcher mtr = ptr.matcher(score);
        mtr.find();
        for (int i = 1; i <= rounds; i++) {
            Pattern sptr = Pattern.compile("(\\d+)(.*)");
            Matcher smtr = sptr.matcher(mtr.group(i));
            smtr.find();
            resScore[i - 1] = Integer.parseInt(smtr.group(1));
            for (int j = 0; j < smtr.group(2).length(); j++) {
                switch (smtr.group(2).charAt(j)) {
                    case 'S': resScore[i - 1] = resScore[i - 1] * 1;
                              break;
                    case 'D': resScore[i - 1] = resScore[i - 1] * resScore[i - 1];
                              break;
                    case 'T': resScore[i - 1] = resScore[i - 1] * resScore[i - 1] * resScore[i - 1];
                              break;
                    case '*': resScore[i - 1] = resScore[i - 1] * 2;
                              if (i != 1) { resScore[i - 2] = resScore[i - 2] * 2; }
                              break;
                    case '#': resScore[i - 1] = resScore[i - 1] * (-1);
                              break;
                }
            }
        }
        for (int i : resScore) {
            result += i;
        }
        return result;
    }

    public static void main(String[] args) {
        // Setup test cases
        String[] test = {"1S2D*3T", "1D2S#10S", "1D2S0T", "1S*2T*3S", "1D#2S*3S", "1T2D3D#", "1D2S3T*"};
        int rounds = 3;

        // Setup solver
        Q2_DartGame solver = new Q2_DartGame();

        // Test solution
        for (int i = 0; i < test.length; i++) {
            System.out.println(solver.parseScore(rounds, test[i]));
        }
    }
}
