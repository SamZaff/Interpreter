package interpreter;

import java.util.Stack;
import interpreter.bytecode.ByteCode;

public class VirtualMachine { //HALT cannot use system.exit
    //each bytecode will have access to the virtual machine
    //DO NOT make a method for each individual bytecode in here
    private RunTimeStack runStack;
    private Stack returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private String dumpSwitch;

    public void executeProgram() {
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        dumpSwitch = "ON";
        while(isRunning){
            ByteCode code = program.getCode(pc);
            code.execute(this);
            if (dumpSwitch.equals("ON")) {
                runStack.dump(); // Used to dump runstack state.
            }
            pc++;
        }
    }

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public int peek(){
        return runStack.peek();
    }

    public int pop(){
        return runStack.pop();
    }

    public int push(int i) {
        return runStack.push(i);
    }

    public void newFrameAt(int i) {
        runStack.newFrameAt(i);
    }

    public void popFrame() {
        runStack.popFrame();
    }

    public int store(int i) {
        return runStack.store(i);
    }

    public void load(int i) {
        runStack.load(i);
    }

    public void pushReturnAddress(int i) {
        returnAddrs.push(i);
    }

    public int popReturnAddress(){
        return (int) returnAddrs.pop();
    }

    public int peekReturnAddress(){
        return (int) returnAddrs.peek();
    }

    public void run(boolean flag){
        this.isRunning = flag;
    }

    public int sizeOfStack() {
        return runStack.sizeOfStack();
    }

    public int sizeOfFrame() {
        return runStack.sizeOfFrame();
    }

    public void setPC(int n){
        this.pc = n;
    }

    public int getPC() {
        return this.pc;
    }

    public String setDumpMode(String switcher){
        return dumpSwitch = switcher;
    }

    public boolean DumpModeVerifier(){
        return dumpSwitch.equals("ON");
    }
}
