package machine.cpu;

public class Register {

    private byte data;

    public Register(byte b){
        data = b;
    }

    public Register(){
        data = 0;
    }

    public byte getData() {
        return this.data;
    }

    public void setData(byte data){
        this.data = data;
    }
}
