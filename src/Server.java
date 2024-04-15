import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) {
        try {
            int port = 8080;
            String server = "localhost";

            System.out.println("Iniciando servidor en:");
            System.out.println("hostnamme: " + server);
            System.out.println("puerto: " + port);

            Registry registry = LocateRegistry.createRegistry(port);

            System.setProperty("java.rmi.server.hostname", server);
            registry.rebind("ICalculator", new CalculatorRMI());

            System.out.println("Servidor en ejecución en espera de clientes...");
        } catch (RemoteException ex) {
            System.err.println(ex);
        }
    }
}



