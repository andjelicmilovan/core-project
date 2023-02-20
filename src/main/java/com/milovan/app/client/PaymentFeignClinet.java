package com.milovan.app.client;


import com.milovan.app.dto.PaymentIntentSecretDto;
import com.milovan.app.dto.Transaction1Dto;
import com.milovan.app.dto.TransactionRequestDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@FeignClient(name = "paymentFeignClient", url = "${client.payment.baseUrl}")
public interface PaymentFeignClinet {
    @PostMapping("/api/payment/start-transaction")
    void getAllPosts(@RequestBody TransactionRequestDto transactionRequestDto);

    @PostMapping("/api/transaction/start")
    Transaction1Dto getPaymentIntent(@RequestBody TransactionRequestDto transactionRequestDto);
}
