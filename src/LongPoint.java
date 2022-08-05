import java.awt.*;
import java.awt.geom.Point2D;

/**
 * A helper class modeled after Java's built-in Point class.
 * Uses signed 64-bit integers for coordinates instead of 32-bit integers.
 */
public class LongPoint extends Point2D
{
    private long x;
    private long y;

    public LongPoint()
    {
        x = 0;
        y = 0;
    }

    public LongPoint(Point p)
    {
        x = p.x;
        y = p.y;
    }

    public LongPoint(long xVal, long yVal)
    {
        x = xVal;
        y = yVal;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
            return true;

        if (obj instanceof LongPoint)
        {
            LongPoint p = (LongPoint) obj;
            return x == p.x && y == p.y;
        }
        return false;
    }

    @Override
    public String toString()
    {
        return x + " " + y; // For Life 1.06 format
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public LongPoint getLocation()
    {
        return new LongPoint(x, y);
    }

    public void setLocation(LongPoint p)
    {
        setLocation(p.x, p.y);
    }

    public void setLocation(long xVal, long yVal)
    {
        x = xVal;
        y = yVal;
    }

    @Override
    public void setLocation(double x, double y)
    {
        x = x < Long.MIN_VALUE ? Long.MIN_VALUE : x > Long.MAX_VALUE ? Long.MAX_VALUE
                : x;
        y = y < Long.MIN_VALUE ? Long.MIN_VALUE : y > Long.MAX_VALUE ? Long.MAX_VALUE
                : y;
        setLocation((long)Math.round(x), (long)Math.round(y));
    }

    public void move(long x, long y)
    {
        setLocation(x, y);
    }

    public void translate(long xDir, long yDir)
    {
        x += xDir;
        y += yDir;
    }
}
