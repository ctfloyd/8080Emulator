package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class SUB implements Instruction {

    private Register register;

    public SUB(Register register){
        this.register = register;
    }

    public SUB(){

    }

    @Override
    public void operate(Emulator state) {
        if(this.register == null)
        {
            state.getRegisterA().setData((byte)(state.getMemory()[state.getHL()] - state.getRegisterA().getData()));
        } else {
            state.getRegisterA().setData((byte) (state.getRegisterA().getData() - register.getData()));
        }

        state.setSZP(state.getRegisterA());
        state.setCarry(false);
        //TODO: Auxillary Carry
    }
}
