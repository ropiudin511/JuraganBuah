package com.ropiudin.juraganbuah

import android.os.Parcel
import android.os.Parcelable

class ModelLogin() : Parcelable {
    constructor(parcel: Parcel) : this() {
    }

    override fun describeContents(): Int {
        TODO("Not yet implemented")
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {

    }

    companion object CREATOR : Parcelable.Creator<ModelLogin> {
        override fun createFromParcel(parcel: Parcel): ModelLogin {
            return ModelLogin(parcel)
        }

        override fun newArray(size: Int): Array<ModelLogin?> {
            return arrayOfNulls(size)
        }
    }

}
