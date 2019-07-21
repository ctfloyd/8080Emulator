package emulator.instructions;

import emulator.Emulator;

public class XCHG implements Instruction {

    @Override
    public void operate(Emulator state) {
        short hl = (short)state.getHL();

        byte newh = state.getRegisterD().getData();
        byte newl = state.getRegisterE().getData();

        state.getRegisterH().setData(newh);
        state.getRegisterL().setData(newl);
        state.getRegisterD().setData((byte)(hl >> 8));
        state.getRegisterE().setData((byte)hl);
    }
}
