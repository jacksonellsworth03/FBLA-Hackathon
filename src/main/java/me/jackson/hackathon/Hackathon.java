package me.jackson.hackathon;

import me.jackson.hackathon.parse.Parser;
import me.jackson.hackathon.parse.object.objects.Chapter;
import me.jackson.hackathon.parse.parsers.CSVParser;
import me.jackson.hackathon.write.FileUpdater;
import me.jackson.hackathon.write.impl.CSVWriter;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * The main class for the program.
 *
 * @author Jackson Ellsworth
 * @since 11/15/2019
 */
public final class Hackathon {

    /**
     * This file header essentially sets up the columns and rows for the program, so I want the default to be present.
     *
     * <p>
     * I know it's long and obnoxious, but there really isn't a better way (In Java) to solve this issue.
     * </p>
     */
    private static final String FILE_HEADER = "chapter_id,school_name,school_address_1,school_address_2,school_phone,primary_adviser_name,primary_adviser_email,adviser_name_2,adviser_email_2,adviser_name_3,adviser_email_3";

    /**
     * The main program statement.
     *
     * @param args The arguments from the console.
     */
    public static void main(String[] args) throws IOException {
        Parser parser = new CSVParser();
        FileUpdater writer = new CSVWriter();
        List<String[]> parsed = parser.parseFile(new File("./run/", "info.csv"));
        List<Chapter> chapters = parser.organize(parsed);
        writer.writeFile(new File("./run/", "info.csv"), chapters);
    }

    public static String getFileHeader() {
        return FILE_HEADER;
    }
}
