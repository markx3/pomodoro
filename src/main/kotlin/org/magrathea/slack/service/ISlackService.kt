package org.magrathea.slack.service

import org.magrathea.slack.dto.SlackSlashCommandRequest

interface ISlackService {

    fun handlePomodoroRequest(slackSlashCommandRequest: SlackSlashCommandRequest): String
}
