package States;

import Default.Point;
import Default.Shape;
import Default.ShapeContainer;
import Default.ShapeDecorator;

import java.util.List;

public class MarkState extends State{
    private Shape selected;

    public MarkState(List<Shape> shapes, ShapeContainer shapeContainer) {
        super(shapes, shapeContainer);
    }

    public MarkState() {
    }

    @Override
    public void pointerDown(Point point) {
        selected = shapeContainer.select(point);
        if(selected != null){
            Shape markedShape = new ShapeDecorator(selected);
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
