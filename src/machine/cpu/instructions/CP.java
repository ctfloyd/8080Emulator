package machine.cpu.instructions;

import machine.cpu.Cpu8080;

public class CP implements Instruction {

    public static final int CYCLES = 17;

    @Override
    public void operate(Cpu8080 state) {
        if (!state.getSign()) {
            new CALL().operate(state);
        } else {
            state.setPC((short) (state.getPC() + 2));
        }
    }
}
