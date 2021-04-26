import org.ice1000.jimgui.*;
import org.ice1000.jimgui.flag.JImWindowFlags;
import org.ice1000.jimgui.util.JniLoader;

public class main {
    public static void main(String[] args) {
        render();
    }

    public static void render(){
        JniLoader.load();
        try(
            JImGui imGui = new JImGui();

            NativeFloat fontSize = new NativeFloat();
        ) {
            // * load font presets
            JImFontAtlas fonts = imGui.getIO().getFonts();
            JImFont fontFromFile = fonts.addFontFromFile("res/equip.ttf", 18);
            if (fontFromFile.isLoaded()) {
                System.out.println(fontFromFile.debugName());
            }

            fontSize.modifyValue(18);

            // * load window presets
            int windowFlags = JImWindowFlags.MenuBar + JImWindowFlags.NoTitleBar;

            while (!imGui.windowShouldClose()) {
                imGui.initNewFrame();
                imGui.showStyleEditor();

                /*
                * explanation, for me who will forget in a week:
                *
                 */
                JImFont font = imGui.findFont();
                if(font != null) {
                    font.setFontSize(fontSize.accessValue());

                    // * for debugging purposes
                    final NativeString debugName = font.debugName();
                    if(debugName.isNull())
                        System.out.println("no font debug name");
                } else {
                    System.out.println("font not found");
                }

                // * begin main component launcher
                imGui.begin(new JImStr("Menu"), windowFlags);


                imGui.pushFont(fontFromFile);
                imGui.textColored(JImVec4.fromHSV(133/360f, 0.94f, 1f), "Entity");
                imGui.popFont();


                // ! cannot modify, always last line
                imGui.render();
            }
        }
    }
}
