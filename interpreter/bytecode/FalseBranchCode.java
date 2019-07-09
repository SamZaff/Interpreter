package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class FalseBranchCode extends BranchCode {
    @Override
    public void execute(VirtualMachine vm) {
        if (vm.pop() == 0) {
            vm.setPC(address);
        }
        if (vm.DumpModeVerifier()) {
            System.out.println("FALSEBRANCH " + label);
        }
    }

    @Override
    public void init(ArrayList<String> string) {
        label = string.get(0);
    }

    @Override
    public void setBranchAddress(int n) {
        super.setBranchAddress(n);
    }

    @Override
    public String getLabel() {
        return super.getLabel();
    }
}
