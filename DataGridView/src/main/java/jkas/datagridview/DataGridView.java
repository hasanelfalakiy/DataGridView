package jkas.datagridview;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.ArrayList;

public class DataGridView extends LinearLayout {
    private DefaultSetting defaultSetting;
    private ArrayList<Row> listRow = new ArrayList<>();
    private ArrayList<View> listVerticalDiviser = new ArrayList<>();
    private ArrayList<View> listHorizontalDiviser = new ArrayList<>();
    private ArrayList<View> listVerticalDiviserHeader = new ArrayList<>();

    private ArrayList<TableRow> listTableRow = new ArrayList<>();
    private TableLayout tableLayoutRoot;
    public Row rowHeader;

    public DataGridView(Context c) {
        this(c, null);
    }

    public DataGridView(Context c, AttributeSet attrs) {
        super(c, attrs);
        initDefault(attrs);
    }

    private void initDefault(AttributeSet attrs) {
        defaultSetting = DefaultSetting.getInstance();
        tableLayoutRoot = new TableLayout(getContext());
        initAttr(attrs);
        setAttrs();
        this.addView(tableLayoutRoot);
    }

    private void initAttr(AttributeSet attrs) {
        if (attrs == null) return;
        TypedArray a =
                getContext()
                        .getTheme()
                        .obtainStyledAttributes(attrs, R.styleable.DataGridView, 0, 0);
        try {
            // int
            defaultSetting.columnCount =
                    a.getInt(R.styleable.DataGridView_columnCount, defaultSetting.columnCount);

            // dimen
            defaultSetting.columnHeaderHeight =
                    a.getDimension(
                            R.styleable.DataGridView_columnHeaderHeight,
                            defaultSetting.columnHeaderHeight);
            defaultSetting.diviserSize =
                    a.getDimension(
                            R.styleable.DataGridView_diviserSize, defaultSetting.diviserSize);
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
            defaultSetting.diviserColor =
                    a.getColor(R.styleable.DataGridView_diviserColor, defaultSetting.diviserColor);
            defaultSetting.diviserHeaderColor =
                    a.getColor(
                            R.styleable.DataGridView_diviserHeaderColor,
                            defaultSetting.diviserHeaderColor);

            // boolean
            defaultSetting.hideHeader =
                    a.getBoolean(R.styleable.DataGridView_hideHeader, defaultSetting.hideHeader);
            defaultSetting.showVerticalSeparator =
                    a.getBoolean(
                            R.styleable.DataGridView_showVerticalSeparator,
                            defaultSetting.showVerticalSeparator);
            defaultSetting.showHorizontalSeparator =
                    a.getBoolean(
                            R.styleable.DataGridView_showHorizontalSeparator,
                            defaultSetting.showHorizontalSeparator);
        } finally {
            a.recycle();
        }
    }

    private void setAttrs() {
        setColumnCount(defaultSetting.columnCount);
        setColumnHeaderHeight(defaultSetting.columnHeaderHeight);
        setColumnHeaderBackgroundColor(defaultSetting.columnHeaderBackgroundColor);
        setColumnHeaderTextColor(defaultSetting.columnHeaderTextColor);
        hideHeader(defaultSetting.hideHeader);
        showVerticalSeparator(defaultSetting.showVerticalSeparator);
        showHorizontalSeparator(defaultSetting.showHorizontalSeparator);
        setRowBackgroundColor(defaultSetting.rowBackgroundColor);
        setRowHeight(defaultSetting.rowHeight);
        setRowTextColor(defaultSetting.rowTextColor);
        setDiviserColor(defaultSetting.diviserColor);
        setDiviserSize(defaultSetting.diviserSize);
        setDiviserHeaderColor(defaultSetting.diviserHeaderColor);
    }

    // start ATTRS
    public void setColumnCount(int columnCount) {
        defaultSetting.columnCount = columnCount;
        this.removeAllViews();
        rowHeader = newRow();
        listVerticalDiviser.clear();
        listHorizontalDiviser.clear();
        listRow.clear();
        listTableRow.clear();
    }

    public void setColumnHeaderBackgroundColor(int columnHeaderBackgroundColor) {
        defaultSetting.columnHeaderBackgroundColor = columnHeaderBackgroundColor;
    }

    public void setColumnHeaderHeight(float columnHeaderHeight) {
        defaultSetting.columnHeaderHeight = columnHeaderHeight;
    }

    public void setColumnHeaderTextColor(int columnHeaderTextColor) {
        defaultSetting.columnHeaderTextColor = columnHeaderTextColor;
        for (Row.Cell cell : rowHeader.getCells()) {
            if (cell.getView() instanceof TextView) {
                ((TextView) cell.getView()).setTextColor(columnHeaderTextColor);
            }
        }
    }

    public void hideHeader(boolean hideHeader) {
        defaultSetting.hideHeader = hideHeader;
    }

    public void showVerticalSeparator(boolean showVerticalSeparator) {
        defaultSetting.showVerticalSeparator = showVerticalSeparator;
        for (View v : listVerticalDiviser) {
            v.setVisibility(showVerticalSeparator ? View.VISIBLE : View.GONE);
        }
    }

    public void showHorizontalSeparator(boolean showHorizontalSeparator) {
        defaultSetting.showHorizontalSeparator = showHorizontalSeparator;
        for (View v : listVerticalDiviser) {
            v.setVisibility(showHorizontalSeparator ? View.VISIBLE : View.GONE);
        }
    }

    public void showHeaderSeparator(boolean showHorizontalSeparator) {
        for (View v : listVerticalDiviserHeader) {
            v.setVisibility(showHorizontalSeparator ? View.VISIBLE : View.GONE);
        }
    }

    public void setRowBackgroundColor(int rowBackgroundColor) {
        defaultSetting.rowBackgroundColor = rowBackgroundColor;
        for (View tr : listTableRow) tr.setBackgroundColor(rowBackgroundColor);
    }

    public void setRowHeight(float rowHeight) {
        defaultSetting.rowHeight = rowHeight;
        for (View tr : listTableRow) tr.getLayoutParams().height = (int) (rowHeight * 0.9f);
    }

    public void setRowTextColor(int rowTextColor) {
        defaultSetting.rowTextColor = rowTextColor;
        for (Row row : listRow) {
            for (Row.Cell cell : row.getCells()) {
                if (cell.getView() instanceof TextView) {
                    ((TextView) cell.getView()).setTextColor(rowTextColor);
                }
            }
        }
    }

    public void setDiviserColor(int diviserColor) {
        defaultSetting.diviserColor = diviserColor;
        for (View diviser : listVerticalDiviser) diviser.setBackgroundColor(diviserColor);
        for (View diviser : listHorizontalDiviser) diviser.setBackgroundColor(diviserColor);
    }

    public void setDiviserSize(float diviserSize) {
        defaultSetting.diviserSize = diviserSize;
        for (View diviser : listVerticalDiviser)
            diviser.getLayoutParams().width = (int) diviserSize;
        for (View diviser : listHorizontalDiviser)
            diviser.getLayoutParams().height = (int) diviserSize;
    }

    public void setDiviserHeaderColor(int diviserColor) {
        defaultSetting.diviserHeaderColor = diviserColor;
        for (View diviser : listVerticalDiviserHeader) diviser.setBackgroundColor(diviserColor);
    }

    // end ATTRS

    public void clearRows() {
        this.listRow.clear();
        this.listTableRow.clear();
        this.listVerticalDiviser.clear();
        this.listHorizontalDiviser.clear();
        this.tableLayoutRoot.removeAllViews();
    }

    int positionPatternVertical = 0;

    public void addRow(Row row) {
        TableRow tableRow = new TableRow(getContext());
        tableRow.setTag("row");
        if (defaultSetting.usePattern && defaultSetting.getListColorRow().size() > 0) {
            tableRow.setBackgroundColor(defaultSetting.getListColorRow().get(positionPatternVertical));
        } else tableRow.setBackgroundColor(defaultSetting.rowBackgroundColor);

        positionPatternVertical++;
        if (defaultSetting.usePattern) {
            if (positionPatternVertical == defaultSetting.getListColorRow().size())
                positionPatternVertical = 0;
        }

        if (row.getCells().size() < defaultSetting.columnCount) {
            int v = defaultSetting.columnCount - row.getCells().size();
            for (int i = 0; i < v; i++) row.addCell(row.newCell().setTextContent("(none)"));
        }

        if (defaultSetting.showHorizontalSeparator) {
            View diviser = new View(getContext());
            diviser.setLayoutParams(Utils.getParamsHorizontalDiviser());
            diviser.getLayoutParams().height = (int) defaultSetting.diviserSize;
            diviser.setBackgroundColor(defaultSetting.diviserColor);
            this.listHorizontalDiviser.add(diviser);
            tableLayoutRoot.addView(diviser);
        }

        boolean firstExec = false;
        int positionPattern = 0;
        for (Row.Cell cell : row.getCells()) {
            if (defaultSetting.showVerticalSeparator) {
                if (!firstExec) firstExec = true;
                else {
                    View v = new View(getContext());
                    v.setLayoutParams(Utils.getParamsVerticalDiviser());
                    v.getLayoutParams().width = (int) defaultSetting.diviserSize;
                    v.setBackgroundColor(defaultSetting.diviserColor);
                    this.listVerticalDiviser.add(v);
                    tableRow.addView(v);
                }
            }
            if (defaultSetting.usePattern && defaultSetting.getListColorColumn().size() > 0) {
                cell.getView()
                        .setBackgroundColor(defaultSetting.getListColorColumn().get(positionPattern));
            }
            cell.getDefaultView().setHeight((int) defaultSetting.rowHeight);
            cell.getDefaultView().setTextSize(12f);
            cell.getDefaultView().setTextColor(defaultSetting.rowTextColor);
            tableRow.addView(cell.getView());

            positionPattern++;
            if (defaultSetting.usePattern && defaultSetting.getListColorColumn().size() > 0) {
                if (positionPattern == defaultSetting.getListColorColumn().size()) {
                    positionPattern = 0;
                }
            }
        }
        tableRow.requestLayout();
        tableLayoutRoot.addView(tableRow);
        tableLayoutRoot.requestLayout();

        this.listTableRow.add(tableRow);
        this.listRow.add(row);
    }

    public ArrayList<Row> getRows() {
        return this.listRow;
    }

    public Row getRowHeader() {
        return this.rowHeader;
    }

    public void setHeader(Row row) {
        if (defaultSetting.columnCount < 1) defaultSetting.columnCount = row.getCells().size();
        TableRow tableRowHeader = new TableRow(getContext());
        tableRowHeader.setBackgroundColor(defaultSetting.columnHeaderBackgroundColor);
        tableRowHeader.setTag("root");
        tableRowHeader.setVisibility(defaultSetting.hideHeader ? View.GONE : View.VISIBLE);
        if (tableLayoutRoot.getChildCount() > 0) {
            if (tableLayoutRoot.getChildAt(0).getTag().toString().equals("root")) {
                tableLayoutRoot.removeViewAt(0);
            }
        }
        if (row.getCells().size() < defaultSetting.columnCount) {
            int v = defaultSetting.columnCount - row.getCells().size();
            for (int i = 0; i < v; i++) {
                row.addCell(row.newCell().setTextContent("(none)"));
            }
        }

        boolean firstExec = false;
        int positionPattern = 0;
        for (Row.Cell cell : row.getCells()) {
            if (defaultSetting.showVerticalSeparator) {
                if (!firstExec) firstExec = true;
                else {
                    View v = new View(getContext());
                    v.setLayoutParams(Utils.getParamsVerticalDiviser());
                    v.getLayoutParams().width = (int) defaultSetting.diviserSize;
                    v.setBackgroundColor(defaultSetting.diviserHeaderColor);
                    listVerticalDiviserHeader.add(v);
                    tableRowHeader.addView(v);
                }
            }
            if (defaultSetting.usePattern && defaultSetting.getListColorColumnHeader().size() > 0) {
                cell.getView()
                        .setBackgroundColor(
                                defaultSetting.getListColorColumnHeader().get(positionPattern));
            }
            cell.getDefaultView().setHeight((int) defaultSetting.columnHeaderHeight);
            cell.getDefaultView().setTextSize(14f);
            cell.getDefaultView().setTextColor(defaultSetting.columnHeaderTextColor);
            tableRowHeader.addView(cell.getView());

            positionPattern++;
            if (defaultSetting.usePattern) {
                if (positionPattern == defaultSetting.getListColorColumnHeader().size()) {
                    positionPattern = 0;
                }
            }
        }
        rowHeader = row;
        tableLayoutRoot.addView(tableRowHeader, 0);
        tableRowHeader.requestLayout();
    }

    public Row newRow() {
        if (defaultSetting.columnCount < 1) {
            throw new IllegalStateException(
                    "Cannot create a row with zero columns. use \"setColumnCount(int)\" method");
        } else return Row.newRow(getContext(), defaultSetting.columnCount);
    }

    public DefaultSetting getDefaultSetting() {
        return this.defaultSetting;
    }

    @Override
    public void addView(View child) {
        throwNewAddException();
        super.addView(child);
    }

    @Override
    public void addView(View child, int index) {
        throwNewAddException();
        super.addView(child, index);
    }

    @Override
    public void addView(View child, ViewGroup.LayoutParams params) {
        throwNewAddException();
        super.addView(child, params);
    }

    @Override
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        throwNewAddException();
        super.addView(child, index, params);
    }

    public void throwNewAddException() {
        if (getChildCount() > 0)
            throw new IllegalStateException(
                    "It is not allowed to add views in this way. Use the addRow(...) method to add new data.");
    }

    @Override
    public void setPadding(int arg0, int arg1, int arg2, int arg3) {
        super.setPadding(0, 0, 0, 0);
    }

    public static class DefaultSetting {
        public boolean usePattern = false;
        public int columnCount;
        public int columnHeaderBackgroundColor;
        public float columnHeaderHeight;
        public int columnHeaderTextColor;
        public boolean hideHeader;
        public boolean showVerticalSeparator = true;
        public boolean showHorizontalSeparator = false;
        public int rowBackgroundColor;
        public float rowHeight;
        public int rowTextColor;
        public int diviserColor;
        public float diviserSize;
        public int diviserHeaderColor;
        private ArrayList<Integer> listColorColumnHeader = new ArrayList<>();
        private ArrayList<Integer> listColorColumn = new ArrayList<>();
        private ArrayList<Integer> listColorRow = new ArrayList<>();

        private DefaultSetting() {
            columnCount = 0;
        }

        public static DefaultSetting getInstance() {
            return new DefaultSetting();
        }

        public ArrayList<Integer> getListColorColumnHeader() {
            return this.listColorColumnHeader;
        }

        public void addColorInListColumnHeader(int color) {
            this.listColorColumnHeader.add(color);
        }

        public ArrayList<Integer> getListColorColumn() {
            return this.listColorColumn;
        }

        public void addColorInListColumn(int color) {
            this.listColorColumn.add(color);
        }

        public ArrayList<Integer> getListColorRow() {
            return this.listColorRow;
        }

        public void addColorInListRow(int color) {
            this.listColorRow.add(color);
        }
    }
}
