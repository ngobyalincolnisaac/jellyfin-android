package org.jellyfin.mobile.settings

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import de.Maxr1998.modernpreferences.PreferencesAdapter
import de.Maxr1998.modernpreferences.helpers.categoryHeader
import de.Maxr1998.modernpreferences.helpers.checkBox
import de.Maxr1998.modernpreferences.helpers.screen
import de.Maxr1998.modernpreferences.helpers.singleChoice
import de.Maxr1998.modernpreferences.preferences.choice.SelectionItem
import org.jellyfin.mobile.R
import org.jellyfin.mobile.utils.Constants

class SettingsActivity : AppCompatActivity() {

    private val settingsAdapter: PreferencesAdapter by lazy { PreferencesAdapter(buildSettingsScreen()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        setSupportActionBar(findViewById(R.id.toolbar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.adapter = settingsAdapter
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun buildSettingsScreen() = screen(this) {
        collapseIcon = true
        categoryHeader(PREF_CATEGORY_MUSIC_PLAYER) {
            titleRes = R.string.pref_category_music_player
        }
        checkBox(Constants.PREF_MUSIC_NOTIFICATION_ALWAYS_DISMISSIBLE) {
            titleRes = R.string.pref_music_notification_always_dismissible_title
        }
        categoryHeader(PREF_CATEGORY_VIDEO_PLAYER) {
            titleRes = R.string.pref_category_video_player
        }
        val videoPlayerOptions = listOf(
            SelectionItem(VideoPlayerType.WEB_PLAYER, R.string.video_player_web, R.string.video_player_web_description),
            SelectionItem(VideoPlayerType.EXO_PLAYER, R.string.video_player_native, R.string.video_player_native_description),
            SelectionItem(VideoPlayerType.EXTERNAL_PLAYER, R.string.video_player_external, R.string.video_player_external_description),
        )
        singleChoice(Constants.PREF_VIDEO_PLAYER_TYPE, videoPlayerOptions) {
            titleRes = R.string.pref_video_player_type_title
            initialSelection = VideoPlayerType.WEB_PLAYER
        }
        checkBox(Constants.PREF_EXOPLAYER_ALLOW_BACKGROUND_AUDIO) {
            titleRes = R.string.pref_exoplayer_allow_background_audio
        }
    }

    companion object {
        const val PREF_CATEGORY_MUSIC_PLAYER = "pref_category_music"
        const val PREF_CATEGORY_VIDEO_PLAYER = "pref_category_video"
    }
}
