package interpreter;

import interpreter.bytecode.ByteCode;
import java.util.ArrayList;
import interpreter.bytecode.*;
import java.util.HashMap;

public class Program {

    private ArrayList<ByteCode> program;
    private static HashMap<String, Integer> labelCode = new HashMap<>();

    public Program() {

        program = new ArrayList<>();
    }

    protected ByteCode getCode(int pc) {

        return this.program.get(pc);
    }

    public int getSize() {

        return this.program.size();
    }

    /**
     * This function should go through the program and resolve all addresses.
     * Currently all labels look like LABEL <<num>>>, these need to be converted into
     * correct addresses so the VirtualMachine knows what to set the Program Counter(PC)
     * HINT: make note what type of data-stucture bytecodes are stored in.
     *
     * @param program Program object that holds a list of ByteCodes
     */
    public void addByteCode(ByteCode byteCode) {
        if (byteCode instanceof LabelCode) {
            LabelCode x = (LabelCode)byteCode;
            //program.size();
            labelCode.put(x.getLabel(), program.size()-1);
        }
        program.add(byteCode);

    }

    public void resolveAddrs(Program program) {
        for (int i = 0; i < program.getSize(); i++) {
            if (program.program.get(i) instanceof BranchCode) {
                BranchCode br = (BranchCode)program.program.get(i);
                //System.out.println(br.getLabel());
                if (br.getLabel() != null) {
                    br.setBranchAddress(labelCode.get(br.getLabel()));
                }

            }
        }

    }

}
