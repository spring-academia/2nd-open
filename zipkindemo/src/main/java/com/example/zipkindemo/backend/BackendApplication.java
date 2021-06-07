package com.example.zipkindemo.backend;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.annotation.NewSpan;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.concurrent.TimeUnit;

@EnableKafka
@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class,
                "--spring.application.name=backend",
                "--server.port=8081");
    }

    @RestController
    @Slf4j
    static class BackendController {
        @Autowired
        BackendPaymentService paymentService;

        @GetMapping("/order/{orderNumber}")
        public String order(@PathVariable Integer orderNumber) {
            paymentService.payment(orderNumber * 10);


            /*
            30퍼센트 비율로 200 응답이 아닌 500 에러를 반환하기 위한 예제 코드
            long time = System.nanoTime();
            if(time % 10 < 3 ){
                throw new RuntimeException("error");
            }
            log.info("{}:controller : {}", time, orderNumber * 10);
             */

            return "OK " + orderNumber;
        }
    }

    @Service
    @Slf4j
    static class BackendPaymentService {
        @Autowired
        KafkaTemplate<String, String> kafkaTemplate;

        public void payment(int i) {
            kafkaTemplate.send("backend", i + "원이 결제 요청됩니다");
        }

        @KafkaListener(topics = "backend", groupId = "backend-c1")
        public void consume(ConsumerRecord<String, String> record) {
            log.info("consume : {}  그리고 결제 완료!!", record.value());
        }
        // order/orderNumber --> servce.payment --> kafka produce --> kafka save -->
        // backend consume --> logging
    }


    /*
    KafkaProducer 를 테스트 하기 전에 사용되는 테스트 코드입니다
    @Service
    @Slf4j
    static class BackendPaymentService {
        @SneakyThrows
        @NewSpan(name = "backendPayment")   // 새로운 Span 정보를 생성 함
        public void payment(long time, @SpanTag("payment-price") Integer price) {
            // 강제로 0.1 ~ 0.6 초 지연 시간을 발생
           TimeUnit.MILLISECONDS.sleep(new Random().nextInt(500) * 100);
            log.info("{}: payment approved : {}", time, price);
        }
    }*/

}
