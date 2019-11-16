package me.jackson.hackathon.parse;

import me.jackson.hackathon.parse.object.ParsedObject;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * The outline for any parser in the application.
 *
 * <p>
 * Ideally, this allows multiple file formats to later be implemented (IE: JSON, HOCON; Rather than just CSV).
 * </p>
 *
 * @author Jackson Ellsworth
 * @since 11/15/2019
 */
public interface Parser<O extends ParsedObject> {

    /**
     * Organizes the given lines into the parsers object type.
     *
     * @param lines The lines parsed previously.
     * @return The type specific to the parser's object collection.
     */
    List<O> organize(List<String[]> lines);

    /**
     * Parses the file into the {@link List} collection object.
     *
     *
     * @param file The file being parsed.
     * @throws IOException Allows file reading to occur.
     * @return The file's information parsed line-by-line.
     */
    List<String[]> parseFile(File file) throws IOException;
}
