package data.rest.bls;

import data.APICredentials;
import data.REST;
import data.components.DataOrigin;
import data.components.DataPoint;
import data.components.DataSource;
import org.json.JSONArray;
import org.json.JSONObject;

public class BLS {
    private static String baseURL = "https://api.bls.gov/publicAPI/v2/timeseries/data/";

    private static String authCred = APICredentials.blsKey;

    public static DataPoint[] SingleSeries(String seriesID, String perams){
        String url = baseURL + perams;

        JSONArray series = new JSONArray();
        series.put(seriesID);

        JSONObject payload = new JSONObject();
        payload.put("seriesid", series);
        payload.put("registrationkey", authCred);

        JSONObject response = new JSONObject(REST.post(url, payload.toString()));
        JSONObject results = response.getJSONObject("Results");
        JSONArray seriesResponse = results.getJSONArray("series");
        JSONObject rawdata = seriesResponse.getJSONObject(0);
        JSONArray data = rawdata.getJSONArray("data");

        DataPoint[] values = new DataPoint[data.length()];
        for(int i = 0; i < data.length(); i++){
            JSONObject datapoint = data.getJSONObject(i);
            DataPoint point = new DataPoint();

            point.setLabel(datapoint.getString("year") + datapoint.getString("period"));
            point.setOrigin(new DataOrigin(DataSource.BLS, datapoint.toString(), url));
            point.setValue(datapoint.get("value"));

            values[i] = point;
        }

        return values;
    }
}
