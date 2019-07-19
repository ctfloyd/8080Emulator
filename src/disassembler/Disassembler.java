package disassembler;

import java.io.*;

public class Disassembler {


    private static String bytesToHex(byte[] hashInBytes) {

        StringBuilder sb = new StringBuilder();
        for (byte b : hashInBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();

    }

    public static void dissassembleToFile(String src, String dest){
        try {
            InputStream in = new FileInputStream(src);

            double fileSize = new File(src).length();
            byte[] inBytes = new byte[(int) fileSize];

            in.read(inBytes);

            String stringB = bytesToHex(inBytes);

            int pointer = 0;
            int end = stringB.length();
            int instructionCount = 0;
            while(pointer < end){
                pointer += parseHexToAsm(stringB, pointer, dest);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int parseHexToAsm(String buffer, int pointer, String outFile) throws IOException {
        String instruction = "" + buffer.charAt(pointer) + buffer.charAt(pointer+1);

        String nextByte = "";
        String afterByte = "";
        String twoBytes = "";
        if(pointer + 4 < buffer.length()) {
            nextByte = buffer.substring(pointer + 2, pointer + 4);
        }
        if(pointer + 6 < buffer.length()){
            afterByte = buffer.substring(pointer + 4, pointer + 6);
            twoBytes = afterByte + nextByte;
        }

        int advance = 1;

        String ret;
        switch(instruction){
            case "00": ret = "NOP"; break;
            case "01": ret = "LXI B,#$" + twoBytes; advance = 3; break;
            case "02": ret = "STAX B"; break;
            case "03": ret = "INX B"; break;
            case "04": ret = "INR B"; break;
            case "05": ret = "DCR B"; break;
            case "06": ret = "MVI B,#$" + nextByte; advance = 2; break;
            case "07": ret = "RLC"; break;
            case "08": ret = "NOP"; break;
            case "09": ret = "DAD B"; break;
            case "0a": ret = "LDAX B"; break;
            case "0b": ret = "DCX B"; break;
            case "0c": ret = "INR C"; break;
            case "0d": ret = "DCR C"; break;
            case "0e": ret = "MVI C,#$" + nextByte; advance = 2; break;
            case "0f": ret = "RRC"; break;

            case "10": ret = "NOP"; break;
            case "11": ret = "LXI D,#$" + twoBytes; advance = 3; break;
            case "12": ret = "STAX D"; break;
            case "13": ret = "INX D"; break;
            case "14": ret = "INR D"; break;
            case "15": ret = "DCR D"; break;
            case "16": ret = "MVI D,#$" + nextByte; advance = 2; break;
            case "17": ret = "RAL"; break;
            case "18": ret = "NOP"; break;
            case "19": ret = "DAD D"; break;
            case "1a": ret = "LDAX D"; break;
            case "1b": ret = "DCX D"; break;
            case "1c": ret = "INR E"; break;
            case "1d": ret = "DCR E"; break;
            case "1e": ret = "MVI E,#$" + nextByte; advance = 2; break;
            case "1f": ret = "RAR"; break;


            case "20": ret = "NOP"; break;
            case "21": ret = "LXI H,#$" + twoBytes; advance = 3; break;
            case "22": ret = "SHLD $" + twoBytes; advance = 3; break;
            case "23": ret = "INX H"; break;
            case "24": ret = "INR H"; break;
            case "25": ret = "DCR H"; break;
            case "26": ret = "MVI H,#$" + nextByte; advance = 2; break;
            case "27": ret = "DAA"; break;
            case "28": ret = "NOP"; break;
            case "29": ret = "DAD H"; break;
            case "2a": ret = "LHLD $" + twoBytes; advance = 3; break;
            case "2b": ret = "DCX H"; break;
            case "2c": ret = "INR L"; break;
            case "2d": ret = "DCR L"; break;
            case "2e": ret = "MVI L,#$" + nextByte; advance = 2; break;
            case "2f": ret = "CMA"; break;

            case "30": ret = "NOP"; break;
            case "31": ret = "LXI SP,#$" + twoBytes; advance = 3; break;
            case "32": ret = "STA $" + twoBytes; advance = 3; break;
            case "33": ret = "INX SP"; break;
            case "34": ret = "INR M"; break;
            case "35": ret = "DCR M"; break;
            case "36": ret = "MVI M,#$" + nextByte; advance = 2; break;
            case "37": ret = "STC"; break;
            case "38": ret = "NOP"; break;
            case "39": ret = "DAD SP"; break;
            case "3a": ret = "LDA $" + twoBytes; advance = 3; break;
            case "3b": ret = "DCX SP"; break;
            case "3c": ret = "INR A"; break;
            case "3d": ret = "DCR A"; break;
            case "3e": ret = "MVI A,#$" + nextByte; advance = 2; break;
            case "3f": ret = "CMC"; break;

            case "40": ret = "MOV B,B"; break;
            case "41": ret = "MOV B,C"; break;
            case "42": ret = "MOV B,D"; break;
            case "43": ret = "MOV B,E"; break;
            case "44": ret = "MOV B,H"; break;
            case "45": ret = "MOV B,L"; break;
            case "46": ret = "MOV B,M"; break;
            case "47": ret = "MOV B,A"; break;
            case "48": ret = "MOV C,B"; break;
            case "49": ret = "MOV C,C"; break;
            case "4a": ret = "MOV C,D"; break;
            case "4b": ret = "MOV C,E"; break;
            case "4c": ret = "MOV C,H"; break;
            case "4d": ret = "MOV C,L"; break;
            case "4e": ret = "MOV C,M"; break;
            case "4f": ret = "MOV C,A"; break;

            case "50": ret = "MOV D,B"; break;
            case "51": ret = "MOV D,C"; break;
            case "52": ret = "MOV D,D"; break;
            case "53": ret = "MOV D,E"; break;
            case "54": ret = "MOV D,H"; break;
            case "55": ret = "MOV D,L"; break;
            case "56": ret = "MOV D,M"; break;
            case "57": ret = "MOV D,A"; break;
            case "58": ret = "MOV E,B"; break;
            case "59": ret = "MOV E,C"; break;
            case "5a": ret = "MOV E,D"; break;
            case "5b": ret = "MOV E,E"; break;
            case "5c": ret = "MOV E,H"; break;
            case "5d": ret = "MOV E,L"; break;
            case "5e": ret = "MOV E,M"; break;
            case "5f": ret = "MOV E,A"; break;

            case "60": ret = "MOV H,B"; break;
            case "61": ret = "MOV H,C"; break;
            case "62": ret = "MOV H,D"; break;
            case "63": ret = "MOV H,E"; break;
            case "64": ret = "MOV H,H"; break;
            case "65": ret = "MOV H,L"; break;
            case "66": ret = "MOV H,M"; break;
            case "67": ret = "MOV H,A"; break;
            case "68": ret = "MOV L,B"; break;
            case "69": ret = "MOV L,C"; break;
            case "6a": ret = "MOV L,D"; break;
            case "6b": ret = "MOV L,E"; break;
            case "6c": ret = "MOV L,H"; break;
            case "6d": ret = "MOV L,L"; break;
            case "6e": ret = "MOV L,M"; break;
            case "6f": ret = "MOV L,A"; break;

            case "70": ret = "MOV M,B"; break;
            case "71": ret = "MOV M,C"; break;
            case "72": ret = "MOV M,D"; break;
            case "73": ret = "MOV M,E"; break;
            case "74": ret = "MOV M,H"; break;
            case "75": ret = "MOV M,L"; break;
            case "76": ret = "HLT"; break;
            case "77": ret = "MOV M,A"; break;
            case "78": ret = "MOV A,B"; break;
            case "79": ret = "MOV A,C"; break;
            case "7a": ret = "MOV A,D"; break;
            case "7b": ret = "MOV A,E"; break;
            case "7c": ret = "MOV A,H"; break;
            case "7d": ret = "MOV A,L"; break;
            case "7e": ret = "MOV A,M"; break;
            case "7f": ret = "MOV A,A"; break;

            case "80": ret = "ADD B"; break;
            case "81": ret = "ADD C"; break;
            case "82": ret = "ADD D"; break;
            case "83": ret = "ADD E"; break;
            case "84": ret = "ADD H"; break;
            case "85": ret = "ADD L"; break;
            case "86": ret = "ADD M"; break;
            case "87": ret = "ADD A"; break;
            case "88": ret = "ADC B"; break;
            case "89": ret = "ADC C"; break;
            case "8a": ret = "ADC D"; break;
            case "8b": ret = "ADC E"; break;
            case "8c": ret = "ADC H"; break;
            case "8d": ret = "ADC L"; break;
            case "8e": ret = "ADC M"; break;
            case "8f": ret = "ADC A"; break;

            case "90": ret = "SUB B"; break;
            case "91": ret = "SUB C"; break;
            case "92": ret = "SUB D"; break;
            case "93": ret = "SUB E"; break;
            case "94": ret = "SUB H"; break;
            case "95": ret = "SUB L"; break;
            case "96": ret = "SUB M"; break;
            case "97": ret = "SUB A"; break;
            case "98": ret = "SBB B"; break;
            case "99": ret = "SBB C"; break;
            case "9a": ret = "SBB D"; break;
            case "9b": ret = "SBB E"; break;
            case "9c": ret = "SBB H"; break;
            case "9d": ret = "SBB L"; break;
            case "9e": ret = "SBB M"; break;
            case "9f": ret = "SBB A"; break;

            case "a0": ret = "ANA B"; break;
            case "a1": ret = "ANA C"; break;
            case "a2": ret = "ANA D"; break;
            case "a3": ret = "ANA E"; break;
            case "a4": ret = "ANA H"; break;
            case "a5": ret = "ANA L"; break;
            case "a6": ret = "ANA M"; break;
            case "a7": ret = "ANA A"; break;
            case "a8": ret = "XRA B"; break;
            case "a9": ret = "XRA C"; break;
            case "aa": ret = "XRA D"; break;
            case "ab": ret = "XRA E"; break;
            case "ac": ret = "XRA H"; break;
            case "ad": ret = "XRA L"; break;
            case "ae": ret = "XRA M"; break;
            case "af": ret = "XRA A"; break;

            case "b0": ret = "ORA B"; break;
            case "b1": ret = "ORA C"; break;
            case "b2": ret = "ORA D"; break;
            case "b3": ret = "ORA E"; break;
            case "b4": ret = "ORA H"; break;
            case "b5": ret = "ORA L"; break;
            case "b6": ret = "ORA M"; break;
            case "b7": ret = "ORA A"; break;
            case "b8": ret = "CMP B"; break;
            case "b9": ret = "CMP C"; break;
            case "ba": ret = "CMP D"; break;
            case "bb": ret = "CMP E"; break;
            case "bc": ret = "CMP H"; break;
            case "bd": ret = "CMP L"; break;
            case "be": ret = "CMP M"; break;
            case "bf": ret = "CMP A"; break;

            case "c0": ret = "RNZ"; break;
            case "c1": ret = "POP B"; break;
            case "c2": ret = "JNZ $" + twoBytes; advance = 3; break;
            case "c3": ret = "JMP $" + twoBytes; advance = 3; break;
            case "c4": ret = "CNZ $" + twoBytes; advance = 3; break;
            case "c5": ret = "PUSH B"; break;
            case "c6": ret = "ADI #$" + nextByte; advance = 2; break;
            case "c7": ret = "RST 0"; break;
            case "c8": ret = "RZ"; break;
            case "c9": ret = "RET"; break;
            case "ca": ret = "JZ $" + twoBytes; advance = 3; break;
            case "cb": ret = "JMP $" + twoBytes; advance = 3; break;
            case "cc": ret = "CZ $" + twoBytes; advance = 3; break;
            case "cd": ret = "CALL $" + twoBytes; advance = 3; break;
            case "ce": ret = "ACI #$" + nextByte; advance = 2; break;
            case "cf": ret = "RST 1"; break;

            case "d0": ret = "RNC"; break;
            case "d1": ret = "POP D"; break;
            case "d2": ret = "JNC $" + twoBytes; advance = 3; break;
            case "d3": ret = "OUT #$" + nextByte; advance = 2; break;
            case "d4": ret = "CNC $" + twoBytes; advance = 3; break;
            case "d5": ret = "PUSH D"; break;
            case "d6": ret = "SUI #$" + nextByte; advance = 2; break;
            case "d7": ret = "RST 2"; break;
            case "d8": ret = "RC"; break;
            case "d9": ret = "RET"; break;
            case "da": ret = "JC $" + twoBytes; advance = 3; break;
            case "db": ret = "IN $#" + nextByte; advance = 2; break;
            case "dc": ret = "CC $" + twoBytes; advance = 3; break;
            case "dd": ret = "CALL $" + twoBytes; advance = 3; break;
            case "de": ret = "SBI #$" + nextByte; advance = 2; break;
            case "df": ret = "RST 3"; break;

            case "e0": ret = "RPO"; break;
            case "e1": ret = "POP H"; break;
            case "e2": ret = "JPO $" + twoBytes; advance = 3; break;
            case "e3": ret = "XHTL"; break;
            case "e4": ret = "CPO $" + twoBytes; advance = 3; break;
            case "e5": ret = "PUSH H"; break;
            case "e6": ret = "ANI #$" + nextByte; advance = 2; break;
            case "e7": ret = "RST 4"; break;
            case "e8": ret = "RPE"; break;
            case "e9": ret = "PCHL"; break;
            case "ea": ret = "JPE" + twoBytes; advance = 3; break;
            case "eb": ret = "XCHG"; break;
            case "ec": ret = "CPE $" + twoBytes; advance = 3; break;
            case "ed": ret = "CALL $" + twoBytes; advance = 3; break;
            case "ee": ret = "XRI #$" + nextByte; advance = 2; break;
            case "ef": ret = "RST 5"; break;

            case "f0": ret = "RP"; break;
            case "f1": ret = "POP PSW"; break;
            case "f2": ret = "JP $" + twoBytes; advance = 3; break;
            case "f3": ret = "DI"; break;
            case "f4": ret = "CP $" + twoBytes; advance = 3; break;
            case "f5": ret = "PUSH PSW"; break;
            case "f6": ret = "ORI #$" + nextByte; advance = 2; break;
            case "f7": ret = "RST 6"; break;
            case "f8": ret = "RM"; break;
            case "f9": ret = "SPHL"; break;
            case "fa": ret = "JM $" + twoBytes; advance = 3; break;
            case "fb": ret = "EI"; break;
            case "fc": ret = "CM $" + twoBytes; advance = 3; break;
            case "fd": ret = "CALL $" + twoBytes; advance = 3; break;
            case "fe": ret = "CPI #$" + nextByte; advance = 2; break;
            case "ff": ret = "RST 7"; break;

            default:
                ret = "Undefined instruction: " + instruction;
        }

        String[] format = ret.split(" ");
        FileWriter f = new FileWriter(outFile, true);
        PrintWriter fOut = new PrintWriter(f);
        if(format.length > 1)
            fOut.println(String.format("%-4s     %-8s", format[0], format[1]));
        else
            fOut.println(ret);
        fOut.close();
        return advance * 2;
    }
}