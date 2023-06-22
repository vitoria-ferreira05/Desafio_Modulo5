package SistemaDeVendas.LoginPessoa;

import java.math.BigInteger;
import java.security.MessageDigest;

public class CriptografiaSenha {
    protected static String criptografarSenha(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bty = senha.getBytes();
            md.update(bty, 0, senha.length());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
