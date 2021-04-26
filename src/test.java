import org.ice1000.jimgui.*;
import org.ice1000.jimgui.util.JniLoader;

public class test {

    public static void main(String[] args) throws InterruptedException {
        JniLoader.load();

        try (NativeFloat fontSize = new NativeFloat(); JImGui imGui = new JImGui()) {
            fontSize.modifyValue(18);
            JImFontAtlas fonts = imGui.getIO().getFonts();
            fonts.addFontDefault();
            JImFont fontFromFile = fonts.addFontFromFile("res/open-sans.ttf", 24);

            if (fontFromFile.isLoaded())
                System.out.println(fontFromFile.debugName());

            while (!imGui.windowShouldClose()) {
                imGui.initNewFrame();

                JImFont font = imGui.findFont();

                if (font != null) {
                    font.setFontSize(fontSize.accessValue());

                    final NativeString string = font.debugName();

                    if (string.isNull()) {
                        imGui.text("Dunno");
                    } else {
                        imGui.text(string);
                    }
                } else {
                    imGui.text("Not found");
                }

                imGui.dragFloat("Font size", fontSize);
                imGui.showFontSelector("Wtf");
                imGui.pushFont(imGui.getIO().getFontDefault());
                imGui.text("Default font");
                imGui.popFont();
                imGui.pushFont(fontFromFile);
                imGui.text("FiraCode font");
                imGui.popFont();
                imGui.render();
            }
        }
    }
}