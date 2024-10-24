package jkas.datagridview;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.TableRow;

public class Utils {

    public static float getDimen(Context c, int res) {
        float val = c.getResources().getDimension(res);
        return (val * 0.9f);
    }

    public static void copyTextToClipBoard(Context context, String text) {
        ((ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE))
                .setPrimaryClip(ClipData.newPlainText("clipboard", text));
    }

    public static TableRow.LayoutParams getParamsTableRow() {
        final TableRow.LayoutParams params =
                new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, 200);
        return params;
    }

    public static TableRow.LayoutParams getParamsCell() {
        final TableRow.LayoutParams params =
                new TableRow.LayoutParams(
                        TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.MATCH_PARENT);
        params.weight = 1;
        return params;
    }

    public static TableRow.LayoutParams getParamsVerticalDiviser() {
        final TableRow.LayoutParams params =
                new TableRow.LayoutParams(4, TableRow.LayoutParams.MATCH_PARENT);
        return params;
    }

    public static TableRow.LayoutParams getParamsHorizontalDiviser() {
        final TableRow.LayoutParams params =
                new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, 4);
        return params;
    }
}
