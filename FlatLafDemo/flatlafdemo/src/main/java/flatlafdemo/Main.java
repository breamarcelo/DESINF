package flatlafdemo;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatLightLaf;

public class Main {
    public static void main(String[] args) {
        FlatLightLaf.setup();
        UIManager.put("Component.arc", 12);
        UIManager.put("Button.arc", 14);
        UIManager.put("TextComponent.arc", 10);
        
        MiJFrame frame = new MiJFrame();
    }
}