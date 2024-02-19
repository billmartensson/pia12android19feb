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
    goReadmore : (fruit : String) -> Unit,
    goFancy : () -> Unit
) {
    Column {
        Text("Welcome", modifier = Modifier.background(Color.White))

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
    }
}


@Preview
@Composable
fun WelcomePreview() {
    Welcome(goReadmore = {}, goFancy = {})
}