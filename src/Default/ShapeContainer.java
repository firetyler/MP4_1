package Default;

import Default.MouseHandler;
import Default.Point;
import Default.Pointable;
import States.InsertState;
import States.State;

import java.awt.Color;
import java.awt.Graphics;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;

public class ShapeContainer extends JPanel implements Pointable
  {
  private static final long serialVersionUID = 1L;

    private List<Shape> shapes = new LinkedList<Shape>();
    private Point lastPoint;
    //private Default.Shape mode;
    private State state = new InsertState(this.shapes,this);
    public void setState(State state){
      this.state = state;
    }

    public List<Shape> getShapes(){return this.shapes;}
  public ShapeContainer()
    {
    super();
    MouseHandler mouseHandler = new MouseHandler(this);
    this.addMouseListener(mouseHandler);
    this.addMouseMotionListener(mouseHandler);
    this.setBackground(Color.white);
    }
  
  public void addShape(Shape shape)
    {
    shapes.add(shape);
    }

  public void paintComponent(Graphics g) // anropas av Swing när det är dags att
                                         // rendera
    {
    super.paintComponent(g);

    for (Shape shape : shapes)
      shape.draw(g);

    }
    public Point getLastPoint() {
      return lastPoint;
    }

    public Shape select(Point point)
    {
      for (Shape shape : shapes)
      {
        if (shape.intersects(point))
        {
          return shape;

        }
      }
      return null;
    }

    @Override
    public void pointerDown(Point point) {
      state.pointerDown(point);
      lastPoint = point;
      repaint();
    }


    @Override
    public void pointerUp(Point point) {
      state.pointerUp(point);
      lastPoint = point;
    }
    @Override
    public void pointerMoved(Point point, boolean pointerDown) {
      state.pointerMoved(point, pointerDown);
      lastPoint = point;
    }

 }