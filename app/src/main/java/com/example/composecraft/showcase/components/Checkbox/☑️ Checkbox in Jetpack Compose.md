

## What is a Checkbox?

A **Checkbox** is a selection control that allows users to choose one or more options from a set.

Unlike a Radio Button, multiple checkboxes can be selected at the same time.

Common use cases:

- Task lists
    
- Settings screens
    
- Permissions
    
- Agreement forms
    
- Multi-select filters
    

---

# Why Use a Checkbox?

Checkboxes help users:

- Select multiple items
    
- Toggle settings on/off
    
- Track completed tasks
    
- Confirm agreements
    

Example:

```text
☑ Receive Notifications
☐ Enable Dark Mode
☑ Auto Sync Data
```

---

# Material Design Guidelines

Use a Checkbox when:

✅ Users can select multiple options

✅ An option can be independently enabled or disabled

✅ The choice represents a true/false state

Do NOT use a Checkbox when:

❌ Only one option can be selected

Use:

```text
RadioButton
```

instead.

---

# Dependency

Checkbox is included in Material 3.

```kotlin
implementation("androidx.compose.material3:material3")
```

---

# Basic Checkbox

## Example

```kotlin
@Composable
fun BasicCheckbox() {

    var checked by remember {
        mutableStateOf(false)
    }

    Checkbox(
        checked = checked,
        onCheckedChange = {
            checked = it
        }
    )
}
```

---

## Output

Unchecked:

```text
☐
```

Checked:

```text
☑
```

---

# Checkbox Parameters

```kotlin
Checkbox(
    checked = checked,
    onCheckedChange = { checked = it }
)
```

|Parameter|Description|
|---|---|
|checked|Current state|
|onCheckedChange|Called when value changes|

---

# Checkbox with Label

Most checkboxes should have descriptive text.

## Example

```kotlin
@Composable
fun CheckboxWithLabel() {

    var checked by remember {
        mutableStateOf(false)
    }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Checkbox(
            checked = checked,
            onCheckedChange = {
                checked = it
            }
        )

        Text("Receive Notifications")
    }
}
```

---

## Output

```text
☑ Receive Notifications
```

---

# Clickable Row Pattern

Users expect clicking the text to toggle the checkbox.

## Recommended Pattern

```kotlin
@Composable
fun SettingsCheckbox() {

    var checked by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                checked = !checked
            }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Checkbox(
            checked = checked,
            onCheckedChange = null
        )

        Spacer(
            modifier = Modifier.width(8.dp)
        )

        Text("Enable Notifications")
    }
}
```

---

## Why?

This creates a larger touch area and improves usability.

✅ Better UX

✅ Easier to tap

✅ Material Design recommendation

---

# Multiple Checkboxes

Example for settings screens.

```kotlin
@Composable
fun SettingsScreen() {

    var email by remember {
        mutableStateOf(true)
    }

    var push by remember {
        mutableStateOf(false)
    }

    Column {

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = email,
                onCheckedChange = {
                    email = it
                }
            )

            Text("Email Notifications")
        }

        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {

            Checkbox(
                checked = push,
                onCheckedChange = {
                    push = it
                }
            )

            Text("Push Notifications")
        }
    }
}
```

---

# Todo List Example

One of the most common uses of checkboxes.

```kotlin
data class TodoItem(
    val title: String,
    val completed: Boolean
)
```

```kotlin
@Composable
fun TodoItemRow(
    item: TodoItem,
    onCheckedChange: (Boolean) -> Unit
) {

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {

        Checkbox(
            checked = item.completed,
            onCheckedChange = onCheckedChange
        )

        Text(item.title)
    }
}
```

---

## Output

```text
☑ Learn Kotlin
☐ Learn Compose
☐ Build Android App
```

---

# Parent Checkbox Pattern

Useful when selecting all items.

## Example

```text
☐ Select All

☐ Item 1
☐ Item 2
☐ Item 3
```

After selection:

```text
☑ Select All

☑ Item 1
☑ Item 2
☑ Item 3
```

---

# Tri-State Checkbox

Used when some child items are selected.

States:

|State|Meaning|
|---|---|
|On|All selected|
|Off|None selected|
|Indeterminate|Some selected|

---

## Example

```kotlin
TriStateCheckbox(
    state = ToggleableState.Indeterminate,
    onClick = { }
)
```

---

## Output

```text
☒
```

Represents:

```text
Some items selected
```

---

# Custom Checkbox Colors

```kotlin
Checkbox(
    checked = checked,
    onCheckedChange = {
        checked = it
    },
    colors = CheckboxDefaults.colors()
)
```

Custom colors:

```kotlin
Checkbox(
    checked = checked,
    onCheckedChange = {
        checked = it
    },
    colors = CheckboxDefaults.colors(
        checkedColor = Color.Green
    )
)
```

---

# Disabled Checkbox

Prevent user interaction.

```kotlin
Checkbox(
    checked = true,
    onCheckedChange = null,
    enabled = false
)
```

---

## Output

```text
☑ (disabled)
```

---

# State Hoisting

Recommended for reusable components.

## Component

```kotlin
@Composable
fun TaskCheckbox(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {

    Checkbox(
        checked = checked,
        onCheckedChange = onCheckedChange
    )
}
```

---

## Parent

```kotlin
var checked by remember {
    mutableStateOf(false)
}

TaskCheckbox(
    checked = checked,
    onCheckedChange = {
        checked = it
    }
)
```

---

# MVVM Example

## UI State

```kotlin
data class SettingsUiState(
    val notificationsEnabled: Boolean = false
)
```

---

## ViewModel

```kotlin
class SettingsViewModel : ViewModel() {

    private val _uiState =
        MutableStateFlow(
            SettingsUiState()
        )

    val uiState = _uiState.asStateFlow()

    fun updateNotifications(
        enabled: Boolean
    ) {

        _uiState.update {
            it.copy(
                notificationsEnabled = enabled
            )
        }
    }
}
```

---

## Screen

```kotlin
Checkbox(
    checked = uiState.notificationsEnabled,
    onCheckedChange = viewModel::updateNotifications
)
```

---

# Common Use Cases

## Settings Screen

```text
☑ Enable Notifications
☐ Dark Mode
☑ Auto Backup
```

---

## Todo App

```text
☑ Buy Milk
☐ Read Book
☐ Exercise
```

---

## Permissions

```text
☑ Camera Access
☐ Microphone Access
☑ Storage Access
```

---

## Terms and Conditions

```text
☐ I agree to the Terms and Conditions
```

---

# Accessibility Guidelines

✅ Always provide a label

✅ Make the entire row clickable

✅ Use sufficient spacing

✅ Ensure color contrast

❌ Never use a checkbox without context

❌ Avoid tiny touch targets

---

# Checkbox vs RadioButton

|Feature|Checkbox|RadioButton|
|---|---|---|
|Multiple Selection|✅|❌|
|Single Selection|❌|✅|
|Independent Choice|✅|❌|
|Settings Toggles|✅|❌|

---

# Best Practices

✅ Use Checkbox for multiple selections

✅ Use State Hoisting

✅ Make labels clickable

✅ Keep labels concise

✅ Use TriStateCheckbox for parent-child selections

❌ Don't use checkboxes when only one option should be chosen

❌ Don't rely solely on color to indicate state

---

# Summary

A **Checkbox** allows users to select or deselect options independently.

Main components:

|Component|Purpose|
|---|---|
|Checkbox|Standard selection|
|TriStateCheckbox|Parent-child selection|
|CheckboxDefaults|Styling|

Most common usage:

- Todo lists
    
- Settings screens
    
- Permissions
    
- Agreement forms
    
- Multi-select filters
    

In Jetpack Compose, always manage checkbox state using `remember`, state hoisting, or a `ViewModel` when building larger applications.