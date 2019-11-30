package org.magrathea.slack.notifier

import org.magrathea.pomodoro.notifier.PomodoroNotifier
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
open class SlackPomodoroNotifier: PomodoroNotifier {
    override fun notifyPomodoroStopped() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}