package jkas.datagridview;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.util.TypedValue;

public class Utils {
    public static float getDimenValue(Context C, String unitString) {
        return Float.parseFloat((parseUnitString2Px(C, unitString)));
    }

    public static String parseUnitString2Px(Context C, String unitString) {
        String[] suffixs = {"sp", "dp", "dip", "pt", "px", "mm", "in"};
        unitString = unitString.trim();
        int lastIndex = -1;
        for (String suffix : suffixs) {
            if (unitString.endsWith(suffix)) {
                lastIndex = unitString.length() - suffix.length();
                try {
                    float v = Float.parseFloat(unitString.substring(0, lastIndex));
                    switch (suffix) {
                        case "sp":
                            return String.valueOf(
                                    TypedValue.applyDimension(
                                            TypedValue.COMPLEX_UNIT_SP,
                                            v,
                                            C.getResources().getDisplayMetrics()));
                        case "dp":
                        case "dip":
                            return String.valueOf(
                                    TypedValue.applyDimension(
                                            TypedValue.COMPLEX_UNIT_DIP,
                                            v,
                                            C.getResources().getDisplayMetrics()));
                        case "pt":
                            return String.valueOf(
                                    TypedValue.applyDimension(
                                            TypedValue.COMPLEX_UNIT_PT,
                                            v,
                                            C.getResources().getDisplayMetrics()));
                        case "px":
                            return String.valueOf(v);
                        case "mm":
                            return String.valueOf(
                                    TypedValue.applyDimension(
                                            TypedValue.COMPLEX_UNIT_MM,
                                            v,
                                            C.getResources().getDisplayMetrics()));
                        case "in":
                            return String.valueOf(
                                    TypedValue.applyDimension(
                                            TypedValue.COMPLEX_UNIT_IN,
                                            v,
                                            C.getResources().getDisplayMetrics()));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        return "-1";
    }
    
    public static void copyTextToClipBoard(Context context, String text) {
        ((ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE))
                .setPrimaryClip(ClipData.newPlainText("clipboard", text));
    }
}
