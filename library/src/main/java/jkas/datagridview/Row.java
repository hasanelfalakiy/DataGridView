package jkas.datagridview;

import android.content.Context;
import java.util.ArrayList;

public class Row {
    private Context C;
    private int columnCount = 0;
    private ArrayList<Cell> listColumn = new ArrayList<>();

    private Row(Context c, int columnCount) {
        this.C = c;
        this.columnCount = columnCount;
    }

    protected static Row newRow(Context c, int columnCount) {
        return new Row(c, columnCount);
    }

    /*
     *
     *
     * CELL
     */

    public Cell newCell() {
        return Cell.newCell();
    }

    public static class Cell {
        private Cell(){
            // init default
        }
        protected static Cell newCell() {
            return new Cell();
        }

        // method here
    }
}
