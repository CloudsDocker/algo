import java.util.logging.Logger;

import static java.lang.System.out;

/**
 * Created by todzhang on 2017/1/30.
 *
 * class for doing encryption and decryption using the Caesar Cipher
 */
public class CaesarCipher {
    private char[] encoder=new char[26];
    private char[] decoder=new char[26];

    public CaesarCipher(int rotation){
        for(int k=0;k<26;k++){
            encoder[k]=(char)('A'+(k+rotation)%26);
            decoder[k]=(char)('A'+(k-rotation+26)%26);
        }
    }


    private String encode(String origional){
        return transform(origional,encoder);
    }

    private String decode(String origional){
        return transform(origional,decoder);
    }

    private String transform(String origional, char[] codes){
        char[] msg=origional.toCharArray();
        for (int i = 0; i < msg.length; i++) {
            if(Character.isUpperCase(msg[i])){
                int j=msg[i]-'A';
                msg[i]=codes[j];
            }
        }
        return new String(msg);
    }

    public static void main(String[] args){
        CaesarCipher cipher=new CaesarCipher(3);
        out.println("--- encryption code is:"+new String(cipher.encoder));
        out.println("--- decryption code is:"+new String(cipher.decoder));

        String msg="EAGLE IS IN PLAY; MEET AT JOE'S";

        String coded=cipher.encode(msg);
        out.println(" == the secret is :"+coded);
        String answer=cipher.decode(coded);

        out.println("=======Messag is :"+answer);

        Logger logger=Logger.getAnonymousLogger();

    }
}
