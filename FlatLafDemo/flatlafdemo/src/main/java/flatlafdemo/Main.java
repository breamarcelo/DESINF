package flatlafdemo;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

public class Main {
    public static void main(String[] args) {
        // formulario Light
        FlatLightLaf.setup();

        UIManager.put("Component.arc", 12);
        UIManager.put("Button.arc", 14);
        UIManager.put("TextComponent.arc", 10);
        
        LightJFrame lightJFrame = new LightJFrame();

        // FlatMacLightLaf
        FlatMacLightLaf.setup();

        UIManager.put("Component.arc", 12);
        UIManager.put("Button.arc", 14);
        UIManager.put("TextComponent.arc", 10);
        
        LightJFrame lightJFrame2 = new LightJFrame();

        // check popup for style
    
        
        // formulario dark
        FlatDarkLaf.setup();

        UIManager.put("Component.arc", 12);
        UIManager.put("Button.arc", 14);
        UIManager.put("TextComponent.arc", 10);
        
        DarkJFrame darkJFrame = new DarkJFrame();
        
        // FlatMacDarkLaf
        FlatMacDarkLaf.setup();

        UIManager.put("Component.arc", 12);
        UIManager.put("Button.arc", 14);
        UIManager.put("TextComponent.arc", 10);
        
        DarkJFrame darkJFrame2 = new DarkJFrame();
    }
}