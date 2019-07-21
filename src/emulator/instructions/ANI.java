package emulator.instructions;

import emulator.Emulator;

public class ANI implements Instruction {

    @Override
    public void operate(Emulator state) {
        System.out.println("ANI called by: " + state.readMemory(state.getPC()));
        state.getRegisterA().setData((byte)((state.getRegisterA().getData() & 0xFF) & state.readMemory(state.getPC())));
        state.setSZP(state.getRegisterA());
        state.setCarry(false);
        state.setPC((short)(state.getPC() + 1));
        state.printStatus();
    }
}
