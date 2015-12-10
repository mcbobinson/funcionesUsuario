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
import java.util.Scanner;
public class funcionesC4 {
static Jugador[] players= new Jugador[100];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner lea=new Scanner (System.in);
        
        int opMenuInicio,op2;
        
        boolean GameRunning=true,InGameActive=false;
        
        players[0]= new Jugador("test","test",0);
        players[0].AgregarLog("prueba del log");
        System.out.println( players[0].getUser());
        String user,pass;
        
        
        while(GameRunning)
        {
            System.out.println("Ingrese El Numero De La Opcion Deseada");
            System.out.println("1 - Log In");
            System.out.println("2 - CrearUsuario");
            System.out.println("3 - Salir");
            opMenuInicio= lea.nextInt();
            switch(opMenuInicio)
            {
                case 1:
                {
                    System.out.println("Si ya tiene usuario ingrese los siguientes datos");
                    System.out.println("ingrese el user");
                    user=lea.next();
                    System.out.println("ingrese la pass");
                    pass=lea.next();
                    
                    for(Jugador l : players)
                    {
                       
                        if(l.ExisteJugador(user, pass))
                        {
                            System.out.println("Existe Usuario Entra al Juego");
                            InGameLogic(l.getUser());
                            break;
                            
                            
                        }    
                        break;
                    }
                    System.out.println("Player No Se Encontro");
                    break;
                }
                
                case 2:
                {
                    boolean existe= false;
                    System.out.println("Creacion De Usuario debe de ser unico");
                    System.out.println("ingrese el user");
                    user=lea.next();
                    System.out.println("ingrese la pass");
                    pass=lea.next();
                    for(Jugador l : players)
                    {
                        if(l.ExisteJugador(user, pass))
                        {
                            System.out.println("usuario ya existe , Vuelva a insertar usuario");
                            break;
                        }
                        break;
                    }
                    for(int x=0;x<players.length;x++)
                    {
                        if(players[x]==null)
                        {
                            players[x]=new Jugador(user,pass,0);
                        }
                    }
                   
                    InGameActive= true;
                    while(InGameActive)
                    {
                        //aqui va la logica del juego PORQUE AQUI SIGNIFICA QUE SI EXISTE EL USUARIO
                    }
                    break;
                }
                
                case 3:
                {
                    GameRunning=false;
                    break;
                }
                
            }
        }
        
    }
    
    
 ////funciones
   
public static void InGameLogic(String OnlineUser)
{
    String UsuarioConectado=OnlineUser;
    Scanner lea= new Scanner(System.in);
    int OpcionIG,OpSuMenu;
    boolean InGameMenu=true;
    while(InGameMenu)
    {
        System.out.println("Ingrese El Numero De La Opcion Deseada");
        System.out.println("1 - Jugar Connect4Four");
        System.out.println("2 - Configuracion");
        System.out.println("3 - Reportes");
        System.out.println("4 - Mi Perfil");
        System.out.println("5 - Salir");
        OpcionIG= lea.nextInt();
        boolean SubMenu=true;
        switch(OpcionIG)
        {
            case 1:
            {
                ////logica del juego, inicio del juego
                break;
            }

            /*case 2:
            {
                while(SubMenu)
                {
                    System.out.println("Ingrese El Numero De La Opcion Deseada");
                    System.out.println("1 - Dificultad");
                    System.out.println("2 - Modo De Juego");
                    System.out.println("3 - Regresar al Menu Principal");
                    OpSuMenu=lea.nextInt();
                    switch(OpSuMenu)
                    {
                        case 1:
                        {
                            break;
                        }

                        case 2:
                        {
                            break;
                        }
                        case 3:
                        {
                            SubMenu=false;
                            break;
                        }
                    }
                }    
                break;
            }*/
            case 3:
            {
                while(SubMenu)
                {
                    System.out.println("Ingrese El Numero De La Opcion Deseada");
                    System.out.println("1 - Descripcion De Mis 10 Ultimos Juegos");
                    System.out.println("2 - Ranking Jugadores");
                    System.out.println("3 - Regresar al Menu");
                    OpSuMenu=lea.nextInt();
                    switch(OpSuMenu)
                    {
                        case 1:
                        {
                            break;
                        }

                        case 2:
                        {
                            break;
                        }
                        case 3:
                        {
                            SubMenu=false;
                            break;
                        }
                    }
                }  
                break;
            }
            case 4:
            {
                while(SubMenu)
                {
                    System.out.println("Ingrese El Numero De La Opcion Deseada");
                    System.out.println("1 - Ver Mis Datos");
                    System.out.println("2 - Modificar Mis Datos");
                    System.out.println("3 - Eliminar Mi Cuenta");
                    System.out.println("4 - Regresar al Menu");
                    OpSuMenu=lea.nextInt();
                    switch(OpSuMenu)
                    {
                        case 1:
                        {
                            
                            for(Jugador l : players)
                            {
                                if(l.getUser().equalsIgnoreCase(UsuarioConectado))
                                {
                                    System.out.println("nombre: " + l.getUser() + " pass: " + l.getPass()+ " puntuacion "+ l.getPuntuacion());
                                    l.PrintLog();
                                }
                                break;
                            }
                            break;
                        }

                        case 2:
                        {
                            System.out.println("Modificar user");
                            String user =lea.next();
                            System.out.println("modificar pass");
                            String pass= lea.next();
                            if(!NoExiste(user))
                            {
                                for(Jugador l : players)
                                {
                                    if(l.getUser().equalsIgnoreCase(UsuarioConectado))
                                    {
                                        l.setUser(user);
                                        l.setPass(pass);
                                        UsuarioConectado=user;
                                        
                                    }
                                    break;
                                }
                            }
                            break;
                        }
                        case 3:
                        {
                            for(int x=0;x<players.length;x++)
                            {
                                if(players[x].user.equalsIgnoreCase(UsuarioConectado))
                                {
                                    players[x]=null;
                                    SubMenu=false;
                                    InGameMenu=false;
                                    break;
                                }
                            }
                            
                            break;
                        }
                        case 4:
                        {
                            SubMenu=false;
                            break;
                        }
                    }
                }  
                break;
            }
            case 5:
            {
                InGameMenu=false;
                break;
            }
        }
    }
    
}

public static boolean NoExiste(String user)
{
    for( Jugador l : players)
    {
        if(l.user.equalsIgnoreCase(user))
        {
            System.out.println("ya existe ese user");
            return true;
        }
        break;
    }
    return false;
    
}
    
}


