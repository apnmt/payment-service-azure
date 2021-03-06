package de.apnmt.payment.messaging;

import de.apnmt.common.event.ApnmtEvent;
import de.apnmt.common.event.value.OrganizationActivationEventDTO;
import de.apnmt.common.sender.ApnmtEventSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class OrganizationActivationEventSender implements ApnmtEventSender<OrganizationActivationEventDTO> {

    private static final Logger log = LoggerFactory.getLogger(OrganizationActivationEventSender.class);

    private JmsTemplate jmsTemplate;

    public OrganizationActivationEventSender(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @Override
    public void send(String topic, ApnmtEvent<OrganizationActivationEventDTO> event) {
        log.info("Send event {} to topic {}", event, topic);
        jmsTemplate.convertAndSend(topic, event);
    }

}
