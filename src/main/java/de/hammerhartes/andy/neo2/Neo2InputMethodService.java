package de.hammerhartes.andy.neo2;

import android.inputmethodservice.InputMethodService;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;

public class Neo2InputMethodService extends InputMethodService {
    private int capsLockMeta;

    @Override
    public boolean onKeyDown(final int keyCode, final KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_CAPS_LOCK || keyCode == KeyEvent.KEYCODE_BACKSLASH) {
            capsLockMeta = KeyEvent.META_CAPS_LOCK_ON;
            return true;
        } else {
            final KeyCharacterMap keyCharacterMap = event.getKeyCharacterMap();
            final int newMetaState = (event.getMetaState() & ~KeyEvent.META_CAPS_LOCK_ON) | capsLockMeta;
            if (newMetaState != event.getMetaState()) {
                final int unicodeChar = keyCharacterMap.get(keyCode, newMetaState);
                if (unicodeChar != 0) {
                    getCurrentInputConnection().commitText(String.valueOf((char) unicodeChar), 1);
                    return true;
                }
            }
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(final int keyCode, final KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_CAPS_LOCK || keyCode == KeyEvent.KEYCODE_BACKSLASH) {
            capsLockMeta = 0;
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }
}
