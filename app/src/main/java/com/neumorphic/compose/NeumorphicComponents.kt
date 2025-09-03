package com.neumorphic.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
internal fun NeumorphicBox(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(20.dp),
    contentPadding: Dp = 20.dp,
    firstColor: Color = Color.White,
    secondColor: Color = Color.LightGray,
    contentAlignment: Alignment = Alignment.TopStart,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = modifier
            .background(Color.Transparent, shape)
            .innerShadow(
                shape = shape,
                color = firstColor,
                blur = contentPadding / 2,
                offsetX = contentPadding,
                offsetY = contentPadding,
                spread = 0.dp
            )
            .innerShadow(
                shape = shape,
                color = secondColor,
                blur = contentPadding / 2,
                offsetX = -contentPadding,
                offsetY = -contentPadding,
                spread = 0.dp
            ),
        content = content,
        contentAlignment = contentAlignment
    )
}

@Composable
fun NeuMorphicUP(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(20.dp),
    contentPadding: Dp = 20.dp,
    lightColor: Color = Color.White,
    shadowColor: Color = Color.LightGray,
    contentAlignment: Alignment = Alignment.TopStart,
    content: @Composable BoxScope.() -> Unit = {},
) {
    NeumorphicBox(
        modifier = modifier,
        shape = shape,
        contentPadding = contentPadding,
        firstColor = lightColor,
        secondColor = shadowColor,
        contentAlignment = contentAlignment,
        content = content
    )
}

@Composable
fun NeuMorphicDown(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(20.dp),
    contentPadding: Dp = 20.dp,
    lightColor: Color = Color.White,
    shadowColor: Color = Color.LightGray,
    contentAlignment: Alignment = Alignment.TopStart,
    content: @Composable BoxScope.() -> Unit = {},
) {
    NeumorphicBox(
        modifier = modifier,
        shape = shape,
        contentPadding = contentPadding,
        firstColor = shadowColor,
        secondColor = lightColor,
        contentAlignment = contentAlignment,
        content = content
    )
}

@Composable
fun NeuMorphicButton(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(12.dp),
    contentPadding: Dp = 20.dp,
    lightColor: Color = Color.White,
    shadowColor: Color = Color.LightGray,
    onClick: () -> Unit,
    content: @Composable BoxScope.() -> Unit,
) {
    NeuMorphicUP(
        modifier = modifier
            .clickable { onClick() },
        shape = shape,
        contentPadding = contentPadding,
        lightColor = lightColor,
        shadowColor = shadowColor,
        contentAlignment = Alignment.Center,
        content = content
    )
}

@Composable
fun NeuMorphicCard(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(16.dp),
    contentPadding: Dp = 16.dp,
    lightColor: Color = Color.White,
    shadowColor: Color = Color.LightGray,
    content: @Composable BoxScope.() -> Unit,
) {
    NeuMorphicUP(
        modifier = modifier,
        shape = shape,
        contentPadding = contentPadding,
        lightColor = lightColor,
        shadowColor = shadowColor,
        contentAlignment = Alignment.TopStart,
        content = content
    )
}

@Composable
fun NeuMorphicSwitch(
    modifier: Modifier = Modifier,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    shape: Shape = RoundedCornerShape(50),
    contentPadding: Dp = 4.dp,
    lightColor: Color = Color.White,
    shadowColor: Color = Color.LightGray,
) {
    Box(
        modifier = modifier
            .height(32.dp)
            .width(64.dp)
            .clickable { onCheckedChange(!isChecked) }
    ) {
        NeuMorphicDown(
            modifier = Modifier.fillMaxSize(),
            shape = shape,
            contentPadding = contentPadding,
            lightColor = lightColor,
            shadowColor = shadowColor,
            content = {}
        )
        Box(
            modifier = Modifier
                .align(if (isChecked) Alignment.CenterEnd else Alignment.CenterStart)
                .padding(4.dp)
                .size(24.dp)
        ) {
            NeuMorphicUP(
                shape = CircleShape,
                contentPadding = 4.dp,
                lightColor = lightColor,
                shadowColor = shadowColor,
                content = {}
            )
        }
    }
}

@Composable
fun NeuMorphicProgressBar(
    modifier: Modifier = Modifier,
    progress: Float,
    shape: Shape = RoundedCornerShape(50),
    contentPadding: Dp = 4.dp,
    lightColor: Color = Color.White,
    shadowColor: Color = Color.LightGray,
) {
    Box(
        modifier = modifier
            .height(16.dp)
            .fillMaxWidth()
    ) {
        NeuMorphicDown(
            modifier = Modifier.fillMaxSize(),
            shape = shape,
            contentPadding = contentPadding,
            lightColor = lightColor,
            shadowColor = shadowColor,
            content = {}
        )
        NeuMorphicUP(
            modifier = Modifier
                .fillMaxWidth(progress.coerceIn(0f, 1f))
                .fillMaxSize(),
            shape = shape,
            contentPadding = contentPadding,
            lightColor = lightColor,
            shadowColor = shadowColor,
            content = {}
        )
    }
}

@Composable
fun NeuMorphicSlider(
    modifier: Modifier = Modifier,
    value: Float,
    onValueChange: (Float) -> Unit,
    shape: Shape = RoundedCornerShape(50),
    contentPadding: Dp = 4.dp,
    lightColor: Color = Color.White,
    shadowColor: Color = Color.LightGray,
) {
    var sliderWidth by remember { mutableStateOf(0f) }
    val density = LocalDensity.current.density
    Box(
        modifier = modifier
            .height(32.dp)
            .fillMaxWidth()
            .pointerInput(Unit) {
                detectHorizontalDragGestures { _, dragAmount ->
                    val newValue = (value + dragAmount / sliderWidth).coerceIn(0f, 1f)
                    onValueChange(newValue)
                }
            }
            .onSizeChanged { size ->
                sliderWidth = size.width.toFloat()
            }
    ) {
        NeuMorphicDown(
            modifier = Modifier.fillMaxSize(),
            shape = shape,
            contentPadding = contentPadding,
            lightColor = lightColor,
            shadowColor = shadowColor,
            content = {}
        )
        Box(
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(4.dp)
                .size(24.dp)
                .offset(x = Dp(value * (sliderWidth - (24.dp.value * density)) / density))
        ) {
            NeuMorphicUP(
                shape = CircleShape,
                contentPadding = 4.dp,
                lightColor = lightColor,
                shadowColor = shadowColor,
                content = {}
            )
        }
    }
}

@Composable
fun NeuMorphicTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    shape: Shape = RoundedCornerShape(12.dp),
    contentPadding: Dp = 20.dp,
    lightColor: Color = Color.White,
    shadowColor: Color = Color.LightGray,
) {
    NeuMorphicDown(
        modifier = modifier
            .height(48.dp)
            .fillMaxWidth(),
        shape = shape,
        contentPadding = contentPadding,
        lightColor = lightColor,
        shadowColor = shadowColor,
        contentAlignment = Alignment.CenterStart
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            textStyle = TextStyle(color = MaterialTheme.colorScheme.onSurface)
        )
    }
}

@Composable
fun NeuMorphicFAB(
    modifier: Modifier = Modifier,
    shape: Shape = CircleShape,
    contentPadding: Dp = 12.dp,
    lightColor: Color = Color.White,
    shadowColor: Color = Color.LightGray,
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
) {
    NeuMorphicUP(
        modifier = modifier
            .size(56.dp)
            .clickable { onClick() },
        shape = shape,
        contentPadding = contentPadding,
        lightColor = lightColor,
        shadowColor = shadowColor,
        contentAlignment = Alignment.Center,
        content = { icon() }
    )
}

@Composable
fun NeuMorphicPopup(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(16.dp),
    contentPadding: Dp = 16.dp,
    lightColor: Color = Color.White,
    shadowColor: Color = Color.LightGray,
    onDismiss: () -> Unit,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .clickable { onDismiss() }
    ) {
        NeuMorphicUP(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = shape,
            contentPadding = contentPadding,
            lightColor = lightColor,
            shadowColor = shadowColor,
            contentAlignment = Alignment.TopStart,
            content = content
        )
    }
}