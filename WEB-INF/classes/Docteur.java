package docteur;

import java.sql.ResultSet;

import databases.DatabaseUtil;

public class Docteur {
    String maladie;
    int loha;
    int lelo ;
    int tenda;
    int kibo;
    int caca;
    int fatigue;
    int temperature;

    public String getMaladie() {
        return maladie;
    }
    public void setMaladie() throws Exception{
        DatabaseUtil data = new DatabaseUtil();
        if (getLoha() == 0 && getLelo() == 0 && getTenda() == 0 && getKibo() == 0 && getCaca() == 0 &&
        getFatigue() == 0 && getTemperature() == 0) {
        this.maladie = "TSY MARARY";  
        }else{    
        ResultSet datas = data.getMaladie(getLoha(),getLelo(),getTenda(),getKibo(),getCaca(),getFatigue(),getTemperature());
        while(datas.next())
        this.maladie = datas.getString(1);
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
    public int getTemperature() {
        return temperature;
    }
    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
    public int getFatigue() {
        return fatigue;
    }
    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }
}