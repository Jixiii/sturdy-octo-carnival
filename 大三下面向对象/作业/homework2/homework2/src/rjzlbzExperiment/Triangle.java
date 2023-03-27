package rjzlbzExperiment;

/**
 * @author IDK You Yet
 */
public class Triangle {
    private int a1;
    private int b1;
    private int c1;

    public Triangle() {
    }

    public Triangle(int a, int b, int c) {
        this.a1 = a;
        this.b1 = b;
        this.c1 = c;
    }

    public String panDuanXingZhuang(int a,int b,int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return "边长非法";
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "不能构成三角形";
        }
        if (a == b && b == c) {
            return "等边三角形";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (a == b || b == c || a == c) {
            stringBuilder.append("等腰");
        } else {
            stringBuilder.append("一般");
        }
        stringBuilder.append("三角形");
        return stringBuilder.toString();
    }
}
