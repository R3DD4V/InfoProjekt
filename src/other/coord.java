package other;

public class coord {
    private int X;
    private int Y;

    public coord(int pX, int pY) {
        set(pX, pY);
    }

    public int x() {
        return X;
    }

    public int y() {
        return Y;
    }

    public void set(int pX, int pY) {
        X = pX;
        Y = pY;
    }
}
