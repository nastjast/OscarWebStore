package com.telran.oscar.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProvider {

    @org.testng.annotations.DataProvider(name = "registrationWithInvalidEmailFromCSV")
    public static Iterator<Object[]> registrationWithInvalidEmailFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/negEmail.csv")));
        String line = reader.readLine();
        while (line != null) {
            list.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }

    @org.testng.annotations.DataProvider(name = "registrationWithInvalidPasswordFromCSV")
    public static Iterator<Object[]> registrationWithInvalidPasswordFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/negPassword.csv")));
        String line = reader.readLine();
        while (line != null) {
            list.add(line.split(","));
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }

    @org.testng.annotations.DataProvider(name = "product names")
    public Object[][] productNames() {
        return new Object[][]
                {
                        {"Neuromancer."},
                        {"The Robot Novels"},
                        {"Excession"},
                        {"The City and the ..."}
                };

    }

    @org.testng.annotations.DataProvider(name = "side menu elements")
    public Object[][] sideMenuNames() {
        return new Object[][]
                {
                        {"All products"},
                        {"Clothing"},
                        {"Books"},
                        {"Offers"}
                };

    }
}
