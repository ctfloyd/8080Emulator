package machine.cpu.instructions;

import machine.cpu.Cpu8080;

public class XTHL implements Instruction {

    public static final int CYCLES = 18;

    @Override
    public void operate(Cpu8080 state) {
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
