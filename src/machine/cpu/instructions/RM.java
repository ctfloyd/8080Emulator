package machine.cpu.instructions;

import machine.cpu.Cpu8080;

public class RM implements Instruction {

    public static final int CYCLES = 11;

    @Override
    public void operate(Cpu8080 state) {
        if(state.getSign())
            new RET().operate(state);
    }
}
