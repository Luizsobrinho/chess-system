package boardgame;

public class Board {

	private int rows;
	private int columns;

	private Piece[][] pieces;

	public Board(int rows, int columns) {
		if (rows < 1 || columns < 1) {
			throw new BoardExpection("Error ao criar o tabuleiro: � necessario que haja 1 linha e 1 coluna");
		}
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public Piece piece(int row, int column) {
		if (!positionExists(row, column)) {
			throw new RuntimeException("Posi��o n�o est� no tabuleiro");
		}
		return pieces[row][column];
	}

	public Piece piece(Position position) {
		if (!positionExists(position)) {
			throw new RuntimeException("Posi��o n�o est� no tabuleiro");
		}
		return pieces[position.getRow()][position.getColumn()];
	}

	public void placePiece(Piece piece, Position position) {
		if (thereIsPiece(position)) {
			throw new BoardExpection("Existe uma pe�a nesta posi��o: " + position);
		}
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}

	public boolean positionExists(Position position) {
		return positionExists(position.getRow(), position.getColumn());
	}

	private boolean positionExists(int row, int column) {
		return row >= 0 && row <= rows && column >= 0 && column <= columns;
	}

	public boolean thereIsPiece(Position position) {
		if (!positionExists(position)) {
			throw new RuntimeException("Posi��o n�o est� no tabuleiro");
		}
		return piece(position) != null;
	}

	public int getRows() {
		return rows;
	}

	public int getColumns() {
		return columns;
	}

}
