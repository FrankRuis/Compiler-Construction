package pp.cc.project.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Frank
 *
 * Class for easy access to runtime commands e.g. for compiling generated haskell files
 */
public class RuntimeUtils {
    /**
     * Compile the given sprockell file
     * @param sprogram The sprockell file
     * @param printOutput True if you want to print the output of the command, else false
     * @return The exit code of the runtime process
     */
    public static int compileSprockell(File sprogram, boolean printOutput) {
        try {
            // Get the parent directory of the sprockell program
            File folder = sprogram.getParentFile();

            // Get the runtime object and execute the command to compile the sprockell program
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(String.format("ghc -i../Sprockell/src %s", sprogram.getName()), null, folder);

            // Construct a buffered reader from the process input stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // Make sure the buffered reader is not null
            if (printOutput) {
                // Read the result of the compilation
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            // Wait for the process to finish and return the exit code
            return process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        // Return a non-zero exit code signalling an error
        return -1;
    }

    /**
     * Run the compiled exe of the given sprockell source file
     * @param sprogram The sprockell source file
     * @param printOutput True if you want to print the output of the command, else false
     * @return The exit code of the runtime process
     */
    public static int runSprockell(File sprogram, boolean printOutput) {
        try {
            // Get the runtime object and execute the command to compile the sprockell program
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("\"" + sprogram.getAbsolutePath().replaceFirst("[.][^.]+$", ".exe") + "\"");

            // Construct a buffered reader from the process input stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // Make sure the buffered reader is not null
            if (printOutput) {
                // Read the result of the compilation
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

            // Wait for the process to finish and return the exit code
            return process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        // Return a non-zero exit code signalling an error
        return -1;
    }
}
