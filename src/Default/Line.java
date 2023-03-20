package Default;
import java.awt.*;

public class Line implements Shape{

    private Point start;
    private Point end;
    private Point center;

    public Line(double x1, double y1, double x2, double y2){
        start = new Point(x1,y1);
        end = new Point(x2,y2);
        center = new Point((x1+x2)/2,(y1+y2)/2);
    }
    public Line(Point start, Point end){
        this.start = start;
        this.end = end;
        center = new Point((start.getX()+end.getX())/2,(start.getY()+end.getY())/2);
    }

    public void draw(Graphics g){
        g.drawLine((int)start.getX(),(int)start.getY(),(int)end.getX(),(int)end.getY());
    }
    public Point getPosition(){
        return start;
    }
    public double getWidth(){
        return Math.abs(end.getX() - start.getX());
    }
    public double getHeight(){
        return Math.abs(end.getY() - start.getY());
    }
    public boolean intersects(Point point){
        final double tolerance = 5;
        if(distance(start,point) + distance(end,point) - distance(start,end) <= tolerance){
            return true;
        }
        return false;
    }
    public void moveTo(Point point){
        center.moveTo(point);
        start.moveTo(point);
    }
    public void move(double dx, double dy){
        
        start.move(dx, dy);
    }
    public void resizeTo(Point point){
        end.moveTo(point);
    }
    public Shape peel(){
        return this;
    }

    private double distance(Point A,Point B){
        return Math.sqrt(Math.pow(A.getX()-B.getX(),2)+Math.pow(A.getY()-B.getY(),2));
    }
}
