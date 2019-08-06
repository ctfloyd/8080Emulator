package machine.cpu.instructions;

import machine.cpu.Cpu8080;

public class STA implements Instruction{


    public static final int CYCLES = 13;

    @Override
    public void operate(Cpu8080 state) {
        short addr = (short)((state.readMemory(state.getPC() + 1) << 8) | (state.readMemory(state.getPC())));
        state.writeMemory(state.getRegisterA().getData(), addr);
        state.setPC((short)(state.getPC() + 2));
    }

}
