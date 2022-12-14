package otp.tournament_tracker.view.util.tournamentview;

import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ColumnNode {
	private VBox column;

	public ColumnNode() {
		this.column = new VBox();
		this.column.setSpacing(ViewConstants.BOXHEIGHT);
		this.column.setAlignment(Pos.CENTER);
	}
	
	public void addTeams (StackPane[] teamGraphic) {
		this.column.getChildren().addAll(teamGraphic);
	}
	
	public VBox getColumn() {
		return this.column;
	}
}
