package emulator.instructions;

import emulator.Emulator;

public interface Instruction {
    void operate(Emulator state);
}
