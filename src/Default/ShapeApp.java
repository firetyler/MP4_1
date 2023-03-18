package Default;

import States.*;

import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ShapeApp extends JFrame
  {
  private static final long serialVersionUID = 1L;
  private ShapeContainer shapeContainer = new ShapeContainer();
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

    createMenuItem(menu, "Insert", e -> shapeContainer.setState(new InsertState(shapeContainer.getShapes(),shapeContainer)));
    createMenuItem(menu, "Move", e -> shapeContainer.setState(new MoveState(shapeContainer.getShapes(),shapeContainer)));
    createMenuItem(menu, "Delete", e -> shapeContainer.setState(new DeleteState(shapeContainer.getShapes(),shapeContainer)));
    createMenuItem(menu, "Mark", e -> shapeContainer.setState(new MarkState(shapeContainer.getShapes(),shapeContainer)));
    createMenuItem(menu, "Unmark", e -> shapeContainer.setState(new UnmarkState(shapeContainer.getShapes(),shapeContainer)));
    createMenuItem(menu, "Resize", e -> shapeContainer.setState(new ResizeState(shapeContainer.getShapes(),shapeContainer)));

    JMenu shapesManu = new JMenu("Shapes");

    createMenuItem(shapesManu,"Circle",e -> shapeContainer.setShape("Circle"));
    createMenuItem(shapesManu,"Line",e -> shapeContainer.setShape("Line"));


    JMenuBar menuBar = new JMenuBar();
    menuBar.add(menu);
      menuBar.add(shapesManu);
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
