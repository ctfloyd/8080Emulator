package emulator.instructions;

import emulator.Emulator;

public class XCHG implements Instruction {

    @Override
    public void operate(Emulator state) {
        byte newh = state.getRegisterD().getData();
        byte newl = state.getRegisterE().getData();
        state.getRegisterD().setData(state.getRegisterH().getData());
        state.getRegisterE().setData(state.getRegisterL().getData());
        state.getRegisterH().setData(newh);
        state.getRegisterL().setData(newl);

    }
}
