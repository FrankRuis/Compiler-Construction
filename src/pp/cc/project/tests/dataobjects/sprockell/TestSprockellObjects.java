package pp.cc.project.tests.dataobjects.sprockell;

import junit.framework.TestCase;
import pp.cc.project.dataobjects.sprockell.*;

/**
 * @author Frank
 */
public class TestSprockellObjects extends TestCase {
    /**
     * Test the toString() methods of the Sprockell objects
     */
    public void testSprockellObjects() {
        Constant constant = new Constant(-10);
        assertEquals("(-10)", constant.toString());

        constant = new Constant('a');
        assertEquals("(ord 'a')", constant.toString());

        Register register = new Register(Register.Reg.RegB);
        assertEquals("RegB", register.toString());

        MemAddr memAddr = new MemAddr("stdio");
        assertEquals("(stdio)", memAddr.toString());

        memAddr = new MemAddr(register);
        assertEquals("(Deref RegB)", memAddr.toString());

        Target target = new Target(register);
        assertEquals("(Ind RegB)", target.toString());

        target = new Target(Target.Type.Rel, new Constant(5));
        assertEquals("(Rel (5))", target.toString());

        target = new Target(Target.Type.Abs, new Constant(-9));
        assertEquals("(Abs (-9))", target.toString());

        Operator operator = new Operator(Operator.Type.Add);
        assertEquals("Add", operator.toString());

        Instruction instruction = new Instruction(Instr.Branch, register, target);
        assertEquals("Branch RegB (Abs (-9))", instruction.toString());

        instruction = new Instruction(Instr.Compute, operator, register, new Register(Register.Reg.RegA),
                new Register(Register.Reg.RegE));
        assertEquals("Compute Add RegB RegA RegE", instruction.toString());
    }
}
