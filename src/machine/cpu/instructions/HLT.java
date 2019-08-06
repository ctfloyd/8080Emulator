package machine.cpu.instructions;

import machine.cpu.Cpu8080;

public class HLT implements Instruction {

    public static final int CYCLES = 7;

    @Override
    public void operate(Cpu8080 state) {
        state.setStopped();
    }
}
