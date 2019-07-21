package emulator.instructions;

import emulator.Emulator;
import emulator.Register;

public class CPI implements Instruction {


    @Override
    public void operate(Emulator state) {
        state.printStatus();
        System.out.println("CPI called by: " + state.readMemory(state.getPC()));
        int result = (byte)(state.getRegisterA().getData() - state.readMemory(state.getPC()));
        state.setSZP(new Register((byte)result));
        if((state.getRegisterA().getData() & 0xFF) < state.readMemory(state.getPC())){
            state.setCarry(true);
        } else {
            state.setCarry(false);
        }
        state.printStatus();
        state.setPC((short)(state.getPC() + 1));
    }
}
