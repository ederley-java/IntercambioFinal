package model;

public class Bolsa {

    private String nomePrograma;
    private String nomeBolsa;
    private String pais;
    private String parceiro;
    private String dataFinalInscr;

    public Bolsa(String nomePrograma, String nomeBolsa, String pais, String parceiro, String dataFinalInscr) {
        this.nomePrograma = nomePrograma;
        this.nomeBolsa = nomeBolsa;
        this.pais = pais;
        this.parceiro = parceiro;
        this.dataFinalInscr = dataFinalInscr;
    }

    public Bolsa() {

    }

    @Override
    public String toString() {
        return "Bolsa [nomePrograma=" + nomePrograma + ", nomeBolsa=" + nomeBolsa + ", pais=" + pais
                + ", parceiro=" + parceiro + ", dataFinalInscr=" + dataFinalInscr + "]";
    }


    public String getNomePrograma() {
        return nomePrograma;
    }

    public void setNomePrograma(String nomePrograma) {
        this.nomePrograma = nomePrograma;
    }

    public String getNomeBolsa() {
        return nomeBolsa;
    }

    public void setNomeBolsa(String nomeBolsa) {
        this.nomeBolsa = nomeBolsa;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getParceiro() {
        return parceiro;
    }

    public void setParceiro(String parceiro) {
        this.parceiro = parceiro;
    }

    public String getDataFinalInscr() {
        return dataFinalInscr;
    }

    public void setDataFinalInscr(String dataFinalInscr) {
        this.dataFinalInscr = dataFinalInscr;
    }

}
