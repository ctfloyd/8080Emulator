package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class ADC implements Instruction {

    private Register register;

    public ADC(Register register){
        this.register = register;
    }

    public ADC(){

    }

    @Override
    public void operate(Emulator state) {
        byte carryByte = state.getCarry() ? (byte)1 : (byte)0;
        if(this.register == null)
        {
            state.getRegisterA().setData((byte)(state.readMemory(state.getHL()) + state.getRegisterA().getData() + carryByte));
            state.setPC((short)(state.getPC() + 1));
        } else {
            state.getRegisterA().setData((byte) ((state.getRegisterA().getData() & 0xFF) + (register.getData() & 0xFF) + carryByte));
        }

        state.setSZP(state.getRegisterA());
        state.setCarry(false);
        //TODO: Auxillary Carry
    }
}
