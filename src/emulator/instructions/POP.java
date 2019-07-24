package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class POP implements Instruction {

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
    public void operate(Emulator state) {
        if(lowRegister == null) {
            byte conditionData = (byte)state.readMemory(state.getSP());
            state.setSign((conditionData & 0x80) != 0);
            state.setZero((conditionData & 0x40) != 0);
            // TODO: set aux carry 0x20
            state.setParity((conditionData & 0x04) != 0);
            state.setCarry((conditionData & 0x01) != 0);
            state.getRegisterA().setData((byte)state.readMemory(state.getSP() + 1));
            state.printStatus();

        } else {
            highRegister.setData((byte)state.readMemory(state.getSP() + 1));
            lowRegister.setData((byte)state.readMemory(state.getSP()));
        }
        state.setSP((short)(state.getSP() + 2));
    }
}
