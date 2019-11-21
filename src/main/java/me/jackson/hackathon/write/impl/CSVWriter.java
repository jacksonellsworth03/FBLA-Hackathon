package me.jackson.hackathon.write.impl;

import me.jackson.hackathon.Hackathon;
import me.jackson.hackathon.parse.object.objects.Chapter;
import me.jackson.hackathon.write.FileUpdater;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import java.util.List;

/**
 * An implementation of {@link FileUpdater} for CSV files.
 *
 * @author Jackson Ellsworth
 * @since 11/20/2019
 */
public class CSVWriter implements FileUpdater<Chapter> {

    /**
     * An instance of java's {@link Calendar} object.
     */
    private final Calendar calendar = Calendar.getInstance();

    @Override
    public void writeFile(File file, List<Chapter> objects) throws IOException {
        String directory = file.getParent();
        String backupFileName = String.format("info-backup-%s-%s-%s-%s.csv",
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH),
                System.currentTimeMillis());
        if (file.exists()) {
            /* Creates a backup file with the current date and system time. */
            File backup = new File(directory, backupFileName);
            Files.move(file.toPath(), backup.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }
        /* Create a new "original". */
        Path newFile = new File(directory, "info.csv").toPath();
        Files.createFile(newFile);

        try (final Writer writer = new FileWriter(newFile.toFile())) {
            writer.write(Hackathon.getFileHeader() + "\n");
            for (Chapter chapter : objects) {
                switch (chapter.getType()) {
                    case "TRIPLE":
                        writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s", chapter.getChapterID(), chapter.getSchool(),
                                chapter.getMainAddress(), chapter.getAlternateAddress(), chapter.getPhone(), chapter.getPrimaryAdviser(),
                                chapter.getPrimaryAdviserEmail(), chapter.getSecondaryAdviser(), chapter.getSecondaryAdviserEmail(),
                                chapter.getTertiaryAdviser(), chapter.getTertiaryAdviserEmail()));
                        break;
                    case "DOUBLE":
                        writer.write(String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s", chapter.getChapterID(), chapter.getSchool(),
                                chapter.getMainAddress(), chapter.getAlternateAddress(), chapter.getPhone(), chapter.getPrimaryAdviser(),
                                chapter.getPrimaryAdviserEmail(), chapter.getSecondaryAdviser(), chapter.getSecondaryAdviserEmail()));
                        break;
                    case "SINGLE":
                        writer.write(String.format("%s,%s,%s,%s,%s,%s,%s", chapter.getChapterID(), chapter.getSchool(),
                                chapter.getMainAddress(), chapter.getAlternateAddress(), chapter.getPhone(), chapter.getPrimaryAdviser(),
                                chapter.getPrimaryAdviserEmail()));
                        break;
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            Files.delete(newFile);
        }
    }
}
