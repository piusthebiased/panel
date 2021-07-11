package components.games;

import components.LoadOutput;
import components.microcomponents.SelectionButton;
import org.ice1000.jimgui.JImDrawList;
import org.ice1000.jimgui.JImGui;
import org.ice1000.jimgui.JImStr;

public class GamePanel {
    private boolean open = false;

    public GamePanel(){

    }

    public static void render(JImGui imGui, LoadOutput loadOutput){
        // * begin main component launcher
        imGui.begin(new JImStr("Game Panel"), loadOutput.getWindowPresets());

        // * load drawlist
        JImDrawList mdl = imGui.findWindowDrawList();
        float mcposx = imGui.getWindowPosX();
        float mcposy = imGui.getWindowPosY();


        imGui.popFont();
        imGui.pushFont(loadOutput.getFont42());

        imGui.columns(4, "gamepanel", false);

        if(imGui.beginChild0("CS:GO", 175, 175)){
            SelectionButton.Button(imGui, loadOutput, "CS:GO", 55);

            if(imGui.invisibleButton("csgobutton", 175, 175)){
                System.out.println("im clicked \\o/");
            }
        }
        imGui.endChild();

    }

    public void toggle(){
        if(open){
            open = false;
        } else {
            open = true;
        }
    }

    public boolean isOpen() {
        return open;
    }
}
