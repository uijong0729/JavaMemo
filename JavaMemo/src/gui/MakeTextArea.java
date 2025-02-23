package gui;

import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MakeTextArea {


    public static void showTextArea(String text) {
        Frame frame = new Frame();
        Panel panel = new Panel();
        TextArea ta = new TextArea(text);
        panel.add(ta);
        frame.add(panel, "Center");
        frame.setSize(500, 270);
        frame.setVisible(true);
        frame.addWindowListener(new WindowListener() {

            @Override
            public void windowOpened(WindowEvent e) {
                // TODO 自動生成されたメソッド・スタブ

            }

            @Override
            public void windowIconified(WindowEvent e) {
                // TODO 自動生成されたメソッド・スタブ

            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                // TODO 自動生成されたメソッド・スタブ

            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                // TODO 自動生成されたメソッド・スタブ

            }

            @Override
            public void windowClosing(WindowEvent e) {
                // TODO 自動生成されたメソッド・スタブ
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {
                // TODO 自動生成されたメソッド・スタブ

            }

            @Override
            public void windowActivated(WindowEvent e) {
                // TODO 自動生成されたメソッド・スタブ

            }
        });
    }
}
