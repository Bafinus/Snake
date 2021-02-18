package gui;

import actions.KeyHandler;

import javax.swing.*;

public class Gui
{
    public static int width = 800;
    public static int height = 600;
    public static int xoff = 130, yoff = 40;
    JFrame jf;
    Draw d;

    public void create()
    {
        jf = new JFrame("Snake");
        d = new Draw();

        jf.setSize(width, height + yoff);
        jf.addKeyListener(new KeyHandler());
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jf.add(d);
        jf.setVisible(true);
    }
}
