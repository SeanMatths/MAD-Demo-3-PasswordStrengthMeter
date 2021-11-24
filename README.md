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
```java
meter.setPasswordStrengthCalculator(new PasswordStrengthCalculator() {
    @Override
    public int calculatePasswordSecurityLevel(String password) {
        // Do some calculation and return an int corresponding to the "points" or "level" the user password got
        return points;
    }

    @Override
    public int getMinimumLength() {
        // Define the minimum length of a password. Anything below this should always yield a score of 0
        return 8;
    }

    @Override
    public boolean passwordAccepted(int level) {
        // Define whether or not the level is an accepted level or not.
        return level > 3;
    }

    @Override
    public void onPasswordAccepted(String password) {
        // Called when the password entered meets your requirements of length and strength levels
    }
});
```


# Source
https://github.com/gustavaa/AndroidPasswordStrengthMeter