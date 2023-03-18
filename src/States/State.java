package States;

import Default.Pointable;
import Default.Shape;
import Default.ShapeContainer;

import java.util.List;

public abstract class State implements Pointable {
    protected List<Shape> shapes;
    protected ShapeContainer shapeContainer;

    public State(List<Shape> shapes,ShapeContainer shapeContainer){
        this.shapes = shapes;
        this.shapeContainer = shapeContainer;
    }

    public State(){

    }
}
