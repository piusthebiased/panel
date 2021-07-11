package data.rest.bls;

import data.components.DataPoint;

public class CUUR {
    public static DataPoint[] CPIPerc12Month(){
        return BLS.SingleSeries("CUUR0000SA0", "?output_view=pct_12mths");
    }
}
