import components.GuiConfig;
import components.LoadOutput;
import components.Menu;
import org.ice1000.jimgui.*;
import org.ice1000.jimgui.util.JniLoader;

public class main {
    public static void main(String[] args) {
        render();
    }

    public static void render(){
        JniLoader.load();
        // * preload file

        try(JImGui imGui = new JImGui();) {
            // * load font presets
            LoadOutput loadOutput = GuiConfig.load(imGui);

            while (!imGui.windowShouldClose()) {
                imGui.initNewFrame();

                // * load
                GuiConfig.render(imGui, loadOutput);

                Menu.render(imGui, loadOutput);

                // ! cannot modify, always last line
                imGui.render();
            }
        }
    }
}
