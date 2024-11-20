package socket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.io.DataInputStream;

import java.io.DataOutputStream;

import java.io.IOException;

import java.io.PrintStream;

import java.net.Socket;

import java.util.StringTokenizer;

import java.util.logging.Level;

import java.util.logging.Logger;


public class ClienteCli implements Runnable {

	

    String nickName = "";

    Socket sock;

    Thread hilo;

    

	final DataInputStream disCliente;

    final DataOutputStream dosCliente;

    boolean isConected;

    PrintStream ps;

    

    public ClienteCli(Socket sock, String nick, DataInputStream in, DataOutputStream out) {

        this.nickName = nick;

        this.sock = sock;

        this.disCliente = in;

        this.dosCliente = out;    

        

        ps = new PrintStream(System.out);

        this.isConected = true;

        this.hilo = new Thread(this, nickName);

    }


    @Override

    public void run() {

        String msgRecibido = "";

        String destino = "";



        while (this.sock.isConnected() && this.isConected) {

            try {

                // Leer el mensaje recibido

                msgRecibido = this.disCliente.readUTF().trim();



                // Comprobar si el mensaje es un comando

                if (msgRecibido.equalsIgnoreCase("/salir")) {

                    this.isConected = false;

                    this.dosCliente.writeUTF("Te has desconectado.");

                    break;

                } else if (msgRecibido.equalsIgnoreCase("/clientes")) {

                    // Enviar lista de clientes conectados

                    StringBuilder listaClientes = new StringBuilder(Servidor.ANSI_BLUE + "Clientes conectados:\n" + Servidor.ANSI_RESET);

                    for (ClienteCli cli : Servidor.ClientesConectados) {

                        if (cli.isConected) {

                            listaClientes.append("- ").append(cli.getNickName()).append("\n");

                        }

                    }

                    this.dosCliente.writeUTF(listaClientes.toString());

                    continue;

                }



                // Separar destinatario y mensaje

                if (msgRecibido.contains("#")) {

                    StringTokenizer token = new StringTokenizer(msgRecibido, "#");

                    destino = token.nextToken().trim().toLowerCase();

                    msgRecibido = token.nextToken().trim();

                } else {

                    destino = "";

                }



                // Mostrar mensaje en consola del servidor

                ps.println("\n"

                        + Servidor.ANSI_PURPLE

                        + "El cliente "

                        + Servidor.ANSI_GREEN

                        + this.nickName

                        + Servidor.ANSI_PURPLE

                        + " envía: "

                        + Servidor.ANSI_YELLOW

                        + msgRecibido + "\n\t"

                        + Servidor.ANSI_PURPLE

                        + " al cliente =>"

                        + Servidor.ANSI_CYAN

                        + (destino.equalsIgnoreCase("") ? " Todos" : " ".concat(destino.toUpperCase()))

                        + "\n"

                        + Servidor.ANSI_RESET

                );



                // Enviar mensaje a los destinatarios

                for (ClienteCli cli : Servidor.ClientesConectados) {

                    if (msgRecibido.equalsIgnoreCase("")) break;

                    if (cli.getNickName().toLowerCase().equalsIgnoreCase(destino) && this.isConected) {

                        if (cli.isConected) {

                            cli.dosCliente.writeUTF(Servidor.ANSI_GREEN

                                    + this.nickName

                                    + ": "

                                    + Servidor.ANSI_RESET

                                    + msgRecibido);

                        } else {

                            this.dosCliente.writeUTF(Servidor.ANSI_RED

                                    + "Cliente no disponible" + Servidor.ANSI_RESET);

                        }

                        break;

                    } else if (destino.equalsIgnoreCase("") &&

                            this.isConected &&

                            !cli.getNickName().toLowerCase().equalsIgnoreCase(this.nickName)) {

                        cli.dosCliente.writeUTF(Servidor.ANSI_YELLOW

                                + this.nickName

                                + ": "

                                + Servidor.ANSI_RESET

                                + msgRecibido);

                    }

                }



            } catch (IOException ex) {

                Logger.getLogger(ClienteCli.class.getName()).log(Level.SEVERE, null, ex);

            }

        }

    }



    

	

	

	void notificarClientes(boolean estado) {

		for( ClienteCli cli : Servidor.ClientesConectados )

		{

			if( !cli.getNickName().equals(this.nickName) && cli.isConected() )

			{

				try {

					if(estado)

					{

						cli.dosCliente.writeUTF(Servidor.ANSI_GREEN

								+ "\t---"

								+ this.getNickName()

								+ " se ah CONECTADO---"

								+ Servidor.ANSI_RESET

						);						

					}else {

						cli.dosCliente.writeUTF(Servidor.ANSI_RED

								+ "\t---"

								+ this.getNickName()

								+ " se ah DESCONECTADO---"

								+ Servidor.ANSI_RESET

						);

					}

				}catch(IOException ex) {

					Logger.getLogger(ClienteCli.class.getName()).log(Level.SEVERE,null,ex);

				}

			}

		}

	}

	

    public String getNickName() {

		return nickName;

	}



	public Socket getSock() {

		return sock;

	}



	public Thread getHilo() {

		return hilo;

	}



	public boolean isConected() {

		return isConected;

	}	

	

}