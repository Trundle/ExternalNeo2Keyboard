# External Neo2 Keyboard #

A rather hackish and incomplete
[Neo2 keyboard layout](http://neo-layout.org/) for external
(bluetooth) keyboards. Only tested under Android 4.4. On the plus side:
it does not require root and the complete source is available.


## How does it work? ##

The app provides a custom
[Key Character Map File](http://source.android.com/devices/tech/input/key-character-map-files.html). While
that theoretically kind of works, it still is a rather disappointing
experience: To use layer 3, you have to press and release the caps
lock key first, then press the key you want and then you have to
disable caps lock again. To work around that limitation, the app also
implements a custom *Input Method Editor*.


## Building from source ##

This project uses the Gradle-based Android build system. For details see
[the build system's user documentation](http://tools.android.com/tech-docs/new-build-system/user-guide).

1. Create a file `local.properties` with the following content:

       sdk.dir = /wherever/your/android/sdk/is/installed

2. Run `./gradlew assembleDebug`

The created APK file can be found under
`build/apk/ExternalNeo2Keyboard-debug-unaligned.apk`. If you want to
 install it directly on an attached device, run `./gradlew installDebug`.

To create a release version instead:

1. Edit `release.gradle`
2. Run `./gradlew assembleRelease`


## License ##

MIT/Expat. See `LICENSE` for details.
