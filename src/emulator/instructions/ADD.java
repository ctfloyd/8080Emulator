package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class ADD implements Instruction {

    private Register register;

    public ADD(Register register){
        this.register = register;
    }

    public ADD(){

    }

    @Override
    public void operate(Emulator state) {
        if(this.register == null)
        {
            state.getRegisterA().setData((byte)(state.getMemory()[state.getHL()] + state.getRegisterA().getData()));
        } else {
            state.getRegisterA().setData((byte) (state.getRegisterA().getData() + register.getData()));
        }

        state.setSZP(state.getRegisterA());
        state.setCarry(false);
        //TODO: Auxillary Carry
    }
}
