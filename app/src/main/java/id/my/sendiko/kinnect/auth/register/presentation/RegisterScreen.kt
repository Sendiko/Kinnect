package id.my.sendiko.kinnect.auth.register.presentation

import android.widget.Space
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.PeopleAlt
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import id.my.sendiko.kinnect.R
import id.my.sendiko.kinnect.auth.core.presentation.SecureTextField
import id.my.sendiko.kinnect.core.ui.component.BaseTextField
import id.my.sendiko.kinnect.core.ui.theme.KinnectTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    state: RegisterState,
    onEvent: (RegisterEvent) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Icon(
                            imageVector = Icons.Default.PeopleAlt,
                            contentDescription = stringResource(R.string.app_name)
                        )
                        Spacer(Modifier.width(8.dp))
                        Text(
                            text = stringResource(R.string.app_name),
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.register_headline_1),
                    style = MaterialTheme.typography.headlineLarge
                )
                Text(
                    text = stringResource(R.string.register_headline_2),
                    style = MaterialTheme.typography.headlineLarge,
                    fontWeight = FontWeight.Bold
                )
            }
            Surface(
                color = MaterialTheme.colorScheme.surfaceContainer,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                shape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                        .fillMaxWidth(),
                ) {
                    Text(
                        text = stringResource(R.string.register_title),
                        style = MaterialTheme.typography.titleLarge
                    )
                    Text(
                        text = stringResource(R.string.register_subtitle)
                    )
                    Spacer(Modifier.height(16.dp))
                    Text(
                        text = stringResource(R.string.full_name_label),
                        style = MaterialTheme.typography.labelLarge
                    )
                    BaseTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.fullName,
                        hint = stringResource(R.string.full_name_hint),
                        onValueChange = { onEvent(RegisterEvent.OnFullNameChanged(it)) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Person,
                                contentDescription = stringResource(R.string.full_name_label)
                            )
                        }
                    )
                    Spacer(Modifier.height(16.dp))
                    Text(
                        text = stringResource(R.string.email_label),
                        style = MaterialTheme.typography.labelLarge
                    )
                    BaseTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.email,
                        hint = stringResource(R.string.email_hint),
                        onValueChange = { onEvent(RegisterEvent.OnEmailChanged(it)) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Email,
                                contentDescription = stringResource(R.string.email_label)
                            )
                        }
                    )
                    Spacer(Modifier.height(16.dp))
                    Text(
                        text = stringResource(R.string.password_label),
                        style = MaterialTheme.typography.labelLarge
                    )
                    SecureTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = state.password,
                        hint = stringResource(R.string.create_password_hint),
                        onValueChange = { onEvent(RegisterEvent.OnPasswordChanged(it)) },
                        isVisible = state.passwordVisible,
                        onVisibilityChanged = { onEvent(RegisterEvent.OnPasswordVisibilityChanged(it)) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Default.Lock,
                                contentDescription = stringResource(R.string.password_label)
                            )
                        }
                    )
                    Spacer(Modifier.height(16.dp))
                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { onEvent(RegisterEvent.OnRegisterClicked) },
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Text(
                            text = stringResource(R.string.register_title)
                        )
                    }
                    TextButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { onEvent(RegisterEvent.OnRegisterClicked) },
                    ) {
                        Text(
                            text = stringResource(R.string.login_here)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
private fun RegisterScreenPrev() {
    KinnectTheme {
        RegisterScreen(
            state = RegisterState(),
            onEvent = {  }
        )
    }
}