package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ReturnCode extends ByteCode{
    private String label = null;
    private int returnedPC;
    private int returnedVal;
    @Override
    public void execute(VirtualMachine vm) {
        returnedVal = vm.peek();
        vm.popFrame();
        //if (vm.ReturnAddressSize() != 0) {
        vm.setPC(vm.popReturnAddress());
        //}
        if (vm.DumpModeVerifier()) {
            if (label != null) {
                if (label.contains("<")) {
                    label = label.substring(0, label.indexOf("<"));
                }
                System.out.println("RETURN " + label + " " + label + ": " + returnedVal);

            } else {
                System.out.println("RETURN");
            }
        }

    }

    @Override
    public void init(ArrayList<String> string) {
        if (string.size() > 0) {
            label = string.get(0);
        }
    }
}
