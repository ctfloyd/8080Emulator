package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class SHLD implements Instruction{


    @Override
    public void operate(Emulator state) {
        short location = (short)((state.readMemory(state.getPC() + 1) << 8) | (state.readMemory(state.getPC())));
        state.writeMemory(state.getRegisterL().getData(), location);
        state.writeMemory(state.getRegisterH().getData(), location + 1);
        state.setPC((short)(state.getPC() + 2));
    }

}
