package me.jackson.hackathon;

import me.jackson.hackathon.parse.Parser;
import me.jackson.hackathon.parse.object.objects.Chapter;
import me.jackson.hackathon.parse.parsers.CSVParser;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * The main class for the program.
 *
 * @author Jackson Ellsworth
 * @since 11/15/2019
 */
public class Hackathon {

    /**
     * The main program statement.
     *
     * @param args The arguments from the console.
     */
    public static void main(String[] args) throws IOException {
        Parser parser = new CSVParser();
        List<String[]> parsed = parser.parseFile(new File("./run/", "info.csv"));
        List<Chapter> chapters = parser.organize(parsed);
    }

}
