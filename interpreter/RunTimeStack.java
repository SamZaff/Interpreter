package interpreter;

import java.util.ArrayList;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList runTimeStack;
    private Stack<Integer> framePointer;


    public RunTimeStack() { //bytecode is NOT allowed to have access to runTimeStack
        runTimeStack = new ArrayList<Integer>();
        framePointer = new Stack<Integer>();
        // Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }
    public void dump() {
        int start = framePointer.get(0);
        int stop;
        for (int i = 0; i < framePointer.size(); i++) {
            System.out.print("[");
            if ((i+1) < framePointer.size()) {
                stop = framePointer.get(i+1);
            }
            else {
                stop = runTimeStack.size();
            }
            for (int j = start; j < stop; j++) {
                System.out.print(runTimeStack.get(j));
                if (j < stop - 1) {
                    System.out.print(",");
                }
            }
            start = stop;
            System.out.print("]");
        }
        System.out.println();
    }
    public int peek() {
        if (runTimeStack.size() > 1) {
            return (int) runTimeStack.get(runTimeStack.size() - 1);
        }
        return (int) runTimeStack.get(0);
    }
    public int pop() {
        if (runTimeStack.size() > 1) {
            return (int)runTimeStack.remove(runTimeStack.size()-1);
        }
        //return 0;
        return (int) runTimeStack.remove(0);
    }
    public int push(int i) {
        runTimeStack.add(i);
        return i;
    }

    public void newFrameAt(int offset) {
        if (offset <= runTimeStack.size()) {
            framePointer.push(runTimeStack.size()-offset);
        }
    }

    public void popFrame() {
        int var  = (int) runTimeStack.get(runTimeStack.size()-1);
        for (int i = runTimeStack.size() - 1; i >= framePointer.peek(); i--) {
            runTimeStack.remove(i);
        }
        framePointer.pop();
        runTimeStack.add(var);
    }

    public int store(int offset) {
        if(runTimeStack.size() == 1 && !framePointer.isEmpty()) {
            return (int) runTimeStack.get(0);
        }

        else if ((framePointer.peek() + offset) > runTimeStack.size()-1) {
            int x = (int) runTimeStack.get(runTimeStack.size()-1);
            runTimeStack.set(runTimeStack.size()-1, x);
            return x;
        }
        int x = (int) runTimeStack.get(runTimeStack.size()-1);
        runTimeStack.remove(runTimeStack.size()-1);
        runTimeStack.set(framePointer.peek()+offset, x);
        return x;
    }

    public int load(int offset) {
        if ((framePointer.peek() + offset) > runTimeStack.size()-1) {
            int x = (int) runTimeStack.get(runTimeStack.size()-1);
            runTimeStack.get(x);
            return x;
        }
        int x = (int) runTimeStack.get(framePointer.peek() + offset);
        runTimeStack.add(x);
        return x; //temp
    }

    public int sizeOfStack() {
        return runTimeStack.size();
    }

    public int sizeOfFrame(){
        return framePointer.size();
    }
}
