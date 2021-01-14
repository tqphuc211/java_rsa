package com.company;

import java.math.BigInteger;
import java.util.BitSet;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        RSA rsa = new RSA();
        System.out.println("Input m:");
        Scanner sc = new Scanner(System.in);
        String ip = sc.nextLine();
        // encrypt
        byte[] encrypted = rsa.encrypt(ip.getBytes());
        System.out.println("c: " + new String(encrypted));
        // decrypt
        byte[] decrypted = rsa.decrypt(encrypted);
        System.out.println("Decrypted m: " + new String(decrypted));

//        BigInteger i=new BigInteger("10407932194664399081925240327364085538");
//        BigInteger max = new BigInteger("1040793219466439908192524032736408553861526224726670480531911235040360805967336029801223944173232418484242161395428100779138356624832346490813990660567732076292412950938922034577318334966158355047295942054768981121169367714754847886696250138443826029173234888531116082853841658502825560466622483189091880184706822220314052102669843548873295802887805086973618690071472071055570316872908710407932194664399081925240327364085538615262247266704805319112350403608059673360298012239441732324184842421613954281007791383566248323464908139906605677320762924129509389220345773183349661583550472959420547689811211693677147548478866962501384438260291732348885311160828538416585028255604666224831890918801847068222203140521026698435488732958028878050869736186900714720710555703168729087");
//        BigInteger t=new BigInteger("2");
//        while (i.compareTo(max)<0){
//            i=i.add(t);
//            if (isPrime(i))
//                System.out.println(i);
//        }
    }

    private static String bytesToString(byte[] encrypted)
    {
        String test = "";
        for (byte b : encrypted)
        {
            test += Byte.toString(b);
        }
        return test;
    }


    public static boolean isPrime(BigInteger n) {

        BigInteger[] l = {new BigInteger("2"), new BigInteger("3"), new BigInteger("5")};

        BitSet bs = BitSet.valueOf(n.toByteArray());
        int r = 1;
        while (!bs.get(r) && r < bs.length()) {
            r++;
        }
        BitSet m = bs.get(r, bs.length());

        BigInteger o= new BigInteger("1");
        BigInteger on= new BigInteger("-1");
        for (int i=0; i<l.length; i++){
            try {
                BigInteger b = l[i];

//            BitSet mt= BitSet.valueOf(m.toByteArray());
                BigInteger mt = new BigInteger(m.toByteArray());
                BigInteger t = new BigInteger("1");
                for (int j = 1; j <= r; j++) {
//                t=t.add(t);
                    BigInteger rs = b.modPow(mt.shiftLeft(j), n);
                    if (rs.compareTo(o) != 0 && rs.compareTo(on) != 0) {
                        return false;
                    }
                }
            }catch(Exception ex){
                System.out.println("exception"+n);
                return false;
            }
        }

        return true;
    }
}
