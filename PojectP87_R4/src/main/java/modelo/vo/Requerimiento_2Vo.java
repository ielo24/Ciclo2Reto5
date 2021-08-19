package modelo.vo;

public class Requerimiento_2Vo {
    // Su código
    private Integer idpro;
    private String nommat;

    public Requerimiento_2Vo() {
    }

    public Integer getIdpro() {
        return idpro;
    }

    public void setIdpro(Integer idpro) {
        this.idpro = idpro;
    }

    public String getNommat() {
        return nommat;
    }

    public void setNommat(String nommat) {
        this.nommat = nommat;
    }

    @Override
    public String toString() {
        return idpro + " " + nommat;
    }

}
