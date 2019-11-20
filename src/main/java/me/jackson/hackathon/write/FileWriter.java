package me.jackson.hackathon.write;

import me.jackson.hackathon.parse.object.ParsedObject;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * An extensible interface for writing files.
 *
 * @author Jackson Ellsworth
 * @since 11/20/2019
 */
public interface FileWriter<O extends ParsedObject> {

    /**
     * Writes the necessary file.
     *
     * @param file The file being written to.
     * @param objects The objects being written to the file.
     * @throws IOException Solves the issue of needing a catch statement everywhere in the method.
     */
    void writeFile(File file, List<O> objects) throws IOException;
}
