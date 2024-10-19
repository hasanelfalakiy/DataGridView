package jkas.datagridview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.Toast;
import java.util.ArrayList;

public class DataGridView extends LinearLayout {
    private int showPosition = 1;
    private DefaultSetting defaultSetting;
    private ArrayList<Row> listRow = new ArrayList<>();

    public DataGridView(Context c) {
        super(c);
        initDefault();
    }

    public DataGridView(Context c, AttributeSet attrSet) {
        super(c, attrSet);
        initDefault();
        initAttr(attrSet);
    }

    private void initDefault() {
        defaultSetting = DefaultSetting.getInstance(getContext());
    }

    private void initAttr(AttributeSet attrSet) {
        if (attrSet == null) return;

        TypedArray a =
                getContext()
                        .getTheme()
                        .obtainStyledAttributes(attrSet, R.styleable.DataGridView, 0, 0);
        try {
            // int
            defaultSetting.columnCount =
                    a.getInt(R.styleable.DataGridView_columnCount, defaultSetting.columnCount);
            defaultSetting.columnWidthSizeType =
                    a.getInt(
                            R.styleable.DataGridView_columnWidthSizeType,
                            defaultSetting.columnWidthSizeType);
            defaultSetting.rowCount =
                    a.getInt(R.styleable.DataGridView_rowCount, defaultSetting.rowCount);

            // dimen
            defaultSetting.columnHeaderHeight =
                    a.getDimension(
                            R.styleable.DataGridView_columnHeaderHeight,
                            defaultSetting.columnHeaderHeight);
            defaultSetting.gridStrokeSize =
                    a.getDimension(
                            R.styleable.DataGridView_strokeSize, defaultSetting.gridStrokeSize);
            defaultSetting.rowHeight =
                    a.getDimension(R.styleable.DataGridView_rowHeight, defaultSetting.rowHeight);

            // color
            defaultSetting.columnHeaderBackgroundColor =
                    a.getColor(
                            R.styleable.DataGridView_columnHeaderBackgroundColor,
                            defaultSetting.columnHeaderBackgroundColor);
            defaultSetting.columnHeaderTextColor =
                    a.getColor(
                            R.styleable.DataGridView_columnHeaderTextColor,
                            defaultSetting.columnHeaderTextColor);
            defaultSetting.rowBackgroundColor =
                    a.getColor(
                            R.styleable.DataGridView_rowBackgroundColor,
                            defaultSetting.rowBackgroundColor);
            defaultSetting.rowTextColor =
                    a.getColor(R.styleable.DataGridView_rowTextColor, defaultSetting.rowTextColor);
            defaultSetting.strokeColor =
                    a.getColor(R.styleable.DataGridView_strokeColor, defaultSetting.strokeColor);

            // boolean
            defaultSetting.hideHeader =
                    a.getBoolean(R.styleable.DataGridView_hideHeader, defaultSetting.hideHeader);
            defaultSetting.showHorizontalSeparator =
                    a.getBoolean(
                            R.styleable.DataGridView_showHorizontalSeparator,
                            defaultSetting.showHorizontalSeparator);
            defaultSetting.showVerticalSeparator =
                    a.getBoolean(
                            R.styleable.DataGridView_showVerticalSeparator,
                            defaultSetting.showVerticalSeparator);
        } finally {
            a.recycle();
        }
    }

    public void clearRows() {
        this.listRow.clear();
        // clean all rows
    }

    public boolean deleteRow(int position) {
        if (position > listRow.size() || position < 0) {
            throw new IllegalStateException(
                    "The position must not be a negative value let alone greater than the number of available rows.");
        }
        this.listRow.remove(position);
        // remove row at

        return true;
    }

    public void deleteRow(Row row) {
        this.listRow.remove(row);
        // remove row
    }

    public void addRow(Row row) {
        this.listRow.add(row);
        // add
    }

    public boolean addRow(Row row, int position) {
        if (position > listRow.size() || position < 0) {
            throw new IllegalStateException(
                    "The position must not be a negative value let alone greater than the number of available rows.");
        }
        this.listRow.add(position, row);

        // add

        return true;
    }

    public ArrayList<Row> getRows() {
        return this.listRow;
    }

    public boolean canShowPrevious() {
        // check
        return false;
    }

    public boolean canShowNext() {
        // check
        return false;
    }

    public boolean showPrevious() {
        return false;
    }

    public boolean showNext() {
        return false;
    }

    public Row newRow() {
        if (defaultSetting.columnCount < 1) {
            throw new IllegalStateException(
                    "Cannot create a row with zero columns. use \"setColumnCount(int)\" method");
        } else if (defaultSetting.rowCount < 1) {
            throw new IllegalStateException(
                    "it is important to set the number of rows to display in the grid because the value must not be zero. use \"setRowCount(int)\" method");
        } else return Row.newRow(getContext(), defaultSetting.columnCount);
    }

    public DefaultSetting getDefaultSetting() {
        return this.defaultSetting;
    }

    private OnEventListener listener;

    public void setOnEventListener(OnEventListener listener) {
        this.listener = listener;
    }

    public interface OnEventListener {
        public default void onRowAdded(Row row) {}

        public default void onRowRemoved(Row row) {}

        public default void onAllRowRemoved() {}

        public default void onShowPerformed() {}
    }

    public static class DefaultSetting {
        private Context C;
        private static DefaultSetting instance;
        public static final int WRAP_CONTENT = 0;
        public static final int STRETCH = 1;

        public int columnCount;
        public int columnHeaderBackgroundColor;
        public float columnHeaderHeight;
        public int columnHeaderTextColor;
        public int columnWidthSizeType;
        public boolean hideHeader;
        public boolean showVerticalSeparator;
        public boolean showHorizontalSeparator;
        public int rowBackgroundColor;
        public int rowCount;
        public float rowHeight;
        public int rowTextColor;
        public int strokeColor;
        public float gridStrokeSize;

        private DefaultSetting(Context c) {
            C = c;
            columnCount = 0;
            columnHeaderBackgroundColor = C.getColor(R.color.backgroundColorHeader);
            columnHeaderTextColor = C.getColor(R.color.textColorHeader);
            columnHeaderHeight = C.getResources().getDimension(R.dimen.columnHeaderSizeHeight);
            columnWidthSizeType = WRAP_CONTENT;

            hideHeader = false;

            showVerticalSeparator = false;
            showHorizontalSeparator = true;

            rowBackgroundColor = C.getColor(R.color.backgroundColorRow);
            rowTextColor = C.getColor(R.color.textColorRow);
            rowCount = 43;
            rowHeight = C.getResources().getDimension(R.dimen.rowHeight);

            strokeColor = C.getColor(R.color.backgroundColorHeader);
            gridStrokeSize = 0;
        }

        public static DefaultSetting getInstance(Context c) {
            if (instance == null) instance = new DefaultSetting(c);
            return instance;
        }
    }
}
