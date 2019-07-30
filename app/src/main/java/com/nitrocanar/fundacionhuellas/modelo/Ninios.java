package com.nitrocanar.fundacionhuellas.modelo;

public class Ninios {
    private int ninId;
    private String ninNombre;
    private String ninApellido;
    private String ninEdad;
    private byte[] ninFoto;

    public Ninios() {
    }

    public Ninios(int ninId, String ninNombre, String ninApellido, String ninEdad, byte[] ninFoto) {
        this.ninId = ninId;
        this.ninNombre = ninNombre;
        this.ninApellido = ninApellido;
        this.ninEdad = ninEdad;
        this.ninFoto = ninFoto;
    }

    public int getNinId() {
        return ninId;
    }

    public void setNinId(int ninId) {
        this.ninId = ninId;
    }

    public String getNinNombre() {
        return ninNombre;
    }

    public void setNinNombre(String ninNombre) {
        this.ninNombre = ninNombre;
    }

    public String getNinApellido() {
        return ninApellido;
    }

    public void setNinApellido(String ninApellido) {
        this.ninApellido = ninApellido;
    }

    public String getNinEdad() {
        return ninEdad;
    }

    public void setNinEdad(String ninEdad) {
        this.ninEdad = ninEdad;
    }

    public byte[] getNinFoto() {
        return ninFoto;
    }

    public void setNinFoto(byte[] ninFoto) {
        this.ninFoto = ninFoto;
    }
}
