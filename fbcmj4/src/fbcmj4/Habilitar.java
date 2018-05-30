//AL02829156
//ARELI MAGDIEL CIGARROA REVOLLO

package fbcmj4;

import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import facebook4j.FacebookFactory;
import facebook4j.Post;
import facebook4j.ResponseList;
import facebook4j.auth.AccessToken;

public class Habilitar {
	String appId;
	String appSecret;
	String userToken;
	Facebook conn;
	static final Logger log = LogManager.getLogger(Habilitar.class);
	
	public Habilitar () throws Excepcions {
		super();
		this.appId = Configurar.getAppId();
		this.appSecret = Configurar.getAppSecret();
		this.userToken = fbcmj4.Configurar.getAccessToken();
		
		try {
			conn = new FacebookFactory().getInstance();
			conn.setOAuthAppId(appId, appSecret);
			conn.setOAuthPermissions(fbcmj4.Configurar.getPermissions());
			conn.setOAuthAccessToken(new AccessToken(userToken));
		} catch(Exception e) {
			log.error("Error de conectividad con facebook");
			throw new Excepcions("Error de conectividad con facebook");
		}
	}
	
	public Habilitar (String userToken) throws Excepcions {
		super();
		this.appId = Configurar.getAppId();
		this.appSecret = Configurar.getAppSecret();
		this.userToken = userToken;
		
		try {
			conn = new FacebookFactory().getInstance();
			conn.setOAuthAppId(appId, appSecret);
			conn.setOAuthPermissions(Configurar.getPermissions());
			conn.setOAuthAccessToken(new AccessToken(userToken));
		} catch(Exception e) {
			log.error("Error de conectividad con facebook");
			throw new Excepcions("Error de conectividad con facebook");
		}
	}
	
	public void changeUser(String newToken) {
		conn.setOAuthAccessToken(new AccessToken(userToken));
	}
	
	private void imprimirPost(Post p) {
		String name = p.getName();
		String story = p.getStory();
		String msg = p.getMessage();
		if(name == null) {
			name = "";
		}
		if(story == null) {
			story = "";
		}
		if(msg == null) {
			msg = "";
		}
		System.out.println("================================");
		System.out.println("Nombre: " + name);
		System.out.println("Historia: " + story);
		System.out.println("Mensaje: " + msg);
		System.out.println("================================");
	}
	
	public void verNewsFeed() {
		
		try {
			System.out.println("Mostrando newsFeed de " + conn.getMe().getName());
			ResponseList<Post> p = conn.getFeed();
			for(Post currentP : p) {
				imprimirPost(currentP);
			}
		} catch (FacebookException e) {
			log.error(e);
			System.err.println("Error de conectividad");
		}
	}
	
	public void verWall() {
		try {
			System.out.println("Mostrando wall de " + conn.getMe().getName());
			ResponseList<Post> p = conn.getPosts();
			for(Post currentP : p) {
				imprimirPost(currentP);
			}
		} catch (FacebookException e) {
			log.error(e);
			System.err.println("Error de conectividad");
		}
		
	}
	
	public void publicar(String mensaje) {
		try {
			conn.postStatusMessage(mensaje);
			System.out.println("Se publico correctamente");
		} catch (FacebookException e) {
			log.error(e);
			System.err.println("Error de conectividad");
		}
	}
	
	public void publicarLink(URL url) {
		try {
			conn.postLink(url);
			System.out.println("Se publico correctamente");
		} catch (FacebookException e) {
			log.error(e);
			System.err.println("Error de conectividad");
		}
	}
}