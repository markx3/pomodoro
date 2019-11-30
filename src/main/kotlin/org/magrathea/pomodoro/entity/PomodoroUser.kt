package org.magrathea.pomodoro.entity

import org.magrathea.base.User

data class PomodoroUser(var pomodoroTime: Int, var userId: String): User() {
}