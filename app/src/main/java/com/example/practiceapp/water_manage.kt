package com.example.practiceapp

import kotlin.math.roundToInt

class water_manage{

    companion object {
        private var age:Int = 33
        private var sex:Boolean = true
        private var tall:Double = 161.0
        private var weight:Double = 45.0
        private var water_cup = 0
        private var water:Int = 0

        public fun fill_cup(fill:Int){
            water_cup = water_cup + fill
        }

        public fun get_cup(): Int{
            return water_cup
        }

        public fun drink_water() {
            water = water + water_cup
            water_cup = 0
        }

        public fun get_water(): Int {
            var goal = weight*30
            return (water/goal * 100).roundToInt()
        }
    }
}