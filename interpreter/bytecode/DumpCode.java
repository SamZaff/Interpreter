package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class DumpCode extends ByteCode {
    private String switcher;
    @Override
    public void execute(VirtualMachine vm) {
        vm.setDumpMode(switcher);
    }

    @Override
    public void init(ArrayList<String> string) {
        switcher = string.get(0);
    }
}
