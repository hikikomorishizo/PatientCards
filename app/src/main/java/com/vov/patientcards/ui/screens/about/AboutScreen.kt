package com.vov.patientcards.ui.screens.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll

@Composable
fun AboutScreen() {
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
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = """
                Это приложение было создано мной.
                
                Потому что Аня сказала: «А можешь сделать приложение?»
                
                В процессе разработки:
                — было сказано «да я щас быстро»
                — и ни разу не было «щас быстро»
                — было много уверенного «да там дел на пять минут»
                — гуглилось «почему не работает, хотя всё правильно»
                — удалялось то, что «точно работало минуту назад»
                — добавлялось много костылей (временно, честно)
                — читалась документация (без понимания)
                — копировался код «вроде подходит»
                — удалялся код «чтобы проверить гипотезу» (гипотеза не подтверждалась)
                — баги фиксились созданием новых багов
                — приложение падало «но красиво»
                — уверенно ломалось то, что НЕ работало
                — чинилось то, что и так работало
                — делались «временные» решения
                — временные решения оставались навсегда
                
                Если что-то работает — это задумано.
                Если не работает — значит, это тоже задумано (наверное).
                
                С любовью,
                специально для Ани ❤️
                P.S. Аня лучшая девочка которая мне дорога <3
            """.trimIndent(),
            fontSize = 15.sp,
            textAlign = TextAlign.Center,
            lineHeight = 20.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}
