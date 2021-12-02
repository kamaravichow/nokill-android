# 📵 NoKILL 🔪
Android library that captures global crashes 🦀 , so that your application never really crashes

[![](https://jitpack.io/v/kamaravichow/nokill-android.svg)](https://jitpack.io/#kamaravichow/nokill-android)

## GIF

![Sample](demo.gif)

## Add to your project 📇

Add it in your root build.gradle at the end of repositories:

```groovy
repositories {
    maven { url 'https://jitpack.io' }
}
 ```
Now, add the dependency :
```groovy
  implementation 'com.github.kamaravichow:nokill-android:1.0.0'
```

## Usage Guide 🤠

Initialise 
```kotlin
NoKill.init(crashHandler)
 ```
 
#### Best Practice 😋

Best practice to use this library is to initialise it in application class, this will help avoid all kinds of crashes your application can go through.

```kotlin
class App : Application() {

    override fun onCreate() {
        super.onCreate()

        // initialise no kill
        NoKill().init(object : CrashHandler {
            override fun uncaughtException(t: Thread, e: Throwable) {
                showToastOnUIThread(e.message)
            }
        })


    }


    fun showToastOnUIThread(message: String?) {
        Handler(Looper.getMainLooper()).post {
            Toast.makeText(
                applicationContext,
                message,
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
```
Checkout the [**DEMO app**](https://github.com/kamaravichow/nokill-android/tree/main/app/src/main/java/me/aravi/packages/nokill) in the project for more information 
  
## Like the work ?
Feel free to drop a star or start a discussion. Looking forward to colaborate with you guys

These works take time, if this library really helped you. You can drop a small token of worth here [PATREON](https://www.patreon.com/kamaravichow?fan_landing=true)

## License

```
Copyright 2021 Aravind Chowdary (@kamaravichow)

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

     http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```




