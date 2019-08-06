package machine.cpu.instructions;

import machine.cpu.Cpu8080;

public class PCHL implements Instruction {

    public static final int CYCLES = 5;

    @Override
    public void operate(Cpu8080 state) {
        state.setPC((short)state.getHL());
    }
}
