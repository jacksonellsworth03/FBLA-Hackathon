package me.jackson.hackathon.manage;

import me.jackson.hackathon.parse.object.objects.Chapter;

import java.util.HashMap;
import java.util.Map;

/**
 * Manages the chapters for the application.
 *
 * @author Jackson Ellsworth
 * @since 11/20/2019
 */
public class ChapterManager {

    /**
     * The chapters in the application.
     */
    private final Map<Integer, Chapter> chapters = new HashMap<>();

    /**
     * Adds a chapter to the application.
     *
     * @param chapter The chapter being added to the application.
     */
    public void registerChapter(Chapter chapter) {
        chapters.put(chapter.getChapterID(), chapter);
    }

    public Map<Integer, Chapter> getChapters() {
        return chapters;
    }
}
