package pp.cc.project.utils;

import org.antlr.v4.runtime.tree.ParseTree;
import pp.cc.project.codegen.FirstPass;
import pp.cc.project.codegen.FirstPassResult;
import pp.cc.project.codegen.SecondPass;
import pp.cc.project.dataobjects.sprockell.Program;
import pp.cc.project.utils.Exceptions.ParseException;

import java.io.File;

/**
 * @author Frank
 */
public class CompileFrartellProgram {
    public static void main(String[] args) {
        // Change this to the file you would like to compile
        File file = new File(FileUtils.getProjPath("samples/correct/IsEvenTest.frart"));

        // Parse the file and get the parse tree
        ParseTree parseTree = ParseUtils.getParseTree(file);

        try {
            // Get the result of the first pass
            FirstPassResult result = new FirstPass().check(parseTree);

            // Get the generated Sprockell program
            Program program = new SecondPass().generate(parseTree, result);

            // Print the program
            System.out.println(program);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
