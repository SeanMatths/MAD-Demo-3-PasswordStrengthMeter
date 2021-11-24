# Password Strength Meter
## Installation
1. Add the following to your project-level build.gradle

```java
allprojects {
    repositories {
        mavenCentral()
    }
}
```

2. Add the following to your app-level build.gradle:
```java
dependencies {
    implementation 'nu.aaro.gustav:passwordstrengthmeter:0.4'
}
```

## Usage
The view can be setup in a layout file like this:
```xml
<nu.aaro.gustav.passwordstrengthmeter.PasswordStrengthMeter
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:id="@+id/passwordInputMeter"
    app:strengthBarHeight="5dp"
    app:animateChanges="true"
    app:showStrengthLabel="true"
    app:showStrengthBar="true"
    app:animationDuration="300"
    app:labelTextSize="12sp"/>
```

And then it has to be attached to an EditText view in code like this:
```java
// Grabbing Views
EditText etPassword = findViewById(R.id.etVisiblePassword);
PasswordStrengthMeter passwordStrengthMeter = findViewById(R.id.passwordStrengthMeter);

// Setting the password strength meters to be bound to the EditText Views
passwordStrengthMeter.setEditText(etPassword);
```

## Customization
### Builtin settings:
```java
passwordStrengthMeter.setAnimationDuration(300);
passwordStrengthMeter.setShowStrengthIndicator(true);
passwordStrengthMeter.setShowStrengthLabel(true);
```

### Override Settings:



# Source
https://github.com/gustavaa/AndroidPasswordStrengthMeter