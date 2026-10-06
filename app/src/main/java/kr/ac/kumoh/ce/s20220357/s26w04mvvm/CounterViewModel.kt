package kr.ac.kumoh.ce.s20220357.s26w04mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CounterViewModel : ViewModel() {
    private var _counter = MutableStateFlow(CounterModel(0))
    private val _events = MutableSharedFlow<String>()
    // Mutable로 아예 바꿀 수 없도록 변환해서 넘겨줌
    val events = _events.asSharedFlow()

    val counter = _counter.asStateFlow()

    fun incrementCount() {
        _counter.value = _counter.value.increment()

        if (_counter.value.count == 5) {
            viewModelScope.launch {
                _events.emit("카운터 5에 도달")
            }
        }
    }

    fun decrementCount() {
        _counter.value = _counter.value.decrement()
    }

    fun resetCount() {
        _counter.value = _counter.value.reset()
    }
}