package id.my.sendiko.kinnect.auth.core.presentation

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.my.sendiko.kinnect.R
import id.my.sendiko.kinnect.core.ui.theme.KinnectTheme

@Composable
fun SecureTextField(
    modifier: Modifier = Modifier,
    value: String,
    hint: String,
    onValueChange: (String) -> Unit,
    onVisibilityChanged: (Boolean) -> Unit,
    isVisible: Boolean,
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
            AnimatedContent(
                targetState = isVisible
            ) { isVisible ->
                if (isVisible) {
                    IconButton(
                        onClick = { onVisibilityChanged(false) }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Visibility,
                            contentDescription = stringResource(R.string.visibility_on)
                        )
                    }
                } else {
                    IconButton(
                        onClick = { onVisibilityChanged(true) }
                    ) {
                        Icon(
                            imageVector = Icons.Default.VisibilityOff,
                            contentDescription = stringResource(R.string.visibility_off)
                        )
                    }
                }
            }
        },
        visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation()
    )
}

@Preview
@Composable
private fun SecureTextFieldPrev() {
    KinnectTheme {
        Surface {
            SecureTextField(
                value = "",
                hint = "Use your password",
                onValueChange = {  },
                onVisibilityChanged = {  },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = null
                    )
                },
                isVisible = false
            )
        }
    }
}