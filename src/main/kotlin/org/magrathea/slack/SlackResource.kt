package org.magrathea.slack

import org.jboss.resteasy.annotations.Form
import org.magrathea.slack.service.SlackService
import org.magrathea.slack.dto.SlackSlashCommandRequest
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/pomodoro")
class SlackResource(private val slackService: SlackService) {

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    fun start(@Form slackSlashCommandRequest: SlackSlashCommandRequest): String {
        return slackService.handleSlackSlashCommand(slackSlashCommandRequest)
    }
}
