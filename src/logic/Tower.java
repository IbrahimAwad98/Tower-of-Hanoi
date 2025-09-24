package logic;

public class Tower {
    private final Rod left, middle, right;
    private int moves;
    private int nrOfDisks;

    public Tower(int nrOfDisks) {
        this.left = new Rod(nrOfDisks);
        this.middle = new Rod(nrOfDisks);
        this.right = new Rod(nrOfDisks);
        initNewGame(nrOfDisks);
    }

    public void initNewGame() {

        initNewGame(this.nrOfDisks);
    }

    public void initNewGame(int nrOfDisks) {
        left.clear();
        middle.clear();
        right.clear();

        this.nrOfDisks = nrOfDisks;
        this.moves = 0;

        for (int d = nrOfDisks; d >= 1; d--) {
            left.push(new Disk(d, Color.BLUE));
        }
    }

    public boolean isLegalMove(RodPos from, RodPos to) {
        if (from == null || to == null) {
            return false;
        }
        if (from == to){
            return false;
        }

        Rod source = rod(from);
        Rod destination = rod(to);

        if (source.isEmpty())
        {
            return false;
        }
        if (destination.isEmpty()) {
            return true;
        }
        return source.peek().diameter() < destination.peek().diameter();
    }

    public void makeMove(RodPos from, RodPos to) {
        if (!isLegalMove(from, to)) {
            throw new IllegalStateException("Illegal move: " + from + " -> " + to);
        }
        Rod src = rod(from);
        Rod dst = rod(to);
        Disk moving = src.pop();
        dst.push(moving);
        moves++;
    }

    public int getNoOfDisks() {
        return nrOfDisks;
    }
    public int getMoves() {

        return moves;
    }
    public boolean isSolved() {
        return right.size() == nrOfDisks; }

    public Disk[] getDisks(RodPos pos) {
        return rod(pos).copyDiskArr(); }

    private Rod rod(RodPos pos) {
        return switch (pos) {
            case LEFT -> left;
            case MIDDLE -> middle;
            case RIGHT -> right;
        };
    }

    @Override
    public String toString() {
        return "L=" + left + "  M=" + middle + "  R=" + right + "  (moves=" + moves + ")";
    }
}