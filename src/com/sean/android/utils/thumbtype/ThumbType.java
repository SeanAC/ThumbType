/*
 * Copyright (C) 2008-2009 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sean.android.utils.thumbtype;

import android.graphics.PixelFormat;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.KeyboardView;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;

public class ThumbType extends InputMethodService 
        implements KeyboardView.OnKeyboardActionListener {
	
    static final boolean DEBUG = false;
    
    private WindowManager wm;
    private WindowManager.LayoutParams wmParams;
    private ThumbTypeView inputView;
    
    @Override
    public void onCreate() {
        super.onCreate();
        wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        wmParams = new WindowManager.LayoutParams(
        					WindowManager.LayoutParams.WRAP_CONTENT,
        					WindowManager.LayoutParams.WRAP_CONTENT,
        					WindowManager.LayoutParams.TYPE_SYSTEM_ALERT,
        					0,
        					PixelFormat.TRANSLUCENT);
        inputView = (ThumbTypeView) getLayoutInflater().inflate(R.layout.thumb_type_view, null);
    }
    
    @Override
    public void onInitializeInterface() {
    }

    @Override
    public View onCreateInputView() {
    	return null;
    }
    
    @Override
    public void onStartInputView(EditorInfo attribute, boolean restarting) {
       	if (inputView != null)
    		wm.addView(inputView, wmParams);
    	super.onStartInputView(attribute, restarting);
    }
    
    @Override
    public void onFinishInputView(boolean finishingInput) {
    	if (inputView != null)
    		wm.removeView(inputView);
    	super.onFinishInputView(finishingInput);
    }

    @Override
    public void onStartInput(EditorInfo attribute, boolean restarting) {
        super.onStartInput(attribute, restarting);
    }

    @Override
    public void onFinishInput() {
        super.onFinishInput();
    }

	@Override
	public void onPress(int primaryCode) {
	}

	@Override
	public void onRelease(int primaryCode) {
	}

	@Override
	public void onKey(int primaryCode, int[] keyCodes) {
	}

	@Override
	public void onText(CharSequence text) {
	}

	@Override
	public void swipeLeft() {
	}

	@Override
	public void swipeRight() {
	}

	@Override
	public void swipeDown() {
	}

	@Override
	public void swipeUp() {
	}

}
