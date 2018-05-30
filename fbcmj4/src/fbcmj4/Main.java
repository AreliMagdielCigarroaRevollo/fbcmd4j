//AL02829156
//ARELI MAGDIEL CIGARROA REVOLLO
package fbcmj4;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import facebook4j.FacebookException;

public class Main {
	static final Logger log = LogManager.getLogger(Main.class);
	
	
	public static void main(String[] args) throws FacebookException, IOException, Excepcions {
		Habilitar fb = new Habilitar();
		Scanner input = new Scanner(System.in);
		boolean next = true;

		while (next) {
			System.out.println("***APLICACIÓN CLIENTE DE FACEBOOK*** \n\n");
			System.out.println("Opciones :");
			System.out.println("\t0 - *Configurar usuario");
			System.out.println("\t1 - *Ver usuario");
			System.out.println("\t2 - *Ver newsfeed");
			System.out.println("\t3 - *Ver wall");
			System.out.println("\t4 - *Publicar Estado");
			System.out.println("\t5 - *Publicar link\n\n");
			System.out.println("\t6 - *******Salir*******");
			String op = input.nextLine();

			switch (op) {
			case "0":
				String newToken = Configurar.LoginProccess(input);
				fb = new Habilitar(newToken);
				break;
			case "1":
				System.out.println("Bienvenido :) " + fb.conn.getMe().getName());
				break;
			case "2":
				fb.verNewsFeed();
				break;
			case "3":
				fb.verWall();
				break;
			case "4":
				System.out.println("Nuevo estado:");
				String mensaje = input.nextLine();
				fb.publicar(mensaje);
				break;
			case "5":
				System.out.println("Nuevo estado:");
				String urlString = input.nextLine();
				try {
					URL url = new URL(urlString);
					fb.publicarLink(url);					
				} catch(MalformedURLException e) {
					log.error("La url introducida no es valida");
				} catch(Exception e) {
					log.error("Error de conectividad");
				}
				
				break;
			case "6":
				next = false;
				break;
			default:
				System.out.println("Opción invalida. Favor de ingresar opción existente.");
				break;
			}
		}
	}
}