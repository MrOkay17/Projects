public class MeanCalc {
    private int s;
    private int r1;
    private int r2;

    public MeanCalc(int a, int b) {
        r1 = a;
        s = b;

    }

    public int getMean() {
        r2 = s * 2 - r1;
        return r2;
    }
}
