package org.creepebucket.creepebucketlib;

import java.util.*;

public class ModUtils {
    public static double now() {
        return System.nanoTime() / 1e9;
    }

    public static double roundDouble(double value) {
        return Math.round(value * 1e10) / 1e10;
    }

    // 基础单位转换（1000 进制），不省略末尾 0
    public static String formattedNumber(double value) {
        String[] prefixes = new String[]{"", "K", "M", "G", "T", "P", "E", "Z", "Y"};

        double v = value;
        int idx = 0;
        while (Math.abs(v) >= 1000.0 && idx < prefixes.length - 1) {
            v /= 1000.0;
            idx++;
        }

        double absVal = Math.abs(v);
        int decimals;
        if (absVal == 0.0) {
            decimals = 0;
        } else if (absVal >= 1.0) {
            int intDigits = (int) Math.floor(Math.log10(absVal)) + 1; // 1..3
            decimals = Math.max(0, 4 - intDigits);
        } else {
            decimals = 4;
        }

        return String.format("%." + decimals + "f %s", v, prefixes[idx]);
    }

    // 基础单位转换（1000 进制），按显示位数动态决定小数位数，不省略末尾 0
    public static String formattedNumber(double value, int stringLength) {
        String[] prefixes = new String[]{"", "K", "M", "G", "T", "P", "E", "Z", "Y"};
        int exp = (int) Math.floor(Math.log10(value));

        try {
            if (Double.isInfinite(value)) {
                return "∞" + " ".repeat(stringLength - 1);
            } else if (value < 10) {
                // 不可以log的情况
                return String.format("%0" + Math.max(1, stringLength - 1) + "." + Math.max(0, stringLength - 3) + "f", value) + " ";
            } else if (value >= 1e27) {
                // 使用科学计数法
                var man = value / Math.pow(10, exp);

                int expDecimals = exp <= 1 ? 1 : (int) Math.ceil(Math.log10(exp));
                return String.format("%0" + Math.max(1, stringLength - 2 - expDecimals) + "." + Math.max(0, stringLength - 4 - expDecimals) + "f", man) + "e" + exp + " ";
            } else if (value >= 1000) {
                // 使用前缀
                int index = (int) Math.floor((double) exp / 3);
                var man = value / Math.pow(10, index * 3);
                int manDecimals = man <= 1 ? 1 : (int) Math.floor(Math.log10(man)) + 1;

                return String.format("%0" + Math.max(1, stringLength - 2) + "." + Math.max(0, stringLength - 3 - manDecimals) + "f", man) + " " + prefixes[index];
            } else {
                // 直接输出
                int manDecimals = value <= 1 ? 1 : (int) Math.floor(Math.log10(value)) + 1;
                return String.format("%0" + Math.max(1, stringLength - 1) + "." + Math.max(0, stringLength - 2 - manDecimals) + "f", value) + " ";
            }
        } catch (UnknownFormatConversionException _) {
            System.out.println("prm数字转换出错: " + value + " " + stringLength);
            return "bug了请报告"; // 实在没招了, 有bug
        }
    }
}
