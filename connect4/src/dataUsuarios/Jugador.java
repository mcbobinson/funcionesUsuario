/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataUsuarios;

/**
 *
 * @author roberto
 */
public class Jugador {

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    String user, pass;
    int puntuacion;
    String [] logJugador= new String[10];
    
    public Jugador(String user,String pass,int puntuacion)
    {
            this.user=user;
            this.pass=pass;
            this.puntuacion=puntuacion;
    }
    
    public boolean ExisteJugador(String user, String pass)
    {
        return this.user.equalsIgnoreCase(user) && this.pass.equals(pass);
    }
    
    public void AgregarLog(String MensajeDePartida)
    {
        for(int x=0 ; x<10; x++)
        {
            if(null==logJugador[x])
            {
                logJugador[x]=MensajeDePartida;
                break;
            }
            break;
        }
    }
    public void PrintLog()
    {
        for(String l : logJugador)
        {
            System.out.println(l);
        }
    }
}

