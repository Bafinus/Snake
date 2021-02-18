package gui;

import game.Snake;

import javax.swing.*;
import java.awt.*;

public class Draw extends JLabel
{
    Point p;

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;


        // Background
        g2.setColor(new Color(87, 138, 52, 255));
        g2.fillRect(Gui.xoff - 16, Gui.yoff - 16, 512 + 32, 513 + 32);

        // Grid
        drawGrid(g2);

        // Snake
        drawSnake(g2);

        // Pickup
        drawPickUp(g2);


        g2.setColor(Color.BLACK);
        g2.setFont(new Font("Arial", Font.BOLD, 28));
        g2.drawString("Score: " + Snake.score, 5, 25);
        g2.drawString("Top : " + Snake.topScore, 655, 25);

        repaint();
    }

    public void drawSnake(Graphics2D g2)
    {
        g2.setColor(new Color(40, 205, 0));
        for (int i = 0; i < Snake.tails.size(); i++)
        {
            p = Snake.ptc(Snake.tails.get(i).getX(), Snake.tails.get(i).getY());
            g2.fillRect(p.x, p.y, 16, 16);
        }

        g2.setColor(new Color(0x137300));
        p = Snake.ptc(Snake.head.getX(), Snake.head.getY());
        g2.fillRect(p.x, p.y, 16, 16);
    }

    public void drawPickUp(Graphics2D g2)
    {
        g2.setColor(new Color(0xDD0000));

        p = Snake.ptc(Snake.pickup.getX(), Snake.pickup.getY());
        g2.fillRect(p.x, p.y, 16, 16);
    }

    public void drawGrid(Graphics2D g2)
    {
        g2.setColor(Color.LIGHT_GRAY);
        for (int i = 0; i < 32; i++)
        {
            for (int j = 0; j < 32; j++)
            {
                if ((i + j) % 2 == 0)
                {
                    g2.setColor(new Color(170, 215, 81, 255));
                } else
                {
                    g2.setColor(new Color(162, 209, 73, 255));
                }

                g2.fillRect(i * 16 + Gui.xoff, j * 16 + Gui.yoff, 16, 16);
            }
        }
    }
}
