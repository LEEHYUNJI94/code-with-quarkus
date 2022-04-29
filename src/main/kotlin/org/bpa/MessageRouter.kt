package org.bpa

import java.awt.PageAttributes
import javax.ws.rs.POST
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType


@Path("/api/message")
class MessageRouter(private val messageService: MessageService) {
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    fun sendMessage(text:String){
        messageService.sendMessage(text)
    }
}