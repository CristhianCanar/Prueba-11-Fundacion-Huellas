package com.nitrocanar.fundacionhuellas.modelo;

public class Donante {
    private int donId;
    private String donNombre;
    private String donApellido;
    private String donEmail;
    private String donTelefono;
    private String donContrasenia;
    private String donTipo;
    private byte[] donFirma;

    public Donante() {
    }

    public Donante(int donId, String donNombre, String donApellido, String donEmail, String donTelefono, String donContrasenia, String donTipo, byte[] donFirma) {
        this.donId = donId;
        this.donNombre = donNombre;
        this.donApellido = donApellido;
        this.donEmail = donEmail;
        this.donTelefono = donTelefono;
        this.donContrasenia = donContrasenia;
        this.donTipo = donTipo;
        this.donFirma = donFirma;
    }

    public int getDonId() {
        return donId;
    }

    public void setDonId(int donId) {
        this.donId = donId;
    }

    public String getDonNombre() {
        return donNombre;
    }

    public void setDonNombre(String donNombre) {
        this.donNombre = donNombre;
    }

    public String getDonApellido() {
        return donApellido;
    }

    public void setDonApellido(String donApellido) {
        this.donApellido = donApellido;
    }

    public String getDonEmail() {
        return donEmail;
    }

    public void setDonEmail(String donEmail) {
        this.donEmail = donEmail;
    }

    public String getDonTelefono() {
        return donTelefono;
    }

    public void setDonTelefono(String donTelefono) {
        this.donTelefono = donTelefono;
    }

    public String getDonContrasenia() {
        return donContrasenia;
    }

    public void setDonContrasenia(String donContrasenia) {
        this.donContrasenia = donContrasenia;
    }

    public String getDonTipo() {
        return donTipo;
    }

    public void setDonTipo(String donTipo) {
        this.donTipo = donTipo;
    }

    public byte[] getDonFirma() {
        return donFirma;
    }

    public void setDonFirma(byte[] donFirma) {
        this.donFirma = donFirma;
    }
}
