package data.components;

public class DataOrigin {
    private DataSource source;
    private String raw;
    private String originURL;

    public DataOrigin(){

    }

    public DataOrigin(DataSource source, String raw, String originURL){
        this.source = source;
        this.originURL = originURL;
        this.raw = raw;
    }

    public DataSource getSource() {
        return source;
    }

    public String getOriginURL() {
        return originURL;
    }

    public String getRaw() {
        return raw;
    }

    public void setOriginURL(String originURL) {
        this.originURL = originURL;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public void setSource(DataSource source) {
        this.source = source;
    }
}
