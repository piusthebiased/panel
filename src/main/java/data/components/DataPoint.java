package data.components;

// * set up like x,y,origin
public class DataPoint {
    private Object value;
    private Object label;
    private DataOrigin origin;

    public DataPoint(){

    }

    public DataPoint(Object value, Object label, DataOrigin origin){
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public DataOrigin getOrigin() {
        return origin;
    }

    public Object getLabel() {
        return label;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public void setOrigin(DataOrigin origin) {
        this.origin = origin;
    }

    public void setLabel(Object label) {
        this.label = label;
    }
}
