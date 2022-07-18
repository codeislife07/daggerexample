package com.example.daggerexample



data class RecyclerList(val items: List<RecycleData>)
data class RecycleData(val name: String?, val description: String?, val owner: Owner?)
data class Owner(val avatar_url: String?)
