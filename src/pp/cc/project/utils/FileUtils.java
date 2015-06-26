package pp.cc.project.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author Frank
 *
 * Class for easy access to static functions for reading files
 */
public class FileUtils {
    /**
     * Read a file and return its contents.
     * @param file The file to read
     * @return The file contents, or an empty string if an error occurs
     */
    public static String readFile(File file) {
        try {
            // Create a stringbuffer for the file contents
            StringBuilder builder = new StringBuilder();

            // Read all lines from the file
            Files.lines(file.toPath()).forEach(line -> builder.append(String.format("%s%n", line)));

            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }

    /**
     * Get the path to the project source directory
     * @return the path to the project source directory
     */
    public static String getBase() {
        // Get the path to the current working directory
        Path path = FileSystems.getDefault().getPath(System.getProperty("user.dir"));

        // IntelliJ's working directory is in PPFinalProject, eclipse's working directory is in PPFinalProject/src
        return Paths.get(path.toString(), path.endsWith("PPFinalProject") ? "src/" : "").toString();
    }

    /**
     * Get the path that goes through the given folders starting from the project source directory
     * @param args The folders to go through in order
     * @return The path
     */
    public static String getPath(String... args) {
        return Paths.get(getBase(), args).toString();
    }

    /**
     * Get the path that goes through the given folders starting from the pp.cc.project package
     * @param args The folders to go through in order
     * @return The path
     */
    public static String getProjPath(String... args) {
        return Paths.get(getBase() + "/pp/cc/project/", args).toString();
    }
}
