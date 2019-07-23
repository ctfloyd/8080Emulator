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
        int registerData;
        if(this.register == null)
        {
            registerData = (state.readMemory(state.getHL()) & 0xFF) - (state.getRegisterA().getData() & 0xFF);
        } else {
            registerData = (state.getRegisterA().getData() & 0xFF) - (register.getData()  & 0xFF);
        }

        state.getRegisterA().setData((byte)registerData);
        state.setSZP(state.getRegisterA());
        System.out.println(Integer.toBinaryString(registerData));
        state.setCarry((registerData & 0xFFFFFF00) == 0);
        state.printStatus();
        //TODO: Auxillary Carry
    }
}
