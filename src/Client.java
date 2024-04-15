import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

public class Client {
    public static void main(String[] args) {
        int port = 8080;
        String server = "192.168.56.102";

        try {
            ICalculator calculator = (ICalculator) Naming.lookup("rmi://" + server + ":" + port + "/ICalculator");

            while (true) {
                String option = JOptionPane.showInputDialog(
                    "Calular\n" +
                    "Suma........................................... (1)\n" +
                    "Resta........................................... (2)\n" +
                    "Multiplicación............................. (3)\n" +
                    "División....................................... (4)\n"
                );

                if (option == null) {
                    break;
                }

                float firstNumber = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el primer numero"));
                float secondNumber = Float.parseFloat(JOptionPane.showInputDialog("Ingrese el segundo numero"));

                switch (option) {
                    case "1":
                        JOptionPane.showMessageDialog(null, firstNumber + " + " + secondNumber + " = " + calculator.addition(firstNumber, secondNumber));
                        break;
                    case "2":
                        JOptionPane.showMessageDialog(null, firstNumber + " - " + secondNumber + " = " + calculator.subtraction(firstNumber, secondNumber));
                        break;
                    case "3":
                        JOptionPane.showMessageDialog(null, firstNumber + " * " + secondNumber + " = " + calculator.multiplication(firstNumber, secondNumber));
                        break;
                    case "4":
                        JOptionPane.showMessageDialog(null, firstNumber + " / " + secondNumber + " = " + calculator.division(firstNumber, secondNumber));
                        break;
                    default:
                        break;
                }
            }
        } catch (RemoteException | NotBoundException ex) {
            JOptionPane.showMessageDialog(null, "No se pudo conectar al servidor: \n" + ex);
        } catch (MalformedURLException ex) {
            JOptionPane.showMessageDialog(null, "La URL esta en formato incorrecto:\n" + ex);
        }
    }
}


