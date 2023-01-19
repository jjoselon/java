//package com.company.webflux.webclient;
//
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//public class ClientServiceTest {
//
//    private static final Logger logger = LoggerFactory.getLogger(ClientServiceTest.class);
//
//    @Autowired
//    private ApiWebClient webClient;
//
//    private ClientAndServer mockServer;
//
//    @BeforeEach
//    public void startServer() {
//        mockServer = ClientAndServer.startClientAndServer(8899);
//    }
//
//    @AfterEach
//    public void stopServer() {
//        mockServer.stop();
//    }
//
//    @Test
//    void createShouldReturnTheResponse() {
//
//        // set up mock server with a delay of 1 seconds
//        mockServer.when(HttpRequest.request().withMethod("POST")
//                        .withPath("/accounts")).
//                respond(HttpResponse.response()
//                        .withBody("{ \"name\": \"Frank\", \"email\": \"frank@mail.com\"}")
//                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                        .withDelay(TimeUnit.MILLISECONDS, 1000));
//
//        ClientRequest request = new ClientRequest();
//        request.setName("Frank");
//        request.setName("frank@mail.com");
//
//        ClientResponse response = webClient.createClient(request);
//
//        assertThat(response).isNotNull();
//        assertThat(response.getName()).isEqualTo("Frank");
//        assertThat(response.getEmail()).isEqualTo("frank@mail.com");
//
//    }
//
//    @Test
//    void createWithTimeoutShouldThrowReadTimeOut() {
//
//        // set up mock server with a delay of 5 seconds
//        mockServer.when(HttpRequest.request().withMethod("POST")
//                        .withPath("/accounts")).
//                respond(HttpResponse.response()
//                        .withBody("{ \"name\": \"Frank\", \"email\": \"frank@mail.com\"}")
//                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                        .withDelay(TimeUnit.MILLISECONDS, 5000));
//
//        ClientRequest request = new ClientRequest();
//        request.setName("Frank");
//        request.setName("frank@mail.com");
//
//        assertThrows(ReadTimeoutException.class, () -> webClient.createClient(request));
//    }
//
//    @Test
//    void createWithStatusShouldThrowACustomException() {
//
//        // set up mock server with a http status 500
//        mockServer.when(HttpRequest.request().withMethod("POST")
//                        .withPath("/accounts"))
//                .respond(HttpResponse.response().withStatusCode(500)
//                        .withHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                        .withDelay(TimeUnit.MILLISECONDS, 1000));
//
//        ClientRequest request = new ClientRequest();
//        request.setName("Frank");
//        request.setName("frank@mail.com");
//
//        ApiWebClientException apiWebClientException = assertThrows(ApiWebClientException.class, () -> webClient.createClient(request));
//        assertTrue(apiWebClientException.getMessage().contains("HTTP Status 500 error"));
//
//    }
//}