package machine.cpu.instructions;

import machine.cpu.Cpu8080;

public class JMP implements Instruction {

    public static final int CYCLES = 10;

    @Override
    public void operate(Cpu8080 state) {
        state.setPC((short) (state.readMemory(state.getPC() + 1) << 8 | state.readMemory(state.getPC())));
    }
}
