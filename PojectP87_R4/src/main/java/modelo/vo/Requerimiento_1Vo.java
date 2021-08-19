package modelo.vo;

public class Requerimiento_1Vo {
    // Su código
    private Integer idlider;
    private String nombre;
    private String priapellido;
    private Integer salario;

    public Integer getIdlider() {
        return idlider;
    }

    public void setIdlider(Integer idlider) {
        this.idlider = idlider;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPriapellido() {
        return priapellido;
    }

    public void setPriapellido(String priapellido) {
        this.priapellido = priapellido;
    }

    public Integer getSalario() {
        return salario;
    }

    public void setSalario(Integer salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return idlider + " " + nombre + " " + priapellido + " " + salario;
    }

}
