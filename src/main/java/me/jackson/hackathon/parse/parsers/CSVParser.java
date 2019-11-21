package me.jackson.hackathon.parse.parsers;

import me.jackson.hackathon.Hackathon;
import me.jackson.hackathon.parse.Parser;
import me.jackson.hackathon.parse.object.objects.Chapter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * An implementation of {@link me.jackson.hackathon.parse.Parser} for a CSV file.
 *
 * @author Jackson Ellsworth
 * @since 11/15/2019
 */
public class CSVParser implements Parser<Chapter> {

    @Override
    public List<Chapter> organize(List<String[]> lines) {
        List<Chapter> chapters = new ArrayList<>();
        /* Hides the header from the program's eyes. */
        if (lines.size() > 0) {
            lines.remove(0);
        }

        for (String[] line : lines) {
            if (line.length == 11) {
                chapters.add(new Chapter("TRIPLE", Integer.parseInt(line[0]), line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8], line[9], line[10]));
            } else if (line.length == 9) {
                chapters.add(new Chapter("DOUBLE", Integer.parseInt(line[0]), line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8]));
            } else {
                chapters.add(new Chapter("SINGLE", Integer.parseInt(line[0]), line[1], line[2], line[3], line[4], line[5], line[6]));
            }
        }

        for (Chapter chapter : chapters) {
            Hackathon.getApplication().getChapterManager().registerChapter(chapter);
        }

        return chapters;
    }

    @Override
    public List<String[]> parseFile(File file) throws IOException {
        List<String[]> lines = new ArrayList<>();
        List<String> unsplit = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            unsplit.add(line);
        }

        for (String string : unsplit) {
            lines.add(string.split(","));
        }

        reader.close();

        return lines;
    }
}
