package clocks;

import actions.Collision;
import game.Snake;

public class GameClock extends Thread
{
    public static boolean running = true;

    public void run()
    {
        while (running)
        {
            try
            {
                sleep(100);
                Snake.move();
                Snake.waitToMove = false;
                Collision.collidePickUp();

                if (Collision.collideSelf())
                {
                    Snake.tails.clear();
                    Snake.head.setX(7);
                    Snake.head.setY(7);
                    // Score
                    Snake.score = 0;
                }

                if (Collision.collideWall())
                {
                    moveSnakeOnWallCollide();
                }
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }

    public void moveSnakeOnWallCollide()
    {
        if (Snake.head.getX() > 31)
        {
            Snake.head.setX(Snake.head.getX() - 32);
        }
        if (Snake.head.getY() > 31)
        {
            Snake.head.setY(Snake.head.getY() - 32);
        }

        if (Snake.head.getX() < 0)
        {
            Snake.head.setX(Snake.head.getX() + 32);
        }
        if (Snake.head.getY() < 0)
        {
            Snake.head.setY(Snake.head.getY() + 32);
        }

        for (int i = 0; i < Snake.tails.size(); i++)
        {
            if (Snake.tails.get(i).getX() > 31)
            {
                Snake.tails.get(i).setX(Snake.tails.get(i).getX() - 32);
            }
            if (Snake.tails.get(i).getY() > 31)
            {
                Snake.tails.get(i).setY(Snake.tails.get(i).getY() - 32);
            }

            if (Snake.tails.get(i).getX() < 0)
            {
                Snake.tails.get(i).setX(Snake.tails.get(i).getX() + 32);
            }
            if (Snake.tails.get(i).getY() < 0)
            {
                Snake.tails.get(i).setY(Snake.tails.get(i).getY() + 32);
            }
        }
    }
}
