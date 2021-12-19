package cn.funcoding.playandroid.compose.utils

import androidx.annotation.StringRes
import java.util.UUID
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

data class Message(val id: Long, @StringRes val messageId: Int = 0, val messageText: String? = "")

/**
 * 负责管理 Snackbar 消息以显示在屏幕上的类
 */
object SnackbarManager {

    private val _messages: MutableStateFlow<List<Message>> = MutableStateFlow(emptyList())
    val messages: StateFlow<List<Message>> get() = _messages.asStateFlow()

    fun showMessage(@StringRes messageTextId: Int) {
        _messages.update { currentMessages ->
            currentMessages + Message(
                id = UUID.randomUUID().mostSignificantBits,
                messageId = messageTextId
            )
        }
    }

    fun showMessage(messageText: String?) {
        _messages.update { currentMessages ->
            currentMessages + Message(
                id = UUID.randomUUID().mostSignificantBits,
                messageText = messageText
            )
        }
    }

    fun setMessageShown(messageId: Long) {
        _messages.update { currentMessages ->
            currentMessages.filterNot { it.id == messageId }
        }
    }
}
