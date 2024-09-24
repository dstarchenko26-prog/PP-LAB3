package Pos;

public class Pos {
    int x;
    int y;

    public Pos(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int dist(Pos b) {
        if (x == b.x) {
            return Math.abs(y - b.y);
        } else if (y == b.y) {
            return Math.abs(x - b.x);
        } else {
            return Math.max(Math.abs(x - b.x), Math.abs(y - b.y));
        }
    }

    public void move(Pos b, int dm, int hr) {
        int newX = 0;
        int xdm = 0;
        int ydm = 0;
        int newY = 0;
        boolean left = false;
        boolean up = false;

        if (x - b.x > 0) {
            left = true;
        }
        if (y - b.y < 0) {
            up = true;
        }

        if (Math.abs(x - b.x) < dm + hr) {
            xdm = Math.abs(x - b.x) - hr;
        } else {
            xdm = dm;
        }

        if (Math.abs(y - b.y) < dm + hr) {
            ydm = Math.abs(y - b.y) - hr;
        } else {
            ydm = dm;
        }

        if (xdm > 0) {
            if (left) {
                newX = x - xdm;
            } else {
                newX = x + xdm;
            }
        } else {
            newX = x;
        }

        if (ydm > 0) {
            if (up) {
                newY = y + ydm;
            } else {
                newY = y - ydm;
            }
        } else {
            newY = y;
        }

        x = newX;
        y = newY;
    }

    public int getX () {
        return x;
    }

    public int getY () {
        return y;
    }
}
