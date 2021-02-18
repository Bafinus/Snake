package game;

import gui.Gui;

import java.awt.*;
import java.util.ArrayList;

public class Snake
{
    public static Head head = new Head(7, 7);
    public static ArrayList<Tail> tails = new ArrayList<>();
    public static PickUp pickup = new PickUp();
    public static boolean waitToMove = false;
    public static int score = 0, topScore = 0;

    public static void addTails()
    {
        if (tails.size() < 1)
        {
            for (int i = 0; i < 5; i++)
            {
                tails.add(new Tail(head.getX(), head.getY()));
            }
        } else
        {
            for (int i = 0; i < 5; i++)
            {
                tails.add(new Tail(tails.get(tails.size() - 1).getX(), tails.get(tails.size() - 1).getY()));
            }
        }
    }

    public static void move()
    {
        if (tails.size() >= 2)
        {
            for (int i = tails.size() - 1; i >= 1; i--)
            {
                if (tails.get(i).isWait())
                {
                    tails.get(i).setWait(false);
                } else
                {
                    tails.get(i).setX(tails.get(i - 1).getX());
                    tails.get(i).setY(tails.get(i - 1).getY());
                }
            }
        }

        if (tails.size() >= 1)
        {
            if (tails.get(0).isWait())
            {
                tails.get(0).setWait(false);
            } else
            {
                tails.get(0).setX(head.getX());
                tails.get(0).setY(head.getY());
            }
        }

        switch (head.getDir())
        {
            case RIGHT -> head.setX(head.getX() + 1);
            case LEFT -> head.setX(head.getX() - 1);
            case UP -> head.setY(head.getY() - 1);
            case DOWN -> head.setY(head.getY() + 1);
        }
    }

    // position to coordinates
    public static Point ptc(int x, int y)
    {
        Point p = new Point(0, 0);

        p.x = x * 16 + Gui.xoff;
        p.y = y * 16 + Gui.yoff;
        return p;
    }
}
