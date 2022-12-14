package otp.tournament_tracker.view.util.tournamentview;

import java.util.ArrayList;

import javafx.scene.layout.HBox;
public class BracketNode {
	private HBox columns;
	private ArrayList<ColumnNode> columnNodes;
	
	public BracketNode(int columnAmount) {
		this.columnNodes = new ArrayList<ColumnNode>();
		this.columns = new HBox();
		this.columns.setSpacing(ViewConstants.BOXWIDTH);
		for (int i = 0; i < columnAmount; i++) {
			ColumnNode toAdd = new ColumnNode();
			this.columnNodes.add(toAdd);
			this.columns.getChildren().add(toAdd.getColumn());
		}
	}
	
	public ArrayList<ColumnNode> getColumns() {
		return this.columnNodes;
	}
	
	public HBox getBracket() {
		return this.columns;
	}
	
	public void reverseColumns() {
		for (int i = 0; i < columns.getChildren().size(); i++) {
			columns.getChildren().get(columns.getChildren().size()-(i+1)).toFront();
		}
	}
}
