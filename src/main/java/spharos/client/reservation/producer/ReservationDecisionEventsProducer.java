package spharos.client.reservation.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.concurrent.CompletableFuture;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import spharos.client.reservation.dto.ReservationDecisionRequest;


@Component
@RequiredArgsConstructor
@Slf4j
public class ReservationDecisionEventsProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    private final ObjectMapper objectMapper;


    @Value("${spring.kafka.topic}")
    public String topic;


    public CompletableFuture<SendResult<String, String>> sendLibraryEvent(ReservationDecisionRequest request)
            throws JsonProcessingException {
        log.info("Sending Monthly Payment Event");
        var key = "test";
        String value = objectMapper.writeValueAsString(request);


        CompletableFuture<SendResult<String, String>> send = kafkaTemplate.send(topic, null, value);
        log.info("value : {}", value);

        return send
                .whenComplete((sendResult, throwable) -> {
                    if (throwable != null) {
                        handleFailure(key, value, throwable); // 에러처리
                    } else {
                        handleSuccess(key, value, sendResult);

                    }
                });
    }


    private void handleFailure(String key, String value, Throwable ex) {
        log.error("Error Sending the Message and the exception is {}", ex.getMessage());


    }
    private void handleSuccess(String key, String value, SendResult<String, String> result) {
        log.info("Message Sent SuccessFully for the key : {} and the value is {} , partition is {}",
                key, value, result.getRecordMetadata().partition());
    }
}