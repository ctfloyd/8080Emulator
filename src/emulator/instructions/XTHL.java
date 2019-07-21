package emulator.instructions;

import emulator.Emulator;

public class XTHL implements Instruction {

    @Override
    public void operate(Emulator state) {
        short hl = (short)state.getHL();
        byte newh = state.getMemory()[state.getSP()];
        byte newl = state.getMemory()[state.getSP() + 1];

        state.writeMemory((byte)(hl >> 8), state.getSP());
        state.writeMemory((byte)hl, state.getSP());

        state.getRegisterH().setData(newh);
        state.getRegisterL().setData(newl);
    }
}
