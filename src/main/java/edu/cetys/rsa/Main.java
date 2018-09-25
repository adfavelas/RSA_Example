package edu.cetys.rsa;

import java.util.*;
import java.io.*;
import java.lang.*;
import java.math.*;

public class Main {
    public static ArrayList<Integer> NumC= new ArrayList<Integer>();
    public static ArrayList<Integer> NumM= new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for(int i=0;i<t;i++){
            NumC.add(in.nextInt());
        }
        //String C = in.next();
        String clave = in.next(); //La Clave es una palabra que estamos seguros que contiene el encriptado RSA
        int pubkey =in.nextInt();
        String out = method(clave, pubkey);
        System.out.println("Mensaje Encriptado: "+ NumC);
        System.out.println("Mensaje Desencriptado: "+ out);
    }



    public static String method(String key, int pubkey){
        BigInteger n,d,one;
        n = BigInteger.valueOf(pubkey);
        one= BigInteger.valueOf(1);
        String M = "";
        //getNum(C);
        int phi = euler(pubkey);

        for(int e=1;e<phi-1;e++){
            if((BigInteger.valueOf(e).gcd(BigInteger.valueOf(phi))).equals(one)){
                d = BigInteger.valueOf(e).modInverse(BigInteger.valueOf(phi));
                decrypt(d,n);
                M=getStr();
                if(M.contains(key)){
                    System.out.println("d = "+d);
                    System.out.println("e = "+e);
                    return M;
                }
            }
            else{
                continue;
            }
        }
        return "No se pudo desencriptar :(";
    }

	/*public static void getNum(String C){
  		for (char charC: C.toCharArray()) {
			NumC.add((int)charC);
		}
		System.out.println("Mensaje Numerico:" +NumC);
	}*/

    public static String getStr(){
        String msg="";
        char x;
        for (int number: NumM) {
            x=(char) number;
            msg=msg+Character.toString(x);
        }
        return msg;
    }

    public static void decrypt(BigInteger d, BigInteger n){
        BigInteger m;
        NumM.clear();
        for(int number: NumC){
            m=BigInteger.valueOf(number).modPow(d,n);
            NumM.add(m.intValue());
        }
    }

    public static int euler(int n){
        int q=n/2;
        for(int p=2;p<n/2;p++){
            if(n%p==0){
                q=n/p;
                int phi = (p-1)*(q-1);
                System.out.println("Phi = "+phi);
                return phi;
            }
        }
        System.out.println("No se encontró phi");
        return 0;
    }

}
