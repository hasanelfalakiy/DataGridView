package jkas.datagridview;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.NonNull;
import java.util.ArrayList;

public class Row {
    private Context C;
    private int columnCount = 0;
    private ArrayList<Cell> listCell = new ArrayList<>();

    private Row(Context c, int columnCount) {
        this.C = c;
        this.columnCount = columnCount;
    }

    public void addCell(Cell cell) {
        if (listCell.size() >= columnCount) {
            throw new IllegalStateException(
                    "adding the new cell is refused because the number of cells is full.\n"
                            + "Maximum number of cells = "
                            + columnCount);
        }
        listCell.add(cell);
    }

    public void clearCells() {
        listCell.clear();
    }

    public boolean removeCell(Cell cell) {
        return listCell.remove(cell);
    }

    public void removeCell(int position) {
        if (position > listCell.size() || position < 0) {
            throw new IllegalStateException(
                    "The position must not be a negative value let alone greater than the number of available cells.");
        }
        listCell.remove(position);
    }

    public ArrayList<Cell> getCells() {
        return this.listCell;
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
        return Cell.newCell(C);
    }

    public static class Cell {
        private final TextView text;
        private View view;

        private Cell(Context c) {
            text = new TextView(c);
            text.setLayoutParams(Utils.getParamsCell());
            this.text.setPadding(43, 8, 43, 8);
            this.text.setGravity(Gravity.CENTER);
        }

        public int getCellWidth() {
            if (view != null) return view.getLayoutParams().width;
            else return text.getLayoutParams().width;
        }

        public int getCellHeight() {
            if (view != null) return view.getLayoutParams().height;
            else return text.getLayoutParams().height;
        }

        public void setCellWidth(int width) {
            text.getLayoutParams().width = width;
            if (view != null) view.getLayoutParams().width = width;
        }

        public void setCellHeight(int height) {
            text.getLayoutParams().height = height;
            if (view != null) view.getLayoutParams().height = height;
        }

        public Cell setView(@NonNull View view) {
            this.view = view;
            return this;
        }

        public Cell setTextContent(@NonNull String str) {
            view = null;
            this.text.setText(str);
            return this;
        }

        public View getView() {
            if (view != null) return view;
            return text;
        }

        public TextView getDefaultView() {
            return text;
        }

        protected static Cell newCell(Context c) {
            return new Cell(c);
        }
    }
}
