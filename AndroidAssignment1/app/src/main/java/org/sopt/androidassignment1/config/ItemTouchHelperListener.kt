package org.sopt.androidassignment1.config

interface ItemTouchHelperListener {
    fun onItemMove(from_position: Int, to_position: Int):Boolean
    fun onItemSwipe(position: Int)
}