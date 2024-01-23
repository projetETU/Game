package medicament;

import java.sql.ResultSet;
import java.util.Vector;

import databases.DatabaseUtil;

public class Medicament {
    String medicament;
    int loha;
    int lelo ;
    int tenda;
    int kibo;
    int caca;
    int fatigue;
    int temperature;
    Double prix;
    public Medicament(){}
    
    public Medicament(String medicament, int loha, int lelo, int tenda, int kibo, int caca, int fatigue,  int temperature, Double prix) {
        this.setMedicament(medicament);
        this.setLoha(loha);
        this.setLelo(lelo);
        this.setTenda(tenda);
        this.setKibo(kibo);
        this.setCaca(caca);
        this.setFatigue(fatigue);
        this.setTemperature(temperature);
        this.setPrix(prix);
    }

    public String getMedicament() {
        return medicament;
    }
    public Medicament[] medicament() throws Exception {
        Vector<Medicament> medicaments = new Vector<>();
        medicamentRecursive(getLoha(), getLelo(), getTenda(), getKibo(), getCaca(), getFatigue(), getTemperature(), medicaments);
        Medicament[] medicaments2 = new Medicament[medicaments.size()];
        medicaments.copyInto(medicaments2);
        return medicaments2;
    }
    
    private void medicamentRecursive(int loha, int lelo, int tenda, int kibo, int caca, int fatigue, int temperature, Vector<Medicament> medicaments) throws Exception {
        DatabaseUtil data = new DatabaseUtil();
        ResultSet rs = data.getMedicament(loha, lelo, tenda, kibo, caca, fatigue, temperature);
    
        while (rs.next()) {
            Medicament currentMedicament = new Medicament(rs.getString(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8), rs.getDouble(9));
    
            if (currentMedicament.getLelo() <= 0 || currentMedicament.getTenda() <= 0
                || currentMedicament.getKibo() <= 0 || currentMedicament.getCaca() <= 0
                || currentMedicament.getFatigue() <= 0 || currentMedicament.getTemperature() <= 0 || currentMedicament.getLoha() <= 0) {
    
                medicaments.add(currentMedicament);
    
                if (currentMedicament.getLelo() <= 0 && currentMedicament.getTenda() <= 0
                    && currentMedicament.getKibo() <= 0 && currentMedicament.getCaca() <= 0
                    && currentMedicament.getFatigue() <= 0 && currentMedicament.getTemperature() <= 0 && currentMedicament.getLoha() <= 0) {
                    break;
                } else {
                    medicamentRecursive(currentMedicament.getLoha(), currentMedicament.getLelo(), currentMedicament.getTenda(),
                                        currentMedicament.getKibo(), currentMedicament.getCaca(), currentMedicament.getFatigue(),
                                        currentMedicament.getTemperature(), medicaments);
                }
            }
        }
    }
            public int getLoha() {
        return loha;
    }
    public void setLoha(int loha) {
        this.loha = loha;
    }
    public int getLelo() {
        return lelo;
    }
    public void setLelo(int lelo) {
        this.lelo = lelo;
    }
    public int getTenda() {
        return tenda;
    }
    public void setTenda(int tenda) {
        this.tenda = tenda;
    }
    public int getKibo() {
        return kibo;
    }
    public void setKibo(int kibo) {
        this.kibo = kibo;
    }
    public int getCaca() {
        return caca;
    }
    public void setCaca(int caca) {
        this.caca = caca;
    }
    public int getFatigue() {
        return fatigue;
    }
    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }
    public int getTemperature() {
        return temperature;
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    public Double getPrix() {
        return prix;
    }
    public void setMedicament(String medicament) {
        this.medicament = medicament;
    }
    public void setPrix(Double prix) {
        this.prix = prix;
    }
    
}
