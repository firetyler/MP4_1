package Default;

import java.awt.Graphics;

public class Rectangle implements Shape{

    private Point start;
    private double width;
    private double height;
    private Point center;

    public Rectangle(Point start, Point end){
        if(start.getX() > end.getX() && start.getY() > end.getY()){
            this.start = end;
            this.width = Math.abs(start.getX() - end.getX());
            this.height = Math.abs(start.getY() - end.getY());
            center = new Point(start.getX() - width/2, start.getY() - height/2);
        }
        else{
            this.start = start;
            this.width = Math.abs(end.getX() - start.getX());
            this.height = Math.abs(end.getY() - start.getY());
            center = new Point(start.getX() + width/2, start.getY() + height/2);
        }
    }


    @Override
    public void draw(Graphics g) {
        g.drawRect((int)start.getX(), (int)start.getY(),(int) width,(int) height);    
    }

    @Override
    public Point getPosition() {
       return start;
    }

    @Override
    public double getWidth() {
        return width;
    }

    @Override
    public double getHeight() {
        return height;
    }

    @Override
    public boolean intersects(Point point) {
        if(point.getX() >= start.getX() && point.getX() <= start.getX() + width){
            if(point.getY() >= start.getY() && point.getY() <= start.getY() + height){
                return true;
            }
        }
        return false;
    }

    @Override
    public void moveTo(Point point) {
        center.moveTo(point);
        start.moveTo(new Point(center.getX() - width/2, center.getY() - height/2));
        
    }

    @Override
    public void move(double dx, double dy) {
        start.move(dx, dy);
    }

    @Override
    public void resizeTo(Point point) {
        if(point.getX() < start.getX() && point.getY() < start.getY()){
            start.moveTo(point);

        }
        width = point.getX() - start.getX();
        height = point.getY() - start.getY();
    }

    @Override
    public Shape peel() {
        return this;
    }
    
}
