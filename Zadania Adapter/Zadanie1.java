import java.util.*;

interface PowerSocket {
    double getVoltage();
}

class Socket230V implements PowerSocket{
    private Random rand = new Random();

    public double getVoltage230V(){
        return 230 + rand.nextDouble() * 46 - 23;
    }
    
    public double getVoltage() {
        return getVoltage230V();
    }

}

class Socket110V implements PowerSocket{
    private Random rand = new Random();

    public double getVoltage110V(){
        return 110 + rand.nextDouble() * 22 - 11;
    }

    public double getVoltage() {
        return getVoltage110V();
    }

}

interface Charger{
    public double getVoltage();
}

class ChargerAdapter implements Charger{
    private PowerSocket socket;
    public ChargerAdapter(PowerSocket socket){
        this.socket = socket;
    }

    public double getVoltage(){
        return socket.getVoltage() / 46;
    }
}

public class Zadanie1{
    public static void main(String[] args){
        Socket230V socket230V = new Socket230V();
        System.out.println("Napięcie: " + socket230V.getVoltage230V());
        ChargerAdapter charger = new ChargerAdapter(socket230V);
        System.out.println("Napięcie z zasilacza: " + charger.getVoltage());

        Socket110V socket110V = new Socket110V();
        System.out.println("Napięcie 110V: " + socket110V.getVoltage110V());
        ChargerAdapter charger110V = new ChargerAdapter(socket110V);
        System.out.println("Napięcie z zasilacza 110V: " + charger110V.getVoltage());
    }
}
