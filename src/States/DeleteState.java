package States;

import Default.Point;
import Default.Shape;
import Default.ShapeContainer;

import java.util.List;

public class DeleteState extends State{
    Shape selected;

    public DeleteState(List<Shape> shapes, ShapeContainer shapeContainer){
        super(shapes,shapeContainer);
    }

    @Override
    public void pointerDown(Point point) {
        selected = shapeContainer.select(point);
        if(selected != null)
            shapes.remove(selected);
        shapeContainer.repaint();
    }

    @Override
    public void pointerUp(Point point) {
        selected = null;
    }

    @Override
    public void pointerMoved(Point point, boolean pointerDown) {

    }
}
