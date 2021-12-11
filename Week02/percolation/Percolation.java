import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] girdmap;
    private WeightedQuickUnionUF w;
    private int gridlen;
    private int top = 0;
    private int bottom;
    private int opensites = 0;

    // creates n-by-n grid, with all sites initially blocked
    public Percolation(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException();
        }
        gridlen = n;
        girdmap = new boolean[n][n];
        w = new WeightedQuickUnionUF(n*n+2);
        bottom = n*n+1;

    }

    private int getIndex(int row, int col) {
        return (row-1) * gridlen + col;
    }

    private boolean checkBounds(int row, int col) {
        if (row < 1 || row > gridlen || col < 1 || col > gridlen) {
            return false;
        }
        return true;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!checkBounds(row, col)) {
            throw new IllegalArgumentException();
        }

        girdmap[row - 1][col - 1] = true;
        opensites++;

        // if row == 1 => union with virtual top site
        if (row == 1) {
            w.union(getIndex(row, col), top);
            // union with other site
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (Math.abs(i) != Math.abs(j)) {
                        if (checkBounds(row+i, col+j)) {
                            if (isOpen(row + i, col + j)) {
                                w.union(getIndex(row + i, col + j), getIndex(row, col));
                            }
                        }

                    }
                }
            }
        }

        // then if row == n => union with virtual bottom site
        if (row == gridlen) {
            w.union(getIndex(row, col), bottom);
            // union with other site
            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    if (Math.abs(i) != Math.abs(j)) {
                        if (checkBounds(row+i, col+j)) {
                            if (isOpen(row + i, col + j)) {
                                w.union(getIndex(row + i, col + j), getIndex(row, col));
                            }
                        }

                    }
                }
            }
            return;
        }

        // at normal pos union nearby
        // union with other site
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (Math.abs(i) != Math.abs(j)) {
                    if (checkBounds(row+i, col+j)) {
                        if (isOpen(row + i, col + j)) {
                            w.union(getIndex(row + i, col + j), getIndex(row, col));
                        }
                    }

                }
            }
        }
    }


    // is the site (row, col) open?
    public boolean isOpen(int row, int col) {
        if (!checkBounds(row, col)) {
            throw new IllegalArgumentException();
        }
        return girdmap[row-1][col-1];
    }

    // is the site (row, col) full?
    public boolean isFull(int row, int col) {
        if (!checkBounds(row, col)) {
            throw new IllegalArgumentException();
        }
        if (w.find(getIndex(row, col)) == w.find(top)) {
            return true;
        }
        return false;

    }

    // returns the number of open sites
    public int numberOfOpenSites() {
        return opensites;
    }

    // does the system percolate?
    public boolean percolates() {
        if (w.find(top) == w.find(bottom)) {
            return true;
        }
        return false;
    }

    // test client (optional)
    public static void main(String[] args) {
        /*
        Percolation a = new Percolation(StdIn.readInt());
        while (!StdIn.isEmpty()) {
            a.open(StdIn.readInt(), StdIn.readInt());
        }
        StdOut.println(a.percolates());
         */
    }
}