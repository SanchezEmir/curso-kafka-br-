package com.sanchezemir.mspayment.service.impl;

import com.sanchezemir.mspayment.model.Payment;
import com.sanchezemir.mspayment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@RequiredArgsConstructor
@Log4j2
@Service
public class PaymentServiceImpl implements PaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @SneakyThrows
    @Override
    public void sendPayment(Payment payment) {
        log.info("Payment received: {}", payment);
        Thread.sleep(1000);

        log.info("Send payment ... {}", payment);
        kafkaTemplate.send("payment-topic", payment);
    }

}
