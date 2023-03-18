import Default.Point;

public interface ShapeMode {
    public void pointerDown(Point point);
    public void pointerUp(Point point);
    public void pointerMoved(Point point, boolean pointerDown);
}
