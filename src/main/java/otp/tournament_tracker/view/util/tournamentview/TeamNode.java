package otp.tournament_tracker.view.util.tournamentview;

import java.util.Random;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;


public class TeamNode {
	private Random colorgen;
	private StackPane teamSquare;
	private Text teamName;
	
	public TeamNode(int paddingX, int paddingY) {
		this.colorgen = new Random(System.nanoTime());
		Rectangle teamRectangle = new Rectangle(paddingX, paddingY);
		teamRectangle.setFill(Color.rgb(colorgen.nextInt(256), colorgen.nextInt(256), colorgen.nextInt(256)));
		this.teamSquare = new StackPane();
		this.teamName = new Text("TBA");
		this.teamName.setFill(Color.WHITE);
		this.teamSquare.getChildren().addAll(teamRectangle, teamName);
	}
	
	public StackPane getRectangle() {
		return this.teamSquare;
	}
	
	public void setText(String teamName) {
		this.teamName.setText(teamName);
	}
}
