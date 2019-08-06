package machine.cpu.instructions;

import machine.cpu.Cpu8080;

public class XCHG implements Instruction {

    public static final int CYCLES = 4;

    @Override
    public void operate(Cpu8080 state) {
        byte newh = state.getRegisterD().getData();
        byte newl = state.getRegisterE().getData();
        state.getRegisterD().setData(state.getRegisterH().getData());
        state.getRegisterE().setData(state.getRegisterL().getData());
        state.getRegisterH().setData(newh);
        state.getRegisterL().setData(newl);

    }
}
