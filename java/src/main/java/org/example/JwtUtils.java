package org.example;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Date;

public class JwtUtils {

  public static PrivateKey getPrivateKeyFromString(String privateKeyPEM) throws Exception {
    byte[] keyBytes = Base64.getDecoder().decode(privateKeyPEM);
    PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
    KeyFactory keyFactory = KeyFactory.getInstance("RSA");
    return keyFactory.generatePrivate(spec);
  }

  public static void main(String[] args) throws Exception {
    //String privateKeyString = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQDIPGkzZtaUiX/rrF+zh7cDjoLbXBZ8wkSbgdPsDpV5QU/BnH9EkaBOxYCjWUdXePxocxB+RuZ0EatZK9f8S6NsnXgkz97XSfMOpBVUVqR80DW4Kvc5aFDRM+xBPgpnrmxctNrAOclJl35jf1rzGqfkop+/VwHEePJrwvU1Gn9tpMigMPZ72zUs/9TUTS0o1RGThXa+Ek1QqunsbIrULw1fS8Fbqb4cRMLaEV1F3mjfpjtqv+3gaTFw/p3eA2aOdNW8WwO01PDc36QKpT6tti8jtSL1G49r71QpRXZLVmY9WjKQDFFfg2ngAyqBx1M9EVeqfzEwsSRUjtFTOp+pgLOVAgMBAAECgf8m6ZaIJrQMqavyYM04Vmd6iXdkqcC0/gvXLKPCfBMQPWECfyc8bBB7PmaBWBhFJ33lznamE6E1bTmfWqXeodRghzmR7dOggv55GeoLOcs9djj6UV86CMur3CtNgoEDJSJp4buhH5m+c3JcY6OJGuUFyZTB2ma9h8OUrY55g2zAIa29iyaa7q43416kwTxU49VxbaWlnRAQk7yHIRVY8iWjC4+0JKn6AWGRuIh8Te2Ob08m5VqAVChszqeFkcO5G1/Qc+z+/mTTEasVptGbiK3M8Y6lED58OE2PHBx4fRKPVpqluRs0bkVf/lxXammGNJPw8AE0up76POVGxM2+72kCgYEA7ngY0HkBTDR9sdUu5aPjAP+cZBlkVL34JRHG/o2tMN1rpY/1SzyglZf9YhdLZmPwcg30qzrEQBw1bSpp86o9V+k7lIELKnorRE0M3u2u5Fh8NPhUp2QCOugv7BsME74HuA+/yloJcuhehAQALlqe1yYxWnC+5OODpgMaxSuBeQkCgYEA1vTHqb+HZPq6SW0cU/Bb/NqaIvrQ6YFBTK0GvpD4PdmmfEi4/TEZ+Wq4HiPVEBBbJEC5OOJ0hom1fDHOAXeICSo0EY5AsXOeirBe+1xx4N8szBXifksBfCkXPJaxA8aI83/m4XFYpFlWQGzrJTGZ2xlzbIYkBcasoE39/m/nRS0CgYEAwAkmsns/eEatEhBC+9rGa39sSY/JJBT3R6LRRRyCY99rWKBdQIFKMC19dwibR5EjiDWE2n8wmxAcVhTZzcdCLxE7UZO5kjNftFj4DG4LcQdwvpdcVJBM23MvZEtDpoJZZPgJ0sI+6bIGqvktzCZd05SGGfbBQ0GUOpQ1cqJeWUECgYEAloMlPz3GDzXktL86w6ecsYtbvDyFhcskrwzEmTEnMR+yjHnbViZIerV4IFqUuL/LIbJUP3mJgB7yvfidt7c7wLcVaGmD8Pz1OUVP7I+JiZybYHe+dRIOAyM+iwU1A2DDykR3pMnZ+JI5a7kYWZ3GjnzerlGq7YR0oXaa78rpVC0CgYAyxGYCvf92NX8RhK9N8IbWkFlub7fm2mQCLvTvVSqs4e8T/gxoX1sNrIVBOC7u0roapR857v4kTP1rqovnLCxpvvmgoxq7296DyaT/rTyX+L7xxhsMaBTvuBIl2i0CO04JSqqG8Ki3/KCYaNT36TqCufige92MK6DYfVrp7yRF1g==";
    String privateKeyString = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCcupROXw81VX91gbFXFOBxIwzo5huGdZ5V7UjOqhfEoZsd5E6sDP8WJBLQiGMKY335u/+Mv2r/UI9ql2qhH4bTwZJlfYLTfEdP0VJ/pP16mCL4k7fwQvZW+HvvRMCnfnsaD1vBWE+KTAdasCEf2AN9UJwEzldjLFlYVCaZH4TXqYbG86668D6FiGMR5qehhQBTUjFFX6/MKY0ohTAbB6rB72Peutf7htLSYsbyERx6L2RL/rzb/aLY9BNBR9rORpWLGaeSddTVC672pdmRQAj64mXmO9hEn34Ktf1VAx6WC6V6m/ki0GoZdkgj/RCf7biiZCj97POzhN49IfM13tWBAgMBAAECggEAAZ4vnoK0rf+6b5k/UMv9GTQ1OkOuy6oO0+uYl9PGtXveffiLIl2g+vhccP4MtGzKAYnUkSNF8G0hnhcdWj56qiK2ntFoM/nhchqHzYEh+xzOO7f6jnoPv+wQaawo9NDX89LZ8uIaMhnnleYrsf/yOL/VZfS5S+Alrqbq/8VSfFz2POv3o2+4T1IwIjDYAmswCHKuxXM55RGaarLoouQBHM9qVY7Dh4Mz6i66Kiw2xUaeTDhm/5laXjk0CInCuUvEKrJBKdJvZ4mPkh919lZ7J02lKNOyyVZGbsyrP6WHqwte1LfxtJg71lXJKpzb29cKVWqOrQLnrEcWyCdQAXIIhQKBgQDJg5bhVGaKj8Pv5CymfXsrn3l/zc/wabXHvxF5fm7m4yZHce7SYL9OgcHSxByydiOqZVzpcnHevdNVo96oQSfWoYDNSD39hcyw7Ix9gbQ/ZrQh2CzBFf/oSNjCNU5+/1APmtlADMALXdof5aWmn5eWqOkjvrpB9ArUw7zgBHcrlQKBgQDHGwudE7FdxQ39kCr/3IgViUUa/UVSbJ/4JGLSkw3CEDm2wthToQE4TPrwwxQtEWgIML30F9+iEjfzIZ+0942CrU/+q+/AI2FTY03R5dglpooXPtTMrKkpcCHFrT1mKz0al78OstZtL3jgSsJck+Ekfs6RAOGl1YOGMD52jw7nPQKBgQC7moNcEexI8WDzs9SRx15lFVnSzvPYmUF/zXTiS//Jeg2IFBzHxQQ1fX3Jz4P77Rp1J1rhhwdV3BmksCO5Nrd1DPRRqQD1Rpxy1jZRHfCF2gK3Q38e33FYeoE6BNCoUN7jOEErbPNZYa2RZoXaYteIjoZGHelfP2jZ/cSYNfAQJQKBgCeMrb/j24V+0QqfCouMaNOuUrXLvWtj/Fq0D5U4dLEpu+0bwxDJmI5wbCBK/8T8AiguVm0YGOn+qHJ5KVovGkLs3kj+Kj+GR5ziyuB4wXipHiED8A0/9tIuXecARIP47shLgD4RNBq4JVCYSQdOsJgpQCr5e9kPEnMjPiUawaEZAoGAQonJBAsFdPpW86qDcAPKNwzi13BheRTbgNUwJcK/fUM0o5e2BrcI3UB+PtccvMEyVwpa4Fz9xPrzC1yQOJwZDG8sdnDqmkCUDwMeOXaCUgU8AwoiDTbYheF5qP+q4vdyjB28vd1Hg0BZ+OuINbvaJGB7TtL5H7H0OLh1sycKTt8=";
    PrivateKey privateKey = getPrivateKeyFromString(privateKeyString);
    String jwt = createJWT(privateKey);
    System.out.println("Generated JWT: " + jwt);
  }
  public static String createJWT(PrivateKey privateKey) {
    return Jwts.builder()
            .setSubject("admin")
            .setIssuer("dynamo")
            .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour expiry
            .signWith(privateKey, SignatureAlgorithm.RS256)
            .compact();
  }


  public static KeyPair generateRSAKeyPair() throws NoSuchAlgorithmException {
    KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
    keyPairGenerator.initialize(2048);
    return keyPairGenerator.generateKeyPair();
  }



  public static Jws<Claims> validateJWT(String jwt, PublicKey publicKey) {
    return Jwts.parserBuilder()
            .setSigningKey(publicKey)
            .build()
            .parseClaimsJws(jwt);
  }
}
