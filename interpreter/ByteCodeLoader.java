
package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import interpreter.bytecode.*;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ByteCodeLoader extends Object {

    private BufferedReader byteSource;
    private Program PC;
    private StringTokenizer tokenizer;
    private static final String DELIMITERS = " ";
    String Token;
    /**
     * Constructor Simply creates a buffered reader.
     * YOU ARE NOT ALLOWED TO READ FILE CONTENTS HERE
     * THIS NEEDS TO HAPPEN IN LOADCODES.
     */
    public ByteCodeLoader(String file) throws IOException {
        this.byteSource = new BufferedReader(new FileReader(file));
    }
    /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab THE correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     */
    public Program loadCodes() {
        try {
            ArrayList<String> tokenList = new ArrayList<String>();
            PC = new Program();
            String var = " ";
            String currentLine = this.byteSource.readLine();
            while (currentLine != null) {
                this.tokenizer = new StringTokenizer( currentLine, DELIMITERS, true );
                tokenList.clear();
                Token = tokenizer.nextToken();
                Token = CodeTable.getClassName(Token);
                while (tokenizer.hasMoreTokens()) {
                    var = tokenizer.nextToken();
                    if (!var.equals(" ")) {
                        //System.out.println(var);
                        tokenList.add(var);
                    }
                }
                //System.out.println(var);
                currentLine = this.byteSource.readLine();
                Class c = Class.forName("interpreter.bytecode."+Token);
                Constructor ct = c.getDeclaredConstructors()[0];
                ByteCode byteCode = (ByteCode)ct.newInstance();
                byteCode.init(tokenList);
                PC.addByteCode(byteCode);
            }

        } catch (Exception ex) {
            Logger.getLogger(ByteCodeLoader.class.getName()).log(Level.SEVERE, null, ex);
        }

        PC.resolveAddrs(PC);
        return PC;
    }
}
