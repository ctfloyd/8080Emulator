package machine.cpu.instructions;

import machine.cpu.Cpu8080;

public class JNZ implements Instruction {

    public static final int CYCLES = 10;

    @Override
    public void operate(Cpu8080 state) {
        if(!state.getZero()){
            new JMP().operate(state);
        } else {
            state.setPC((short)(state.getPC() + 2));
        }
    }
}
