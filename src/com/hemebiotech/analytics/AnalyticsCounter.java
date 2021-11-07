package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class AnalyticsCounter implements ISymptomSorter {

    private List<String> analyticsList;
    private Map<String, Integer> analyticsMap;

    public AnalyticsCounter (List<String> analyticsList) { this.analyticsList = analyticsList;
    }

    /**
     *Remove duplicates and counts the number of occurrences of a list
     */

    @Override
    public Map<String, Integer> SortSymptoms() {
        Map<String, Integer> sortSymptoms = new TreeMap<>();

        for (String lines : (analyticsList)) {

            if (sortSymptoms.containsKey(lines)) {
                sortSymptoms.put(lines, sortSymptoms.get(lines) + 1);
            } else {
                sortSymptoms.put(lines, 1);
            }
        }
        return sortSymptoms;
    }

    public AnalyticsCounter(Map<String, Integer> analyticsMap) { this.analyticsMap = analyticsMap;
    }

    /**
     * Transforms a map into a list, which makes it possible to write it in a file
     */
    public List<String> result() {

        return analyticsMap.entrySet()
                .stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .collect(Collectors.toList());
    }
}
