package pp.cc.project.dataobjects.Sprockell;

import pp.cc.project.dataobjects.Sprockell.Arg.Type;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Frank
 *
 * Sprockell instruction type
 */
public enum Instr {
    /* Local instructions */

    /**
     * Store arg1 in arg2
     */
    Const(1, Type.Const, Type.Reg),
    /**
     * Store result of operator on arg2 and arg3 in arg4
     */
    Compute(3, Type.Operator, Type.Reg, Type.Reg, Type.Reg),
    /**
     * Load from address arg1 and store in arg2
     */
    Load(1, Type.MemAddr, Type.Reg),
    /**
     * Store arg1 at address arg2
     */
    Store(1, Type.Reg, Type.MemAddr),
    /**
     * Jump to arg2 if arg1 is not zero
     */
    Branch(1, Type.Reg, Type.Target),
    /**
     * Jump to arg1
     */
    Jump(0, Type.Target),
    /**
     * Push arg1 to the top of the stack
     */
    Push(1, Type.Reg),
    /**
     * Pop the value at the top of the stack and store it in arg1
     */
    Pop(0, Type.Reg),
    /**
     * Do nothing
     */
    Nop(0),
    /**
     * Terminate the program
     */
    EndProg(0),

    /* System instructions */

    /**
     * Send request to shared memory to fetch arg1
     */
    Read(1, Type.MemAddr),
    /**
     * Block and wait for a message to arrive, store result in arg1
     */
    Receive(0, Type.Reg),
    /**
     * Write arg1 to shared memory address arg2
     */
    Write(1, Type.Reg, Type.MemAddr),
    /**
     * If arg1 contained a 1, do nothing and return 0. If it contained a 0, write 1 and return 1.
     */
    TestAndSet(1, Type.MemAddr);

    // All arguments
    private List<Type> args;

    // Source arguments
    private List<Type> sourceArgs;

    // Target arguments
    private List<Type> targetArgs;

    /**
     * Construct an instruction
     * @param sourceCount The number of source arguments
     * @param args The arguments
     */
    Instr(int sourceCount, Arg.Type... args) {
        this.args = Arrays.asList(args);
        sourceArgs = new ArrayList<>(Arrays.stream(args).limit(sourceCount).collect(Collectors.toList()));
        targetArgs = new ArrayList<>(Arrays.stream(args).skip(sourceCount).collect(Collectors.toList()));
    }

    /**
     * @return The instruction arguments
     */
    public List<Type> getArgs() {
        return args;
    }

    /**
     * @return The instruction source arguments
     */
    public List<Type> getSourceArgs() {
        return sourceArgs;
    }

    /**
     * @return The instruction target arguments
     */
    public List<Type> getTargetArgs() {
        return targetArgs;
    }

    /**
     * @return The amount of arguments
     */
    public int argCount() {
        return args.size();
    }

    /**
     * @return The amount of source arguments
     */
    public int sourceArgCount() {
        return sourceArgs.size();
    }

    /**
     * @return The amount of target arguments
     */
    public int targetArgCount() {
        return targetArgs.size();
    }
}
