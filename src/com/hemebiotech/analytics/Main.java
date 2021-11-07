package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        ReadSymptomDataFromFile file = new ReadSymptomDataFromFile("src/resources/symptoms.txt");
        AnalyticsCounter list = new AnalyticsCounter(file.GetSymptoms());
        AnalyticsCounter map = new AnalyticsCounter(list.SortSymptoms());

        //Write the list in a file

        FileWriter writer = new FileWriter("result.out");
        for (String str : map.result()) {
            writer.write(str + System.lineSeparator());
        }
        writer.close();
    }
}