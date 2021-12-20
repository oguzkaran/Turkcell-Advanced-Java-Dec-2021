package com.turkcell.util.numeric;

import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.OptionalLong;

public final class NumberUtil {
    private NumberUtil()
    {}

    public static OptionalInt toInt(String str)
    {
        var result = OptionalInt.empty();

        try {
            result = OptionalInt.of(Integer.parseInt(str));
        }
        catch (NumberFormatException ignore) {

        }

        return result;
    }

    public static OptionalLong toLong(String str)
    {
        var result = OptionalLong.empty();

        try {
            result = OptionalLong.of(Long.parseLong(str));
        }
        catch (NumberFormatException ignore) {

        }

        return result;
    }

    public static OptionalDouble toDouble(String str)
    {
        var result = OptionalDouble.empty();

        try {
            result = OptionalDouble.of(Double.parseDouble(str));
        }
        catch (NumberFormatException ignore) {

        }

        return result;
    }
}
