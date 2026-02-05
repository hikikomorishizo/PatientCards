package com.vov.patientcards.ui.screens.patients

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SortToggle(
    selected: SortType,
    onSelectedChange: (SortType) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(12.dp)
            )
    ) {

        SortToggleItem(
            text = "Алфавит",
            isSelected = selected == SortType.ALPHABET,
            onClick = { onSelectedChange(SortType.ALPHABET) },
            modifier = Modifier.weight(1f)
        )

        SortToggleItem(
            text = "Дата",
            isSelected = selected == SortType.DATE,
            onClick = { onSelectedChange(SortType.DATE) },
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
private fun SortToggleItem(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxHeight()
            .background(
                if (isSelected)
                    MaterialTheme.colorScheme.primary
                else
                    Color.Transparent
            )
            .clickable { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = if (isSelected)
                MaterialTheme.colorScheme.onPrimary
            else
                MaterialTheme.colorScheme.primary
        )
    }
}
