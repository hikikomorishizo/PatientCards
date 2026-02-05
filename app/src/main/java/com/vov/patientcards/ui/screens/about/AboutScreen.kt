package com.vov.patientcards.ui.screens.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vov.patientcards.R

@Composable
fun AboutScreen() {

    val devProcessItems = listOf(
        "Было сказано «да я щас быстро»",
        "И ни разу не было «щас быстро»",
        "Было много уверенного «да там дел на пять минут»",
        "Гуглилось «почему не работает, хотя всё правильно»",
        "Удалялось то, что «точно работало минуту назад»",
        "Добавлялось много костылей (временно, честно)",
        "Читалась документация (без понимания)",
        "Копировался код «вроде подходит»",
        "Удалялся код «чтобы проверить гипотезу» (гипотеза не подтверждалась)",
        "Баги фиксились созданием новых багов",
        "Приложение падало «но красиво»",
        "Уверенно ломалось то, что НЕ работало",
        "Чинилось то, что и так работало",
        "Делались «временные» решения",
        "Временные решения оставались навсегда"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(24.dp))

        Image(
            painter = painterResource(id = R.drawable.avatar),
            contentDescription = "Аватар разработчика",
            modifier = Modifier
                .size(140.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Вова",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant
            ),
            shape = MaterialTheme.shapes.extraLarge,
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "О приложении",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(bottom = 12.dp),
                    textAlign = TextAlign.Center
                )

                Text(
                    text = """
                        Это приложение было создано мной.
                        
                        Потому что Аня сказала:
                        «А можешь сделать приложение?»
                    """.trimIndent(),
                    textAlign = TextAlign.Center,
                    lineHeight = 20.sp
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = "В процессе разработки:",
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 12.dp)
                )

                devProcessItems.forEach {
                    DevProcessRow(text = it)
                }

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = """
                        Если что-то работает — это задумано.
                        Если не работает — значит, это тоже задумано.
                        
                        С любовью,
                        специально для Ани ❤️
                        
                        P.S. Аня лучшая девочка которая мне дорога <3
                    """.trimIndent(),
                    textAlign = TextAlign.Center,
                    lineHeight = 20.sp
                )
            }
        }
    }
}

@Composable
private fun DevProcessRow(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp),
        verticalAlignment = Alignment.Top
    ) {

        Text(
            text = "•",
            fontSize = 20.sp,
            modifier = Modifier.padding(end = 12.dp)
        )

        Text(
            text = text,
            lineHeight = 20.sp
        )
    }
}
