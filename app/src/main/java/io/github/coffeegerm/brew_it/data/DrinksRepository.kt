/*
 * Copyright 2017 Coffee and Cream Studios
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

package io.github.coffeegerm.brew_it.data

import io.github.coffeegerm.brew_it.BrewItApplication.Companion.syringe
import io.realm.Realm
import javax.inject.Inject
import javax.inject.Named

/**
 * Class full of helper methods for accessing database data
 * Injected into classes using Dagger2
 */

class DrinksRepository {

    private var realm: Realm = Realm.getDefaultInstance()

    fun getAllDrinks(): ArrayList<Drink> = ArrayList(realm.where(Drink::class.java).findAll())

    fun getSingleDrinkById(id: Int): Drink? = realm.where(Drink::class.java).equalTo("id", id).findFirst()

    fun getSingleDrinkByName(name: String): Drink? = realm.where(Drink::class.java).equalTo("name", name).findFirst()
}