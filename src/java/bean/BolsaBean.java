package bean;

import dao.BolsaDAO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import model.Bolsa;

public class BolsaBean implements Serializable {

    private static final long serialVersionUID = 455659950717243338L;
    private Bolsa bolsa = new Bolsa();
    private BolsaDAO bolsaDAO = new BolsaDAO();
    private List<Bolsa> bolsas = new ArrayList<Bolsa>();

    public BolsaBean() {
        bolsas = bolsaDAO.readAll();
    }

    public void limpar() {
        bolsa = new Bolsa();
    }

    public Bolsa getBolsa() {
        return bolsa;
    }

    public void setBolsa(Bolsa bolsa) {
        this.bolsa = bolsa;
    }

    public List<Bolsa> getBolsas() {
        return bolsas;
    }

    public void setBolsas(List<Bolsa> bolsas) {
        this.bolsas = bolsas;
    }

    public Bolsa getNullBolsa() {
        return new Bolsa();
    }

}
