package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class SHLD implements Instruction{


    @Override
    public void operate(Emulator state) {
        byte[] mem = state.getMemory();
        int pc = state.getPC();
        int location = mem[pc + 1] << 8 | mem[pc];
        state.writeMemory(state.getRegisterH().getData(), location);
        state.writeMemory(state.getRegisterL().getData(), location + 1);
    }

}
