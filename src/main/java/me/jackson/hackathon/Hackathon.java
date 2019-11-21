package me.jackson.hackathon;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import me.jackson.hackathon.manage.ChapterManager;
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
public final class Hackathon extends Application {

    /**
     * The singleton instance for the application.
     */
    private static final Hackathon APPLICATION = new Hackathon();

    /**
     * This file header essentially sets up the columns and rows for the program, so I want the default to be present.
     *
     * <p>
     * I know it's long and obnoxious, but there really isn't a better way (In Java) to solve this issue.
     * </p>
     */
    private static final String FILE_HEADER = "chapter_id,school_name,school_address_1,school_address_2,school_phone,primary_adviser_name,primary_adviser_email,adviser_name_2,adviser_email_2,adviser_name_3,adviser_email_3";

    /**
     * Manages the chapters for the application.
     */
    private final ChapterManager chapterManager = new ChapterManager();

    @Override
    public void start(Stage stage) {
        /* Create required instances. */
        Group group = new Group();
        Scene scene = new Scene(group, 500, 500);

        /* Startup stage. */
        stage.setScene(scene);
        stage.setTitle("Georgia FBLA Hackathon");

        /* The vertical padding. */
        VBox verticalBox = new VBox();
        verticalBox.setPadding(new Insets(10, 10, 10, 10));
        verticalBox.setSpacing(10);

        /* The horizontal padding. */
        HBox horizontalBox = new HBox();
        horizontalBox.setSpacing(10);
        horizontalBox.setAlignment(Pos.CENTER);

        /* Add the password field and label. */
        Label label = new Label();
        label.setText("Chapter ID");
        PasswordField field = new PasswordField();
        field.setPromptText("Chapter ID");

        /* Setup response from app whenever ID is typed. */
        field.setOnAction(event -> {
            Chapter found = chapterManager.getChapters().get(Integer.parseInt(field.getText()));

            if (found == null) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error!");
                alert.setHeaderText("There has been an error in finding this chapter!");
                alert.setContentText("That chapter id does not correlate to a chapter!");
                alert.showAndWait();
            }

            field.setText("");
        });

        /* Add the password and scene. */
        horizontalBox.getChildren().addAll(label, field);
        verticalBox.getChildren().addAll(horizontalBox);

        /* Make the vertical padding the main grouping. */
        scene.setRoot(verticalBox);

        /* Showcase the UI itself. */
        stage.show();
    }

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

        launch(args);

        writer.writeFile(new File("./run/", "info.csv"), chapters);
    }

    public static Hackathon getApplication() {
        return APPLICATION;
    }

    public static String getFileHeader() {
        return FILE_HEADER;
    }

    public ChapterManager getChapterManager() {
        return chapterManager;
    }
}
