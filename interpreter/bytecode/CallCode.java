package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class CallCode extends BranchCode {
    private String topVal = "";
    @Override
    public void execute(VirtualMachine vm) {
        vm.pushReturnAddress(vm.getPC());
        vm.setPC(address);
        if(vm.sizeOfStack() > 0){
            topVal = String.valueOf(vm.peek());
        }
        if (vm.DumpModeVerifier()) {
            if(label.contains("<")){
                label = label.substring(0, label.indexOf("<"));
                System.out.println("CALL "+label+"\t"+label+"("+topVal+")");
            }else{
                System.out.println("CALL "+label+"\t"+label+"("+topVal+")");
            }
        }
    }

    public void setBranchAddress(int n){
        address = n;
    }

    @Override
    public void init(ArrayList<String> string) {
        label = string.get(0);

    }

    @Override
    public String getLabel() {
        return super.getLabel();
    }
}
