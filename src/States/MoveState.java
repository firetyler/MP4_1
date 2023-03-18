package States;

import Default.Point;
import Default.Shape;
import Default.ShapeContainer;

import java.util.List;

public class MoveState extends State{
    private Shape selected;

    public MoveState(List<Shape> shapes, ShapeContainer shapeContainer) {
        super(shapes, shapeContainer);
    }

    public MoveState() {
    }

    @Override
    public void pointerDown(Point point) {

        selected = shapeContainer.select(point);

    }

    @Override
    public void pointerUp(Point point) {
        selected = null;
    }

    @Override
    public void pointerMoved(Point point, boolean pointerDown) {

        selected = shapeContainer.select(point);
        if(selected != null && pointerDown){
            selected.moveTo(point);
            shapeContainer.repaint();
        }

    }
}
