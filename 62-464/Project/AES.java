/*
 * Project 1--AES Crypto
 * Asit Patel - 190409
 */

 import javax.crypto.Cipher;
 import javax.crypto.spec.SecretKeySpec;
 import java.nio.charset.StandardCharsets;
 import java.nio.file.Files;
 import java.nio.file.Paths;
 import java.io.FileOutputStream;
 import java.io.IOException;
 
 /**
  * This class provides functionality for AES encryption and decryption.
  */
/**
 * The AES class represents the Advanced Encryption Standard (AES) algorithm.
 * It provides methods for encrypting and decrypting files using AES.
 */
 public class AES {
 
     /**
      * The main method that accepts command line arguments and performs AES encryption or decryption.
      *
      * @param args The command line arguments. The first argument should be 'e' for encryption or 'd' for decryption.
      *             The second argument should be the path to the key file.
      *             The third argument should be the path to the input file.
      */
     public static void main(String[] args) {
         if (args.length != 3) {
             System.out.println("Usage: java AES [e/d] keyFile inputFile");
             return;
         }
 
         String option = args[0];
         String keyFile = args[1];
         String inputFile = args[2];
 
         try {
             String key = readKey(keyFile);
             if (key == null || key.length() != 32) {
                 System.out.println("Invalid key length.");
                 return;
             }
 
             if (option.equals("e")) {
                 encrypt(inputFile, key);
             } else if (option.equals("d")) {
                 decrypt(inputFile, key);
             } else {
                 System.out.println("Invalid option. Use 'e' for encryption or 'd' for decryption.");
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
 
    /**
     * Reads the contents of a file and returns it as a string.
     *
     * @param keyFile the path to the file containing the key
     * @return the contents of the file as a string
     * @throws IOException if an I/O error occurs while reading the file
     */
     private static String readKey(String keyFile) throws IOException {
         byte[] encoded = Files.readAllBytes(Paths.get(keyFile));
         return new String(encoded, StandardCharsets.UTF_8);
     }
 
    /**
     * Encrypts the contents of the specified input file using the AES encryption algorithm.
     *
     * @param inputFile the path to the input file to be encrypted
     * @param key the encryption key used for encryption
     */
      private static void encrypt(String inputFile, String key) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            byte[] inputBytes = Files.readAllBytes(Paths.get(inputFile));

            // Step 1: SubBytes
            inputBytes = subBytes(inputBytes);

            // Step 2: ShiftRows
            inputBytes = shiftRows(inputBytes);

            // Step 3: MixColumns
            inputBytes = mixColumns(inputBytes);

            // Step 4: AddRoundKey
            byte[] encryptedBytes = cipher.doFinal(inputBytes);

            String outputFile = inputFile + ".enc";
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(encryptedBytes);
            outputStream.close();

            System.out.println("Encryption successful. Encrypted file: " + outputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Substitutes each byte in the input byte array with a corresponding byte from the S-Box.
     *
     * @param inputBytes the input byte array
     * @return the output byte array with substituted bytes
     */
    private static byte[] subBytes(byte[] inputBytes) {
        byte[] outputBytes = new byte[inputBytes.length];
        for (int i = 0; i < inputBytes.length; i++) {
            outputBytes[i] = (byte) (sbox[(inputBytes[i] & 0xFF) / 16][(inputBytes[i] & 0xFF) % 16]);
        }
        return outputBytes;
    }

    /**
     * Performs the ShiftRows operation on the input byte array.
     *
     * The ShiftRows operation cyclically shifts the bytes in each row of the input array.
     * The first row remains unchanged, the second row is shifted one position to the left,
     * the third row is shifted two positions to the left, and the fourth row is shifted three
     * positions to the left.
     *
     * @param inputBytes the input byte array to perform the ShiftRows operation on
     * @return the output byte array after performing the ShiftRows operation
     */
    private static byte[] shiftRows(byte[] inputBytes) {
        byte[] outputBytes = new byte[inputBytes.length];
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                outputBytes[col * 4 + row] = inputBytes[((col + row) % 4) * 4 + row];
            }
        }
        return outputBytes;
    }

    /**
     * Mixes the columns of the input byte array using the AES MixColumns transformation.
     *
     * @param inputBytes the input byte array to be mixed
     * @return the byte array with mixed columns
     */
    private static byte[] mixColumns(byte[] inputBytes) {
        byte[] outputBytes = new byte[inputBytes.length];
        for (int col = 0; col < 4; col++) {
            byte[] column = new byte[4];
            for (int row = 0; row < 4; row++) {
                column[row] = inputBytes[col * 4 + row];
            }
            byte[] mixedColumn = mixColumn(column);
            for (int row = 0; row < 4; row++) {
                outputBytes[col * 4 + row] = mixedColumn[row];
            }
        }
        return outputBytes;
    }

    /**
     * Mixes the columns of the AES state matrix using the MixColumns transformation.
     * This transformation operates on each column of the state matrix independently.
     *
     * @param column the column to be mixed
     * @return the mixed column
     */
    private static byte[] mixColumn(byte[] column) {
        byte[] mixedColumn = new byte[4];
        mixedColumn[0] = (byte) (multiply((byte) 0x02, column[0]) ^ multiply((byte) 0x03, column[1]) ^ column[2] ^ column[3]);
        mixedColumn[1] = (byte) (column[0] ^ multiply((byte) 0x02, column[1]) ^ multiply((byte) 0x03, column[2]) ^ column[3]);
        mixedColumn[2] = (byte) (column[0] ^ column[1] ^ multiply((byte) 0x02, column[2]) ^ multiply((byte) 0x03, column[3]));
        mixedColumn[3] = (byte) (multiply((byte) 0x03, column[0]) ^ column[1] ^ column[2] ^ multiply((byte) 0x02, column[3]));
        return mixedColumn;
    }

    /**
     * Multiplies two bytes using the AES multiplication algorithm.
     * 
     * @param a the first byte to be multiplied
     * @param b the second byte to be multiplied
     * @return the result of multiplying the two bytes
     */
    private static byte multiply(byte a, byte b) {
        int result = 0;
        for (int i = 0; i < 8; i++) {
            if ((b & 1) != 0) {
                result ^= a;
            }
            boolean highBitSet = (a & 0x80) != 0;
            a <<= 1;
            if (highBitSet) {
                a ^= 0x1B; // 0x1B is the irreducible polynomial for AES
            }
            b >>= 1;
        }
        return (byte) (result & 0xFF);
    }
    
    // AES S-Box
    public static final int[][] sbox = {{0x63, 0x7c, 0x77, 0x7b, 0xf2, 0x6b, 0x6f, 0xc5, 0x30, 0x01, 0x67, 0x2b, 0xfe, 0xd7, 0xab, 0x76}, 
                                        {0xca, 0x82, 0xc9, 0x7d, 0xfa, 0x59, 0x47, 0xf0, 0xad, 0xd4, 0xa2, 0xaf, 0x9c, 0xa4, 0x72, 0xc0}, 
                                        {0xb7, 0xfd, 0x93, 0x26, 0x36, 0x3f, 0xf7, 0xcc, 0x34, 0xa5, 0xe5, 0xf1, 0x71, 0xd8, 0x31, 0x15}, 
                                        {0x04, 0xc7, 0x23, 0xc3, 0x18, 0x96, 0x05, 0x9a, 0x07, 0x12, 0x80, 0xe2, 0xeb, 0x27, 0xb2, 0x75}, 
                                        {0x09, 0x83, 0x2c, 0x1a, 0x1b, 0x6e, 0x5a, 0xa0, 0x52, 0x3b, 0xd6, 0xb3, 0x29, 0xe3, 0x2f, 0x84}, 
                                        {0x53, 0xd1, 0x00, 0xed, 0x20, 0xfc, 0xb1, 0x5b, 0x6a, 0xcb, 0xbe, 0x39, 0x4a, 0x4c, 0x58, 0xcf}, 
                                        {0xd0, 0xef, 0xaa, 0xfb, 0x43, 0x4d, 0x33, 0x85, 0x45, 0xf9, 0x02, 0x7f, 0x50, 0x3c, 0x9f, 0xa8}, 
                                        {0x51, 0xa3, 0x40, 0x8f, 0x92, 0x9d, 0x38, 0xf5, 0xbc, 0xb6, 0xda, 0x21, 0x10, 0xff, 0xf3, 0xd2}, 
                                        {0xcd, 0x0c, 0x13, 0xec, 0x5f, 0x97, 0x44, 0x17, 0xc4, 0xa7, 0x7e, 0x3d, 0x64, 0x5d, 0x19, 0x73}, 
                                        {0x60, 0x81, 0x4f, 0xdc, 0x22, 0x2a, 0x90, 0x88, 0x46, 0xee, 0xb8, 0x14, 0xde, 0x5e, 0x0b, 0xdb}, 
                                        {0xe0, 0x32, 0x3a, 0x0a, 0x49, 0x06, 0x24, 0x5c, 0xc2, 0xd3, 0xac, 0x62, 0x91, 0x95, 0xe4, 0x79}, 
                                        {0xe7, 0xc8, 0x37, 0x6d, 0x8d, 0xd5, 0x4e, 0xa9, 0x6c, 0x56, 0xf4, 0xea, 0x65, 0x7a, 0xae, 0x08}, 
                                        {0xba, 0x78, 0x25, 0x2e, 0x1c, 0xa6, 0xb4, 0xc6, 0xe8, 0xdd, 0x74, 0x1f, 0x4b, 0xbd, 0x8b, 0x8a}, 
                                        {0x70, 0x3e, 0xb5, 0x66, 0x48, 0x03, 0xf6, 0x0e, 0x61, 0x35, 0x57, 0xb9, 0x86, 0xc1, 0x1d, 0x9e}, 
                                        {0xe1, 0xf8, 0x98, 0x11, 0x69, 0xd9, 0x8e, 0x94, 0x9b, 0x1e, 0x87, 0xe9, 0xce, 0x55, 0x28, 0xdf}, 
                                        {0x8c, 0xa1, 0x89, 0x0d, 0xbf, 0xe6, 0x42, 0x68, 0x41, 0x99, 0x2d, 0x0f, 0xb0, 0x54, 0xbb, 0x16}
                                    };
    
   
    /**
     * Decrypts the contents of the specified input file using the given key.
     *
     * @param inputFile the path of the input file to be decrypted
     * @param key the encryption key used for decryption
     */
    private static void decrypt(String inputFile, String key) {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            byte[] encryptedBytes = Files.readAllBytes(Paths.get(inputFile));

            // Step 1: Inverse AddRoundKey (same as in encryption)
            byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

            // Step 2: Inverse MixColumns
            decryptedBytes = inverseMixColumns(decryptedBytes);

            // Step 3: Inverse ShiftRows
            decryptedBytes = inverseShiftRows(decryptedBytes);

            // Step 4: Inverse SubBytes
            decryptedBytes = inverseSubBytes(decryptedBytes);

            String outputFile = inputFile + ".dec";
            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(decryptedBytes);
            outputStream.close();

            System.out.println("Decryption successful. Decrypted file: " + outputFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Applies the inverse MixColumns operation on the input byte array.
     * 
     * @param inputBytes the input byte array to be processed
     * @return the output byte array after applying the inverse MixColumns operation
     */
    private static byte[] inverseMixColumns(byte[] inputBytes) {
        byte[] outputBytes = new byte[inputBytes.length];
        for (int col = 0; col < 4; col++) {
            byte[] column = new byte[4];
            for (int row = 0; row < 4; row++) {
                column[row] = inputBytes[col * 4 + row];
            }
            byte[] mixedColumn = inverseMixColumn(column);
            for (int row = 0; row < 4; row++) {
                outputBytes[col * 4 + row] = mixedColumn[row];
            }
        }
        return outputBytes;
    }

    /**
     * Performs the inverse MixColumn operation on the given column.
     *
     * @param column The column to perform the inverse MixColumn operation on.
     * @return The result of the inverse MixColumn operation.
     */
    private static byte[] inverseMixColumn(byte[] column) {
        byte[] mixedColumn = new byte[4];
        mixedColumn[0] = (byte) (multiply((byte) 0x0e, column[0]) ^ multiply((byte) 0x0b, column[1]) ^ multiply((byte) 0x0d, column[2]) ^ multiply((byte) 0x09, column[3]));
        mixedColumn[1] = (byte) (multiply((byte) 0x09, column[0]) ^ multiply((byte) 0x0e, column[1]) ^ multiply((byte) 0x0b, column[2]) ^ multiply((byte) 0x0d, column[3]));
        mixedColumn[2] = (byte) (multiply((byte) 0x0d, column[0]) ^ multiply((byte) 0x09, column[1]) ^ multiply((byte) 0x0e, column[2]) ^ multiply((byte) 0x0b, column[3]));
        mixedColumn[3] = (byte) (multiply((byte) 0x0b, column[0]) ^ multiply((byte) 0x0d, column[1]) ^ multiply((byte) 0x09, column[2]) ^ multiply((byte) 0x0e, column[3]));
        return mixedColumn;
    }

    /**
     * Performs the inverse shift rows operation on the input byte array.
     * The inverse shift rows operation shifts the bytes in each row of the input array to the right.
     * The number of shifts for each row is determined by the row index.
     * The result is stored in a new byte array and returned.
     *
     * @param inputBytes the input byte array to perform the inverse shift rows operation on
     * @return the byte array after the inverse shift rows operation
     */
    private static byte[] inverseShiftRows(byte[] inputBytes) {
        byte[] outputBytes = new byte[inputBytes.length];
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                outputBytes[col * 4 + row] = inputBytes[((col - row + 4) % 4) * 4 + row];
            }
        }
        return outputBytes;
    }

    /**
     * Applies the inverse SubBytes transformation to the given input byte array.
     *
     * @param inputBytes the input byte array to be transformed
     * @return the transformed byte array
     */
    private static byte[] inverseSubBytes(byte[] inputBytes) {
        byte[] outputBytes = new byte[inputBytes.length];
        for (int i = 0; i < inputBytes.length; i++) {
            outputBytes[i] = (byte) (inverseSbox[(inputBytes[i] & 0xFF) / 16][(inputBytes[i] & 0xFF) % 16]);
        }
        return outputBytes;
    }
    
    // AES Inverse S-Box
    public static final int[][] inverseSbox = { {0x52, 0x09, 0x6a, 0xd5, 0x30, 0x36, 0xa5, 0x38, 0xbf, 0x40, 0xa3, 0x9e, 0x81, 0xf3, 0xd7, 0xfb}, 
                                                {0x7c, 0xe3, 0x39, 0x82, 0x9b, 0x2f, 0xff, 0x87, 0x34, 0x8e, 0x43, 0x44, 0xc4, 0xde, 0xe9, 0xcb}, 
                                                {0x54, 0x7b, 0x94, 0x32, 0xa6, 0xc2, 0x23, 0x3d, 0xee, 0x4c, 0x95, 0x0b, 0x42, 0xfa, 0xc3, 0x4e}, 
                                                {0x08, 0x2e, 0xa1, 0x66, 0x28, 0xd9, 0x24, 0xb2, 0x76, 0x5b, 0xa2, 0x49, 0x6d, 0x8b, 0xd1, 0x25}, 
                                                {0x72, 0xf8, 0xf6, 0x64, 0x86, 0x68, 0x98, 0x16, 0xd4, 0xa4, 0x5c, 0xcc, 0x5d, 0x65, 0xb6, 0x92}, 
                                                {0x6c, 0x70, 0x48, 0x50, 0xfd, 0xed, 0xb9, 0xda, 0x5e, 0x15, 0x46, 0x57, 0xa7, 0x8d, 0x9d, 0x84}, 
                                                {0x90, 0xd8, 0xab, 0x00, 0x8c, 0xbc, 0xd3, 0x0a, 0xf7, 0xe4, 0x58, 0x05, 0xb8, 0xb3, 0x45, 0x06}, 
                                                {0xd0, 0x2c, 0x1e, 0x8f, 0xca, 0x3f, 0x0f, 0x02, 0xc1, 0xaf, 0xbd, 0x03, 0x01, 0x13, 0x8a, 0x6b}, 
                                                {0x3a, 0x91, 0x11, 0x41, 0x4f, 0x67, 0xdc, 0xea, 0x97, 0xf2, 0xcf, 0xce, 0xf0, 0xb4, 0xe6, 0x73}, 
                                                {0x96, 0xac, 0x74, 0x22, 0xe7, 0xad, 0x35, 0x85, 0xe2, 0xf9, 0x37, 0xe8, 0x1c, 0x75, 0xdf, 0x6e}, 
                                                {0x47, 0xf1, 0x1a, 0x71, 0x1d, 0x29, 0xc5, 0x89, 0x6f, 0xb7, 0x62, 0x0e, 0xaa, 0x18, 0xbe, 0x1b}, 
                                                {0xfc, 0x56, 0x3e, 0x4b, 0xc6, 0xd2, 0x79, 0x20, 0x9a, 0xdb, 0xc0, 0xfe, 0x78, 0xcd, 0x5a, 0xf4}, 
                                                {0x1f, 0xdd, 0xa8, 0x33, 0x88, 0x07, 0xc7, 0x31, 0xb1, 0x12, 0x10, 0x59, 0x27, 0x80, 0xec, 0x5f}, 
                                                {0x60, 0x51, 0x7f, 0xa9, 0x19, 0xb5, 0x4a, 0x0d, 0x2d, 0xe5, 0x7a, 0x9f, 0x93, 0xc9, 0x9c, 0xef}, 
                                                {0xa0, 0xe0, 0x3b, 0x4d, 0xae, 0x2a, 0xf5, 0xb0, 0xc8, 0xeb, 0xbb, 0x3c, 0x83, 0x53, 0x99, 0x61}, 
                                                {0x17, 0x2b, 0x04, 0x7e, 0xba, 0x77, 0xd6, 0x26, 0xe1, 0x69, 0x14, 0x63, 0x55, 0x21, 0x0c, 0x7d}
                                              };
 }