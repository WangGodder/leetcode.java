package easy;

/**
 * @author: godder
 * @date: 2019/2/24
 */
public class FindTheTownJudge_997 {

    public int findJudge(int N, int[][] trust) {
        // if trust is empty, then think whether N is bigger than 1
        if (trust.length == 0) {
            if (N == 1) {
                return 1;
            } else {
                return -1;
            }
        }
        // use array to store the number of people who trust him
        int[] trustedNumArray = new int[N + 1];
        // use array to store the number of people he trust
        int[] trustNumArray = new int[N + 1];
        // initialize
        for (int i = 1; i < N + 1; i++) {
            trustNumArray[i] = 0;
            trustedNumArray[i] = 0;
        }
        // record the most trust penson and the number of people who trust him
        int mostTrustPenson = 1, maxTrustPeopleNumber = 0;
        for (int[] t : trust) {
            trustedNumArray[t[1]]++;
            trustNumArray[t[0]]++;
            if (trustedNumArray[t[1]] > maxTrustPeopleNumber) {
                mostTrustPenson = t[1];
                maxTrustPeopleNumber = trustedNumArray[t[1]];
            }
        }
        // if the most trust penson don't trust other and the number of trust must be N-1
        if (trustNumArray[mostTrustPenson] == 0 && maxTrustPeopleNumber == N-1) {
            return mostTrustPenson;
        }
        return -1;
    }
}
