package otp.tournament_tracker.view.util.tournamentview.bracket_model;

import javafx.scene.layout.StackPane;
import otp.tournament_tracker.model.Team;
import otp.tournament_tracker.view.util.tournamentview.TeamNode;
import otp.tournament_tracker.view.util.tournamentview.ViewConstants;

public class Node {
	
	private int depth;
	private Team team;
	private TeamNode teamGraphic;
	Node right;
	Node left;
	Node parent;
	
	public Node(int depth, Node parent) {
		this.depth = depth;
		this.parent = parent;
		this.right = null;
		this.left = null;
		this.teamGraphic = new TeamNode(ViewConstants.BOXWIDTH, ViewConstants.BOXHEIGHT);
		this.teamGraphic.getRectangle().setOnMouseClicked(event -> {
			this.moveTeamUp();
		});
	}
	
	
	
	public boolean setTeam(Team team) {
		if (this.team == null) {
			this.team = team;
			this.teamGraphic.setText(team.getTeamName());
			return true;
		}
		return false;
	}
	
	private void forceSetTeam(Team team) {
		this.team = team;
		this.teamGraphic.setText(team.getTeamName());
	}
	
	public StackPane getTeamGraphic() {
		return this.teamGraphic.getRectangle();
	}
	
	public void moveTeamUp() {
		if (this.parent != null) {
			this.parent.forceSetTeam(this.team);
		}
	}
	
	public int getDepth() {
		return this.depth;
	}
}
