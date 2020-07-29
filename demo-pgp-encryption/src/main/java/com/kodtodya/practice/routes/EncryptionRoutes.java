package com.kodtodya.practice.routes;

import com.kodtodya.practice.beans.Helper;
import org.apache.camel.PropertyInject;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.crypto.PGPDataFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EncryptionRoutes extends RouteBuilder {

    @PropertyInject("{{test.user.id}}")
    private String keyUserId;

    @PropertyInject("{{test.public.key}}")
    private String publicKeyPath;

    @PropertyInject("{{test.master.password}}")
    private String keyPassword;

    @PropertyInject("{{test.private.key}}")
    private String privateKeyPath;

    @Autowired
    private Helper helper;

    @Override
    public void configure() throws Exception {

        PGPDataFormat encryptionFormat = new PGPDataFormat();
        encryptionFormat.setKeyFileName(publicKeyPath);
        encryptionFormat.setKeyUserid(keyUserId);

		// This route encrypts the contents of a file in src/main/resources/sample-file/myFile.txt
        from("file://src/main/resources/sample-file?fileName=myFile.txt&noop=true")
                .convertBodyTo(String.class)
                .marshal().pgp(publicKeyPath, keyUserId)
                .to("file://output?fileName=myFile.pgp")
                .bean(helper, "inputStreamConverter");

        // This route decrypts the contents of a file in target/output/encrypted_payload.gpg
        from("file://output?fileName=myFile.pgp&move=archive")
                // enterprise application sends me Input stream
                // after polling file from aws-s3; hence adding below step
                .bean(helper, "inputStreamConverter")

                // below code has been tried but did not work
                // to make it work, i need suggestions
                // --------------------------------------------
                //.convertBodyTo(String.class)
                //.bean(helper, "convert")
                //.convertBodyTo(File.class)
                // --------------------------------------------
                // decrypt data
				.unmarshal().pgp(privateKeyPath, keyUserId, keyPassword)
                .log("decrypted content=${body}")
                .to("file://output?fileName=decrypted_myFile.txt")
                .log("File decrypted to decrypted_myFile.txt");
    }
}
