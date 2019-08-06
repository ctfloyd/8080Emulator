package machine.cpu.instructions;

import machine.cpu.Cpu8080;

public class ANI implements Instruction {

    public static final int CYCLES = 7;
    @Override
    public void operate(Cpu8080 state) {
        state.getRegisterA().setData((byte)((state.getRegisterA().getData() & 0xFF) & state.readMemory(state.getPC())));
        state.setSZP(state.getRegisterA());
        state.setCarry(false);
        state.setPC((short)(state.getPC() + 1));
    }
}
