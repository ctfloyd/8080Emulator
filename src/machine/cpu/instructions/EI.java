package machine.cpu.instructions;

import machine.cpu.Cpu8080;

public class EI implements Instruction {

    public static final int CYCLES = 4;
    @Override
    public void operate(Cpu8080 state) {
        state.setInterrupt(true);
    }
}
