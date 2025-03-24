interface moveable {
    public void moveup();
    public void movedown();
    public void moveleft();
    public void moveright();
}
class moveablepoint implements moveable {
    public int x,y,xspeed,yspeed;
    public moveablepoint(int x, int y, int xspeed, int yspeed) {
        this.x = x;
        this.y = y;
        this.xspeed = xspeed;
        this.yspeed = yspeed;
    }
    public String toString() {
        return "(" + x + "," + y + ")";
    }
    public void moveup() {
        y += yspeed;
    }
    public void movedown() {
        y -= yspeed;
    }
    public void moveleft() {
        x -= xspeed;
    }
    public void moveright() {
        x += xspeed;
    }
}
class moveablecircle implements moveable {
    public int radius;
    public moveablepoint center;
    public moveablecircle(moveablepoint center, int radius) {
        this.center = center;
        this.radius = radius;
    }
    public String toString() {
        return "Circle at " + center + " with radius " + radius;
    }
    public void moveup() {
        center.y += 1;
    }
    public void movedown() {
        center.y -= 1;
    }
    public void moveleft() {
        center.x -= 1;
    }
    public void moveright() {
        center.x += 1;
    }
} 
public class main{
    public static void main(String[] args) {
        moveablepoint p1 = new moveablepoint(0, 0, 1, 1);
        System.out.println(p1);
        p1.moveup();
        System.out.println(p1);
        p1.moveright();
        System.out.println(p1);
        moveablecircle c1 = new moveablecircle(new moveablepoint(1, 1, 1, 1), 2);
        System.out.println(c1);
        c1.moveup();
        System.out.println(c1);
        c1.moveright();
        System.out.println(c1);
    }
}
