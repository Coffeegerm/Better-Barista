/*
 * Copyright 2018 Coffee and Cream Studios
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.coffeegerm.betterbarista.ui

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.coffeegerm.betterbarista.R
import io.github.coffeegerm.betterbarista.utilities.Constants.SINGLE_DRINK_REQUEST_CODE
import io.github.coffeegerm.betterbarista.utilities.NavigationOnItemSelectedListener
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.longToast
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.setOnNavigationItemSelectedListener(NavigationOnItemSelectedListener(supportFragmentManager))
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == SINGLE_DRINK_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                navigation.selectedItemId = R.id.navigation_timer
            }
        }
    }

    private var backPressed: Long = 0

    override fun onBackPressed() {
        if (backPressed + 2000 > System.currentTimeMillis()) super.onBackPressed()
        else longToast(getString(R.string.close_message))
        backPressed = System.currentTimeMillis()
    }
}