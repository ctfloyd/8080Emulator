package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class SBB implements Instruction {

    private Register register;

    public SBB(Register register){
        this.register = register;
    }

    public SBB(){

    }

    @Override
    public void operate(Emulator state) {
        byte carryByte = state.getCarry() ? (byte)1 : (byte)0;
        if(this.register == null)
        {
            state.getRegisterA().setData((byte)((state.getMemory()[state.getHL()] + carryByte) - state.getRegisterA().getData()));
        } else {
            state.getRegisterA().setData((byte) (state.getRegisterA().getData() - (register.getData() + carryByte)));
        }

        state.setSZP(state.getRegisterA());
        state.setCarry(false);
        //TODO: Auxillary Carry
    }
}
