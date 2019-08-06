package machine.cpu.instructions;

import machine.cpu.Cpu8080;
import machine.cpu.Register;

public class ANA implements Instruction {

    public static final int CYCLES = 4;
    private Register register;

    public ANA(Register register){
        this.register = register;
    }

    public ANA(){

    }

    @Override
    public void operate(Cpu8080 state) {
        if(this.register == null)
        {
            state.getRegisterA().setData((byte)(state.getRegisterA().getData() & state.readMemory(state.getHL())));
        } else {
            state.getRegisterA().setData((byte)(state.getRegisterA().getData() & register.getData()));

        }
        state.setSZP(state.getRegisterA());
        state.setCarry(false);
    }
}
