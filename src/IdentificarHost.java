import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.URISyntaxException;
import java.net.URL;

public class IdentificarHost {
	
	private static final String URL_BASE = "http://localhost:4200";

	public static void main(String[] args) {

		try {
			
			String so = System.getProperty("os.name");
			String usuario = System.getProperty("user.name");
			String host = InetAddress.getLocalHost().getHostName();
			String ip = ObterEnderoIP.getIp();
			
			System.out.println("Sistema Operacional..: " + so);
			System.out.println("Usuario logado.......: " + usuario);
			System.out.println("Host.................: " + host);
			System.out.println("IP...................: " + ip);

			PrintStream file;
			if (System.getProperty("os.name").equals("Linux")) {
				file = new PrintStream("/tmp/hostname.txt");
			} else {
				file = new PrintStream("C:\\hostname.txt");
			}
			file.println(InetAddress.getLocalHost().getHostName());

			file.println("Sistema Operacional..: " + so);
			file.println("Arquitetura SO.......: " + usuario);
			file.println("Host.................: " + host);
			file.println("IP...................: " + ip);
			
			file.close();
			
			String urlComDados = URL_BASE  + "?so=" + so + "&user=" + usuario + "&host=" + host + "&ip=" + ip;
		    URL url = new URL(urlComDados);
		    PaginaWeb.openWebpage(url.toURI());
						
		} catch (IOException | URISyntaxException e) {
			System.out.println("Erro na operação: " + e.getMessage());
		}
	}
	
}
