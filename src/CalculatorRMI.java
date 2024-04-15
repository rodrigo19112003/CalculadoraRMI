import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorRMI extends UnicastRemoteObject implements ICalculator{
    
    protected CalculatorRMI() throws RemoteException {
        super();
    }

    @Override
    public float division(float firstNumber, float secondNumber) throws RemoteException {
        return firstNumber / secondNumber;
    }

    @Override
    public float multiplication(float firstNumber, float secondNumber) throws RemoteException {
        return firstNumber * secondNumber;
    }

    @Override
    public float addition(float firstNumber, float secondNumber) throws RemoteException {
        return firstNumber + secondNumber;
    }

    @Override
    public float subtraction(float firstNumber, float secondNumber) throws RemoteException {
        return firstNumber - secondNumber;
    }
}


