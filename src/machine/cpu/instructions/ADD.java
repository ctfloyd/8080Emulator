package machine.cpu.instructions;

import machine.cpu.Cpu8080;
import machine.cpu.Register;

public class ADD implements Instruction {

    public static final int CYCLES = 4; // TODO: memory takes 7 cycles
    private Register register;

    public ADD(Register register){
        this.register = register;
    }

    public ADD(){

    }

    @Override
    public void operate(Cpu8080 state) {
        int registerData;
        if(this.register == null)
        {
            registerData = (state.readMemory(state.getHL()) + (state.getRegisterA().getData() & 0xFF));
        } else {
            registerData = (state.getRegisterA().getData() & 0xFF) + (register.getData() & 0xFF);
        }
        state.getRegisterA().setData((byte)registerData);
        state.setSZP(state.getRegisterA());
        state.setCarry((registerData & 0xFFFFFF00) != 0);
        //TODO: Auxillary Carry
    }
}
