import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class SmartShape {

	private Color borderColor, fillColor;
	RectangularShape shape;
	
	public SmartShape(RectangularShape myShape, Color fill) {
		
		shape = myShape;
		borderColor = Color.black;
		fillColor = fill;
	
	
	}
	
	public void setLocation(double xLoc, double yLoc){
		shape.setFrame(xLoc, yLoc, shape.getWidth(), shape.getHeight());
	}
	public void setSize(double width,double height){
		shape.setFrame(shape.getX(), shape.getY(), width, height);
	}

	public void setFillColor(Color newColor){
		borderColor = newColor;
	}

	public void setBorderColor(Color newColor){
		fillColor = newColor;
	}
	
	public Color getFillColor(){ 
		return fillColor;
	}
	
	public Color getBorderColor(){
		return borderColor;
	}

	public void paint(Graphics2D brush){
		brush.setColor(borderColor);
	    brush.draw(shape);		
		brush.setColor(fillColor);
		brush.fill(shape);
	}
}