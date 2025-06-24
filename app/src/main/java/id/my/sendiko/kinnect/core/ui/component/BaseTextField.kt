package id.my.sendiko.kinnect.core.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.my.sendiko.kinnect.R
import id.my.sendiko.kinnect.core.ui.theme.KinnectTheme

@Composable
fun BaseTextField(
    modifier: Modifier = Modifier,
    value: String,
    hint: String,
    onValueChange: (String) -> Unit,
    leadingIcon: @Composable (() -> Unit)? = null
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(16.dp),
        leadingIcon = leadingIcon,
        placeholder = {
            Text(text = hint)
        },
        trailingIcon = {
            AnimatedVisibility(
                visible = value.isNotBlank()
            ) {
                IconButton(
                    onClick = { onValueChange("") }
                ) {
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = stringResource(R.string.clear_text)
                    )
                }
            }
        }
    )
}

@Preview
@Composable
private fun BaseTextFieldPrev() {
    KinnectTheme {
        Surface {
            BaseTextField(
                value = "Sendiko",
                onValueChange = {  },
                hint = "Use your username",
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = null
                    )
                }
            )
        }
    }
}