AES Encryption/Decryption Program

This program implements AES-128, a block cipher algorithm used for encryption and decryption of data. AES-128 operates on 128-bit input and key, with 10 rounds of encryption or decryption.

Usage:
java AES option keyFile inputFile

Arguments:
- option: Specify 'e' for encryption or 'd' for decryption.
- keyFile: Path to the file containing the 128-bit encryption/decryption key. The key should be represented as a string of 32 hex characters (128 bits).
- inputFile: Path to the input file containing the plaintext to be encrypted or the ciphertext to be decrypted. Each line in the input file should consist of 32 hex characters representing a 128-bit block of data.

Output:
- For encryption: An encrypted file will be created with the extension '.enc' appended to the input file name. The encrypted file follows AES standards specified in the assignment.
- For decryption: A decrypted file will be created with the extension '.dec' appended to the input file name. The decrypted file will match the original plaintext input file (modulo dealing with any malformed or short lines).

AES Algorithm:
- AES operates in 128-bit blocks and uses a 128-bit key for encryption and decryption.
- The algorithm consists of four main steps: subBytes, shiftRows, mixColumns, and addRoundKey, repeated for multiple rounds.
- The subBytes step substitutes each byte of the input with a value from a fixed 256-element lookup table using the byte value as an index.
- The shiftRows step shifts the rows of the input array cyclically to the left, with each row shifted by a different offset.
- The mixColumns step applies a matrix multiplication to each column of the input array.
- The addRoundKey step XORs the input array with a round key derived from the original key.

Background:
- AES, also known as Rijndael, is a widely used block cipher algorithm designed to replace the earlier DES.
- AES supports key sizes of 128, 192, and 256 bits, with corresponding numbers of rounds (10, 12, and 14).
- The AES standard is available online, and there are various resources and books available for detailed understanding of the algorithm.

Instructions:
1. Ensure that the key file contains a valid 128-bit key represented as a string of 32 hex characters.
2. The input file should contain plaintext to be encrypted or ciphertext to be decrypted, with each line consisting of 32 hex characters.
3. Execute the program using the specified command format: 'java AES [e/d] keyFile inputFile'.

Example Usage:

Encryption:
java AES e key.txt input.txt

Decryption:
java AES d key.txt input.txt.enc