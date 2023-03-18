package States;

import Default.Point;
import Default.Shape;
import Default.ShapeContainer;

import java.util.List;

public class ResizeState extends State{

    public ResizeState(List<Shape> shapes, ShapeContainer shapeContainer) {
        super(shapes, shapeContainer);
    }
    Shape selectedShape;
    @Override
    public void pointerDown(Point point) {
        selectedShape = shapeContainer.select(point);
    }

    @Override
    public void pointerUp(Point point) {
        selectedShape = null;
    }

    @Override
    public void pointerMoved(Point point, boolean pointerDown) {
        selectedShape.resizeTo(point);
    }
}
