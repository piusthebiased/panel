package components;

import components.finance.FinancePanel;
import components.games.GamePanel;
import components.microcomponents.SelectionButton;
import org.ice1000.jimgui.JImDrawList;
import org.ice1000.jimgui.JImGui;
import org.ice1000.jimgui.JImStr;
import org.ice1000.jimgui.util.ColorUtil;

public class Menu {
    private static GamePanel gamePanel = new GamePanel();
    private static FinancePanel financePanel = new FinancePanel();

    public static void render(JImGui imGui, LoadOutput loadOutput){
        // * begin main component launcher
        imGui.begin(new JImStr("Menu"), loadOutput.getWindowPresets());

        // * load drawlist
        JImDrawList mdl = imGui.findWindowDrawList();
        float mcposx = imGui.getWindowPosX();
        float mcposy = imGui.getWindowPosY();


        imGui.popFont();
        imGui.pushFont(loadOutput.getFont42());

        imGui.columns(4, "menupanel", false);

        if(imGui.beginChild0("school", 175, 175)){
            SelectionButton.Button(imGui, loadOutput, "School", 55);

            if(imGui.invisibleButton("schoolbutton", 175, 175)){
                System.out.println("im clicked \\o/");
            }
        }
        imGui.endChild();

        imGui.nextColumn();
        if(imGui.beginChild0("programming", 175, 175)){
            SelectionButton.Button(imGui, loadOutput, "Programming", 30);

            if(imGui.invisibleButton("programming", 175, 175)){
                System.out.println("im clicked \\o/");
            }
        }
        imGui.endChild();

        imGui.nextColumn();
        if(imGui.beginChild0("gaming", 175, 175)){
            SelectionButton.Button(imGui, loadOutput, "Gaming", 50);

            if(imGui.invisibleButton("gaming", 175, 175)){
                gamePanel.toggle();
            }
        }
        imGui.endChild();

        imGui.nextColumn();
        if(imGui.beginChild0("finance", 175, 175)){
            SelectionButton.Button(imGui, loadOutput, "Finance", 55);

            if(imGui.invisibleButton("finance", 175, 175)){
                financePanel.toggle();
            }
        }
        imGui.endChild();

        // * if state, load;
        if(gamePanel.isOpen()){
            GamePanel.render(imGui, loadOutput);
        }

        if(financePanel.isOpen()){
            FinancePanel.render(imGui, loadOutput);
        }
    }
}
