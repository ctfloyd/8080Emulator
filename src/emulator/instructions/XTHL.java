package emulator.instructions;

import emulator.Emulator;

public class XTHL implements Instruction {

    @Override
    public void operate(Emulator state) {
        byte oldL = state.getRegisterL().getData();
        byte oldH = state.getRegisterH().getData();

        byte newl = (byte)state.readMemory(state.getSP());
        byte newh = (byte)state.readMemory(state.getSP() + 1);

        state.writeMemory(oldL, state.getSP());
        state.writeMemory(oldH, state.getSP() + 1);

        state.getRegisterL().setData(newl);
        state.getRegisterH().setData(newh);
    }
}
