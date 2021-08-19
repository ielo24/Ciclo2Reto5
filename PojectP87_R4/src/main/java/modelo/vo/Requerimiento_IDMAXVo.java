package modelo.vo;

public class Requerimiento_IDMAXVo {
    private Integer maxID;

    public Requerimiento_IDMAXVo() {
    }

    public Integer getMaxID() {
        return maxID;
    }

    public void setMaxID(Integer maxID) {
        this.maxID = maxID;
    }

    @Override
    public String toString() {
        return maxID + "";
    }

}
