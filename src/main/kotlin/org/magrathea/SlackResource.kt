package org.magrathea

import org.jboss.resteasy.annotations.Form
import org.magrathea.slack.service.ISlackService
import org.magrathea.slack.dto.SlackSlashCommandRequest
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/pomodoro")
class SlackResource(private val slackService: ISlackService) {

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    fun start(@Form slackSlashCommandRequest: SlackSlashCommandRequest): String {
        if (slackSlashCommandRequest.text == "start") {
            slackService.setDoNotDisturb()

            return "Pomodoro started"
        }

        if (slackSlashCommandRequest.text == "stop") {
            slackService.stopDoNotDisturb()

            return "Pomodoro stopped"
        }

        return "Unknown action"
    }
}
