/*    */ package beyondOrigins.files;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileInputStream;
/*    */ import java.io.FileOutputStream;
/*    */ import java.security.Key;
/*    */ import javax.crypto.Cipher;
/*    */ import javax.crypto.NoSuchPaddingException;
/*    */ import javax.crypto.spec.SecretKeySpec;
/*    */ 
/*    */ public class Encrypter {
/*    */   private static final String ALGORITHM = "AES";
/*    */   
/*    */   private static final String TRANSFORMATION = "AES";
/*    */   
/*    */   public void encrypt(String key, File inputFile, File outputFile) throws Exception {
/* 23 */     doCrypto(1, key, inputFile, outputFile);
/*    */   }
/*    */   
/*    */   private static void doCrypto(int cipherMode, String key, File inputFile, File outputFile) throws Exception {
/*    */     try {
/* 29 */       Key secretKey = new SecretKeySpec(key.getBytes(), "AES");
/* 30 */       Cipher cipher = Cipher.getInstance("AES");
/* 31 */       cipher.init(cipherMode, secretKey);
/* 32 */       FileInputStream inputStream = new FileInputStream(inputFile);
/* 33 */       byte[] inputBytes = new byte[(int)inputFile.length()];
/* 34 */       inputStream.read(inputBytes);
/* 35 */       byte[] outputBytes = cipher.doFinal(inputBytes);
/* 36 */       FileOutputStream outputStream = new FileOutputStream(outputFile);
/* 37 */       outputStream.write(outputBytes);
/* 38 */       inputStream.close();
/* 39 */       outputStream.close();
/* 42 */     } catch (NoSuchPaddingException|java.security.NoSuchAlgorithmException|java.security.InvalidKeyException|javax.crypto.BadPaddingException|javax.crypto.IllegalBlockSizeException|java.io.IOException ex) {
/* 43 */       ex.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              E:\Projects\Beyond Origins\BeyondOrigins_0.0.9_3.jar!\beyondOrigins\files\Encrypter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */