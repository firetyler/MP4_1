package States;
import Default.Circle;
import Default.Point;
import Default.Shape;
import Default.ShapeContainer;

import java.util.List;

public class InsertState extends State {
    private Shape shape;


    public InsertState(List<Shape> shapes, ShapeContainer shapeContainer){
        super(shapes,shapeContainer);

    }

    public InsertState(){

    }

    @Override
    public void pointerDown(Point point ) {
        shape = shapeContainer.newShape(point);
        shapes.add(shape);
    }

    @Override
    public void pointerUp(Point point) {
        shape = null;

    }

    @Override
    public void pointerMoved(Point point, boolean pointerDown) {
        if(pointerDown && shape != null){
            shape.moveTo(point);
        }


    }
}
