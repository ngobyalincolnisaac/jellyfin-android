package org.jellyfin.mobile.utils

object Constants {
    // Webapp constants
    const val INDEX_PATCH_PATH = "index_patch.html"
    const val INDEX_PATH = "web/index.html"

    // Preference keys
    const val PREF_INSTANCE_URL = "pref_instance_url"
    const val PREF_IGNORE_BATTERY_OPTIMIZATIONS = "pref_ignore_battery_optimizations"
    const val PREF_DOWNLOAD_METHOD = "pref_download_method"
    const val PREF_MUSIC_NOTIFICATION_ALWAYS_DISMISSIBLE = "pref_music_notification_always_dismissible"
    const val PREF_ENABLE_EXOPLAYER = "pref_enable_exoplayer"

    // Intent extras
    const val EXTRA_MEDIA_SOURCE_ITEM = "org.jellyfin.mobile.MEDIA_SOURCE_ITEM"
    const val EXTRA_WEBAPP_MESSENGER = "org.jellyfin.mobile.WEBAPP_MESSENGER"

    // Music player actions
    const val ACTION_PLAY = "action_play"
    const val ACTION_PAUSE = "action_pause"
    const val ACTION_REWIND = "action_rewind"
    const val ACTION_FAST_FORWARD = "action_fast_foward"
    const val ACTION_NEXT = "action_next"
    const val ACTION_PREVIOUS = "action_previous"
    const val ACTION_STOP = "action_stop"
    const val ACTION_REPORT = "action_report"
    const val ACTION_SHOW_PLAYER = "ACTION_SHOW_PLAYER"

    // Video player constants
    const val LANGUAGE_UNDEFINED = "und"
    const val TICKS_PER_MILLISECOND = 10000
    const val PLAYER_TIME_UPDATE_RATE = 3000L
    const val DEFAULT_CONTROLS_TIMEOUT_MS = 2500
    const val DEFAULT_SEEK_TIME_MS = 5000L

    // Video player events
    const val EVENT_PLAYING = "Playing"
    const val EVENT_PAUSE = "Pause"
    const val EVENT_ENDED = "Ended"
    const val EVENT_TIME_UPDATE = "TimeUpdate"

    // Orientation constants
    val ORIENTATION_PORTRAIT_RANGE = CombinedIntRange(340..360, 0..20)
    val ORIENTATION_LANDSCAPE_RANGE = CombinedIntRange(70..110, 250..290)
}