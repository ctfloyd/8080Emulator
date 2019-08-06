package machine.cpu.instructions;

import machine.cpu.Cpu8080;

public class ADI implements Instruction {

    public static final int CYCLES = 7;

    @Override
    public void operate(Cpu8080 state) {
        int registerData = ((short)state.getRegisterA().getData() &0xFFFF)+ (short)(state.readMemory(state.getPC()) & 0xFFFF);
        state.getRegisterA().setData((byte)registerData);
        state.setSZP(state.getRegisterA());
        state.setCarry((registerData & 0xFFFFFF00) > 0);
        // TODO: set aux carry
        state.setPC((short) (state.getPC() + 1));
    }

    //FFF7
    //FFF5
}
