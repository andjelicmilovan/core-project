package com.milovan.app.web.rest;

import com.milovan.app.client.PaymentFeignClinet;
import com.milovan.app.dto.TransactionRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;

@Controller
public class MainController {

    @Autowired
    private final PaymentFeignClinet paymentFeignClinet;

    public MainController(PaymentFeignClinet paymentFeignClinet) {
        this.paymentFeignClinet = paymentFeignClinet;
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("allemplist", "employeeServiceImpl.getAllEmployee()");
        return "index";
    }

    @GetMapping("test1")
    public void testFeign(){
        TransactionRequestDto transactionRequestDto = new TransactionRequestDto();
        transactionRequestDto.setAmount(BigDecimal.valueOf(4234));
        transactionRequestDto.setUserEmail("andjelic363@gmail.com");
        transactionRequestDto.setUserId("4234");
        paymentFeignClinet.getAllPosts(transactionRequestDto);
    }
}
