package machine.cpu.instructions;

import machine.cpu.Cpu8080;

public class CMA implements Instruction {

    public static final int CYCLES = 4;

    @Override
    public void operate(Cpu8080 state) {
        state.getRegisterA().setData((byte)~state.getRegisterA().getData());
    }
}
