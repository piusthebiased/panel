package components.finance.microcomponents;

import components.LoadOutput;
import data.components.DataPoint;
import org.ice1000.jimgui.JImFont;
import org.ice1000.jimgui.JImGui;

public class Chart {
    private DataPoint[] data;
    private ChartProps props;
    private LoadOutput loadOutput;

    // * constructors
    public Chart(){

    }

    public Chart(DataPoint[] data, ChartProps props, LoadOutput loadOutput){
        this.data = data;
        this.props = props;
    }

    // * render
    public void render(JImGui imGui){
        ChartType type = props.getType();

        switch (type){
            case BAR:
                renderBar(imGui);
                break;
            case FINANCEBAR:
                renderFinBar(imGui);
                break;
            case LINE:
                renderLine(imGui);
                break;
            case PIE:
                renderPie(imGui);
                break;
            case SCATTER:
                renderScatter(imGui);
                break;
            case HISTOGRAM:
                renderHistogram(imGui);
                break;
        }
    }

    private void renderBar(JImGui imGui){
        imGui.popFont();
        imGui.pushFont(loadOutput.getFinanceFont());


    }

    private void renderFinBar(JImGui imGui){

    }

    private void renderLine(JImGui imGui){

    }

    private void renderPie(JImGui imGui){

    }

    private void renderScatter(JImGui imGui){

    }

    private void renderHistogram(JImGui imGui){

    }


    // * modifiers
    public DataPoint[] getData() {
        return data;
    }

    public void setData(DataPoint[] data) {
        this.data = data;
    }

    public void setProps(ChartProps props) {
        this.props = props;
    }

    public ChartProps getProps() {
        return props;
    }

    public LoadOutput getLoadOutput() {
        return loadOutput;
    }

    public void setLoadOutput(LoadOutput loadOutput) {
        this.loadOutput = loadOutput;
    }
}
