import com.luketebo.function.Win;

import javax.swing.*;

public class Test {
    public static void main(String[] args) {
        Win a = new Win();
        a.setVisible(true);
        a.setSize(1550,900);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.init();
    }
}
