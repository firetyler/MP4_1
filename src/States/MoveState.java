package States;

import Default.Point;
import Default.Shape;
import Default.ShapeContainer;

import java.util.List;

public class MoveState extends State{
    private ShapeContainer shapeContainer;
    private Shape selected;

    public MoveState(List<Shape> shapes, ShapeContainer shapeContainer) {
        super(shapes, shapeContainer);
    }

    public MoveState() {
    }

    @Override
    public void pointerDown(Point point) {
        /**
         * if (selected != null && pointerDown)
         *       {
         *       if (mode == Mode.MOVE)
         *         {
         *         selected.moveTo(point);
         *         repaint(); // uppmanar swing att måla om
         *         }
         *       else if(mode == Mode.RESIZE)
         *         {
         *         selected.resizeTo(point);
         *         repaint();
         *         }
         *       }
         */


    }

    @Override
    public void pointerUp(Point point) {

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