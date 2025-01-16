package com.amb.random.users.presentation

import ShimmerEffect
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.SubcomposeAsyncImage
import com.amb.random.users.domain.model.User
import com.amb.random.users.presentation.ui.theme.RandomUsersAppTheme
import org.koin.androidx.compose.koinViewModel

internal class RandomUserActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RandomUsersAppTheme {
                ProfileScreen(viewModel = koinViewModel())
            }
        }
    }

    @Composable
    private fun ProfileScreen(viewModel: RandomUserViewModel) {
        val state = viewModel.viewState.value
        state.userData?.let { data ->
            Column(
                modifier = Modifier.fillMaxSize()
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ProfileImage(userImage = data.avatar)
                    ProfileUserName(data)
                }
                ProfileDetails(data)
                GetNewRandomUser { viewModel.getRandomUser() }
            }

        }
        if (state.isLoading) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator()
            }
        }
        if (state.error != null) {
            Text(text = state.error)
        }
    }

    @Composable
    fun ProfileImage(userImage: String) {
        Card(
            shape = CircleShape,
            modifier = Modifier
                .padding(24.dp)
                .size(250.dp)
        ) {
            SubcomposeAsyncImage(
                loading = {
                    ShimmerEffect(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Color.LightGray, shape = RoundedCornerShape(12.dp))
                    )
                },
                contentDescription = null,
                modifier = Modifier.fillMaxWidth(),
                alignment = Alignment.Center,
                model = userImage
            )
        }
    }

    @Composable
    private fun ProfileUserName(data: User) {
        Text(
            text = "${data.firstName} ${data.lastName}",
            fontSize = 24.sp,
            style = TextStyle(fontWeight = FontWeight.ExtraBold)
        )
    }

    @Composable
    private fun ProfileDetails(data: User) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Spacer(modifier = Modifier.size(8.dp))
            Text(
                text = "Details",
                fontSize = 16.sp,
                style = TextStyle(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.size(8.dp))
            Row {
                Icon(
                    imageVector = Icons.Rounded.Email,
                    contentDescription = "",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(text = data.email, fontSize = 16.sp)
            }
            Row {
                Icon(
                    imageVector = Icons.Rounded.DateRange,
                    contentDescription = "",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(text = data.dateOfBirth, fontSize = 16.sp)
            }
            Row {
                Icon(
                    imageVector = Icons.Rounded.Star,
                    contentDescription = "",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(text = data.employment.title, fontSize = 16.sp)
            }
            Row {
                Icon(
                    imageVector = Icons.Rounded.Home,
                    contentDescription = "",
                    modifier = Modifier.padding(end = 8.dp)
                )
                Text(
                    text = "${data.address.city}, ${data.address.state} - ${data.address.country}",
                    fontSize = 16.sp
                )
            }
        }
    }

    @Composable
    private fun GetNewRandomUser(onClick: () -> Unit) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FloatingActionButton(
                shape = CircleShape,
                onClick = { onClick() },
            ) {
                Icon(Icons.Filled.Refresh, "Floating action button.")
            }
        }
    }
}
