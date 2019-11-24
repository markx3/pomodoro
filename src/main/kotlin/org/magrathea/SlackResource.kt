package org.magrathea

import org.jboss.resteasy.annotations.Form
import org.magrathea.slack.service.ISlackService
import org.magrathea.slack.dto.SlackSlashCommandRequest
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType

@Path("/pomodoro")
class SlackResource
    @Inject
    constructor(private val slackService: ISlackService) {

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    fun start(@Form slackSlashCommandRequest: SlackSlashCommandRequest): String {
        if (slackSlashCommandRequest.message == "start") {
            slackService.setDoNotDisturb(
                requireNotNull(slackSlashCommandRequest.token) { "Slack token cannot be null" }
            )

            // TODO So much. :)
            return "Pomodoro started"
        }

        return "Unknown action"
    }
}
