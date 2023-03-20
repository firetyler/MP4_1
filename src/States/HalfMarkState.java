package States;

import java.util.List;

import Default.HalfFillDecorator;
import Default.Point;
import Default.Shape;
import Default.ShapeContainer;

public class HalfMarkState extends State{
    private Shape selected;


    public HalfMarkState(List<Shape> shapes, ShapeContainer shapeContainer) {
        super(shapes, shapeContainer);
    }

    public HalfMarkState() {
    }


    @Override
    public void pointerDown(Point point) {
        selected = shapeContainer.select(point);
        if(selected != null){
            Shape markedShape = new HalfFillDecorator(selected);
            shapes.remove(selected);
            shapes.add(markedShape);
            shapeContainer.repaint();
        }


    }

    @Override
    public void pointerUp(Point point) {

    }

    @Override
    public void pointerMoved(Point point, boolean pointerDown) {

    } 

}
