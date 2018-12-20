package boardgame;

public class Piece {

	protected Position position;
	private Board board;

	public Piece() {

	}

	public Piece(Board board) {
		this.board = board;
		this.position = null;
	}

	public Piece(Position position, Board board) {

		this.position = position;
		this.board = board;
	}

	protected Board getBoard() {
		return board;
	}

}
