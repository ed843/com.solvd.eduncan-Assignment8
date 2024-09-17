package com.solvd.eduncan;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class Utils {
    @FunctionalInterface
    public interface Comparator<T> {
        int compare(T o1, T o2);
    }

    @FunctionalInterface
    public interface Filter<T> {
        boolean test(T item);
    }

    public static <T> List<T> filterList(List<T> list, Filter<T> filter) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (filter.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

    public static <T> void sortList(List<T> list, Comparator<T> comparator) {
        list.sort((o1, o2) -> comparator.compare(o1, o2));
    }

    public static String generateEmployeeId() {
        Supplier<String> generateEmployeeId = () -> "EMP" + (int)(Math.random() * 10000);
        return generateEmployeeId.get();
    }

}
