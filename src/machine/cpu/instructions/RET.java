package machine.cpu.instructions;

import machine.cpu.Cpu8080;
import machine.cpu.Register;

public class RET implements Instruction {

    public static final int CYCLES = 10;

    @Override
    public void operate(Cpu8080 state) {
        Register registerHigh = new Register();
        Register registerLow = new Register();
        new POP(registerHigh, registerLow).operate(state);
        state.setPC((short)((registerHigh.getData() & 0xFF) << 8 | (registerLow.getData() & 0xFF) + 1));
    }
}
