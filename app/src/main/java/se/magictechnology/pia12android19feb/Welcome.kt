package se.magictechnology.pia12android19feb

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Welcome(
    stuffvm : StuffViewModel,
    goReadmore : (fruit : String) -> Unit,
    goFancy : () -> Unit
) {
    Column {
        Text("Welcome", modifier = Modifier.background(Color.White))

        Text(stuffvm.sometext)

        Button(onClick = {
            goReadmore("Kiwi")
        }) {
            Text("Read more")
        }
        Button(onClick = {
            goFancy()
        }) {
            Text("Fancy")
        }
        Button(onClick = {
            stuffvm.loadsome()
        }) {
            Text("LOAD")
        }
    }
}


@Preview
@Composable
fun WelcomePreview() {
    Welcome(StuffViewModel(), goReadmore = {}, goFancy = {})
}