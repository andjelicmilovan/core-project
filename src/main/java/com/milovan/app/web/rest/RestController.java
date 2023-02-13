package com.milovan.app.web.rest;

import com.milovan.app.client.PaymentFeignClinet;
import com.milovan.app.dto.PaymentIntentSecretDto;
import com.milovan.app.dto.Transaction1Dto;
import com.milovan.app.dto.TransactionRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.net.URI;
import java.net.URISyntaxException;

@org.springframework.web.bind.annotation.RestController

public class RestController {

    @Autowired
    private final PaymentFeignClinet paymentFeignClinet;

    public RestController(PaymentFeignClinet paymentFeignClinet) {
        this.paymentFeignClinet = paymentFeignClinet;
    }

    @GetMapping("test")
    public void testFeign(){
        TransactionRequestDto transactionRequestDto = new TransactionRequestDto();
        transactionRequestDto.setAmount(BigDecimal.valueOf(4234));
        transactionRequestDto.setUserEmail("andjelic363@gmail.com");
        transactionRequestDto.setUserId("4234");
        paymentFeignClinet.getAllPosts(transactionRequestDto);
    }

    @GetMapping("redirect")
    public ResponseEntity<Object> testRedirect() throws URISyntaxException {
        TransactionRequestDto transactionRequestDto = new TransactionRequestDto();
        transactionRequestDto.setUserId("12L2L");
        transactionRequestDto.setUserEmail("dedes@gmail.com");
        transactionRequestDto.setAmount(BigDecimal.valueOf(430.5));
        transactionRequestDto.setOrderId("k4234-424l-423");
        Transaction1Dto paymentIntentSecretDto = paymentFeignClinet.getPaymentIntent(transactionRequestDto);
        org.springframework.http.HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(new URI("http://localhost:3000/payment-main/"+paymentIntentSecretDto.getId()));
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);

    }
}
