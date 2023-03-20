package Default;

import States.*;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ShapeApp extends JFrame
  {
  private static final long serialVersionUID = 1L;
  private ShapeContainer shapeContainer = new ShapeContainer();
  public enum State
    {
    INSERT, MOVE, DELETE, MARK, UNMARK, RESIZE, HALFMARK
    };
  private State state = State.INSERT;
  private JLabel label = new JLabel("Current mode: " + state);
  public ShapeApp()
    {
    createMenue();
    this.add(shapeContainer);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(400,400);
    this.setVisible(true);
    }
  
  public void createMenue()
    {
    JMenu menu = new JMenu("Modes");

    createMenuItem(menu, "Insert", e -> {shapeContainer.setState(new InsertState(shapeContainer.getShapes(),shapeContainer));
                                                                                      label.setText("Current mode: " + State.INSERT); });
    createMenuItem(menu, "Move", e -> {shapeContainer.setState(new MoveState(shapeContainer.getShapes(),shapeContainer));
                                                                                     label.setText("Current mode: "+ State.MOVE);});
    createMenuItem(menu, "Delete", e -> {shapeContainer.setState(new DeleteState(shapeContainer.getShapes(),shapeContainer));
                                                                                      label.setText("Current mode: "+ State.DELETE);});
    createMenuItem(menu, "Mark", e -> {shapeContainer.setState(new MarkState(shapeContainer.getShapes(),shapeContainer));
                                                                                      label.setText("Current mode: "+ State.MARK);});
    createMenuItem(menu, "HalfMark", e -> {shapeContainer.setState(new HalfMarkState(shapeContainer.getShapes(),shapeContainer));
                                                                                        label.setText("Current mode: "+ State.HALFMARK);});                                                                                  
    createMenuItem(menu, "Unmark", e -> {shapeContainer.setState(new UnmarkState(shapeContainer.getShapes(),shapeContainer));
                                                                                      label.setText("Current mode: "+ State.UNMARK);});
    createMenuItem(menu, "Resize", e -> {shapeContainer.setState(new ResizeState(shapeContainer.getShapes(),shapeContainer));
                                                                                      label.setText("Current mode: "+ State.RESIZE);});

    JMenu shapesManu = new JMenu("Shapes");

    createMenuItem(shapesManu,"Circle",e -> shapeContainer.setShape("Circle"));
    createMenuItem(shapesManu,"Line",e -> shapeContainer.setShape("Line"));
    createMenuItem(shapesManu, "Rectangle", e->shapeContainer.setShape("Rectangle"));
    



    JMenuBar menuBar = new JMenuBar();
    menuBar.add(menu);
    menuBar.add(new JLabel(" | "));
    menuBar.add(shapesManu);
    menuBar.add(new JLabel(" | "));
    menuBar.add(label);
    this.setJMenuBar(menuBar);
    }
  
  private void createMenuItem(JMenu menu, String label, ActionListener listener)
    {
    JMenuItem menuItem = new JMenuItem(label);
    menuItem.addActionListener(listener);
    menu.add(menuItem);
    }
  
  public static void main(String args[])
    {
    new ShapeApp(); // obs egentligen SwingUtilities ...
    }
  }
