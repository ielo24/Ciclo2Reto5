package modelo.vo;

public class Requerimiento_3Vo {
    // Su código
    private Integer idpro;
    private String ciudadpro;
    private String nomlider;

    public Requerimiento_3Vo() {
    }

    public Integer getIdpro() {
        return idpro;
    }

    public void setIdpro(Integer idpro) {
        this.idpro = idpro;
    }

    public String getCiudadpro() {
        return ciudadpro;
    }

    public void setCiudadpro(String ciudadpro) {
        this.ciudadpro = ciudadpro;
    }

    public String getNomlider() {
        return nomlider;
    }

    public void setNomlider(String nomlider) {
        this.nomlider = nomlider;
    }

    @Override
    public String toString() {
        return idpro + " " + ciudadpro + " " + nomlider;
    }

}
