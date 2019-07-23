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
        System.out.println("--------SBB---------");
        state.printStatus();
        byte carryByte = state.getCarry() ? (byte)1 : (byte)0;
        int registerData;
        if(this.register == null)
        {
            registerData = (state.getRegisterA().getData() & 0xFF) - state.readMemory(state.getHL()) - carryByte;
            System.out.println((state.getRegisterA().getData() & 0xFF) + " - " + state.readMemory(state.getHL()) + " - " + carryByte + " + "  + state.getRegisterB().getData());
        } else {
            registerData = (state.getRegisterA().getData() & 0xFF) - (register.getData() & 0xFF) - carryByte;
            System.out.println((state.getRegisterA().getData() & 0xFF) + " - " + (register.getData() & 0xFF) + " - " + carryByte +  " + "  + state.getRegisterB().getData());
        }
        state.getRegisterA().setData((byte)registerData);
        state.setSZP(state.getRegisterA());
        System.out.println(Integer.toBinaryString(registerData));
        state.setCarry((registerData & 0xFFFFFF00) == 0);
        state.printStatus();
        System.out.println("--------------------");
        //TODO: Auxillary Carry
    }
}
