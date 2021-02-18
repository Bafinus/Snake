package game;

public class Head
{
    int x, y;
    Dir dir = Dir.RIGHT;

    public Head(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public int getY()
    {
        return y;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public Dir getDir()
    {
        return dir;
    }

    public void setDir(Dir dir)
    {
        this.dir = dir;
    }
}
