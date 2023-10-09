package com.imooc.architect.showcase.flux.web;

import com.imooc.architect.showcase.flux.WebFluxApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@WebFluxTest(controllers = DemoController.class)
@Import(WebFluxApplication.class)
class DemoControllerTest {
    @Autowired
    private WebTestClient client;

    @Test
    void getIsDataReady() {

        WebTestClient.ResponseSpec responseSpec = client.get()
                .uri("/demo/getByName?name={name}", "Jimmy")
                .accept(MediaType.APPLICATION_JSON)
                .exchange();

        responseSpec.expectStatus().isOk()
                .expectBody()
                .jsonPath("$.name").isEqualTo("Jimmy");
    }
}