package machine.cpu.instructions;

import machine.cpu.Cpu8080;
import machine.cpu.Register;

public class SUB implements Instruction {

    public static final int CYCLES = 4; // TODO: memory takes 7 cycles
    private Register register;

    public SUB(Register register){
        this.register = register;
    }

    public SUB(){

    }

    @Override
    public void operate(Cpu8080 state) {
        int registerData;
        if(this.register == null)
        {
            registerData = (state.readMemory(state.getHL()) & 0xFF) - (state.getRegisterA().getData() & 0xFF);
        } else {
            registerData = (state.getRegisterA().getData() & 0xFF) - (register.getData()  & 0xFF);
        }

        state.getRegisterA().setData((byte)registerData);
        state.setSZP(state.getRegisterA());
        state.setCarry((registerData & 0xFFFFFF00) == 0);
        //TODO: Auxillary Carry
    }
}
