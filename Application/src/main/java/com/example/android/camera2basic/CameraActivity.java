/*
 * Copyright 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.camera2basic;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class CameraActivity extends AppCompatActivity {
    private static Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(R.layout.activity_camera);

        Intent intent = getIntent();
        String chosenFrame = intent.getStringExtra(ChooseFrameActivity.CHOSEN_FRAME);

        if (null == savedInstanceState) {
            Bundle bundle = new Bundle();
            bundle.putString("FRAME_TYPE", chosenFrame);
            Camera2BasicFragment C2BFragment = Camera2BasicFragment.newInstance();
            C2BFragment.setArguments(bundle);
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, C2BFragment)
                    .commit();
        }
    }

    public static Context getContext() {
        return mContext;
    }

}