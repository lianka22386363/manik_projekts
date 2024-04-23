import java.io.FileWriter;
import java.io.IOException;
public class Info {
    private FileWriter writer;
    private String name;
    private String data;
    private String time;
    private String type;
    private String length;
    private String broken;
    public Info(String name, String data, String time, String type, String length, String broken) {
        this.name = name;
        this.data = data;
        this.time = time;
        this.type = type;
        this.length = length;
        this.broken = broken;
    }
    public String printinfo() {
        return "\n" + "Klienta vārds: " + name + "\nProcedūras datums: " + data + "\nProcedūras laiks: " + time + "\nProcedūra veids: " + type + "\nNagu garums: " + length + "\nSalauztu nagu skaits: " + broken;
    }
}