package com.neumorphic.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class ComponentDemo(
    val title: String,
    val description: String,
    val content: @Composable () -> Unit
)

@Composable
fun NeumorphicScreen(modifier: Modifier = Modifier) {
    val components = listOf(
        ComponentDemo(
            title = "Basic Shapes",
            description = "Neumorphic boxes with rounded corners in raised and inset styles.",
            content = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    NeuMorphicUP(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("UP")
                    }
                    NeuMorphicDown(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Down")
                    }
                }
            }
        ),
        ComponentDemo(
            title = "Circular Shapes",
            description = "Circular neumorphic boxes in raised and inset styles.",
            content = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    NeuMorphicUP(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        shape = CircleShape,
                        contentAlignment = Alignment.Center
                    ) {
                        Text("UP")
                    }
                    NeuMorphicDown(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        shape = CircleShape,
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Down")
                    }
                }
            }
        ),
        ComponentDemo(
            title = "Buttons",
            description = "Interactive neumorphic buttons with rounded and circular shapes.",
            content = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    NeuMorphicButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = 12.dp,
                        onClick = {}
                    ) {
                        Text("Button UP")
                    }
                    NeuMorphicButton(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(48.dp),
                        shape = CircleShape,
                        contentPadding = 12.dp,
                        onClick = {}
                    ) {
                        Text("Circle")
                    }
                }
            }
        ),
        ComponentDemo(
            title = "Cards",
            description = "Neumorphic cards with standard and asymmetric corner designs.",
            content = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    NeuMorphicCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        shape = RoundedCornerShape(16.dp),
                        contentPadding = 16.dp
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("Card Title", style = MaterialTheme.typography.titleMedium)
                            Text("Neumorphic card content with rounded corners.")
                        }
                    }
                    NeuMorphicCard(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(120.dp),
                        shape = RoundedCornerShape(topStart = 24.dp, bottomEnd = 24.dp),
                        contentPadding = 16.dp
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("Asymmetric Card", style = MaterialTheme.typography.titleMedium)
                            Text("Card with asymmetric corners.")
                        }
                    }
                }
            }
        ),
        ComponentDemo(
            title = "Switches",
            description = "Toggle switches with rounded and circular designs.",
            content = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    var switchState by remember { mutableStateOf(false) }
                    NeuMorphicSwitch(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(32.dp),
                        isChecked = switchState,
                        onCheckedChange = { switchState = it },
                        shape = RoundedCornerShape(50)
                    )
                    var circleSwitchState by remember { mutableStateOf(true) }
                    NeuMorphicSwitch(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(32.dp),
                        isChecked = circleSwitchState,
                        onCheckedChange = { circleSwitchState = it },
                        shape = CircleShape
                    )
                }
            }
        ),
        ComponentDemo(
            title = "Progress Bars",
            description = "Horizontal progress bars with different corner radii.",
            content = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    NeuMorphicProgressBar(
                        modifier = Modifier.fillMaxWidth(),
                        progress = 0.3f,
                        shape = RoundedCornerShape(50),
                        contentPadding = 4.dp
                    )
                    NeuMorphicProgressBar(
                        modifier = Modifier.fillMaxWidth(),
                        progress = 0.7f,
                        shape = RoundedCornerShape(8.dp),
                        contentPadding = 4.dp
                    )
                }
            }
        ),
        ComponentDemo(
            title = "Sliders",
            description = "Interactive sliders with rounded and circular tracks.",
            content = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    var sliderValue by remember { mutableStateOf(0.5f) }
                    NeuMorphicSlider(
                        modifier = Modifier.fillMaxWidth(),
                        value = sliderValue,
                        onValueChange = { sliderValue = it },
                        shape = RoundedCornerShape(50)
                    )
                    var circleSliderValue by remember { mutableStateOf(0.2f) }
                    NeuMorphicSlider(
                        modifier = Modifier.fillMaxWidth(),
                        value = circleSliderValue,
                        onValueChange = { circleSliderValue = it },
                        shape = CircleShape
                    )
                }
            }
        ),
        ComponentDemo(
            title = "Text Fields",
            description = "Input fields with rounded and circular shapes.",
            content = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    var textValue by remember { mutableStateOf("") }
                    NeuMorphicTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = textValue,
                        onValueChange = { textValue = it },
                        shape = RoundedCornerShape(12.dp)
                    )
                    var circleTextValue by remember { mutableStateOf("") }
                    NeuMorphicTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = circleTextValue,
                        onValueChange = { circleTextValue = it },
                        shape = CircleShape
                    )
                }
            }
        ),
        ComponentDemo(
            title = "Floating Action Button",
            description = "Neumorphic FAB with a circular shape and icon.",
            content = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    NeuMorphicFAB(
                        modifier = Modifier.size(56.dp),
                        shape = CircleShape,
                        contentPadding = 12.dp,
                        onClick = {},
                        icon = {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add",
                                tint = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    )
                }
            }
        ),
        ComponentDemo(
            title = "Popup",
            description = "Neumorphic popup with rounded corners and dismiss action.",
            content = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    NeuMorphicPopup(
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(16.dp),
                        contentPadding = 16.dp,
                        onDismiss = {}
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text("Popup Title", style = MaterialTheme.typography.titleMedium)
                            Text("This is a neumorphic popup with dismiss action.")
                        }
                    }
                }
            }
        ),
        ComponentDemo(
            title = "Asymmetric Shapes",
            description = "Neumorphic boxes with non-uniform corner radii.",
            content = {
                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    NeuMorphicUP(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        shape = RoundedCornerShape(topStart = 24.dp, bottomEnd = 24.dp),
                        contentPadding = 12.dp,
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Asymmetric")
                    }
                    NeuMorphicDown(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp),
                        shape = RoundedCornerShape(topEnd = 24.dp, bottomStart = 24.dp),
                        contentPadding = 12.dp,
                        contentAlignment = Alignment.Center
                    ) {
                        Text("Opposite")
                    }
                }
            }
        )
    )

    Scaffold { scaffoldPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(scaffoldPadding)
                .background(Color(0xFFEEEEEE))
                .padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            items(components) { component ->
                Column(
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Text(
                        text = component.title,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = component.description,
                        style = MaterialTheme.typography.bodyMedium,
                        fontSize = 14.sp,
                        color = Color.Gray
                    )
                    component.content()
                }
            }
        }
    }
}