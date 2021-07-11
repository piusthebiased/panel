package components.finance.microcomponents;

public class ChartProps {
    private ChartType type;
    private int height;
    private int length;

    public ChartProps(){

    }

    public ChartProps(ChartType type, int height, int length){
        this.type = type;
        this.height = height;
        this.length = length;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setType(ChartType type) {
        this.type = type;
    }

    public ChartType getType() {
        return type;
    }

    public int getHeight() {
        return height;
    }

    public int getLength() {
        return length;
    }
}
