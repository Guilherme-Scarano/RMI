package br.edu.ifsuldeminas.mch.sd.rmi.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Operations extends Remote {

    Number sum(Number x, Number y) throws RemoteException;

    Number sub(Number x, Number y) throws RemoteException;

    Number mul(Number x, Number y) throws RemoteException;

    Number div(Number x, Number y) throws RemoteException;

    List<String> lastOperations(int howMany) throws RemoteException;

    List<String> lastOperations() throws RemoteException;

    Number sqrt(Number x) throws RemoteException; // Raiz quadrada

    Number cbrt(Number x) throws RemoteException; // Raiz cúbica
    
    Number sqrt4(Number x) throws RemoteException; // Raiz quarta

    Number sqrt5(Number x) throws RemoteException; // Raiz quinta

    Number pow(Number base, int exponent) throws RemoteException; // Potência

    Number percent(Number total, Number percentage) throws RemoteException; // Porcentagem

    Number mod(Number x, Number y) throws RemoteException; // Módulo

    Number factorial(Number x) throws RemoteException; // Fatorial
}
