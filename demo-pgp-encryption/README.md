# PGP Encryption Demo

This example demonstrates how you can use Apache Camel's PGP encryption feature.

### Building

The example can be built with

    mvn clean install

### Running the example in your local

    mvn clean spring-boot:run

### Routes
**encryptRoute** - Reads the contents of the src/main/resources/sample-file/payload.txt then encrypts them. It writes the encrypted file
to target/output/encrypted_payload.gpg. It encrypts using the PGP public keyring src/main/resources/pgp-keyring/john-smith-public.key.  

**decryptRoute** - Reads the contents of the target/output/encrypted_payload.gpg then decrypts them. It puts the read file in target/output/processed
directory. It writes the decrypted content to target/output/decrypted_payload.txt. It decrypts using the PGP private keyring src/main/resources/pgp-keyring/john-smith-private.key.  
