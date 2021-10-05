package com.example.findme.Model;

public class Desaparecidos {
    private String nombreDes;
    private String Ciudad;
    private String Edad;
    private int imagenDes;

    public Desaparecidos(String nombreDes, String Ciudad, String Edad, int imagenDes) {
        this.nombreDes = nombreDes;
        this.Ciudad = Ciudad;
        this.Edad = Edad;
        this.imagenDes = imagenDes;
    }

    public String getNombreDes() {
        return nombreDes;
    }

    public void setNombreDes(String nombreDes) {
        this.nombreDes = nombreDes;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String ciudad) {
        Ciudad = ciudad;
    }

    public String getEdad() {
        return Edad;
    }

    public void setEdad(String edad) {
        Edad = edad;
    }

    public int getImagenDes() {
        return imagenDes;
    }

    public void setImagenDes(int imagenDes) {
        this.imagenDes = imagenDes;
    }
}
