package com.amb.card.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.amb.card.domain.model.CreditCard
import com.amb.card.presentation.ui.theme.RandomUsersAppTheme
import org.koin.androidx.compose.koinViewModel
import kotlin.random.Random

internal class CreditCardActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RandomUsersAppTheme {
                val viewModel: CreditCardViewModel = koinViewModel()
                val state = viewModel.viewState.value
                state.data?.let { CreditCard(it) }
            }
        }
    }

    @Composable
    fun CreditCard(data: CreditCard) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp)
                    .aspectRatio(1.586f),
                elevation = CardDefaults.cardElevation(defaultElevation = 16.dp)
            ) {
                Box {
                    val randomColor = Color(
                        red = Random.nextInt(256),
                        green = Random.nextInt(256),
                        blue = Random.nextInt(256)
                    )
                    CardBackground(baseColor = randomColor)
                    CardNumber(data.number)
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .padding(32.dp)
                    ) {
                        LabelAndText(
                            label = "Fake",
                            text = "Credit Card"
                        )
                    }
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(32.dp)
                    ) {
                        Row {
                            LabelAndText(
                                label = "expires",
                                text = data.expiryDate.removeRange(7, data.expiryDate.length)
                            )
                            Spacer(modifier = Modifier.width(16.dp))
                            LabelAndText(label = "cvv", text = "xxx")
                        }
                    }
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .padding(32.dp)
                    ) {
                        Text(
                            text = data.type, style = TextStyle(
                                fontWeight = FontWeight.W500,
                                fontStyle = FontStyle.Italic,
                                fontSize = 22.sp,
                                letterSpacing = 1.sp,
                                color = Color.White
                            )
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun CardBackground(baseColor: Color) {
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .background(baseColor)
        ) {
        }
    }

    @Composable
    fun CardNumber(cardNumber: String) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = cardNumber,
                style = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    letterSpacing = 1.sp,
                    color = Color.White
                )
            )
        }
    }

    @Composable
    fun LabelAndText(label: String, text: String) {
        Column(
            modifier = Modifier.wrapContentSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = label.uppercase(),
                style = TextStyle(
                    fontWeight = FontWeight.W300,
                    fontSize = 12.sp,
                    letterSpacing = 1.sp,
                    color = Color.White
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = text,
                style = TextStyle(
                    fontWeight = FontWeight.W400,
                    fontSize = 16.sp,
                    letterSpacing = 1.sp,
                    color = Color.White
                )
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        RandomUsersAppTheme {
            CreditCard(
                CreditCard(
                    expiryDate = "2026-01-18",
                    type = "maestro",
                    number = "1212-1221-1121-1234",
                    id = 12,
                    uid = "uid"
                )
            )
        }
    }
}