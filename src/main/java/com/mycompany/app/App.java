package com.mycompany.app;

import java.net.URI;

import foundation.identity.did.Service;
import foundation.identity.did.VerificationMethod;
import foundation.identity.did.DIDDocument;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        URI did = URI.create("did:ex:1234");

        Service service = Service.builder()
                .type("ServiceEndpointProxyService")
                .serviceEndpoint("https://myservice.com/myendpoint")
                .build();
        
        VerificationMethod verificationMethod = VerificationMethod.builder()
                .id(URI.create(did + "#key-1"))
                .type("Ed25519VerificationKey2018")
                .publicKeyBase58("FyfKP2HvTKqDZQzvyL38yXH7bExmwofxHf2NR5BrcGf1")
                .build();
        
        DIDDocument diddoc = DIDDocument.builder()
                .id(did)
                .service(service)
                .verificationMethod(verificationMethod)
                .build();
        
        System.out.println(diddoc.toJson(true));
    }
}
