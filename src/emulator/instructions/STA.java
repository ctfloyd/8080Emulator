package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class STA implements Instruction{


    @Override
    public void operate(Emulator state) {
        state.writeMemory(state.getRegisterA().getData(), state.readMemory(state.getPC() + 1) << 8 | state.readMemory(state.getPC()) );
        state.setPC((short)(state.getPC() + 2));
    }

}
