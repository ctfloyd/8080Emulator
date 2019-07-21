package emulator.instructions;

import emulator.Emulator;

public class LHLD implements Instruction{

    @Override
    public void operate(Emulator state) {
        int location = state.getHL();
        state.getRegisterL().setData(state.getMemory()[location]);
        state.getRegisterH().setData(state.getMemory()[location + 1]);
        state.setPC((short)(state.getPC() + 2));
    }

}
