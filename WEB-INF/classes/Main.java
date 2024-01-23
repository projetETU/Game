import medicament.Medicament;

public class Main {
    public static void main(String[] args) throws Exception {
        Medicament m = new Medicament();
        m.setLoha(4);
        m.setCaca(4);
        m.setFatigue(4);
        m.setLelo(4);
        m.setTemperature(4);
        m.setKibo(0);
        m.setTenda(0);
        Medicament[] medicaments = m.medicament();
                for (Medicament me: medicaments ) {
                    System.out.println(me.getMedicament());
                }
    }
}
