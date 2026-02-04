package com.vov.patientcards.ui

import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.random.Random
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.style.TextAlign


@Composable
fun SplashScreen(
    onFinished: () -> Unit
) {
    val messages = listOf(
        "Ты моё чудо 💖",
        "Улыбнись, я писал это думая о тебе ✨",
        "Ты делаешь мой мир лучше 🌸",
        "Ты невероятная ❤️",
        "Я всё ещё не понимаю, как мне так повезло с тобой 🥰",
        "Если бы счастье имело имя — оно было бы твоим 💫",
        "Ты красивее, чем этот экран загрузки (а он старался) 💕",
        "Каждый раз, когда ты улыбаешься, где-то радуется один разработчик 😌",

        "СУПЕР КОГТИ!",
        "Мяу 🧠💘",
        "Да, это приложение сделано специально для тебя. Привыкай 😎",
        "Подожди 3 секунды. Я старался.",
        "Загрузка… потому что ты стоишь ожидания ⏳",
        "Если ты это читаешь — значит, я снова думаю о тебе 🙃",
        "Это не баг. Это романтика.",
        "Нажимай дальше, красавица 😏",
        "Я мог бы написать код. Но написал это.",

        "Техническая пауза для поцелуя 💋",
        "Этот экран официально одобрен мной и тобой",
        "Warning: excessive cuteness detected 🚨",
        "Compose загружается… любовь уже загружена ❤️",
        "Если бы я мог, я бы поставил тебе ⭐⭐⭐⭐⭐",
    )

    val message = remember { messages.random() }

    val alpha = remember { Animatable(0f) }
    val scale = remember { Animatable(0.9f) }

    LaunchedEffect(Unit) {
        alpha.animateTo(1f, tween(1000))
        scale.animateTo(1f, tween(1000))
        delay(2000)
        onFinished()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFFFFF1F5),
                        Color(0xFFFFE4EC)
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .padding(24.dp)
                .graphicsLayer(
                    alpha = alpha.value,
                    scaleX = scale.value,
                    scaleY = scale.value
                )
                .background(
                    color = Color.White.copy(alpha = 0.9f),
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(horizontal = 28.dp, vertical = 24.dp)
        ) {
            Text(
                text = message,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                color = Color(0xFF333333),
                fontWeight = FontWeight.Medium
            )
        }
    }
}
