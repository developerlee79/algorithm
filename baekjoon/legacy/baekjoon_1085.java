public class baekjoon_1085 {
    int x = 6;
    int y = 2;
    int w = 10;
    int h = 3;

    static int getMin(int x, int y, int w, int h) {
        int x_min = Math.min(x, w - x);
        int y_min = Math.min(y, h - y);

        return Math.min(x_min, y_min);
    }
}
