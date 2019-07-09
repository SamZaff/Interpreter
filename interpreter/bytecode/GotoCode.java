package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class GotoCode extends BranchCode {
    //String var;
    @Override
    public void execute(VirtualMachine vm) {
        vm.setPC(address);
        if (vm.DumpModeVerifier()) {
            System.out.println("GOTO " + label);
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
