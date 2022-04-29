package org.bpa

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer
//Kafka에 전달하기위해 Deserialize함
class EventMessageDeserializer :ObjectMapperDeserializer <EventMessage>(EventMessage::class.java)
