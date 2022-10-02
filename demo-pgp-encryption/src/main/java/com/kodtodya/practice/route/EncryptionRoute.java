package com.kodtodya.practice.route;

import org.apache.camel.PropertyInject;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class EncryptionRoute extends RouteBuilder {

    @PropertyInject("{{test.user.id}}")
    private String keyUserId;

    @PropertyInject("{{test.public.key}}")
    private String publicKeyPath;

    @PropertyInject("{{test.master.password}}")
    private String keyPassword;

    @PropertyInject("{{test.private.key}}")
    private String privateKeyPath;

    @Override
    public void configure() {

		// This route encrypts the contents of a file in src/main/resources/sample-file/myFile.txt
        from("file://src/main/resources/sample-file?fileName=myFile.txt&noop=true").id("source-file-consumer")
                .convertBodyTo(String.class)
                .log("File read. Content=${body}")
                .marshal().pgp(publicKeyPath, keyUserId)
                .to("file://output?fileName=myFile.pgp").id("encrypted-file-producer");

        // This route decrypts the contents of a file in output/encrypted_payload.gpg
        from("file://output?fileName=myFile.pgp&move=archive").id("encrypted-file-consumer")
                // decrypt data
				.unmarshal().pgp(privateKeyPath, keyUserId, keyPassword)
                .log("decrypted content=${body}")
                .to("file://output?fileName=decrypted_myFile.txt").id("decrypted-file-producer")
                .log("File decrypted to decrypted_myFile.txt");
    }
}
