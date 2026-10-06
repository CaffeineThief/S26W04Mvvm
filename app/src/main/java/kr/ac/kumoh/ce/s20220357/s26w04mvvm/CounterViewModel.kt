package kr.ac.kumoh.ce.s20220357.s26w04mvvm

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CounterViewModel : ViewModel() {
    private var _counter = MutableStateFlow(CounterModel(0))
    val counter = _counter.asStateFlow()

    fun incrementCount() {
        _counter.value = _counter.value.increment()
    }

    fun decrementCount() {
        _counter.value = _counter.value.decrement()
    }

    fun resetCount() {
        _counter.value = _counter.value.reset()
    }
}