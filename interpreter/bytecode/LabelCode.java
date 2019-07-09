package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode {
    private String label;
    @Override
    public void execute(VirtualMachine vm) {
        if (vm.DumpModeVerifier()) {
            System.out.println("LABEL " + label);
        }
    }

    @Override
    public void init(ArrayList<String> string) {
        label = string.get(0);
    }

    public String getLabel() {
        return label;
    }
}
