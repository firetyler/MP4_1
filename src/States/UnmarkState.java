package States;

import Default.Point;
import Default.Shape;
import Default.ShapeContainer;

import java.util.List;

public class UnmarkState extends State{

    public UnmarkState(List<Shape> shapes, ShapeContainer shapeContainer){
        super(shapes,shapeContainer);
    }

    @Override
    public void pointerDown(Point point) {
        Shape selected = shapeContainer.select(point);
        if(selected != null){
            Shape unmarkedShape =  selected.peel();
            shapes.remove(selected);
            shapes.add(unmarkedShape);
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
