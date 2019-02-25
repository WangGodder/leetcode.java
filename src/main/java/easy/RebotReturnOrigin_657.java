package easy;

/**
 * @author: godder
 * @date: 2019/2/24
 */
public class RebotReturnOrigin_657 {
    public boolean judgeCircle(String moves) {
        int horizon = 0, vertical = 0;
        for (char move : moves.toCharArray()) {
            switch (move) {
                case 'R': horizon++; break;
                case 'L': horizon--; break;
                case 'U': vertical++; break;
                case 'D': vertical--; break;
                default: break;
            }
        }
        return horizon == 0 && vertical == 0;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        String moves = "UD";
        RebotReturnOrigin_657 solution = RebotReturnOrigin_657.class.newInstance();
        boolean result = solution.judgeCircle(moves);
        System.out.println(result);
    }
}
