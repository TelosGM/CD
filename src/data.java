/**
 * Created by javi3 on 06/05/2016.
 */
public class data {

    private int [][] draw;
    private int i;
    private int j;
    private int max;

    public data (int section, int width,int max){

        int [][] draw = new int[section%width][section/width];
        int i= section/width;
        int j = section%width;
        int m=max;
    }

    public int[][] getDraw() {
        return draw;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getMax() {
        return max;
    }
}
