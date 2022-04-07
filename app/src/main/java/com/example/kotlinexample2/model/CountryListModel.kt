package com.example.kotlinexample2.model

data class CountryListModel(val name : Name?,
                            val flags : Flags?)

data class Name(val common : String?,
                val official : String?)

data class Flags(val png : String?)


