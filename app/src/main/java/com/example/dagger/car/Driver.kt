package com.example.dagger.car

import javax.inject.Inject
import javax.inject.Singleton

/*
@Singleton
class Driver @Inject constructor() {
}*/

class Driver (val name: String){
    // we don't own this class so we can't annotate it with @Inject


}