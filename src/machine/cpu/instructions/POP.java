package machine.cpu.instructions;

import machine.cpu.Cpu8080;
import machine.cpu.Register;

public class POP implements Instruction {

    public static final int CYCLES = 10;

    private Register highRegister;
    private Register lowRegister;

    public POP(Register highRegister, Register lowRegister){
        this.highRegister = highRegister;
        this.lowRegister = lowRegister;
    }

    public POP(Register psw){
        this.highRegister = psw;
    }

    @Override
    public void operate(Cpu8080 state) {
        if(lowRegister == null) {
            byte conditionData = (byte)state.readMemory(state.getSP());
            state.setSign((conditionData & 0x80) != 0);
            state.setZero((conditionData & 0x40) != 0);
            // TODO: set aux carry 0x20
            state.setParity((conditionData & 0x04) != 0);
            state.setCarry((conditionData & 0x01) != 0);
            state.getRegisterA().setData((byte)state.readMemory(state.getSP() + 1));

        } else {
            highRegister.setData((byte)state.readMemory(state.getSP() + 1));
            lowRegister.setData((byte)state.readMemory(state.getSP()));
        }
        state.setSP((short)(state.getSP() + 2));
    }
}
