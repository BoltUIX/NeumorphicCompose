# Neumorphic Compose UI Kit

![Neumorphic UI Kit](https://github.com/BoltUIX/NeumorphicCompose/blob/main/Intro.png?raw=true)

A modern, customizable **Neumorphic UI Kit** built with **Jetpack Compose** for Android, providing a sleek, soft, and tactile design experience. This UI kit is **free to use** under the **MIT License**, making it ideal for developers looking to integrate neumorphic design into their Android applications.

![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-UI%20Kit-blue)
![Android](https://img.shields.io/badge/Platform-Android-green)
![MIT License](https://img.shields.io/badge/License-MIT-yellow)

## Features

The Neumorphic Compose UI Kit offers a comprehensive set of components with raised (UP) and inset (Down) neumorphic styles, supporting various shapes and interactive behaviors. Current features include:

- **Basic Shapes**: Rectangular neumorphic boxes with rounded corners in raised and inset styles.
- **Circular Shapes**: Circular neumorphic boxes for a distinct visual effect.
- **Buttons**: Interactive buttons with rounded and circular shapes, supporting click actions.
- **Cards**: Content containers with standard and asymmetric corner designs.
- **Switches**: Toggle switches with rounded and circular tracks, with state management.
- **Progress Bars**: Horizontal progress bars with customizable corner radii.
- **Sliders**: Interactive sliders with rounded and circular tracks for value selection.
- **Text Fields**: Input fields with rounded and circular shapes for text entry.
- **Floating Action Button (FAB)**: Circular FAB with an icon, following Material Design guidelines.
- **Popup**: Dialog-like popup with rounded corners and dismiss action.
- **Asymmetric Shapes**: Boxes with non-uniform corner radii for unique designs.
- **Customizable Styling**: Adjust colors, padding, and shapes for all components.
- **MIT License**: Freely use, modify, and distribute the UI kit.

## Getting Started

To use the Neumorphic Compose UI Kit in your Android project, follow these steps:

1. **Copy the UI Kit Files**: Add the following files to your project under the `com.neumorphic.compose` package:
    - `NeumorphicComponents.kt`: Contains all neumorphic components.
    - `ModifierExtensions.kt`: Defines the `innerShadow` modifier for the neumorphic effect.
    - `NeumorphicScreen.kt`: Demo screen showcasing all components.
    - `MainActivity.kt`: Entry point to display the demo.

2. **Run the Demo**: Use the `NeumorphicScreen` composable in your `MainActivity` to preview the components:
   ```kotlin
   setContent {
       NeumorphicComposeComponentsTheme {
           Surface(
               modifier = Modifier.fillMaxSize(),
               color = MaterialTheme.colorScheme.background
           ) {
               Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   NeumorphicScreen(
                       modifier = Modifier.padding(innerPadding)
                   )
               }
           }
       }
   }
   ```

## Code Examples

Below are examples of using the `NeuMorphicButton`, `NeuMorphicFAB`, and `NeuMorphicPopup` components:

```kotlin
@Composable
fun ButtonDemo() {
    Column(
        verticalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        NeuMorphicButton(
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            shape = RoundedCornerShape(12.dp),
            contentPadding = 12.dp,
            onClick = { /* Handle click */ }
        ) {
            Text("Click Me")
        }
        NeuMorphicFAB(
            modifier = Modifier.size(56.dp),
            shape = CircleShape,
            contentPadding = 12.dp,
            onClick = { /* Handle FAB click */ },
            icon = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }
        )
        NeuMorphicPopup(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp),
            contentPadding = 16.dp,
            onDismiss = { /* Handle dismiss */ }
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Popup Title", style = MaterialTheme.typography.titleMedium)
                Text("This is a neumorphic popup.")
            }
        }
    }
}
```

## Component Preview

The `NeumorphicScreen` composable provides a `ListView`-style demo of all components, each with a title and description:

- **Basic Shapes**: Neumorphic boxes with rounded corners.
  ```kotlin
  NeuMorphicUP(
      modifier = Modifier.fillMaxWidth().height(100.dp),
      contentAlignment = Alignment.Center
  ) { Text("UP") }
  ```

- **Circular Shapes**: Circular neumorphic boxes.
  ```kotlin
  NeuMorphicUP(
      modifier = Modifier.fillMaxWidth().height(100.dp),
      shape = CircleShape,
      contentAlignment = Alignment.Center
  ) { Text("UP") }
  ```

- **Buttons**: Interactive buttons with rounded and circular shapes.
  ```kotlin
  NeuMorphicButton(
      modifier = Modifier.fillMaxWidth().height(48.dp),
      shape = RoundedCornerShape(12.dp),
      onClick = {}
  ) { Text("Button UP") }
  ```

- **Cards**: Standard and asymmetric cards.
  ```kotlin
  NeuMorphicCard(
      modifier = Modifier.fillMaxWidth().height(120.dp),
      shape = RoundedCornerShape(16.dp)
  ) {
      Column(modifier = Modifier.padding(16.dp)) {
          Text("Card Title", style = MaterialTheme.typography.titleMedium)
          Text("Neumorphic card content.")
      }
  }
  ```

- **Switches**: Rounded and circular toggle switches.
  ```kotlin
  var switchState by remember { mutableStateOf(false) }
  NeuMorphicSwitch(
      modifier = Modifier.fillMaxWidth().height(32.dp),
      isChecked = switchState,
      onCheckedChange = { switchState = it }
  )
  ```

- **Progress Bars**: Horizontal progress bars.
  ```kotlin
  NeuMorphicProgressBar(
      modifier = Modifier.fillMaxWidth(),
      progress = 0.3f,
      shape = RoundedCornerShape(50)
  )
  ```

- **Sliders**: Interactive sliders.
  ```kotlin
  var sliderValue by remember { mutableStateOf(0.5f) }
  NeuMorphicSlider(
      modifier = Modifier.fillMaxWidth(),
      value = sliderValue,
      onValueChange = { sliderValue = it }
  )
  ```

- **Text Fields**: Rounded and circular input fields.
  ```kotlin
  var textValue by remember { mutableStateOf("") }
  NeuMorphicTextField(
      modifier = Modifier.fillMaxWidth(),
      value = textValue,
      onValueChange = { textValue = it }
  )
  ```

- **Floating Action Button**: Circular FAB with an icon.
  ```kotlin
  NeuMorphicFAB(
      modifier = Modifier.size(56.dp),
      onClick = {},
      icon = { Icon(Icons.Default.Add, contentDescription = "Add") }
  )
  ```

- **Popup**: Dialog-like popup with dismiss action.
  ```kotlin
  NeuMorphicPopup(
      modifier = Modifier.fillMaxWidth(),
      onDismiss = {}
  ) {
      Column(modifier = Modifier.padding(16.dp)) {
          Text("Popup Title", style = MaterialTheme.typography.titleMedium)
          Text("This is a neumorphic popup.")
      }
  }
  ```

- **Asymmetric Shapes**: Boxes with non-uniform corner radii.
  ```kotlin
  NeuMorphicUP(
      modifier = Modifier.fillMaxWidth().height(100.dp),
      shape = RoundedCornerShape(topStart = 24.dp, bottomEnd = 24.dp)
  ) { Text("Asymmetric") }
  ```

## Version 2 Development

We are actively working on **Version 2** of the Neumorphic Compose UI Kit! Planned enhancements include:
- Additional components (e.g., checkboxes, radio buttons, dropdown menus).
- Enhanced animations for interactive components.
- Dark mode support for neumorphic styles.
- Accessibility improvements (e.g., content descriptions, focus handling).
- Performance optimizations for complex layouts.

If you’re interested in contributing or following the development, please visit our [GitHub repository](https://github.com/BoltUIX/NeumorphicCompose) for updates!

## License

This project is licensed under the **MIT License**:

```
MIT License

Copyright (c) 2025 BoltUIX

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

## Contributing

Contributions are welcome! Please submit pull requests or open issues on our [GitHub repository](https://github.com/BoltUIX/NeumorphicCompose) to suggest improvements or report bugs.

---

