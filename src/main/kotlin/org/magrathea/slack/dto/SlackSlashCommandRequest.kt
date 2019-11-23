package org.magrathea.slack.dto

import javax.ws.rs.FormParam

class SlackSlashCommandRequest {

    @FormParam("user_id")
    private var userId : String = ""

    @FormParam("text")
    private var message : String = ""

    @FormParam("token")
    private var token : String = ""

    fun getUserId() : String {
        return userId;
    }

    fun getMessage() : String {
        return message;
    }

    fun getToken() : String {
        return token;
    }
}