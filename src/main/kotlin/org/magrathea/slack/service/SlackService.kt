package org.magrathea.slack.service

import org.magrathea.slack.dto.SlackSlashCommandRequest

interface SlackService {

    fun handleSlackSlashCommand(slackSlashCommandRequest: SlackSlashCommandRequest): String
}
