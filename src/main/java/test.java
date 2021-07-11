import data.components.DataPoint;
import data.rest.bls.BLS;

public class test {
    public static void main(String[] args) throws InterruptedException {
        DataPoint[] points = BLS.SingleSeries("CUUR0000SA0", "?output_view=pct_12mths");

        System.out.println(points.length);
        System.out.println("=====");
        int i = 1;
        for(DataPoint point : points){
            System.out.println(i);
            System.out.println(point.getLabel());
            System.out.println(point.getValue());
            System.out.println("=====");
            i++;
        }
    }
}