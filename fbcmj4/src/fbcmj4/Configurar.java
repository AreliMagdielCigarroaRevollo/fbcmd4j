//AL02829156
//ARELI MAGDIEL CIGARROA REVOLLO


package fbcmj4;

import java.util.Scanner;

public class Configurar {

	
	public static String getAppSecret() {
		return "0fd38b30ccd1aaff3740923567e230730";
	}
	
	public static String getAccessToken() {
		return "2147179065505666|ULUCv3lBlD4P1PQCONtTImIa2B4";
	}
	
	public static String getPermissions() {
		return "public_profile,user_actions.news,user_posts,publish_actions";
	}
	
	public static String getAppId() {
		return "2147179065505666";
	}
	
	public static String getUrlForToken() {
		//https://www.facebook.com/v2.10/dialog/oauth?client_id=132509980725145&redirect_uri=https://www.facebook.com/connect/login_success.html&scope=public_profile,user_actions.news,user_posts,publish_actions
		return "https://www.facebook.com/v2.10/dialog/oauth?client_id="+getAppId()+"&redirect_uri=https://www.facebook.com/connect/login_success.html&scope=" + getPermissions();
	}
	
	public static String LoginProccess(Scanner scan) {
		System.out.println("A T E N C I Ó N :  para acceder debes ingresar a la siguiente liga y  copiar el parametro code aqui (" + getUrlForToken() + "):");
		String code = scan.nextLine();
		String urlToken = "https://graph.facebook.com/oauth/access_token?client_id=" + getAppId() + "&redirect_uri=https://www.facebook.com/connect/login_success.html" + "&client_secret=" + getAppSecret() + "&code=" + code;
		System.out.println("Ahora accede a la url y del JSON pega el dato de acces_token (" + urlToken + "):" );
		String newToken = scan.nextLine();
		setAppSecret(newToken);
		return newToken;
		
	}
	
	public static void setAppSecret(String newValue) {
		//
	}
	
	public static void setAccessToken(String newValue) {
		//
	}
	
	public static void setPermissions(String newValue) {
		// 
	}
	
	public static void setAppId(String newValue) {
		//
	}
}