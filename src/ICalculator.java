import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICalculator extends Remote {
     public float division(float firstNumber, float secondNumber) throws RemoteException;

     public float multiplication(float firstNumber, float secondNumber) throws RemoteException;

     public float addition (float firstNumber, float secondNumber) throws RemoteException;

     public float subtraction (float firstNumber, float secondNumber) throws RemoteException;
}


