package flatlafdemo;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;

public class Main {
    public static void main(String[] args) {
        // formulario Light
        FlatLightLaf.setup();

        UIManager.put("Component.arc", 12);
        UIManager.put("Button.arc", 14);
        UIManager.put("TextComponent.arc", 10);
        
        LightJFrame lightJFrame = new LightJFrame();
        
        // formulario dark
        FlatDarkLaf.setup();

        UIManager.put("Component.arc", 12);
        UIManager.put("Button.arc", 14);
        UIManager.put("TextComponent.arc", 10);
        
        DarkJFrame darkJFrame = new DarkJFrame();
    }
}