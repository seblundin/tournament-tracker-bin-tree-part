package otp.tournament_tracker.view.util.tournamentview;

import javafx.scene.Group;
import javafx.scene.shape.Line;

public class LineNode {
	private Group lineGroup;
	private Line horizontalLine;
	private Line verticalLine;
	/**
	 * 
	 * @param startXY array with index 0 as X value, Index 1 as Y value for the startlocation
	 * @param endXY  array with index 0 as X value, Index 1 as Y value for the endlocation
	 */
	public LineNode(int[] startXY, int[] endXY) {
		horizontalLine = new Line();
		verticalLine = new Line();
		//Setting up positioning of lines.
		horizontalLine = positioningLine(horizontalLine, startXY[0], endXY[0], startXY[1], startXY[1]);
		verticalLine = positioningLine(verticalLine, endXY[0], endXY[0], endXY[0], endXY[1]);
		lineGroup = new Group(horizontalLine, verticalLine);
	}
	
	private Line positioningLine(Line line, int startX, int endX, int startY, int endY) {
		line.setStartX(startX);
		line.setEndX(endX);
		line.setStartY(startY);
		line.setEndY(endY);
		//lineGroupPreferenceSize(startX, endX, startY, endY);
		return line;
	}
	//Possible need maybe if autoadjust does not work out.
	private void setLineGroupPreferenceSize(int startX, int endX, int startY, int endY) {
		
		if(Math.abs(startX)<Math.abs(endX)) {
			lineGroup.prefWidth(endX-startX);
		} else if(Math.abs(startX)>Math.abs(endX)) {
			lineGroup.prefWidth(startX-endX);
		}
		if(Math.abs(startY)<Math.abs(endY)) {
			lineGroup.prefWidth(endY-startY);
		} else if(Math.abs(startY)>Math.abs(endY)) {
			lineGroup.prefWidth(endY-startY);
		}
		
	}
	
	public Group getLineGroup() {
		return this.lineGroup;
	}
	
	
}
