package org.bpa

import org.eclipse.microprofile.reactive.messaging.Channel
import org.eclipse.microprofile.reactive.messaging.Emitter
import org.eclipse.microprofile.reactive.messaging.Incoming
import java.util.logging.Logger
import javax.enterprise.context.ApplicationScoped


@ApplicationScoped
//Channel에 있는 emitter을 사용
class MessageService(@Channel("message-out") private val emitter: Emitter<EventMessage>) {
    private val logger = Logger.getLogger(MessageService::class.java.name)

    private var Counter = 0

    fun sendMessage(text:String){
        emitter.send(EventMessage(text,Counter++))
    }

    @Incoming("message-in")
    fun receiveMessage(event:EventMessage){
        logger.info("Receive Message $event}")
    }

}