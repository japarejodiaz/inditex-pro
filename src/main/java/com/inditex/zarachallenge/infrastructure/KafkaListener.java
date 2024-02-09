package com.inditex.zarachallenge.infrastructure;

import com.inditex.zarachallenge.domain.model.ProductAvailabilityEvent;
import com.inditex.zarachallenge.infrastructure.external.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
public class KafkaListener {

	@Autowired
	private SizeService sizeService;

	@Bean
	public Consumer<Message<ProductAvailabilityEvent>> KafkaConsumer() {
		return message -> {
			ProductAvailabilityEvent event = message.getPayload();
			sizeService.updateProductAvailability(event);
		};
	}

}
