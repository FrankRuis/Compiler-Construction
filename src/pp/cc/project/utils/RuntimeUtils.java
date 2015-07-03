package pp.cc.project.utils;

import pp.cc.project.utils.Exceptions.RunException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

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

            // Print the output if printOutput is true
            if (printOutput) {
                // Read the result of the compilation
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }

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
     * @param timeout The maximum time to wait for the program to exit in seconds
     * @return The buffered reader wrapping the input stream of the executed process
     */
    public static BufferedReader runSprockell(File sprogram, int timeout) throws RunException {
        try {
            // Get the runtime object and execute the command to compile the sprockell program
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec("\"" + sprogram.getAbsolutePath().replaceFirst("[.][^.]+$", ".exe") + "\"");

            // Construct a buffered reader from the process input stream
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            // Wait for the process to finish for the given amount of seconds
            if (process.waitFor(timeout, TimeUnit.SECONDS)) {
                // Throw a RunException if the process did exit correctly
                if (process.exitValue() != 0) {
                    throw new RunException("Program returned a non-zero exit code");
                }

                // Return the process input stream wrapped in a buffered reader
                return reader;
            } else {
                // Destroy the process
                process.destroyForcibly();

                // Throw a RunException if the program timed out
                throw new RunException("Program took too long to finish");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

        // Return a non-zero exit code signalling an error
        return null;
    }
}
