package Default;

import java.awt.Graphics;

public class HalfFillDecorator implements Shape
{
private Shape decoratee;
public HalfFillDecorator(Shape decoratee)
  {
  this.decoratee = decoratee;
  }
@Override
public void draw(Graphics g)
  {
    if(decoratee instanceof Circle){
        decoratee.draw(g);
        Point position = decoratee.getPosition();
        int x = (int)(position.getX()-decoratee.getWidth()/2.0+0.5);
        int y = (int)(position.getY()-decoratee.getHeight()/2.0+0.5);
        int width = (int)(decoratee.getWidth()+0.5);
        int height = (int)(decoratee.getHeight()+0.5);
        int startAngle = 90;
        int arcAngle = -180;
        g.fillArc(x, y, width, height, startAngle, arcAngle);
    }
    else if(decoratee instanceof Rectangle){
      decoratee.draw(g);
      Point position = decoratee.getPosition();
      int x = (int)(position.getX()+0.5);
      int y = (int)(position.getY()+0.5);
      g.fillRect(x,y,(int)(decoratee.getWidth()+0.5)/2,(int)(decoratee.getHeight()+0.5));
    }
    else
      decoratee.draw(g);
  }
@Override
public Point getPosition()
  {
  return decoratee.getPosition();
  }
@Override
public double getWidth()
  {
  return decoratee.getWidth();
  }
@Override
public double getHeight()
  {
  return decoratee.getHeight();
  }
@Override
public boolean intersects(Point point)
  {
  return decoratee.intersects(point);
  }
@Override
public void moveTo(Point point)
  {
  decoratee.moveTo(point);
  }
@Override
public void move(double dx, double dy)
  {
  decoratee.move(dx, dy);
  }
@Override
public void resizeTo(Point point)
  {
  decoratee.resizeTo(point);
  }
@Override
public Shape peel()
  {
  return decoratee;
  }
}
