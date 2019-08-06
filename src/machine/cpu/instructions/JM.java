package machine.cpu.instructions;

import machine.cpu.Cpu8080;

public class JM implements Instruction {

    public static final int CYCLES = 10;

    @Override
    public void operate(Cpu8080 state) {
        if(state.getSign()){
            new JMP().operate(state);
        } else {
            state.setPC((short)(state.getPC() + 2));
        }
    }
}
