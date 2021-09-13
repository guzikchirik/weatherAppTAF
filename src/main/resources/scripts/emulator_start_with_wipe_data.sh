echo "Kill all emulators"
#~/Library/Android/sdk/platform-tools/adb devices | grep emulator | cut -f1 | while read line; do ~/Library/Android/sdk/platform-tools/adb -s $line emu kill; done
sleep 3

echo "Start emulator with wipe"
export ANDROID_HOME=$HOME/Library/Android/sdk;
export ANDROID_SDK_ROOT=$ANDROID_HOME; cd $HOME/Library/Android/sdk/emulator;
./emulator -writable-system -no-snapshot -partition-size 1024 -avd Pixel_4_API_29 -wipe-data&

sleep 10
#adb wait-for-device

#while [ "`~/Library/Android/sdk/platform-tools/adb shell getprop init.svc.bootanim `" != "running" ] ; do sleep 1; done

#while [ "`~/Library/Android/sdk/platform-tools/adb shell getprop init.svc.bootanim `" != "stopped" ] ; do sleep 5; done

#while [ "`adb shell getprop sys.boot_completed | tr -d '\r' `" != "1" ] ; do sleep 1; done

echo "Finish"
