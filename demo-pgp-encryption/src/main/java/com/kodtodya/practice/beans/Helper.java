package com.kodtodya.practice.beans;

import org.apache.camel.Exchange;
import org.apache.camel.component.file.GenericFile;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

import java.io.*;

/**
 * @author Avadhut
 * @project demo-pgp-encryption
 * @purpose Reproducer for issue
 */
@Component
public class Helper {

    public void inputStreamConverter(Exchange exchange) throws FileNotFoundException {
        String content = exchange.getIn().getBody(String.class);
        InputStream stream = IOUtils.toInputStream(content);
        exchange.getIn().setBody(stream);
    }

    // below method is written to give trial but it did not work
    // i was thinking to convert body into GenericFile and test
    public void convert(Exchange exchange) throws IOException {
        String content = exchange.getIn().getBody(String.class);
        GenericFile genericFile = new GenericFile();
        File tmpFile = File.createTempFile("tempFile", ".tmp");
        genericFile.setFile(tmpFile);
        genericFile.setBody(content);

        exchange.getIn().setBody(genericFile);
    }
}
