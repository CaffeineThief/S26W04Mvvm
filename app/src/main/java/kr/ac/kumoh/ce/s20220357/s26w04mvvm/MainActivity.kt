package kr.ac.kumoh.ce.s20220357.s26w04mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import kr.ac.kumoh.ce.s20220357.s26w04mvvm.ui.theme.S26W04MvvmTheme

class MainActivity : ComponentActivity() {
    private val counterViewModel: CounterViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            S26W04MvvmTheme {
                MainScreen(counterViewModel)
            }
        }
    }
}

@Composable
fun MainScreen(
    viewModel: CounterViewModel
) {
//    var count by retain { mutableIntStateOf(0) }
    val counterState by viewModel.counter.collectAsStateWithLifecycle()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Counter(
            modifier = Modifier.padding(innerPadding),
            count = counterState.count,
            onIncrement = { viewModel.incrementCount() },
            onDecrement = { viewModel.decrementCount() },
            onReset = { viewModel.resetCount() },
        )
    }
}