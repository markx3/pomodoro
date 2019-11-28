package org.magrathea.slack.dto

import javax.ws.rs.FormParam

class SlackSlashCommandRequest {

    @FormParam("user_id")
    var userId: String? = null

    @FormParam("text")
    var text: String? = null

    @FormParam("token")
    var token: String? = null
}
